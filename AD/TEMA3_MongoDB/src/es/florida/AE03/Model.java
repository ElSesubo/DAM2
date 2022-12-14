package es.florida.AE03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Model {
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Document> coleccion;
	static ArrayList<MongoCollection> colecciones;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void conexion() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("./conexion.json");
        Object obj = parser.parse(reader);
        JSONObject pJsonObj = (JSONObject)obj;
            
        String ip = (String) pJsonObj.get("ip");
        Long port = (Long) pJsonObj.get("port");
        String databaseS = (String) pJsonObj.get("database");
        JSONArray collection = (JSONArray)pJsonObj.get("collections");
        
        int portR = port.intValue();
        
    	mongoClient = new MongoClient(ip, portR);
    	database = mongoClient.getDatabase(databaseS);
        for(int i = 0; i < collection.size(); i++) {
        	JSONObject coleccioneSel = (JSONObject)collection.get(i);
        	String nameColeccion = (String) coleccioneSel.get("collection");
        	coleccion = database.getCollection(nameColeccion);
        	colecciones.add(coleccion);
        }
	}
	
	public String mostrarInfoId(String id) {
		String info = "";
		Bson query = Filters.eq("Id", id);
		MongoCursor<Document> cursor = colecciones.get(0).find(query).iterator();
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
	
	public boolean login(String user, String password) {
		boolean continuar = false;
		String pass256 = DigestUtils.sha256Hex(password);
		String us = null, pass = null;
		MongoCursor<Document> cursor = colecciones.get(1).find().iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	us = obj.getString("user");
        	pass = obj.getString("pass");
        }
        if(user.equals(us) && pass256.equals(pass)) {
        	continuar = true;
        }
        return continuar;
	}

}
