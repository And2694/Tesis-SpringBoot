package com.pribas.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pribas.demo.models.*;
import com.pribas.demo.repository.RepositoryDbMongo;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
public class Controllers {
	
	@Autowired
	public RepositoryDbMongo repomongo;
	
	
	@GetMapping("/getAll")
	public @ResponseBody List<AllData> getAll() {
		return repomongo.findAll();
	}
	
	
	@PostMapping("/createProspect")
	public @ResponseBody Datos_prospecto createProspecto(@RequestBody Datos_prospecto datos_prospecto) {
		
	}
	
}
