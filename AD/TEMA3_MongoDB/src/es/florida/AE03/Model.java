package es.florida.AE03;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public void deleteObject(int id) {
		try {
			con.conexion();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bson query = Filters.eq("Id", id);
		try {
			con.coleccion1.deleteOne(query);
			JOptionPane.showMessageDialog(null, "Registre eliminat correctament");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el registre");
		}
	}
	
	public void updateObject(int id, Document doc) {
		try {
			con.conexion();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bson query = Filters.eq("Id", id);
		try {
			con.coleccion1.updateOne(query, new Document("$set",doc));
			JOptionPane.showMessageDialog(null, "Camps actualitzats correctament");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problema al actulitzar els camps");
		}
	}
	
	public void insertObject(Document doc) {
		try {
			con.conexion();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.coleccion1.insertOne(doc);
			JOptionPane.showMessageDialog(null, "Registre insertat correctament");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar el objecte");
		}
	}
	
	public boolean login(String user, String password) throws IOException, ParseException {
		con.conexion();
		boolean continuar = false;
		String pass256 = DigestUtils.sha256Hex(password);
		String us = null, pass = null;
		MongoCursor<Document> cursor = con.coleccion2.find().iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	us = obj.getString("user");
        	pass = obj.getString("pass");
            if(user.equals(us) && pass256.equals(pass)) {
            	continuar = true;
            }
        }
        return continuar;
	}
	
	public List<Libros> mostrarInfo(Bson query) throws IOException, ParseException {
        con.conexion();
        List<Libros> lista= new ArrayList<Libros>();
        if(query == null) {
            MongoCursor<Document> cursor = con.coleccion1.find().iterator();
            while (cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                int id=obj.getInt("Id");
                String titulo=obj.getString("Titulo");
                lista.add(new Libros(id,titulo));
            }
            return lista;
        }else {
            MongoCursor<Document> cursor = con.coleccion1.find(query).iterator();
            while (cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                int id=obj.getInt("Id");
                String titulo=obj.getString("Titulo");
                lista.add(new Libros(id,titulo));
            }
            return lista;
        }
    }

}
