package com.pribas.demo.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@RequiredArgsConstructor
@SuperBuilder
public class Datos_academicos {
	
	private String campus;
	private String periodo_ingreso;
	private String descripcion_periodo_ingreso;
	private String programa;
	private String descripcion_programa;
	private String facultad;
	private String descripcion_facultad;
	private String nivel;
	private String descripcion_nivel;
	private String tipo_admision;
	private String descripcion_tipo_admision;
	private String tipo_alumno;
	private String descripcion_tipo_alumno;
	private String anio;
	private String periodo_agrupado;
	private String modalidad;
	private String descripcion_modalidad;

}
