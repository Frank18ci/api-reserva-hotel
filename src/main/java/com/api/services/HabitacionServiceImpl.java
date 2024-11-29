package com.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exceptions.ResourceNotFoundException;
import com.api.model.Cliente;
import com.api.model.Habitacion;
import com.api.persistence.entities.ClienteEntity;
import com.api.persistence.entities.HabitacionEntity;
import com.api.persistence.repositories.ClienteRepository;
import com.api.persistence.repositories.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService {
	@Autowired 
	private HabitacionRepository repository;

	@Override
	public List<Habitacion> getHabitaciones() {
		List<Habitacion> hbs = repository.findAll()
				.stream().map(habitacionEntity -> {
					Habitacion h = new Habitacion();
					h.setId(habitacionEntity.getId());
					h.setPrecio(habitacionEntity.getPrecio());
					h.setDisponibilidad(habitacionEntity.getDisponibilidad());
					return h;
				}).collect(Collectors.toList());
		return hbs;
	}

	@Override
	public void saveHabitacion(Habitacion habitacion) {
		HabitacionEntity he = new HabitacionEntity();
		he.setPrecio(habitacion.getPrecio());
		he.setDisponibilidad(habitacion.getDisponibilidad());
		repository.save(he);
	} 
	@Override
	public void updateHabitacion(Habitacion habitacion) {
		HabitacionEntity he = new HabitacionEntity();
		he.setId(habitacion.getId());
		he.setPrecio(habitacion.getPrecio());
		he.setDisponibilidad(habitacion.getDisponibilidad());
		repository.save(he);
	}

	@Override
	public Habitacion findHabitacionById(int id) {
		Habitacion habitacion = repository.findById(id).map(
				habitacionEntity -> {
				Habitacion h = new Habitacion();
				h.setId(habitacionEntity.getId());
				h.setPrecio(habitacionEntity.getPrecio());
				h.setDisponibilidad(habitacionEntity.getDisponibilidad());
				return h;
				}).orElseThrow(() -> new ResourceNotFoundException("Recurso con id: " + id +" no encontrado"));
		return habitacion;
	}

	@Override
	public void removeHabitacionById(int id) {
		repository.deleteById(id);
	}
}
