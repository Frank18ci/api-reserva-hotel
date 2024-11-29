package com.api.services;

import java.util.List;

import com.api.model.Cliente;
import com.api.model.Habitacion;

public interface HabitacionService {
	public List<Habitacion> getHabitaciones();
	public void saveHabitacion(Habitacion cliente);
	public void updateHabitacion(Habitacion cliente);
	public Habitacion findHabitacionById(int id);
	public void removeHabitacionById(int id);
}
