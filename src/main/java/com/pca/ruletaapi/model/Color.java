package com.pca.ruletaapi.model;

public class Color {

	public static final Integer ROJO = 1;
	public static final Integer NEGRO = 2;	
	public static final Integer VERDE = 3;
			
	private Integer id;
	private String nombre;
	private double probabilidadAcertar;
	private double probabilidadEscogencia;
		
	public Color(Integer id, String nombre, double probabilidadAcertar, double probabilidadEscogencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.probabilidadAcertar = probabilidadAcertar;
		this.probabilidadEscogencia = probabilidadEscogencia;
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
	
	public double getProbabilidadAcertar() {
		return probabilidadAcertar;
	}
	
	public void setProbabilidadAcertar(double probabilidadAcertar) {
		this.probabilidadAcertar = probabilidadAcertar;
	}
	
	public double getProbabilidadEscogencia() {
		return probabilidadEscogencia;
	}
	
	public void setProbabilidadEscogencia(double probabilidadEscogencia) {
		this.probabilidadEscogencia = probabilidadEscogencia;
	}
	
	
}
