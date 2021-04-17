package com.pca.ruletaapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pca.ruletaapi.model.Ronda;

/**
 * Clase que simula un objeto de acceso a base de datos Data Access Object.
 * @author fbustosa
 *
 */
@Service
public class RondaDAO {

	private HashMap<Integer, Ronda> dao; // Simula un objeto de base de datos.
	private Integer idCount = 0; //Simula un autoincrement.
	
	/**
	 * Constructor por defecto que inicializa el DAO.
	 */
	public RondaDAO() {
		this.dao = new HashMap<Integer, Ronda>();
	}
	
	/**
	 * Retorna una ronda de acuerdo al id dado como parámetro.
	 * @param id el id de la ronda que se quiere consultar.
	 * @return un ronda si la encuentra con el id, de lo contrario retornará null.
	 */
	public Ronda obtenerPorId(Integer id) {
		return (Ronda) dao.get(id);
	}
	
	/**
	 * Crea una nueva Ronda en la base de datos.
	 * @param ronda La nueva ronda.
	 * @return La nueva ronda creada con su id asignado.
	 */
	public Ronda crear(Ronda ronda) {
		idCount++; //Autoincrementa el id para asignarlo a la nueva ronda.
		ronda.setId(idCount); // Asigna el id autoincrementado a la nueva ronda.
		dao.put(ronda.getId(), ronda);
		return ronda;
	}
	
	/**
	 * Retorna una lista con todas las rondas existentes en la base de datos.
	 * @return Una lista con todos las rondas existentes en la base de datos.
	 */
	public List<Ronda> obtenerTodos() {
		return new ArrayList<Ronda>(dao.values());
	}
}
