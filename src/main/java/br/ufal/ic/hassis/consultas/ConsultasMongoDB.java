package br.ufal.ic.hassis.consultas;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ConsultasMongoDB {

	private static String[] stringDrogas = { "usaMaconha", "usaCocaina",
			"usaCrack", "usaCola", "usaLolo", "usaEcstasy", "usaLancaPerfume",
			"usaOutrasDrogas" };
	private static String[] stringCidades = { "Maceió", "Arapiraca" };

	public static void main(String[] args) throws IOException {
		//Gson gson = new GsonBuilder().serializeNulls().create();

		MongoClient mongoClient;
		mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("test");

		DBCollection coll = db.getCollection("usuarioAssistido");

		DBCursor cursor;

		BasicDBObject query;

		Map<String, Integer> assistidosPorCidade = new HashMap<String, Integer>();
		Map<String, Integer> usuariosPorDroga = new HashMap<String, Integer>();
		float tabelaRalacao[][] = new float[10][10];

		for (int i = 0; i < stringCidades.length; ++i) {
			query = new BasicDBObject("cidade", stringCidades[i]);
			cursor = coll.find(query);
			assistidosPorCidade.put(stringCidades[i], cursor.count());
			System.out.println("Mora em " + stringCidades[i] + " = "
					+ cursor.count());
		}

		for (int i = 0; i < stringDrogas.length; ++i) {
			query = new BasicDBObject(stringDrogas[i], true);
			cursor = coll.find(query);
			usuariosPorDroga.put(stringDrogas[i], cursor.count());
			System.out.println(stringDrogas[i] + " = " + cursor.count());
		}

		int index = 2;
		for (int i = 0; i < stringCidades.length; ++i) {
			for (int j = 0; j < stringDrogas.length; ++j) {
				query = new BasicDBObject("cidade", stringCidades[i]).append(
						stringDrogas[j], true);
				cursor = coll.find(query);
				tabelaRalacao[i][j + index] = (float) cursor.count()
						/ assistidosPorCidade.get(stringCidades[i]);
				tabelaRalacao[j + index][i] = (float) cursor.count()
						/ usuariosPorDroga.get(stringDrogas[j]);
				System.out.println("Mora em " + stringCidades[i] + " e "
						+ stringDrogas[j] + " = " + cursor.count());
			}
		}
		System.out.println("fim");

		for (int i = 0; i < stringDrogas.length; ++i) {
			for (int j = 0; j < stringDrogas.length; ++j) {
				query = new BasicDBObject(stringDrogas[i], true).append(
						stringDrogas[j], true);
				cursor = coll.find(query);
				tabelaRalacao[i + index][j + index] = (float) cursor.count()
						/ usuariosPorDroga.get(stringDrogas[i]);
				System.out.println(stringDrogas[i] + " e " + stringDrogas[j]
						+ " = " + cursor.count());
			}

		}

		for (int i = 0; i < 10; ++i) {
			tabelaRalacao[i][i] = 0;
		}

		/**exibir float com (.) ao invés de (,)*//*
		Locale.setDefault(Locale.US);//
		
		System.out.println("[");
		for (int i = 0; i < 10; ++i) {
			System.out.print("[");
			for (int j = 0; j < 10; ++j) {
				System.out.printf("%.2f,", tabelaRalacao[i][j]);
			}
			System.out.println("],");
		}*/
		JSONArray mJSONArray = new JSONArray(Arrays.asList(tabelaRalacao));
		System.out.println("Array to json");
		System.out.println(mJSONArray.toString());
		
		/**Salvar*/
		File file = new File("./src/main/webapp/resources/json/myjson.json");
		FileOutputStream tempFileOutputStream = new FileOutputStream(
				file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				tempFileOutputStream, 1024);
		bufferedOutputStream.write(mJSONArray.toString().getBytes());
		
		bufferedOutputStream.close();

		// int count=0;
		/*
		 * try { while (cursor.hasNext()) { System.out.println(++count);
		 * System.out.println(cursor.next()); } } finally { cursor.close(); }
		 */

		// DBCursor cursor = coll.find();

	}
}
