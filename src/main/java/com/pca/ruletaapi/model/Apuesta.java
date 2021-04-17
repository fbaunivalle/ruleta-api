package com.pca.ruletaapi.model;

public class Apuesta {
	
	private Integer id;
	private Apostador apostador;
	private Color color;
	private int cantidadApostada;
	private int saldoInicial;
	private int cantidadGanada;
	private int saldoFinal;
	private boolean gana;
	
	public Apuesta(Apostador apostador, Color color, boolean gana) {
		this.apostador = apostador;
		this.color = color;
		this.gana = gana;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Apostador getApostador() {
		return apostador;
	}
	
	public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getCantidadApostada() {
		return cantidadApostada;
	}
	
	public int getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(int saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public int getCantidadGanada() {
		return cantidadGanada;
	}

	public int getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(int saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public void setCantidadGanada(int cantidadGanada) {
		this.cantidadGanada = cantidadGanada;
	}

	public void setCantidadApostada(int cantidadApostada) {
		this.cantidadApostada = cantidadApostada;
	}

	public boolean isGana() {
		return gana;
	}
	
	public void setGana(boolean gana) {
		this.gana = gana;
	}
}
