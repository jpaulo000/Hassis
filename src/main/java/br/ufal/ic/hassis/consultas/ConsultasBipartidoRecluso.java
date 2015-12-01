package br.ufal.ic.hassis.consultas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ConsultasBipartidoRecluso {
	private static String[] stringCidades = { "Água Branca", "Anadia", "Arapiraca",
		"Atalaia", "Barra de Santo Antônio", "Barra de São Miguel",
		"Batalha", "Belém", "Belo Monte", "Boca da Mata", "Branquinha",
		"Cacimbinhas", "Cajueiro", "Campestre", "Campo Alegre",
		"Campo Grande", "Canapi", "Capela", "Carneiros", "Chã Preta",
		"Coité do Nóia", "Colônia Leopoldina", "Coqueiro Seco", "Coruripe",
		"Craíbas", "Delmiro Gouveia", "Dois Riachos", "Estrela de Alagoas",
		"Feira Grande", "Feliz Deserto", "Flexeiras", "Girau do Ponciano",
		"Ibateguara", "Igaci", "Igreja Nova", "Inhapi",
		"Jacaré dos Homens", "Jacuípe", "Japaratinga", "Jaramataia",
		"Jequiá da Praia", "Joaquim Gomes", "Jundiá", "Junqueiro",
		"Lagoa da Canoa", "Limoeiro de Anadia", "Major Isidoro",
		"Mar Vermelho", "Maragogi", "Maravilha", "Marechal Deodoro",
		"Maribondo", "Mata Grande", "Matriz de Camaragibe", "Messias",
		"Minador do Negrão", "Monteirópolis", "Murici", "Novo Lino",
		"Olho d`Água das Flores", "Olho d`Água do Casado",
		"Olho d`Água Grande", "Olivença", "Ouro Branco", "Palestina",
		"Palmeira dos Índios", "Pão de Açúcar", "Pariconha", "Paripueira",
		"Passo de Camaragibe", "Paulo Jacinto", "Penedo", "Piaçabuçu",
		"Pilar", "Pindoba", "Piranhas", "Poço das Trincheiras",
		"Porto Calvo", "Porto de Pedras", "Porto Real do Colégio",
		"Quebrangulo", "Rio Largo", "Roteiro", "Santa Luzia do Norte",
		"Santana do Ipanema", "Santana do Mundaú", "São Brás",
		"São José da Laje", "São José da Tapera", "São Luís do Quitunde",
		"São Miguel dos Campos", "São Miguel dos Milagres",
		"São Sebastião", "Satuba", "Senador Rui Palmeira", "Tanque d`Arca",
		"Taquarana", "Teotônio Vilela", "Traipu", "União dos Palmares",
		"Viçosa"  };
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
	private static String[] profissoes = { "Açougueiro",
		"Ajudante de carga e descarga", "Ajudante de cozinha",
		"Ajudante de eletricista", "Ajudante de serviços gerais",
		"Almoxarife", "Armazenista", "Assistente administrativo",
		"Assistente de loja", "Assistente de vendas",
		"Atendente de balcão", "Atendente de lanchonete",
		"Atendente de loja", "Atendente de padaria",
		"Auxiliar administrativo", "Auxiliar de almoxarife",
		"Auxiliar de cabeleireiro", "Auxiliar de compras",
		"Auxiliar de cozinha", "Auxiliar de limpeza",
		"Auxiliar de linha de produção",
		"Auxiliar de mecânico de ar condicionado",
		"Auxiliar de mecânico de autos", "Auxiliar de serviços gerais",
		"Auxiliar técnico de refrigeração", "Barman",
		"Bombeiro hidráulico", "Borracheiro", "Cabeleireiro",
		"Caldeireiro", "Capataz rural", "Carpinteiro", "Caseiro",
		"Chapeiro", "Cobrador de transportes coletivos",
		"Cobrador externo", "Confeiteiro", "Cozinheiro", "Eletricista",
		"Eletricista automotivo", "Eletricista auxiliar",
		"Embalador a mão", "Empacotador a mão", "Empregado doméstico",
		"Encanador", "Estoquista", "Frentista", "Funileiro",
		"Garagista de veículos", "Garçom", "Gari", "Gesseiro",
		"Instalador de acessórios para veículos", "Jardineiro",
		"Jovem aprendiz", "Lanterneiro de automóveis", "Lavador de carros",
		"Lavador de pratos", "Lavador de pratos", "Marceneiro",
		"Mecânico de ar-condicionado", "Mecânico de automóveis", "Motoboy",
		"Motorista de caminhão (HAB D)", "Motorista entregador",
		"Operador de caixa", "Operador de caldeira",
		"Operador de empilhadeira", "Padeiro", "Pedreiro", "Pintor",
		"Pintor de alvenaria", "Porteiro", "Promotor de vendas",
		"Recepcionista", "Repositor em supermercados", "Serralheiro",
		"Servente de limpeza", "Servente de obras", "Serviços gerais",
		"Soldador", "Soldador MIG", "Técnico mecânico",
		"Torneiro mecânico", "Trabalhador rural", "Vaqueiro", "Vigilante",
		"Zelador" };
	private static String[] trueFalse = {"true","false"};
	
	private static int nLinhasEsq=0;
	private static int nLinhasDir=0;

	private static String json;
	private static Map<String, String[]> categorias;

	public static String gerarDadosExibicao(String chaveEsq, String chaveDir)
			throws IOException {

		if (chaveEsq == null || chaveDir == null) {
			chaveEsq = "escolaridade";
			chaveDir = "etnia";
		}

		categorias = new HashMap<String, String[]>();
		categorias.put("cidade", stringCidades);
		categorias.put("etnia", etnia);
		categorias.put("escolaridade", escolaridade);
		categorias.put("renda", renda);
		categorias.put("profissao", profissoes);
		
		categorias.put("jaSofreuMedidaSocioEducativa", trueFalse);
		categorias.put("usaSubstanciaEntorpecente", trueFalse);
		categorias.put("familiaRealizaVisitas", trueFalse);
		categorias.put("temAlgumParentePreso", trueFalse);
		categorias.put("jaSofreuViolenciaNoPresidio", trueFalse);
		

		String catEsq[] = categorias.get(chaveEsq);
		String catDir[] = categorias.get(chaveDir);
		
		nLinhasEsq=catEsq.length;
		nLinhasDir=catDir.length;

		MongoClient mongoClient;
		mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("testRecluso");

		DBCollection coll = db.getCollection("pessoaAssistida");

		BasicDBObject query;

		int quantidade = 0;

		json = new String("[");
		for (int i = 0; i < catEsq.length; ++i) {
			if (!chaveEsq.equals("drogas") && !chaveDir.equals("drogas")) {
				for (int j = 0; j < catDir.length; ++j) {
					query = new BasicDBObject(chaveEsq, catEsq[i]).append(
							chaveDir, catDir[j]);
					quantidade = coll.find(query).count();
					json += "[ \"" + catEsq[i] + "\", \"" + catDir[j] + "\", "
							+ quantidade + "],\n";
				}
			} 
		}
		json += "]";
		json = json.replace("],\n]", "]]");
		System.out.println(json);
		return json;
	}

	public static int getnLinhasEsq() {
		return nLinhasEsq;
	}

	public static int getnLinhasDir() {
		return nLinhasDir;
	}
}