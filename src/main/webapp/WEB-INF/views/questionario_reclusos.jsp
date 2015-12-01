<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FICHA DE ACOMPANHAMENTO DO RECLUSO</title>
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
<script type="text/javascript" src='resources/js/cpfBR.js'></script>
<!-- validacao cpf-->
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<!-- Calendario -->
<script type="text/javascript" src="resources/js/municipios-estados.js"></script>
<!-- Seleciona os municipios de acordo com o estado -->

<script type="text/javascript">
	window.onload = function() {
		new dgCidadesEstados(document.getElementById('estado'), document
				.getElementById('cidade'), true);
	}
</script>
<script type="text/javascript">
function salvarMongoDb()
{
    document.cadastro.action = "questionario_reclusos/salvar"
    // document.cadastro.target = "_blank";    // Open in a new window

    document.cadastro.submit();             // Submit the page

    return true;
}

function googleAppsScript()
{
    document.cadastro.action = "https://script.google.com/macros/s/AKfycbxcDwVgyeJEszt27HvS4ups-7AlzRdpPKXC7HCgfoOSkl3iVP8/exec"
    document.cadastro.target = "_blank";    // Open in a new window

    document.cadastro.submit();             // Submit the page

    return true;
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
										<form id="cadastro" class="form-horizontal"
											method="post" name="cadastro">
											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<tr>
													<td id="planilha"
														style="color: #4FA30D; font-weight: bold;" align="center"><h3>
															<b>FICHA DE ACOMPANHAMENTO DO RECLUSO</b>
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
													<td class="form2" width="200">Filiação</td>
													<td class="form2" width="540"><input
														class="form-control" name="nomePai" size="50"
														placeholder="Nome do Pai" maxlength="100" type="text"></td>
												</tr>

												<tr>
													<td class="form2" width="200"></td>
													<td class="form2" width="540"><input
														class="form-control" name="nomeMae" size="50"
														placeholder="Nome da Mãe" maxlength="100" type="text"></td>
												</tr>


												<tr>
													<td class="form2" width="200">Naturalidade</td>
													<td class="form2" width="540"><select id="estado"
														class="form-control" name="estado">

													</select>&nbsp; <span style="color: #993366">*</span></td>
												</tr>
												<tr>
													<td class="form2" width="200"></td>
													<td class="form2" width="540"><select
														class="form-control" id="cidade" name="cidade"
														placeholder="Cidade"></select>&nbsp; <span
														style="color: #993366">*</span></td>
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
													<td class="form2" width="200">Grupo Étnico</td>
													<td class="form2" width="540"><select
														class="form-control" name="etnia" size="1">
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
													<td class="form2" width="200">Profissão</td>
													<td class="form2" width="540"><input
														class="form-control" name="profissao" size="50"
														placeholder="Profissão" maxlength="100" type="text"></td>
												</tr>

<tr>
													<td class="form2" width="200">Idade</td>
													<td class="form2" width="540"><input
														class="form-control" name="idade" size="2"
														placeholder="Idade" maxlength="2" type="text">
														&nbsp;</td>
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
													<td class="form_divisoes" colspan="2" width="740">· <b>RECLUSÃO</b></td>
												</tr>

												<tr>
													<td class="form2" width="430">Já sofreu medida
														sócio-educativa de internação?</td>
													<td class="form2" width="310"><input
														name="jaSofreuMedidaSocioEducativa" value="true"
														type="radio">Sim &nbsp;&nbsp; <input
														name="jaSofreuMedidaSocioEducativa" value="false"
														type="radio">Não &nbsp;&nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="430">Faz uso de substância
														entorpecente?</td>
													<td class="form2" width="310"><input
														name="usaSubstanciaEntorpecente" value="true" type="radio">Sim
														&nbsp;&nbsp; <input name="usaSubstanciaEntorpecente"
														value="false" type="radio">Não &nbsp;&nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="430">Família realiza visitas?</td>
													<td class="form2" width="310"><input
														name="familiaRealizaVisitas" value="true" type="radio">Sim
														&nbsp;&nbsp; <input name="familiaRealizaVisitas"
														value="false" type="radio">Não &nbsp;&nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="430">Tem algum parente preso?</td>
													<td class="form2" width="310"><input
														name="temAlgumParentePreso" value="true" type="radio">Sim
														&nbsp;&nbsp; <input name="temAlgumParentePreso"
														value="false" type="radio">Não &nbsp;&nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="430">Já sofreu algum tipo de
														violência no presídio?</td>
													<td class="form2" width="310"><input
														name="jaSofreuViolenciaNoPresidio" value="true"
														type="radio">Sim &nbsp;&nbsp; <input
														name="jaSofreuViolenciaNoPresidio" value="false"
														type="radio">Não &nbsp;&nbsp;</td>
												</tr>

												<tr>
													<td class="form2" width="430">Quantas vezes já foi
														preso?</td>
													<td class="form2" width="310"><input
														class="form-control" name="quantasVezesFoiPreso" size="2"
														placeholder="Quantas vezes já foi preso" maxlength="2"
														type="text"> &nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="430">Tempo que está preso</td>
													<td class="form2" width="310"><input
														class="form-control" name="tempoQueEstaPreso" size="2"
														placeholder="Tempo que está preso" maxlength="2"
														type="text"> &nbsp;</td>
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
													<td class="form_divisoes" colspan="2" width="740">· <b>INFORMAÇÕES DO PROCESSO</b></td>
												</tr>
												<tr>
													<td class="form2" width="200">Prisão referente ao processo</td>
													<td class="form2" width="540"><input
														class="form-control" name="numeroProcesso" size="15"
														placeholder="Nº do processo" maxlength="" type="text">
														&nbsp;</td>
												</tr>
												<tr>
													<td class="form2" width="200">Vara</td>
													<td class="form2" width="540"><input
														class="form-control" name="vara" size="15"
														placeholder="Vara" maxlength="100" type="text"></td>
												</tr>
												<tr>
													<td class="form2" width="200">Comarca</td>
													<td class="form2" width="540"><input
														class="form-control" name="comarca" size="15"
														placeholder="Comarca" maxlength="100" type="text"></td>
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
													<td class="form_divisoes" colspan="2" width="740">· <b>INFORMAÇÕES COMPLEMENTARES</b></td>
												</tr>
												<tr>
													<td class="form2" width="200">Informações Complementares</td>
													<td class="form2" width="540"><textarea
															name="infoComplementares" class="form-control" rows="3" cols="50"
															placeholder="Informações Complementares"></textarea></td>
												</tr>
											
												
												</table>


											<table width="740" align="center" cellspacing="0"
												cellpadding="2" bgcolor="#ffffff" border="0">
												<tr>
													<td class="form2center" colspan="2" width="740"><hr
															class="linegreen1" width="730" size="2" align="center"
															color="#829E7A" noshade></td>
												</tr>


												<!-- submit -->
												<tr>
													<td align="center">
														<button type="submit"  onclick="salvarMongoDb(); googleAppsScript();" class="btn btn-success btn-large">Salvar</button>
														<button type="reset" class="btn">Cancelar</button>
													</td>
												</tr><!-- onclick="salvarMongoDb(); googleAppsScript();" -->

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
</body>
</html>