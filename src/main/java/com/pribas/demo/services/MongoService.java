package com.pribas.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.support.SpringDataMongodbQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.pribas.demo.models.AllData;
import com.pribas.demo.models.Datos_evento;
import com.pribas.demo.models.Datos_prospecto;
import com.pribas.demo.repository.RepositoryDbMongo;
import com.pribas.demo.models.Data;

@Service
public class MongoService {
	
	@Autowired
	private RepositoryDbMongo repomongo;
	private int getIndexData = 0;
	private int getIndexEvento = 0;
	

	
	public List<AllData> getAll(){
	  return repomongo.findAll();
	}
	
	public Datos_prospecto addProspecto(String codigo_evento, String codigo_funcion, Datos_prospecto prospecto){
		List<AllData> tempData = repomongo.findAll();
		getEvento(codigo_evento, codigo_funcion);
		tempData.get(0).getData().get(this.getIndexData).getDatos_evento().get(this.getIndexEvento).getDatos_prospecto().add(prospecto);		
		try {
			repomongo.saveAll(tempData);
			return  prospecto;
		}catch (MongoException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public List<String> getCodigos(){
		List<String> codigo_funcion = new ArrayList<>();
		List<String> codigo_evento = new ArrayList<>();
		List<AllData> allData = repomongo.findAll();
		List<Data> data = allData.get(0).getData();
		List<Datos_evento> evento = new ArrayList<>();
		int i =0;
		for (Data tempData : data) {
			evento.addAll(data.get(i).getDatos_evento());
			codigo_evento.add(data.get(i).getCodigo_evento());
			i++;
		}
		
		int j =0;
		for (Datos_evento datos_evento : evento) {
			codigo_funcion.add(evento.get(j).getCodigo_funcion());
			j++;
		}
		System.out.println(codigo_evento.size()+ " " + codigo_evento);
		System.out.println(codigo_funcion.size()+ " " + codigo_funcion);
		return codigo_funcion;
	}
	
	
	
	
	
	public void getEvento(String codigo_evento, String codigo_funcion){
		List<AllData> allData = repomongo.findAll();
		List<Data> data = allData.get(0).getData();
		List<Datos_evento> evento = new ArrayList<>();
		List<Datos_prospecto> prospectos = new ArrayList<>();
		int i =0;
		for (Data dataTemp : data) {
			if(data.get(i).getCodigo_evento().equalsIgnoreCase(codigo_evento)) {
				evento = data.get(i).getDatos_evento();
				this.getIndexData=i;
			}
		i++;
		}
		int k =0;
		int getIndexEvento=0;
		for (Datos_evento datos_evento : evento) {
			if(evento.get(k).getCodigo_funcion().equalsIgnoreCase(codigo_funcion)) {
				this.getIndexEvento=k;
			}
			k++;
		}
	}

	public String deleteProspect(String numero_documento) {
		
		List<AllData> allData = repomongo.findAll();
		List<Datos_prospecto> datosP = allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto();
		for(int i =0; i < datosP.size(); i++) {
			if(datosP.get(i).getNumero_documento().equalsIgnoreCase(numero_documento)) {
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().remove(i);
			}else {
				
			}
		}
		
		repomongo.saveAll(allData);
		
		return "Prospecto eliminado" ;
	}

	public List<AllData> updateProspect(String numero_documento, Datos_prospecto datos_prospecto) {
		
		List<AllData> allData = repomongo.findAll();
		List<Datos_prospecto> datosP = allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto();
		for(int i =0; i < datosP.size(); i++) {
			if(datosP.get(i).getNumero_documento().equalsIgnoreCase(numero_documento)) {
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setNombres(datos_prospecto.getNombres());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setApellidos(datos_prospecto.getApellidos());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setPidm(datos_prospecto.getPidm());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setNumero_documento(datos_prospecto.getNumero_documento());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setTipo_documento(datos_prospecto.getTipo_documento());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setFecha_nacimiento(datos_prospecto.getFecha_nacimiento());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setFecha_transaccion(datos_prospecto.getFecha_transaccion());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setSexo(datos_prospecto.getSexo());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setClaimpuce(datos_prospecto.getClaimpuce());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setId_banner(datos_prospecto.getId_banner());
				allData.get(0).getData().get(0).getDatos_evento().get(0).getDatos_prospecto().get(i).setUsername(datos_prospecto.getUsername());
			}else {
				
			}
		}
		
		repomongo.saveAll(allData);
		
		return allData;
	}

	
	
	
	

}
