package com.pribas.demo.models;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@lombok.Data
@RequiredArgsConstructor
@SuperBuilder
public class Datos_telefono {
	
	private String tipo_telefono;
	private String codigo_area;
	private String numero_telefono;
	
}
