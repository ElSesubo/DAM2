package es.florida.AE03;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Principal {
	static MongoClient mongoClient = new MongoClient("localhost", 27017);
	static MongoDatabase database = mongoClient.getDatabase("damMongoDB");
	static MongoCollection<Document> coleccion = database.getCollection("Llibres");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject file = new JSONObject();
		 
	    file.put("Full Name", "Ritu Sharma");
	    file.put("Roll No.", new Integer(1704310046));
	    file.put("Tuition Fees", new Double(65400));
	    
		Model model = new Model(mongoClient, database, coleccion);
		Vista vista = new Vista();

		Controlador controlador = new Controlador(vista, model);
	}
}
