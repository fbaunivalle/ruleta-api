package com.pca.ruletaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.ruletaapi.dao.ApostadorDAO;
import com.pca.ruletaapi.dao.ApuestaDAO;
import com.pca.ruletaapi.dao.ColorDAO;
import com.pca.ruletaapi.dao.RondaDAO;
import com.pca.ruletaapi.model.Apostador;
import com.pca.ruletaapi.model.Apuesta;
import com.pca.ruletaapi.model.Color;
import com.pca.ruletaapi.model.Ronda;

@Service
public class RuletaService {
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Autowired
	private ApostadorDAO apostadorDAO;
	
	@Autowired
	private RondaDAO rondaDAO;
	
	@Autowired
	private ApuestaDAO apuestaDAO;
	
	public RuletaService() {
	}
	
	/**
	 * Selecciona de forma aleatoria un color que tiene asociado una probabilidad de ser escogido.
	 * Rojo 0.495
	 * Negro 0.495
	 * Verde 0.01
	 * 
	 * Se puede consultar el algoritmo en https://stackoverflow.com/questions/9330394/how-to-pick-an-item-by-its-probability
	 * 
	 * @return Un color escogido aleatoriamente.
	 */
	public Color jugar() {
		List<Color> colores = colorDAO.getColores();
		double p = Math.random();
		double cumulativeProbability = 0.0;
		for (Color item : colores) {
		    cumulativeProbability += item.getProbabilidadAcertar();
		    if (p <= cumulativeProbability) {
		        return item;
		    }
		}
		
		return null;
	}
	
	/**
	 * Escoge de forma aleatoria un color para apostar en una ronda. Probabilidad de ser escogido:
	 * 
	 * Rojo 0.495
	 * Negro 0.495
	 * Verde 0.01
	 * 
	 * @return Un color escogido aleatoriamente.
	 */
	public Color apostar() {
		List<Color> colores = colorDAO.getColores();
		double p = Math.random();
		double cumulativeProbability = 0.0;
		for (Color item : colores) {
		    cumulativeProbability += item.getProbabilidadEscogencia();
		    if (p <= cumulativeProbability) {
		        return item;
		    }
		}
		
		return null;
	}
	
	/**
	 * Obtiene una cantidad apostada según el criterio de apostar entre 11% y 19% del saldo disponible. 
	 * Este porcentaje se elije de forma aleatoria en ese rango de valores. Si el saldo es menor a 1000 devuelve el saldo.
	 * 
	 * Se usa la siguiente fórmula para escoger aleatoriamente un número entre el rango:
	 * 
	 * (Math.random() * ((max - min) + 1)) + min
	 * 
	 * @param saldo el saldo disponible para apostar.
	 * @return La cantidad a apostar en una ronda según el criterio descrito anteriormente.
	 */
	public int obtenerCantidadApostada(int saldo) {
		if (saldo < 1000) {
			return saldo;
		}
		
		double porcentajeApuesta = (Math.random() * ((0.19 - 0.11) + 0.01)) + 0.11;
		System.out.println("Porcentaje apuesta: " + porcentajeApuesta);
		return (int) ((double)saldo * porcentajeApuesta);
	}
	
	/**
	 * Juega una ronda de la ruleta
	 * @return La ronda jugada.
	 */
	public Ronda jugarRonda( ) {
		Ronda ronda = new Ronda();
		ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
		//Se realizan las apuestas para cada apostador.
		for (Apostador apo : apostadorDAO.obtenerTodos()) {
			//Solo se realiza la apuesta si el saldo del apostador es mayor que cero.
			if (apo.getSaldo() > 0) {
				Apuesta apu = new Apuesta(apo, this.apostar(), false);
				int cantidadApostada = this.obtenerCantidadApostada(apo.getSaldo());
				int saldo = apo.getSaldo();
				apu.setCantidadApostada(cantidadApostada);
				apu.setSaldoInicial(saldo);
				apuestaDAO.crear(apu);
				apo.setSaldo(saldo - cantidadApostada);
				apuestas.add(apu);
			}
		}
		ronda.setApuestas(apuestas);
		Color colorGanador = this.jugar(); // Se juega la ruleta.
		ronda.setColorGanador(colorGanador);
		ronda = rondaDAO.crear(ronda);
		
		//Actualización del saldo de los apostadores según el resultado de la ronda.
		for (Apuesta apu : apuestas) {
			int cantidadGanada = 0;
			
			//Si gana se paga al apostador segun lo apostado.
			if (Objects.equals(apu.getColor().getId(), colorGanador.getId())) {
				
				if (Objects.equals(colorGanador.getId(), Color.ROJO) || Objects.equals(colorGanador.getId(), Color.NEGRO)) {
					//Si con gana rojo o negro se duplica lo apostado.	
					cantidadGanada = (apu.getCantidadApostada() * 2);
					
				} else {
					//Si gana con verde, gana 10 veces lo apostado.
					cantidadGanada = (apu.getCantidadApostada() * 10);
				}
			}
			
			apu.setSaldoFinal(apu.getApostador().getSaldo()  + cantidadGanada);
			apu.getApostador().setSaldo(apu.getApostador().getSaldo() + cantidadGanada);
			apu.setCantidadGanada(cantidadGanada);			
			apuestaDAO.editar(apu); //Actualiza la información de la apuesta.
			apostadorDAO.editar(apu.getApostador());
		}
		
		return ronda;
	}
	
	public List<Ronda> obtenerRondas() {
		return rondaDAO.obtenerTodos();
	}
}
