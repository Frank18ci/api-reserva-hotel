package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	 private int id;
	 private String nombres;
	 private String apellidos;
	 private String dni;
	 private String numTel;
}
