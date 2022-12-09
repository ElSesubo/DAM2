package es.florida.AE03;

import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Model {
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Document> coleccion;
	
	public Model(MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> coleccion) {
		this.mongoClient = mongoClient;
		this.database = database;
		this.coleccion = coleccion;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String mostrarInfoId(String id) {
		String info = "";
		Bson query = Filters.eq("Id", id);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	info += (obj.getString("Id") + ". " + obj.getString("Titol") + " " + obj.getString("Autor") + " " + 
        	obj.getString("Any_naixement") + " " + obj.getString("Any_publicacio") + " " + obj.getString("Editorial") + " " +
        	obj.getString("Nombre_pagines") + "\n");
        }
        return info;
	}
	
	public void deleteObject(String id) {
		Bson query = Filters.eq("Id", id);
		coleccion.deleteOne(query);
	}
	
	public void updateObject(String id, Document doc) {
		Bson query = Filters.eq("Id", id);
		coleccion.updateOne(query, doc);
	}
	
	public void insertObject(Document doc) {
		coleccion.insertOne(doc);
	}

}
