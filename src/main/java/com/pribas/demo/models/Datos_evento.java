package com.pribas.demo.models;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@lombok.Data
@RequiredArgsConstructor
@SuperBuilder
public class Datos_evento {
	
	
	private String fecha_inicio;
	private String hora_inicio;
	private String fecha_fin;
	private String hora_fin;
	private String dias_semana;
	private String edificio;
	private String descripcion_edificio;
	private String salon;
	private String tipo_funcion;
	private String codigo_funcion;
	private String nombre_funcion;
	private List<Datos_prospecto> datos_prospecto;
	
	
}
