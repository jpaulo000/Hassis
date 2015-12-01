package br.ufal.ic.hassis.consultas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ConsultasBipartite {
	private static String[] stringDrogas = { "usaMaconha", "usaCocaina",
			"usaCrack", "usaCola", "usaLolo", "usaEcstasy", "usaLancaPerfume",
			"usaOutrasDrogas" };
	private static String[] stringCidades = { "Maceió", "Arapiraca" };
	private static String[] genero = { "m", "f" };
	private static String[] orientacaoSexual = { "Heterossexual",
			"Homossexual", "Bissexual", "Assexual", "Outro" };
	private static String[] estadoCivil = { "Solteiro(a)", "Casado(a)",
			"Divorciado(a)", "Viúvo(a)", "União Estável", "Outro" };
	private static String[] etnia = { "Brancos", "Pardos", "Negros",
			"Amarelos", "Indígenas", "Sem Declaração" };
	private static String[] escolaridade = { "Fundamental incompleto",
			"Fundamental completo", "Médio incompleto", "Médio completo",
			"Superior incompleto", "Superior completo", "Pós-graduação",
			"Não determinada" };
	private static String[] renda = { "Inferior a um salário mínimo",
			"Entre 1 e 2 salários mínimos", "2 a 3 salários mínimos",
			"3 a 5 salários mínimos", "5 a 10 salários mínimos",
			"20 salários mínimos e mais" };
	// private static String[] tiposDrogas = { "maconha", "cocaína", "crack",
	// "cola", "loló", "ecstasy", "lanca_perfume", "outras" };
	private static String[] frequenciaConsumo = { "Diária",
			"1 ou 2 vezes por semana", "Mais de 2 (duas)", "Semanalmente",
			"Mensalmente", "às vezes" };
	private static String[] comoCompra = { "Dinheiro", "Prostituição",
			"Crimes", "Outras" };
	private static String[] tratamentoRecebido = { "SUS", "Clínica", "SESAU",
			"Outra" };
	private static String[] comoFicouSabendo = { "TV", "Internet",
			"Jornal (Escrito)", "Indicação" };
	private static String[] imagemDPE = { "Muito Boa", "Boa", "Regular",
			"Ruim", "Péssima" };
	
	private static int nLinhasEsq=0;
	private static int nLinhasDir=0;

	private static String json;
	private static Map<String, String[]> categorias;

	public static String gerarDadosExibicao(String chaveEsq, String chaveDir)
			throws IOException {

		if (chaveEsq == null || chaveDir == null) {
			chaveEsq = "estadoCivil";
			chaveDir = "etnia";
		}

		categorias = new HashMap<String, String[]>();
		categorias.put("drogas", stringDrogas);
		categorias.put("cidade", stringCidades);
		categorias.put("genero", genero);
		categorias.put("orientacaoSexual", orientacaoSexual);
		categorias.put("estadoCivil", estadoCivil);
		categorias.put("etnia", etnia);
		categorias.put("escolaridade", escolaridade);
		categorias.put("renda", renda);
		categorias.put("frequenciaConsumo", frequenciaConsumo);
		categorias.put("comoCompra", comoCompra);
		categorias.put("tratamentoRecebido", tratamentoRecebido);
		categorias.put("comoFicouSabendo", comoFicouSabendo);
		categorias.put("imagemDPE", imagemDPE);

		String catEsq[] = categorias.get(chaveEsq);
		String catDir[] = categorias.get(chaveDir);
		
		nLinhasEsq=catEsq.length;
		nLinhasDir=catDir.length;

		MongoClient mongoClient;
		mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("testAssistido");

		DBCollection coll = db.getCollection("usuarioAssistido");

		BasicDBObject query;

		int quantidade = 0;
		
		json = new String("[");
		for (int i = 0; i < catEsq.length; ++i) {
		if(!chaveEsq.equals("drogas") && !chaveDir.equals("drogas")){
			for (int j = 0; j < catDir.length; ++j) {
				query = new BasicDBObject(chaveEsq, catEsq[i]).append(chaveDir,
						catDir[j]);
				quantidade = coll.find(query).count();
				json += "[ \"" + catEsq[i] + "\", \"" + catDir[j] + "\", "
						+ quantidade + "],\n";
			}
		}else{
			if(!chaveDir.equals("drogas")){
				for(int j=0;j< catDir.length;++j){
					query = new BasicDBObject(catEsq[i], true).append(chaveDir,
							catDir[j]);System.out.println("catEsq:"+catEsq[i]+" catDir:"+catDir[j]);
					quantidade = coll.find(query).count();
					json += "[ \"" + catEsq[i] + "\", \"" + catDir[j] + "\", "
							+ quantidade + "],\n";
				}
			}else{
				if(!chaveEsq.equals("drogas")){
					for(int j=0;j< catDir.length;++j){
						query = new BasicDBObject(chaveEsq, catEsq[i]).append(catDir[j],
								true);System.out.println("catEsq:"+catEsq[i]+" catDir:"+catDir[j]);
						quantidade = coll.find(query).count();
						json += "[ \"" + catEsq[i] + "\", \"" + catDir[j] + "\", "
								+ quantidade + "],\n";
					}
				}
			}
		}
		}
		json += "]";
		json = json.replace("],\n]", "]]");
		System.out.println(json);
		return json;
		
		
		
		
		
		/** ex.: etnia X renda *//**Sem drogas*/
	/*	json = new String("[");

		for (int i = 0; i < catEsq.length; ++i) {
			for (int j = 0; j < catDir.length; ++j) {
				query = new BasicDBObject(chaveEsq, catEsq[i]).append(chaveDir,
						catDir[j]);
				quantidade = coll.find(query).count();
				json += "[ \"" + catEsq[i] + "\", \"" + catDir[j] + "\", "
						+ quantidade + "],\n";
			}
		}

		json += "]";
		json = json.replace("],\n]", "]]");
		System.out.println(json);
		return json;*/

	}

	public static int getnLinhasEsq() {
		return nLinhasEsq;
	}

	public static int getnLinhasDir() {
		return nLinhasDir;
	}
}
