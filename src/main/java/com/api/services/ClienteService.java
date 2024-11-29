package com.api.services;

import java.util.List;

import com.api.model.Cliente;

public interface ClienteService {
	public List<Cliente> getClientes();
	public void saveCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public Cliente findClienteById(int id);
	public void removeClienteById(int id);
}
