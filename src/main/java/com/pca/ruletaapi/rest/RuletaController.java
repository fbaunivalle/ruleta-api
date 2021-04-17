package com.pca.ruletaapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pca.ruletaapi.model.Ronda;
import com.pca.ruletaapi.service.RuletaService;

@RestController
@RequestMapping(value = "/api/v1")
public class RuletaController {

	@Autowired
	private RuletaService service;

	
	public RuletaController() {
	}
	
	@CrossOrigin
	@GetMapping(value = "/jugar")
	public ResponseEntity<Ronda> jugar() {		
		return new ResponseEntity<Ronda>(service.jugarRonda(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/rondas")
	public List<Ronda> obtenerRondas() {
		return service.obtenerRondas();
	}
}
