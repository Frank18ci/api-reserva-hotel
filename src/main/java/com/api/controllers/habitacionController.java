package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Cliente;
import com.api.model.Habitacion;
import com.api.services.ClienteService;
import com.api.services.ClienteServiceImpl;
import com.api.services.HabitacionService;


@RestController
@RequestMapping("/habitaciones")
@CrossOrigin
public class habitacionController {
	@Autowired 
	HabitacionService habitacionService;
	
	@GetMapping
	public ResponseEntity<?> listaHabitaciones(){
		List<Habitacion> lista = habitacionService.getHabitaciones();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarHabitacion(@PathVariable int id){
		Habitacion habitacion = habitacionService.findHabitacionById(id);
		return ResponseEntity.ok(habitacion);
	}
	
	@PostMapping
	public ResponseEntity<?> agregarCliente(@RequestBody Habitacion h){
		habitacionService.saveHabitacion(h);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<?> editarCliente(@RequestBody Habitacion h){
		habitacionService.updateHabitacion(h);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable int id){
		habitacionService.removeHabitacionById(id);
		return ResponseEntity.noContent().build();
	}
}
