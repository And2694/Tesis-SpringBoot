package com.pribas.demo.models;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@lombok.Data
@RequiredArgsConstructor
@SuperBuilder
public class Datos_correo {
	
	private String tipo_correo;
	private String correo;

}
