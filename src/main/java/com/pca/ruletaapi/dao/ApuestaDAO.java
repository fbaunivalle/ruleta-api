package com.pca.ruletaapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pca.ruletaapi.model.Apuesta;

@Service
public class ApuestaDAO {

	private HashMap<Integer, Apuesta> dao; // Simula un objeto de base de datos
	private Integer idCount = 0; //Simula un autoincrement

	/**
	 * Constructor por defecto que inicializa el DAO.
	 */
	public ApuestaDAO() {
		this.dao = new HashMap<Integer, Apuesta>(); 
	}
	
	/**
	 * Retorna una apuesta de acuerdo al id dado como parámetro.
	 * @param id el id de la apuesta que se quiere consultar.
	 * @return Una apuesta si la encuentra con el id, de lo contrario retornará null.
	 */
	public Apuesta obtenerPorId(Integer id) {
		return (Apuesta) dao.get(id);
	}
	
	/**
	 * Crea una nueva Apuesta en la base de datos.
	 * @param apostador La nueva apuesta que se va a crear.
	 * @return La Apuesta creada con su id asignado.
	 */
	public Apuesta crear(Apuesta apuesta) {
		idCount++; //Autoincrementa el id para asignarlo al nuevo apostador
		apuesta.setId(idCount); // Asigna el id autoincrementado al nuevo apostador
		dao.put(apuesta.getId(), apuesta);
		return apuesta;
	}
	
	/**
	 * Actualiza una apuesta existente en la base de datos.
	 * @param apuesta La apuesta que se va a actualizar.
	 */
	public Apuesta editar(Apuesta apuesta) {
		dao.put(apuesta.getId(), apuesta);
		return apuesta;
	}
	
	/**
	 * Elimina una apuesta de la base de datos.
	 * @param id El id de la apuesta que se va a eliminar.
	 */
	public void eliminar(Integer id) {
		dao.remove(id);
	}
	
	/**
	 * Retorna una lista con todos las apuestas existentes en la base de datos.
	 * @return Una lista con todos las apuestas existentes en la base de datos.
	 */
	public List<Apuesta> obtenerTodos() {
		return new ArrayList<Apuesta>(dao.values());
	}
}
