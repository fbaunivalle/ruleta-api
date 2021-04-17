package com.pca.ruletaapi.model;

import java.util.List;

public class Ronda {

	private Integer id;
	private List<Apuesta> apuestas;
	private Color colorGanador;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	
	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	public Color getColorGanador() {
		return colorGanador;
	}

	public void setColorGanador(Color colorGanador) {
		this.colorGanador = colorGanador;
	}
	
}
