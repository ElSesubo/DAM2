package es.florida.ej;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ej6 {
	
	static MongoClient mongoClient = new MongoClient("localhost", 27017);
	static MongoDatabase database = mongoClient.getDatabase("damMongoDB");
	static MongoCollection<Document> coleccion = database.getCollection("Llibres");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean continuar = false;
		
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("1. Mostrar tots els ids i els títols de la biblioteca.");
			System.out.println("2. Mostrar la informació detallada d’un llibre a partir del seu id.");
			System.out.println("3. Afegir un nou llibre.");
			System.out.println("4. Modificar atributs d’un llibre a partir del seu id.");
			System.out.println("5. Esborrar llibre.");
			System.out.println("6. Tancar programa");
			System.out.print("Elegir opció: ");
			String opcion = teclado.nextLine();
			
			switch (opcion) {
				case "1":
					mostrarInfo();
					break;
				case "2":
					mostrarInfo();
					System.out.print("Elegir opció: ");
					String op = teclado.nextLine();
					mostrarInfoId(op);
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "6":
					continuar = true;
					break;
			}
		}while(continuar == false);
		mongoClient.close();
	}
	
	public static void mostrarInfo() {
		MongoCursor<Document> cursor = coleccion.find().iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	System.out.println(obj.getString("Id") + ". " + obj.getString("Titol") + " " + obj.getString("Autor") + " " + 
        	obj.getString("Any_naixement") + " " + obj.getString("Any_publicacio") + " " + obj.getString("Editorial") + " " +
        	obj.getString("Nombre_pagines"));
        }
        System.out.println("\n");
	}
	
	public static void mostrarInfoId(String id) {
		Bson query = Filters.eq("Id", id);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();
        while (cursor.hasNext()) {
        	JSONObject obj = new JSONObject(cursor.next().toJson());
        	System.out.println(obj.getString("Id") + ". " + obj.getString("Titol") + " " + obj.getString("Autor") + " " + 
        	obj.getString("Any_naixement") + " " + obj.getString("Any_publicacio") + " " + obj.getString("Editorial") + " " +
        	obj.getString("Nombre_pagines"));
        }
        System.out.println("\n");
	}
	
	public static void insertarObjecte() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Titol: ");
		String tit = teclado.nextLine();
		System.out.print("Autor: ");
		String aut = teclado.nextLine();
		System.out.print("Any Naixement: ");
		String anyN = teclado.nextLine();
		System.out.print("Any Publicació: ");
		String anyP = teclado.nextLine();
		System.out.print("Editorial: ");
		String edt = teclado.nextLine();
		System.out.print("Nombre págines: ");
		String nomP = teclado.nextLine();
		
		Document doc = new Document();
		doc.append("Titol", "pepe");
		doc.append("apellido", "villuela");
		doc.append("apellido", "villuela");
		doc.append("apellido", "villuela");
		doc.append("apellido", "villuela");
		doc.append("apellido", "villuela");
	}

}
