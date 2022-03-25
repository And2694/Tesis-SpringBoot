package com.pribas.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pribas.demo.models.*;
import com.pribas.demo.services.MongoService;

import java.util.List;


@Controller
@RequestMapping("/api")
public class Controllers {
	
	@Autowired
	private MongoService mServices;
	
	
	@GetMapping("/getAll")
	public @ResponseBody List<AllData> getAll() {
		return mServices.getAll();
	}
	
	@PostMapping("/addProspect/{codigo_evento}/{codigo_funcion}")
	public @ResponseBody Datos_prospecto getEvento(@PathVariable String codigo_evento, @PathVariable String codigo_funcion, @RequestBody Datos_prospecto prospecto) {
		return mServices.addProspecto(codigo_evento, codigo_funcion, prospecto);
	}
	
	
	@DeleteMapping("/deleteProspect/{numero_documento}")
	public @ResponseBody String deleteProspect(@PathVariable String numero_documento) {
		return mServices.deleteProspect(numero_documento);
	}
	
	
	@PutMapping("/updateProspect/{numero_documento}")
	public @ResponseBody List<AllData> updateProspect(@PathVariable String numero_documento, @RequestBody Datos_prospecto datos_prospecto){
		return mServices.updateProspect(numero_documento, datos_prospecto);
	}
	
}
