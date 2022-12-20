package AE03;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Model {

	conexion con = new conexion();
	
	public static void main(String[] args) throws IOException, ParseException {
		Model m=new Model();
		m.con.conexion();
	}
	
	public String mostrarInfoId(int id) throws IOException, ParseException {
		con.conexion();
		String info = "";
		Bson query = Filters.eq("Id", id);
		MongoCursor<Document> cursor = con.coleccion1.find(query).iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	info += (obj.getInt("Id") + "\n" + obj.getString("Titulo") + "\n" + obj.getString("Autor") + "\n" + 
        	obj.getInt("Anyo_nacimiento") + "\n" + obj.getInt("Anyo_publicacion") + "\n" + obj.getString("Editorial") + "\n" +
        	obj.getInt("Numero_paginas") + "\n" + obj.getString("Thumbnail"));
        }
        return info;
	}
	
	public void deleteObject(String id) {
		Bson query = Filters.eq("Id", id);
		con.coleccion1.deleteOne(query);
	}
	
	public void updateObject(String id, Document doc) {
		Bson query = Filters.eq("Id", id);
		con.coleccion1.updateOne(query, doc);
	}
	
	public void insertObject(Document doc) {
		con.coleccion1.insertOne(doc);
	}
	
	public boolean login(String user, String password) {
		boolean continuar = false;
		String pass256 = DigestUtils.sha256Hex(password);
		String us = "", pass = "";
		MongoCursor<Document> cursor = con.coleccion2.find().iterator();
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
