package es.florida.ej;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("damMongoDB");
		MongoCollection<Document> coleccion = database.getCollection("canciones");
		//CRUD operations
		
		List listaDocs = new ArrayList();
		
		Document doc = new Document();
		doc.append("nombre", "pepe");
		doc.append("apellido", "villuela");
		
		Document doc2 = new Document();
		doc2.append("nombre12", "pep2e");
		doc2.append("apellido12", "villuela2");
		
		listaDocs.add(doc);
		listaDocs.add(doc2);
		
		coleccion.insertMany(listaDocs);

		mongoClient.close();

	}

}
