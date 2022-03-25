package com.pribas.demo.repository;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pribas.demo.models.AllData;
import com.pribas.demo.models.Data;
import com.pribas.demo.models.Datos_evento;


public interface RepositoryDbMongo extends MongoRepository<AllData, String> {
	
	/*@Query(value = "{'_id': ?0, 'data.$datos_evento.$datos_prospecto.$numero_documento': ?0}")
	Datos_prospecto getProspecto(String _id, String numero_documento);*/
	
	/*@Query(value = "{'_id': ?0, {'data.data.codigo_evento': ?0}}")
	Data getEvento(String _id, String codigo_evento);*/
	
	
}
