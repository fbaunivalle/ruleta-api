package com.pca.ruletaapi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pca.ruletaapi.model.Apostador;

/**
 * Clase que simula un objeto de acceso a base de datos Data Access Object.
 * @author fbustosa
 *
 */
@Service
public class ApostadorDAO {

	private HashMap<Integer, Apostador> dao; // Simula un objeto de base de datos
	private Integer idCount = 0; //Simula un autoincrement

	/**
	 * Constructor por defecto que inicializa el DAO.
	 */
	public ApostadorDAO() {
		this.dao = new HashMap<Integer, Apostador>(); 
	}
	
	/**
	 * Retorna un apostador de acuerdo al id dado como parámetro.
	 * @param id el id del apostador que se quiere consultar.
	 * @return un apostador si lo encuentra con el id, de lo contrario retornará null.
	 */
	public Apostador obtenerPorId(Integer id) {
		return (Apostador) dao.get(id);
	}
	
	/**
	 * Crea un nuevo Apostador en la base de datos.
	 * @param apostador El nuevo apostador.
	 * @return El apostador creado con su id asignado.
	 */
	public Apostador crear(Apostador apostador) {
		idCount++; //Autoincrementa el id para asignarlo al nuevo apostador
		apostador.setId(idCount); // Asigna el id autoincrementado al nuevo apostador
		dao.put(apostador.getId(), apostador);
		return apostador;
	}
	
	/**
	 * Actualiza un apostador existente en la base de datos.
	 * @param apostador El apostador que se va a actualizar.
	 */
	public Apostador editar(Apostador apostador) {
		dao.put(apostador.getId(), apostador);
		return apostador;
	}
	
	/**
	 * Elimina un apostador de la base de datos.
	 * @param id El id del apostador que se va a eliminar.
	 */
	public void eliminar(Integer id) {
		dao.remove(id);
	}
	
	/**
	 * Retorna una lista con todos los apostadores existentes en la base de datos.
	 * @return Una lista con todos los apostadores existentes en la base de datos.
	 */
	public List<Apostador> obtenerTodos() {
		return new ArrayList<Apostador>(dao.values());
	}
}
