package br.ufal.ic.hassis.mongo.povoar;

import java.net.UnknownHostException;
import java.util.Random;

import br.ufal.ic.hassis.model.PessoaAssistida;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class PovoarBancoReclusos {
	private PessoaAssistida usrTest;

	private static String[] nomeDoRecluso = { "Miguel", "Davi", "Arthur",
			"Pedro", "Gabriel", "Bernardo", "Lucas", "Matheus", "Rafael",
			"Heitor", "Enzo", "Guilherme", "Nicolas", "Lorenzo", "Gustavo",
			"Felipe", "Samuel", "João Pedro", "Daniel", "Vitor", "Leonardo",
			"Henrique", "Theo", "Murilo", "Eduardo", "Pedro Henrique",
			"Pietro", "Cauã", "Isaac", "Caio", "Vinicius", "Benjamin", "João",
			"Lucca", "João Miguel", "Bryan", "Joaquim", "João Vitor", "Thiago",
			"Antônio", "Davi Lucas", "Francisco", "Enzo Gabriel", "Bruno",
			"Emanuel", "João Gabriel", "Ian", "Davi Luiz", "Rodrigo", "Otávio",
			"Thomas", "Benício", "Erick", "Nathan", "Fernando", "Yuri",
			"Davi Lucca", "Calebe", "Thales", "Vicente", "João Guilherme",
			"Vitor Hugo", "Anthony", "Ryan", "Breno", "João Lucas",
			"Luiz Felipe", "Alexandre", "Igor", "Carlos Eduardo", "Bento",
			"Raul", "André", "Levi", "Noah", "Augusto", "Diego", "Kaique",
			"Yago", "Pedro Lucas", "Diogo", "Luiz Gustavo", "Luiz Miguel",
			"Ricardo", "Kauê", "Luan", "Luiz Henrique", "Danilo", "Marcelo",
			"Gael", "Juan", "Enrico", "Henry", "Vitor Gabriel", "João Paulo",
			"Lucas Gabriel", "Luiz Fernando", "Luiz Otávio", "Renan", "Kevin" };
	private static String[] sobrenomes = { "Silva", "Souza", "Costa", "Santos",
			"Oliveira", "Pereira", "Rodrigues", "Almeida", "Nascimento",
			"Lima", "Araújo", "Fernandes", "Carvalho", "Gomes", "Martins",
			"Rocha", "Ribeiro", "Alves", "Monteiro", "Mendes", "Barros",
			"Freitas", "Barbosa", "Pinto", "Moura", "Cavalcanti", "Dias",
			"Castro", "Campos", "Cardoso" };

	private static String[] cidades = { "Água Branca", "Anadia", "Arapiraca",
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
			"Viçosa" };

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

	private static Random random = new Random();

	public PovoarBancoReclusos() {
		usrTest = new PessoaAssistida();

	}

	private PessoaAssistida preencherUsr() {
		usrTest.setNomeAssistido(nomeDoRecluso[random.nextInt(100)] + " "
				+ sobrenomes[random.nextInt(30)]);
		usrTest.setRg(Integer.toString(random.nextInt(99999)));
		usrTest.setCpf(Integer.toString(random.nextInt(999999)));

		usrTest.setEstado("Alagoas");
		usrTest.setCidade(cidades[random.nextInt(101)]);

		usrTest.setRenda(renda[random.nextInt(6)]);
		usrTest.setEscolaridade(escolaridade[random.nextInt(7)]);
		usrTest.setEtnia(etnia[random.nextInt(6)]);
		usrTest.setProfissao(profissoes[random.nextInt(88)]);
		/**idade 16-70*/
		usrTest.setIdade(Integer.toString((random.nextInt(55))-(-15)));
		usrTest.setNumeroFilhos(Integer.toString(random.nextInt(5)));
		
		usrTest.setJaSofreuMedidaSocioEducativa(random.nextBoolean());
		usrTest.setUsaSubstanciaEntorpecente(random.nextBoolean());
		usrTest.setFamiliaRealizaVisitas(random.nextBoolean());
		usrTest.setTemAlgumParentePreso(random.nextBoolean());
		usrTest.setJaSofreuViolenciaNoPresidio(random.nextBoolean());
		
		
		
		usrTest.setQuantasVezesFoiPreso(Integer.toString(random.nextInt(3)));
		usrTest.setTempoQueEstaPreso(Integer.toString(random.nextInt(20)));

		return usrTest;

	}

	public PessoaAssistida getUsrTest() {
		return usrTest;
	}

	public static void main(String[] args) throws UnknownHostException {
		PovoarBancoReclusos usrRandom = new PovoarBancoReclusos();
		MongoClient mongoClient;
		mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("testRecluso");

		DBCollection coll = db.getCollection("pessoaAssistida");

		Gson gson = new GsonBuilder().serializeNulls().create();
		// Converte usrAssistido em JSON e depois em BasicDBObject
		BasicDBObject obj;

		int numeroEntradas = 700;
		for (int i = 0; i < numeroEntradas; ++i) {// popular banco

			obj = (BasicDBObject) JSON.parse(gson.toJson(usrRandom
					.preencherUsr()));

			coll.insert(obj);
		}

	}
}