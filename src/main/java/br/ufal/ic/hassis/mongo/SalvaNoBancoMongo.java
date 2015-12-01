package br.ufal.ic.hassis.mongo;

import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import br.ufal.ic.hassis.model.PessoaAssistida;
import br.ufal.ic.hassis.model.UsuarioAssistido;

public class SalvaNoBancoMongo {
	private static MongoClient mongoClient;

	public static MongoClient getInstance() {
		if (mongoClient == null) {
			try {
				mongoClient = new MongoClient("localhost", 27017);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return mongoClient;
	}

	public static void salvar(UsuarioAssistido usrAssistido) {
		// mongoClient = new MongoClient();
		getInstance();


		DB db = mongoClient.getDB("testAssistido");

		DBCollection coll = db.getCollection("usuarioAssistido");
		Gson gson = new GsonBuilder().serializeNulls().create();
		// Converte usrAssistido em JSON e depois em BasicDBObject
		BasicDBObject obj = (BasicDBObject) JSON.parse(gson
				.toJson(usrAssistido));

		coll.insert(obj);

	}
	public static void salvar(PessoaAssistida assistido){
		getInstance();
		
		DB db = mongoClient.getDB("testRecluso");
		
		DBCollection coll =db.getCollection("pessoaAssistida");
		Gson gson = new GsonBuilder().serializeNulls().create();
		// Converte usrAssistido em JSON e depois em BasicDBObject
		BasicDBObject obj = (BasicDBObject) JSON.parse(gson
				.toJson(assistido));

		coll.insert(obj);

	}
}
