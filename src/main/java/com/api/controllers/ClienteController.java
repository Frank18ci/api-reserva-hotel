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
import com.api.services.ClienteService;
import com.api.services.ClienteServiceImpl;


@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {
	@Autowired 
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<?> listaClientes(){
		List<Cliente> lista = clienteService.getClientes();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable int id){
		Cliente cliente = clienteService.findClienteById(id);
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente c){
		clienteService.saveCliente(c);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<?> editarCliente(@RequestBody Cliente c){
		clienteService.updateCliente(c);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable int id){
		clienteService.removeClienteById(id);
		return ResponseEntity.noContent().build();
	}
}
