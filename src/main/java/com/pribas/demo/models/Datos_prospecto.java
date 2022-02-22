package com.pribas.demo.models;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@lombok.Data
@RequiredArgsConstructor
@SuperBuilder
public class Datos_prospecto {

	private Integer pidm;
	private String id_banner;
	private String nombres;
	private String apellidos;
	private String username;
	private String claimpuce;
	private String tipo_documento;
	private String numero_documento;
	private String fecha_nacimiento;
	private String sexo;
	private String fecha_transaccion;
	private Datos_academicos datos_academicos;
	private List<Datos_telefono> datos_telefono;
	private List<Datos_correo> datos_correo;
	
}	
