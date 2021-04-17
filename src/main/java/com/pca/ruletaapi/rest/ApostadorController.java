package com.pca.ruletaapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pca.ruletaapi.dao.ApostadorDAO;
import com.pca.ruletaapi.model.Apostador;

@RestController
@RequestMapping(value = "/api/v1")
public class ApostadorController {
	
	@Autowired
	private ApostadorDAO repo; //Simula el acceso a un servicio de repositorio
	
	public ApostadorController() {
	}

	@CrossOrigin
	@GetMapping(value = "/apostadores")
	public List<Apostador> obtenerTodos() {
		return repo.obtenerTodos();
	}
	
	@CrossOrigin
	@PostMapping(value = "/crear")
	public ResponseEntity<Apostador> crear(@RequestBody Apostador apostador) {
		Apostador ap = repo.crear(apostador);
		return new ResponseEntity<Apostador>(ap, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value = "/editar")
	public ResponseEntity<Apostador> editar(@RequestBody Apostador apostador) {
		Apostador ap = repo.editar(apostador);
		return new ResponseEntity<Apostador>(ap, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/eliminar/{id}")
	public ResponseEntity<Apostador> eliminar(@PathVariable Integer id) {
		Apostador ap = repo.obtenerPorId(id);
		if (ap != null) {
			repo.eliminar(id);
		} else {
			return new ResponseEntity<Apostador>(ap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Apostador>(ap, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/consultar/{id}")
	public ResponseEntity<Apostador> consultar(@PathVariable Integer id) {
		Apostador ap = repo.obtenerPorId(id);
		return new ResponseEntity<Apostador>(ap, HttpStatus.OK);
	}
}
