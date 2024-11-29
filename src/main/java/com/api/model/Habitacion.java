package com.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
	private int id;
	private Double precio;
	private byte disponibilidad;
	private TipoHabitacion tipoHabitacion;
	private Hotel hotel;
	private List<Reserva> reservas;
}
