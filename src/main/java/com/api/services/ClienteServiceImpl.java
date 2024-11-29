package com.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exceptions.ResourceNotFoundException;
import com.api.model.Cliente;
import com.api.persistence.entities.ClienteEntity;
import com.api.persistence.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired 
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll()
				.stream().map(clienteEntity -> {
					Cliente cliente = new Cliente();
					cliente.setId(clienteEntity.getId());
					cliente.setNombres(clienteEntity.getNombres());
					cliente.setApellidos(clienteEntity.getApellidos());
					cliente.setDni(clienteEntity.getDni());
					cliente.setNumTel(clienteEntity.getNumTel());
					return cliente;
				}).collect(Collectors.toList());
		return clientes;
	}

	@Override
	public void saveCliente(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNombres(cliente.getNombres());
		clienteEntity.setApellidos(cliente.getApellidos());
		clienteEntity.setDni(cliente.getDni());
		clienteEntity.setNumTel(cliente.getNumTel());
		clienteRepository.save(clienteEntity);
	} 
	@Override
	public void updateCliente(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(cliente.getId());
		clienteEntity.setNombres(cliente.getNombres());
		clienteEntity.setApellidos(cliente.getApellidos());
		clienteEntity.setDni(cliente.getDni());
		clienteEntity.setNumTel(cliente.getNumTel());
		clienteRepository.save(clienteEntity);
	}

	@Override
	public Cliente findClienteById(int id) {
		Cliente cliente = clienteRepository.findById(id).map(
				clienteEntity -> {
				Cliente c = new Cliente();
				c.setId(clienteEntity.getId());
				c.setNombres(clienteEntity.getNombres());
				c.setApellidos(clienteEntity.getApellidos());
				c.setDni(clienteEntity.getDni());
				c.setNumTel(clienteEntity.getNumTel());
				return c;
				}).orElseThrow(() -> new ResourceNotFoundException("Recurso con id: " + id +" no encontrado"));
		return cliente;
	}

	@Override
	public void removeClienteById(int id) {
		clienteRepository.deleteById(id);
	}
}
