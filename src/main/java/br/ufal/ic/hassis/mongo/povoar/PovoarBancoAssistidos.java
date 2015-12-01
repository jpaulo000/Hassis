package br.ufal.ic.hassis.mongo.povoar;


import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import br.ufal.ic.hassis.model.UsuarioAssistido;

public class PovoarBancoAssistidos {
	private UsuarioAssistido usrTest;

	private static String[] nomeAssistido = { "Miguel", "Sophia", "Davi",
			"Alice", "Arthur", "Julia", "Pedro", "Isabella", "Gabriel",
			"Manuela", "Bernardo", "Laura", "Lucas", "Luiza", "Matheus",
			"Valentina", "Rafael", "Giovanna", "Heitor", "Maria Eduarda",
			"Enzo", "Helena", "Guilherme", "Beatriz", "Nicolas", "Maria Luiza",
			"Lorenzo", "Lara", "Gustavo", "Mariana", "Felipe", "Nicole",
			"Samuel", "João Pedro", "Heloísa", "Daniel", "Isadora", "Vitor",
			"Lívia", "Leonardo", "Maria Clara", "Henrique", "Ana", "Clara",
			"Theo", "Lorena", "Murilo", "Gabriela", "Eduardo", "Yasmin",
			"Pedro", "Henrique", "Isabelly", "Pietro", "Sarah", "kauã",
			"Ana Julia", "Isaac", "Letícia", "Caio", "Ana Luiza", "Vinicius",
			"Melissa", "Benjamin", "Marina", "João", "Clara", "Lucca",
			"Cecília", "João Miguel", "Esther", "Bryan", "Emanuelly",
			"Joaquim", "Rebeca", "João Vitor", "Ana Beatriz", "Thiago",
			"Lavínia", "Antônio", "Vitória", "Davi Lucas", "Bianca",
			"Francisco", "Catarina", "Enzo Gabriel", "Larissa", "Bruno",
			"Maria Fernanda", "Emanuel", "Fernanda", "João Gabriel", " Amanda",
			"Ian", "Alícia", "Davi Luiz", "Carolina", "Rodrigo", "Agatha",
			"Otávio", "Gabrielly" };
	private static String[] sobrenomes = { "Silva", "Souza", "Costa", "Santos",
			"Oliveira", "Pereira", "Rodrigues", "Almeida", "Nascimento",
			"Lima", "Araújo", "Fernandes", "Carvalho", "Gomes", "Martins",
			"Rocha", "Ribeiro", "Alves", "Monteiro", "Mendes", "Barros",
			"Freitas", "Barbosa", "Pinto", "Moura", "Cavalcanti", "Dias",
			"Castro", "Campos", "Cardoso", "" };
	private static int[] anosArray = { 1940, 1941, 1942, 1943, 1944, 1945,
			1946, 1947, 1948, 1949, 1950, 1951, 1952, 1953, 1954, 1955, 1956,
			1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967,
			1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978,
			1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989,
			1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
			2001 };
	private static String[] bairrosMaceio = { "Antares", "Barro Duro",
			"Bebedouro", "Benedito Bentes", "Bom Parto", "Canaã", "Centro",
			"Chã da Jaqueira", "Chã de Bebedouro", "Cidade Universitária",
			"Clima Bom", "Cruz das Almas", "Farol", "Feitosa", "Fernão Velho",
			"Garça Torta", "Gruta de Lourdes", "Guaxuma", "Ipioca",
			"Jacarecica", "Jacintinho", "Jaraguá", "Jardim Petropolis",
			"Jatiúca", "Levada", "Mangabeiras", "Mutange", "Ouro Preto",
			"Pajuçara", "Pescaria", "Petrópolis", "Pinheiro", "Pitanguinha",
			"Poço", "Ponta da Terra", "Ponta Grossa", "Ponta Verde",
			"Pontal da Barra", "Prado", "Riacho Doce", "Rio Novo",
			"Santa Amélia", "Santa Lúcia", "Santo Amaro", "Santos Dumont",
			"São Jorge", "Serraria", "Tabuleiro do Martins",
			"Trapiche da Barra", "Vergel do Lago" };
	private static String[] bairrosArapiraca = { "Alto do Cruzeiro",
			"Baixa Grande", "Baixão", "Batingas", "Boa Vista", "Bom Sucesso",
			"Brasilia", "Brasiliana", "Cacimbas", "Caititus", "Canafistula",
			"Capiatã", "Cavaco", "Centro", "Eldorado", "Guaribas", "Itapuã",
			"Jardim de Maria", "Jardim Esperança", "Jardim Tropical",
			"João Paulo II", "Manoel teles", "Massaranduba", "Nova Esperança",
			"Novo Horizonte", "Olho D'água dos Cazuzinhas", "Ouro Preto",
			"Padre Antônio Lima Neto", "Planalto", "Primavera",
			"Santa Edwiges", "Santa Esmeralda", "São Luiz", "São Luiz II",
			"Senador Teotônio Vilela", "Senador Arnon de Melo",
			"Senador Nilo Coelho", "Verdes Campos", "Zélia Barbosa Rocha",
			"Sítio Alazão", "Sítio Pau D'arco", "Sítio Furnas",
			"Vila Baixa da Onça", "Vila Bananeiras", "Vila São José",
			"Sítio Laranjau", "Sítio Cajarana", "Sítio Carrasco",
			"Sítio Capim", "Sítio Poção", "Sítio Camadanta", "Sítio Fernandes",
			"Sítio Bom Nome", "Sítio Tapera", "Baixa da Onça",
			"Povoado Cangandu", "Sítio Bom Jardim", "Sítio Varginha",
			"Sítio Pé Leve Velho", "Sítio Itapicuru", "Vila Canaã",
			"Povoado Fazenda Velha", "Vila São Francisco", "Sítio Sapucaia" };
	/*
	 * private static String[] cidades = { "Água Branca", "Anadia", "Arapiraca",
	 * "Atalaia", "Barra de Santo Antônio", "Barra de São Miguel", "Batalha",
	 * "Belém", "Belo Monte", "Boca da Mata", "Branquinha", "Cacimbinhas",
	 * "Cajueiro", "Campestre", "Campo Alegre", "Campo Grande", "Canapi",
	 * "Capela", "Carneiros", "Chã Preta", "Coité do Nóia",
	 * "Colônia Leopoldina", "Coqueiro Seco", "Coruripe", "Craíbas",
	 * "Delmiro Gouveia", "Dois Riachos", "Estrela de Alagoas", "Feira Grande",
	 * "Feliz Deserto", "Flexeiras", "Girau do Ponciano", "Ibateguara", "Igaci",
	 * "Igreja Nova", "Inhapi", "Jacaré dos Homens", "Jacuípe", "Japaratinga",
	 * "Jaramataia", "Jequiá da Praia", "Joaquim Gomes", "Jundiá", "Junqueiro",
	 * "Lagoa da Canoa", "Limoeiro de Anadia", "Major Isidoro", "Mar Vermelho",
	 * "Maragogi", "Maravilha", "Marechal Deodoro", "Maribondo", "Mata Grande",
	 * "Matriz de Camaragibe", "Messias", "Minador do Negrão", "Monteirópolis",
	 * "Murici", "Novo Lino", "Olho d`Água das Flores", "Olho d`Água do Casado",
	 * "Olho d`Água Grande", "Olivença", "Ouro Branco", "Palestina",
	 * "Palmeira dos Índios", "Pão de Açúcar", "Pariconha", "Paripueira",
	 * "Passo de Camaragibe", "Paulo Jacinto", "Penedo", "Piaçabuçu", "Pilar",
	 * "Pindoba", "Piranhas", "Poço das Trincheiras", "Porto Calvo",
	 * "Porto de Pedras", "Porto Real do Colégio", "Quebrangulo", "Rio Largo",
	 * "Roteiro", "Santa Luzia do Norte", "Santana do Ipanema",
	 * "Santana do Mundaú", "São Brás", "São José da Laje",
	 * "São José da Tapera", "São Luís do Quitunde", "São Miguel dos Campos",
	 * "São Miguel dos Milagres", "São Sebastião", "Satuba",
	 * "Senador Rui Palmeira", "Tanque d`Arca", "Taquarana", "Teotônio Vilela",
	 * "Traipu", "União dos Palmares", "Viçosa" };
	 */
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
			"Mensalmente", "Às vezes" };
	private static String[] comoCompra = { "Dinheiro", "Prostituição",
			"Crimes", "Outras" };
	private static String[] tratamentoRecebido = { "SUS", "Clínica", "SESAU",
			"Outra" };
	private static String[] comoFicouSabendo = { "TV", "Internet",
			"Jornal (Escrito)", "Indicação" };
	private static String[] imagemDPE = { "Muito Boa", "Boa", "Regular",
			"Ruim", "Péssima" };

	private static int ano, mes, dia;
	private static boolean isImpar = false;
	private static Random random = new Random();
	
	private static int count =0;
	private static int countBool =0;

	public PovoarBancoAssistidos() {
		usrTest = new UsuarioAssistido();

	}

	private UsuarioAssistido preencherUsr() {
		// Drogas drogas[];
		usrTest.setNomeAssistido(nomeAssistido[random.nextInt(100)] + " "
				+ nomeAssistido[random.nextInt(100)] + " "
				+ sobrenomes[random.nextInt(31)]);
		usrTest.setRg(Integer.toString(random.nextInt(99999)));
		usrTest.setCpf(Integer.toString(random.nextInt(999999)));

		ano = anosArray[random.nextInt(62)];
		mes = random.nextInt(12);
		dia = random.nextInt(28);

		String date = dia + "/" + mes + "/" + ano;
		Date utilDate = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			utilDate = formatter.parse(date);
			usrTest.setDtNascimento(utilDate);
			System.out.println("utilDate:" + utilDate);
		} catch (ParseException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		usrTest.setEstado("Alagoas");

		if (isImpar) {
			usrTest.setCidade("Maceió");
			usrTest.setBairro(bairrosMaceio[random.nextInt(50)]);
			isImpar = false;
		} else {
			usrTest.setCidade("Arapiraca");
			usrTest.setBairro(bairrosArapiraca[random.nextInt(64)]);
			isImpar = true;

		}

		usrTest.setGenero(genero[random.nextInt(2)]);
		if (usrTest.getGenero().equals("f"))
			usrTest.setGestante(random.nextBoolean());
		usrTest.setOrientacaoSexual(orientacaoSexual[random.nextInt(5)]);
		usrTest.setEstadoCivil(estadoCivil[random.nextInt(6)]);
		usrTest.setEtnia(etnia[random.nextInt(6)]);
		usrTest.setEscolaridade(escolaridade[random.nextInt(7)]);
		usrTest.setRenda(renda[random.nextInt(6)]);
		usrTest.setNumeroFilhos(Integer.toString(random.nextInt(5)));
		usrTest.setQuandoComecou(Integer.toString(2015 - ano - 5));// comecou a
																	// 5 anos
																	// atras

		// tipos de drogas uma ou mais
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i1 = 0; i1 < 8; i1++) {
			numeros.add(i1);
		}

		// Embaralhamos os números:
