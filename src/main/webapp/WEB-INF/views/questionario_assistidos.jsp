<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Formulário para Cadastro de Assistidos</title>
<link rel="stylesheet" type="text/css" href="resources/css/tabela.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/jquery-ui.css">
<!-- Calendario -->
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<!-- Validacao -->

<script type='text/javascript' src='resources/js/jquery-1.11.1.js'></script>
<!-- validacao e radioButton oculto -->
<script type="text/javascript" src='resources/js/jquery.validate.js'></script>
<!-- validacao -->
<script type="text/javascript" src='resources/js/postalcodeBR.js'></script>
<!-- validacao cep-->
<script type="text/javascript" src='resources/js/cpfBR.js'></script>
<!-- validacao cpf-->
<script type="text/javascript" src='resources/js/dateBR.js'></script>
<!-- validacao data-->
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<!-- Calendario -->
<script type="text/javascript" src="resources/js/municipios-estados.js"></script>
<!-- Seleciona os municipios de acordo com o estado -->
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd/mm/yy',
			yearRange : "1920:2015",
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script type="text/javascript">
	window.onload = function() {
		new dgCidadesEstados(document.getElementById('estado'), document
				.getElementById('cidade'), true);
	}
</script>
</head>
<body marginwidth="0" marginheight="0" topmargin="0" bottommargin="0"
	leftmargin="0" rightmargin="0" bgcolor="#ffffff">

	<ul class="breadcrumb">

		<li><a href="/hassis">Página Inicial</a></li>

		<li class="active">Formulário</li>

	</ul>
	<table align="center" width="778" cellspacing="1" cellpadding="0"
		bgcolor="#ffffff">
		<tr>
			<td width="100%" align="center" valign="top">
				<!--inicio cabecalho-->
				<table width="100%" align="center" cellspacing="0" cellpadding="5"
					bgcolor="#ffffff" border="0">
					<tr>
						<td id="planilhatop"
							style="color: #196202; background-color: #ffffff; font-size: 60px;"
							width="100%" align="center" valign="top"
							title="Cadastro de assistidos"><b>HASSIS</b></td>
						<td id="planilha"
							style="color: #C0C0C0; background-color: #ffffff;" width="45%"
							align="center" valign="top"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- voltar pi e cores-->

	<!--inicio coluna esquerda-->
	<table width="780" align="center" cellspacing="0" cellpadding="3"
		border="0">
		<tr>
			<td width="100%" bgcolor="#ffffff" align="center" valign="top">
				<table width="100%" align="center" cellspacing="0" cellpadding="5"
					bgcolor="#ffffff" border="0">
					<tr>
						<td width="100%" align="center" valign="top">
							<table width="760" align="center" cellspacing="3" cellpadding="5"
								bgcolor="#E5E5E5" border="0">

								<tr>
									<td class="formbox" width="760" align="center">
										<form id="cadastro" action="questionario_assistidos/salvar"
											class="form-horizontal" method="post" name="cadastro">
											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<tr>
													<td id="planilha"
														style="color: #4FA30D; font-weight: bold;" align="center"><h3>
															<b>Questionário sociocultural do assistido</b>
														</h3></td>
												</tr>
											</table>
											<table>
												<tr>
													<td></td>
												</tr>
											</table>
											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">

												<tr>
													<td class="form_divisoes" colspan="2" width="740">· <b>INFORMAÇÕES
															SOBRE O ASSISTIDO</b> &nbsp; <span style="color: #993366"><i>(
																* = PREENCHIMENTO OBRIGATÓRIO )</i></span></td>
												</tr>

												<tr>
													<td class="form2" width="200">Nome completo</td>
													<td class="form2" width="540"><input
														class="form-control" name="nomeAssistido" size="50"
														placeholder="Nome completo" maxlength="100" type="text">
														&nbsp; <span style="color: #993366">*</span></td>
												</tr>

												<tr>
													<td class="form2" width="200">RG</td>
													<td class="form2" width="540"><input
														class="form-control" name="rg" size="13" maxlength="13"
														placeholder="RG" type="text"> &nbsp;</td>
												</tr>


												<tr>
													<td class="form2" width="14">CPF</td>
													<td class="form2" width="14"><input cols="20"
														class="form-control" name="cpf" size="11" maxlength="11"
														placeholder="CPF" type="text"></td>
												</tr>
												<form:errors path="cpf" cssStyle="color:red" />

												<tr>
													<td class="form2" width="200">Nascimento</td>
													<td class="form2" width="540"><input
														class="form-control" name="dtNascimento" size="10"
														maxlength="10" placeholder="dd/mm/aaaa" type="text"
														id="datepicker"></td>
												</tr>


												<tr>
													<td class="form2" width="200">Endereço completo</td>
													<td class="form2" width="540"><input
														class="form-control" name="endereco" size="50"
														placeholder="Endereço completo" maxlength="300"
														type="text"></td>
												</tr>

												<tr>
													<td class="form2" width="200">Complemento</td>
													<td class="form2" width="540"><input
														class="form-control" name="endComplemento"
														placeholder="Complemento" size="50" maxlength="300"
														type="text"></td>
												</tr>


												<tr>
													<td class="form2" width="200">Estado</td>
													<td class="form2" width="540"><select id="estado"
														class="form-control" name="estado">
															<!--option>Acre</option>
															<option selected="selected">Alagoas</option>
															<option>Amapá</option>
															<option>Amazonas</option>
															<option>Bahia</option>
															<option>Ceará</option>
															<option>Distrito Federal</option>
															<option>Espírito Santo</option>
															<option>Goiás</option>
															<option>Maranhão</option>
															<option>Mato Grosso</option>
															<option>Mato Grosso do Sul</option>
															<option>Minas Gerais</option>
															<option>Pará</option>
															<option>Paraíba</option>
															<option>Paraná</option>
															<option>Pernambuco</option>
															<option>Piauí</option>
															<option>Rio de Janeiro</option>
															<option>Rio Grande do Norte</option>
															<option>Rio Grande do Sul</option>
															<option>Rondonia</option>
															<option>Roraima</option>
															<option>Santa Catarina</option>
															<option>São Paulo</option>
															<option>Sergipe</option>
															<option>Tocantins</option-->
													</select>&nbsp; <span style="color: #993366">*</span></td>
												</tr>
												<tr>
													<td class="form2" width="200">Cidade</td>
													<td class="form2" width="540"><select
														class="form-control" id="cidade" name="cidade"
														placeholder="Cidade"></select> <!--input
														class="form-control" name="cidade" size="50"
														placeholder="Cidade" maxlength="300" placeholder="Cidade"
														type="text"-->&nbsp; <span style="color: #993366">*</span></td>
												</tr>

												<tr>
													<td class="form2" width="200">Bairro</td>
													<td class="form2" width="540"><input
														class="form-control" name="bairro" size="50"
														placeholder="Bairro" maxlength="300" placeholder="Bairro"
														type="text"></td>
												</tr>
												<tr>
													<td class="form2" width="200">CEP</td>
													<td class="form2" width="540"><input
														class="form-control" name="cep" size="10" maxlength="10"
														type="text"></td>
												</tr>

												<tr>
													<td class="form2" width="200">Telefone 1</td>
													<td class="form2" width="540">DDD ( <input
														class="form-control" name="ddd1" size="3"
														placeholder="DDD" maxlength="2" type="text"> ) - <input
														class="form-control" name="telefone1" size="10"
														placeholder="Telefone 1" maxlength="10" type="text">
													</td>
												</tr>

												<tr>
													<td class="form2" width="200">Telefone 2</td>
													<td class="form2" width="540">DDD ( <input
														class="form-control" name="ddd2" size="3"
														placeholder="DDD" maxlength="2" type="text"> ) - <input
														class="form-control" name="telefone2" size="10"
														placeholder="Telefone 2" maxlength="10" type="text">
														- opcional
													</td>
												</tr>

												<tr>
													<td class="form2" width="200">E-mail</td>
													<td class="form2" width="540"><input
														class="form-control" name="email" size="50"
														placeholder="E-mail" maxlength="60" type="text">
														&nbsp;</td>
												</tr>

											</table>

											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<!-- linha div -->
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>

												<!-- i itens -->
												<tr>
													<td class="form_divisoes" colspan="2" width="740">· <b>OUTRAS
															INFORMAÇÕES</b></td>
												</tr>
												<tr>
													<td class="form2" width="200">Gênero</td>
													<td class="form2" width="540"><input
														id="generoMasculino" name="genero" value="m" type="radio">Masculino
														&nbsp;&nbsp; <input id="generoFeminino" name="genero"
														value="f" type="radio">Feminino &nbsp;&nbsp;</td>
												</tr>
												<!--Gestante-->
												<tr id="isGestante" style="display: none;">
													<td class="form2" width="200">Gestante?</td>
													<td class="form2" width="540"><input name="isGestante"
														value="false" type="radio">Não &nbsp;&nbsp; <input
														name="isGestante" value="true" type="radio">Sim
														&nbsp;&nbsp;</td>
												</tr>

												<tr>
													<td class="form2" width="200">Orientação sexual</td>
													<td class="form2" width="540"><select
														class="form-control" name="orientacaoSexual" size="1">
															<option selected="selected">Selecione</option>
															<option>Heterossexual</option>
															<option>Homossexual</option>
															<option>Bissexual</option>
															<option>Assexual</option>
															<option>Outro</option>
													</select></td>
												</tr>

												<tr>
													<td class="form2" width="200">Estado Civil</td>
													<td class="form2" width="540"><select
														class="form-control" name="estadoCivil" size="1">
															<option selected="selected">Selecione</option>
															<option>Solteiro(a)</option>
															<option>Casado(a)</option>
															<option>Divorciado(a)</option>
															<option>Viúvo(a)</option>
															<option>União Estável</option>
															<option>Outro</option>
													</select></td>
												</tr>

												<tr>
													<td class="form2" width="200">Grupo Étnico</td>
													<td class="form2" width="540"><select
														class="form-control" name="etinia" size="1">
															<option selected="selected">Selecione</option>
															<option>Brancos</option>
															<option>Pardos</option>
															<option>Negros</option>
															<option>Amarelos</option>
															<option>Indígenas</option>
															<option>Sem Declaração</option>
													</select></td>
												</tr>

												<tr>
													<td class="form2" width="200">Escolaridade</td>
													<td class="form2" width="540"><select
														class="form-control" name="escolaridade" size="1">
															<option selected="selected">Selecione</option>
															<option>Fundamental incompleto</option>
															<option>Fundamental completo</option>
															<option>Médio incompleto</option>
															<option>Médio completo</option>
															<option>Superior incompleto</option>
															<option>Superior completo</option>
															<option>Pós-graduação</option>
															<option>Não determinada</option>
													</select></td>
												</tr>

												<tr>
													<td class="form2" width="200">Renda</td>
													<td class="form2" width="540"><select
														class="form-control" name="renda" size="1">
															<option selected="selected">Selecione</option>
															<option>Inferior a um salário mínimo</option>
															<option>Entre 1 e 2 salários mínimos</option>
															<option>2 a 3 salários mínimos</option>
															<option>3 a 5 salários mínimos</option>
															<option>5 a 10 salários mínimos</option>
															<option>20 salários mínimos e mais</option>
													</select></td>
												</tr>


												<tr>
													<td class="form2" width="200">Número de Filhos</td>
													<td class="form2" width="540"><input
														class="form-control" name="numeroFilhos" size="2"
														placeholder="Nº de Filhos" maxlength="2" type="text">
														&nbsp;</td>
												</tr>


											</table>

											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<!-- linha div -->
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>
												<tr>
													<td class="form_divisoes" colspan="2" width="740">· <b>HISTÓRICO
															DE ENTORPECENTES</b></td>
												</tr>


												<tr>
													<td class="form2" width="200">Quando começou (idade)</td>
													<td class="form2" width="540"><input
														class="form-control" name="quandoComecou" size="2"
														placeholder="Quando começou (idade)" maxlength="2"
														type="text"></td>
												</tr>

												<!--tr>
											<td class="form2" width="200">Tipos</td><td class="form2" width="540">		
												<select class="form-control" name="tipoDroga" size="1">
												<option selected="selected">Selecione</option>
												<option>Maconha</option>
												<option>Cocaína</option>
												<option>Crack</option>						
												<option>Outros</option>
												<option>Cola</option>
												<option>Loló</option>
												<option>Lança perfume</option>
												<option>Ecstasy</option>
												</select>
											</td>
										</tr-->


												<tr>
													<td class="form2" width="200">Tipos</td>
													<td>
														<table>
															<tr>
																<td><label> <input type="checkbox"
																		name="usaMaconha" value="true" class="">Maconha
																</label><br> <label> <input type="checkbox"
																		name="usaCocaina" value="true" class="">Cocaína
																</label><br> <label><input type="checkbox"
																		name="usaCrack" value="true" class="">Crack</label><br>
																	<label><input type="checkbox" name="usaCola"
																		value="true" class="">Cola</label><br></td>
																<td style="padding: 20px; border: 10px"><label><input
																		type="checkbox" name="usaLolo" value="true" class="">Loló</label><br>
																	<label><input type="checkbox" name="usaEcstasy"
																		value="true" class="">Ecstasy</label><br> <label><input
																		type="checkbox" name="usaLancaPerfume" value="true"
																		class="">Lança perfume</label><br> <label><input
																		type="checkbox" name="usaOutrasDrogas" value="true"
																		class="">outras</label><br></td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td class="form2" width="200">Frequência</td>
													<td class="form2" width="540"><select
														class="form-control" name="frequenciaConsumo" size="1">
															<option selected="selected">Selecione</option>
															<option>Diária</option>
															<option>1 ou 2 vezes por semana</option>
															<option>Mais de 2 (duas)</option>
															<option>Semanalmente</option>
															<option>Mensalmente</option>
															<option>Às vezes</option>
													</select></td>
												</tr>



												<tr>
													<td class="form2" width="200">Histórico de vida</td>
													<td class="form2" width="540"><textarea
															class="form-control" name="relatosNasDrogas" rows="3"
															cols="50"
															placeholder="Relatos de situações traumáticas. O objetivo é saber se houve um trauma na vida que pode ter contribuído para o ingresso nas drogas"></textarea>
													</td>
												</tr>

												<tr>
													<td class="form2" width="200">Onde Compra?</td>
													<td class="form2" width="540"><textarea
															name="ondeCompra" class="form-control" rows="3" cols="50"
															placeholder="Bairro? Escola? Boca de fumo?"></textarea></td>
												</tr>

												<tr>
													<td class="form2" width="200">Como Compra?</td>
													<td class="form2" width="540"><select
														id="como-compra-drogas" class="form-control"
														name="comoCompra" size="1">
															<option selected="selected">Selecione</option>
															<option>Dinheiro</option>
															<option>Prostituição</option>
															<option>Crimes</option>
															<option>Outras</option>
													</select></td>
													<!-- Outras formas -->
												</tr>

												<tr id="compraOutrasFormas" style="display: none;">
													<td class="form2" width="200">Outras formas</td>
													<td class="form2" width="540"><input
														class="form-control" name="compraOutrasFormas" size="50"
														placeholder="Outras Formas" type="text"></td>
												</tr>

											</table>


											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<!-- linha div -->
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>
												<tr>
													<td class="form_divisoes" colspan="2" width="740">· <b>CÍRCULOS
															NAS DROGAS</b></td>
												</tr>

												<tr>
													<td class="form2" width="200">Possui amigos que usam
														drogas?</td>
													<td class="form2" width="540"><input
														id="nao-possui-amigos-nas-drogas"
														name="possuiAmigosQueUsam" value="false" type="radio">Não
														&nbsp;&nbsp; <input id="sim-possui-amigos-nas-drogas"
														name="possuiAmigosQueUsam" value="true" type="radio">SIM
														&nbsp;&nbsp;</td>
												</tr>
												<!--Possui amigos sim-->
												<tr id="possui-amigos" style="display: none;">
													<td class="form2" width="200">Usa com eles?</td>
													<td class="form2" width="540"><input
														name="usaComAmigos" value="false" type="radio">Não
														&nbsp;&nbsp; <input name="usaComAmigos" value="true"
														type="radio">Sim &nbsp;&nbsp;</td>
												</tr>

												<tr>
													<td class="form2" width="200">Possui familiares que
														usam drogas?</td>
													<td class="form2" width="540"><input
														id="nao-possui-familiares-nas-drogas"
														name="possuiFamiliaresQueUsam" value="false" type="radio">Não
														&nbsp;&nbsp; <input id="sim-possui-familiares-nas-drogas"
														name="possuiFamiliaresQueUsam" value="true" type="radio">SIM
														&nbsp;&nbsp;</td>
												</tr>
												<!--Possui familiares sim-->
												<tr id="possui-familiares" style="display: none;">
													<td class="form2" width="200">Usa com eles?</td>
													<td class="form2" width="540"><input
														name="usaComFamiliares" value="false" type="radio">Não
														&nbsp;&nbsp; <input name="usaComFamiliares" value="true"
														type="radio">Sim &nbsp;&nbsp;</td>
												</tr>

											</table>
											<!-- f itens -->
											<!-- i	valores -->
											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>
												<tr>
													<td class="form_divisoes" colspan="2" width="740">· <b>SOBRE
															O TRATAMENTO</b></td>
												</tr>

												<tr>
													<td class="form2" width="200">Já recebeu algum
														tratamento?</td>
													<td class="form2" width="540"><input
														id="nao-recebeu-tratamento" name="recebeuTratamento"
														value="false" type="radio" checked="checked">Não
														&nbsp;&nbsp; <input id="sim-recebeu-tratamento"
														name="recebeuTratamento" value="true" type="radio">SIM
														&nbsp;&nbsp;</td>
												</tr>


												<!-- tr id="tratamento-recebido" style="display: none;"><td class="form2" width="200">Onde?</td><td class="form2" width="540"> <input name="tipoTratamentoRecebido" value="SUS" type="radio">SUS &nbsp;&nbsp; <input name="tipoTratamentoRecebido" value="Clínica" type="radio">Clínica &nbsp;&nbsp; <input name="tipoTratamentoRecebido" value="SESAU" type="radio">SESAU &nbsp;&nbsp; </td></tr-->

												<tr id="tratamento-recebido-tr" style="display: none;">
													<td class="form2" width="200">Onde?</td>
													<td class="form2" width="540"><select
														class="form-control" id="tratamento-recebido-select"
														name="tratamentoRecebido" size="1">
															<option selected="selected">Selecione</option>
															<option>SUS</option>
															<option>Clínica</option>
															<option>SESAU</option>
															<option>Outra</option>
													</select></td>
													<!-- Outros lugares -->
												</tr>

												<tr id="atendido-outro-lugar" style="display: none">
													<td class="form2" width="200">Outro lugar</td>
													<td class="form2" width="540"><input
														class="form-control" name="outroTratamentoRecebido"
														size="50" placeholder="Outro lugar" type="text"></td>
												</tr>

												<tr>
													<td class="form2" width="200">Doenças</td>
													<td class="form2" width="540"><textarea
															class="form-control" rows="4" cols="50" name="doencas"
															placeholder="HIV positivo? Demais doenças..."></textarea>
														&nbsp;</td>
												</tr>

												<tr>
													<td class="form2" width="200">Onde foi resgatado(a)?</td>
													<td class="form2" width="540"><textarea
															class="form-control" rows="3" name="ondeFoiResgatado"
															cols="50"
															placeholder="Onde foi resgatado(a) para internação compulsória?"></textarea>
												<tr>
													<td class="form2" width="200">Por que a internação</td>
													<td class="form2" width="540"><textarea
															class="form-control" rows="3" name="porqueInternacao"
															cols="50" placeholder="Por que a internação?"></textarea>
												<tr>
													<td class="form2" width="200">Como ficou sabendo do
														internamento compulsório da DPE?</td>
													<td class="form2" width="540"><select
														class="form-control" name="comoFicouSabendo" size="1">
															<option selected="selected">Selecione</option>
															<option>TV</option>
															<option>Internet</option>
															<option>Jornal (Escrito)</option>
															<option>Indicação</option>
													</select></td>
												</tr>

												<tr>
													<td class="form2" width="200">Imagem que tem da DPE</td>
													<td class="form2" width="540"><select
														class="form-control" name="imagemDPE" size="1">
															<option selected="selected">Selecione</option>
															<option>Muito Boa</option>
															<option>Boa</option>
															<option>Regular</option>
															<option>Ruim</option>
															<option>Péssima</option>
													</select> <!--  --></td>
												</tr>

											</table>
											<!-- f	valores -->
											<!-- i	descricao -->
											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>


												<!-- submit -->
												<tr>
													<!--td class="form4" colspan="2" align="center" width="740"><input
														class="btn btn-default" type="submit" value="salvar"
														style="background-color: #FBFDFF;"
														onmouseover="this.style.background='#ffffff'"
														onmouseout="this.style.background='#FBFDFF'">&nbsp;
														&nbsp; &nbsp; &nbsp;</td-->
													<td align="center">
														<button type="submit" class="btn btn-success btn-large">Salvar</button>
														<button type="reset" class="btn">Cancelar</button>
													</td>
												</tr>

											</table>
										</form>
									</td>
								</tr>

							</table>
						</td>
					</tr>
				</table>
				<hr class="pdi_line_gray0" width="760" size="1" align="center"
					color="#EBEBEB" noshade>
			</td>
		</tr>
	</table>

	<script src="resources/js/validate.js"></script>
	<!-- validacao do form -->

	<script type="text/javascript">
		jQuery(document).ready(function() {

			/**Gênero/Gravidez*/
			$("#generoFeminino").on("click", function() {
				$('#isGestante').css('display', '');
			});
			$("#generoMasculino").on("click", function() {
				$('#isGestante').css('display', 'none');
			});

			/**Como compra*/
			var $outrasFormas = jQuery("#como-compra-drogas");

			$outrasFormas.change(function() {
				if ($outrasFormas.val() === 'Outras') {

					$('#compraOutrasFormas').css('display', '');
				} else {
					$('#compraOutrasFormas').css('display', 'none');
				}
			});

			/*Tratamento recebido**/
			$("#sim-recebeu-tratamento").on("click", function() {
				$('#tratamento-recebido-tr').css('display', '');
			});
			$("#nao-recebeu-tratamento").on("click", function() {
				$('#tratamento-recebido-tr').css('display', 'none');
			});
			var $outroTratamento = jQuery("#tratamento-recebido-select");

			$outroTratamento.change(function() {
				if ($outroTratamento.val() === 'Outra') {

					$('#atendido-outro-lugar').css('display', '');
				} else {
					$('#atendido-outro-lugar').css('display', 'none');
				}
			});

			/**Possui amigos nas drogas*/
			$("#sim-possui-amigos-nas-drogas").on("click", function() {
				$('#possui-amigos').css('display', '');
			});
			$("#nao-possui-amigos-nas-drogas").on("click", function() {
				$('#possui-amigos').css('display', 'none');
			});

			/**Possui familiares nas drogas*/
			$("#sim-possui-familiares-nas-drogas").on("click", function() {
				$('#possui-familiares').css('display', '');
			});
			$("#nao-possui-familiares-nas-drogas").on("click", function() {
				$('#possui-familiares').css('display', 'none');
			});
		});
	</script>
</body>
</html>
