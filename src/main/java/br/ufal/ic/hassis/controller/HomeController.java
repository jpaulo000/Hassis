package br.ufal.ic.hassis.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.ufal.ic.hassis.consultas.ConsultasBipartidoRecluso;
import br.ufal.ic.hassis.consultas.ConsultasBipartite;
import br.ufal.ic.hassis.model.PessoaAssistida;
import br.ufal.ic.hassis.model.UsuarioAssistido;
import br.ufal.ic.hassis.mongo.SalvaNoBancoMongo;

/**
 * Manipula requisições.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simplismente seleciona a view "home" para renderizar retornando seu nome.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		return "home";
	}

	@RequestMapping("/questionario_assistidos")
	public String questionario() {
		logger.info("method questionario!!");
		return "questionario_assistidos";
	}

	@RequestMapping("/questionario_reclusos")
	public String questionario2() {
		logger.info("Questionario HASSIS");
		return "questionario_reclusos";
	}

	@RequestMapping("/infograficos")
	public String infograficos() {
		logger.info("Página infográficos");
		return "infograficos";
	}
	
	@RequestMapping("/infograficos/reclusos")
	public String viewReclusos() {
		logger.info("Página infográficos/reclusos");
		return "view_recluso";
	}
	
	@RequestMapping("/infograficos/internacao")
	public String viewInternacao() {
		logger.info("Página infográficos/internacao");
		return "view_internacao";
	}

	@RequestMapping(value = "/questionario_reclusos/salvar", method = RequestMethod.POST)
	/**Salvar as informações do form web no banco*/
	public String salvarQuestionario(@Valid PessoaAssistida assistido,
			BindingResult result) {
		logger.info("Method salvar...");
		SalvaNoBancoMongo.salvar(assistido);
		if (result.hasErrors()) {
			List<ObjectError> erros = result.getAllErrors();
			for (ObjectError objectError : erros) {
				logger.warn("Erro no formulário: ",
						objectError.getDefaultMessage());
			}
		}

		return "confirmacao_reclusos";
	}

	/** Quando o formulario for enviado */
	@RequestMapping("/questionario_assistidos/salvar")
	public String adicionar(@Valid UsuarioAssistido usrAssistido,
			BindingResult result) throws JsonGenerationException,
			JsonMappingException, IOException {
		if (result.hasFieldErrors()) {
			List<ObjectError> erros = result.getAllErrors();
			for (ObjectError objectError : erros) {
				logger.warn("Erro no formulário: ",
						objectError.getDefaultMessage());
			}
			return "questionario_assistidos";
		}
		SalvaNoBancoMongo.salvar(usrAssistido);

		return "confirmacao_assistidos";
	}

	@RequestMapping("/infograficos/chord_diagram")
	public String chord() {
		logger.info("chord diagram exibido");
		return "Chord Diagram";
	}

	@RequestMapping("/infograficos/biPartite")
	public String bipartidoInternacao(Model model, HttpServletRequest request)
			throws IOException {

		String lado_esq = request.getParameter("lado_esquerdo") != null ? request
				.getParameter("lado_esquerdo") : "escolaridade";
		String lado_dir = request.getParameter("lado_direito") != null ? request
				.getParameter("lado_direito") : "etnia";

		String dados = ConsultasBipartite
				.gerarDadosExibicao(lado_esq, lado_dir);
		int nLinhasEsq = ConsultasBipartite.getnLinhasEsq();
		int nLinhasDir = ConsultasBipartite.getnLinhasDir();

		model.addAttribute("dados", dados)
				.addAttribute("esq_anterior", lado_esq)
				.addAttribute("dir_anterior", lado_dir)
				.addAttribute("nLinhasEsq", nLinhasEsq)
				.addAttribute("nLinhasDir", nLinhasDir);

		logger.info("grafo bipartido exibido");
		return "bipartido";
	}

	@RequestMapping("/infograficos/bipartidoReclusao")
	public String bipartidoReclusao(Model model, HttpServletRequest request)
			throws IOException {

		String lado_esq = request.getParameter("lado_esquerdo") != null ? request
				.getParameter("lado_esquerdo") : "escolaridade";
		String lado_dir = request.getParameter("lado_direito") != null ? request
				.getParameter("lado_direito") : "etnia";
		String dados = ConsultasBipartidoRecluso.gerarDadosExibicao(lado_esq,
				lado_dir);

		int nLinhasEsq = ConsultasBipartidoRecluso.getnLinhasEsq();
		int nLinhasDir = ConsultasBipartidoRecluso.getnLinhasDir();

		model.addAttribute("dados", dados)
				.addAttribute("esq_anterior", lado_esq)
				.addAttribute("dir_anterior", lado_dir)
				.addAttribute("nLinhasEsq", nLinhasEsq)
				.addAttribute("nLinhasDir", nLinhasDir);
		logger.info("grafo bipartido exibido");
		return "bipartido_reclusao";
	}

	/**
	 * Converte valor vazio do campo data para valor null em java.util.Date
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);

		/**
		 * true passado para o construtor CustomDateEditor significa converter
		 * String vazia para null
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/** Redireciona para uma pagina infornando "pagina não encontrada" 
	 * @return 404.html*/
	@RequestMapping("/error404")
	public String error404() {
		logger.warn("Page not found!!");
		return "404";
	}

}