//		Collections.shuffle(numeros);

		// Mostramos 6 aleatórios
		/*
		 * int numeroDrogas = 3;// (random.nextInt(2) + 1); drogas = new
		 * Drogas[numeroDrogas];// new String[numeroDrogas]; for (int i2 = 0; i2
		 * < numeroDrogas; i2++) { drogas[i2] = new
		 * Drogas(tiposDrogas[numeros.get(i2)]);// tiposDrogas[numeros.get(i2)];
		 * // System.out.println(drogas[i2]); }
		 */
		usrTest.setUsaMaconha(random.nextBoolean());
		usrTest.setUsaCocaina(random.nextBoolean());
		usrTest.setUsaCrack(random.nextBoolean());
		usrTest.setUsaCola(random.nextBoolean());
		
		
		if(isImpar){boolean testbool;
			usrTest.setUsaLolo(testbool=random.nextBoolean());
			++count;
			if(testbool){
				++countBool;
			}
			System.out.println(countBool);
			System.out.println(count);
		}
		else{
			usrTest.setUsaLolo(false);
		}
			
		usrTest.setUsaEcstasy(random.nextBoolean());
		if(isImpar){
			usrTest.setUsaLancaPerfume(random.nextBoolean());
		}
		else{
			usrTest.setUsaLancaPerfume(false);
		}
			
		usrTest.setUsaOutrasDrogas(random.nextBoolean());
		
		// usrTest.setTiposDrogas(drogas);
		usrTest.setFrequenciaConsumo(frequenciaConsumo[random.nextInt(6)]);
		usrTest.setComoCompra(comoCompra[random.nextInt(4)]);
		usrTest.setPossuiAmigosQueUsam(random.nextBoolean());
		if (!usrTest.isPossuiAmigosQueUsam()) {
			usrTest.setUsaComAmigos(false);
		} else {
			usrTest.setUsaComAmigos(random.nextBoolean());
		}
		usrTest.setPossuiFamiliaresQueUsam(random.nextBoolean());
		if (!usrTest.isPossuiFamiliaresQueUsam()) {
			usrTest.setUsaComFamiliares(false);
		} else {
			usrTest.setUsaComFamiliares(random.nextBoolean());
		}
		usrTest.setRecebeuTratamento(random.nextBoolean());
		if (usrTest.isRecebeuTratamento())
			usrTest.setTratamentoRecebido(tratamentoRecebido[random.nextInt(4)]);
		usrTest.setComoFicouSabendo(comoFicouSabendo[random.nextInt(4)]);
		usrTest.setImagemDPE(imagemDPE[random.nextInt(5)]);
		return usrTest;

	}

	public UsuarioAssistido getUsrTest() {
		return usrTest;
	}

	public static void main(String[] args) throws UnknownHostException {
		PovoarBancoAssistidos usrRandom = new PovoarBancoAssistidos();
		MongoClient mongoClient;
		mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("testAssistido");

		DBCollection coll = db.getCollection("usuarioAssistido");

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
