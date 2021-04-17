package com.pca.ruletaapi.model;

/**
 * Simula una entidad de tipo Apostador
 * @author fbustosa
 *
 */
public class Apostador {

	private Integer id; // El id del apostador
	private String nombre; // El nombre del apostador
	private int saldo; // El saldo que el apostador puede apostar
	
	
		
	public Apostador() {
	}

	public Apostador(Integer id, String nombre, int saldo) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
