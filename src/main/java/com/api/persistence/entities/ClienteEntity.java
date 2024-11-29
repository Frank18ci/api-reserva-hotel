package com.api.persistence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "clientes")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombres;
	private String apellidos;
	@Column(length = 8)
	private String dni;
	@Column(length = 12)
	private String numTel;
	@OneToMany(mappedBy = "cliente")
	private List<ReservaEntity> reservas;
}
