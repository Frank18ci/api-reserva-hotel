package com.api.persistence.entities;

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
@Entity(name = "habitaciones")
public class HabitacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Double precio;
	private byte disponibilidad;
	@ManyToOne
	private TipoHabitacionEntity tipoHabitacion;
	@ManyToOne
	private HotelEntity hotel;
	@OneToMany(mappedBy = "habitacion")
	private List<ReservaEntity> reservas;
}
