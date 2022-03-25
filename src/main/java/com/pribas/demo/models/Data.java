package com.pribas.demo.models;

import java.util.List;


import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@lombok.Data
@RequiredArgsConstructor
@SuperBuilder
public class Data {
	
	private String tipo_evento;
	private String descripcion_evento;
	private String codigo_evento;
	private String fecha_transaccion_evento;
	private String descripcion_tipo_evento;
	private String campus_evento;
	private List<Datos_evento> datos_evento;

}
