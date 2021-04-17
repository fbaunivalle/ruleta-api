package com.pca.ruletaapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pca.ruletaapi.model.Color;

@Service
public class ColorDAO {
	
	private List<Color> colores; //Lista de opciones de colores que puede escoger el apostador o jugarse en la ruleta.
	
	public ColorDAO() {
		//Se instancian de forma fija las opciones de escogencia con sus respectivas probabilidades.
		colores = new ArrayList<Color>();
		colores.add(new Color(Color.ROJO, "Rojo", 0.495, 0.495));
		colores.add(new Color(Color.NEGRO, "Negro", 0.495, 0.495));
		colores.add(new Color(Color.VERDE, "Verde", 0.01, 0.01));
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}
}
