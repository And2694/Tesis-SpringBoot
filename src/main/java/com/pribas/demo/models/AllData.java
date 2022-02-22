package com.pribas.demo.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.RequiredArgsConstructor;

@lombok.Data
@RequiredArgsConstructor
@Document(collection = "Tesis")
public class AllData {
	
	private String _id;
	private List<Data> Data;

}
