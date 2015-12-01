<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relação em grafo bipartido</title>
<script type='text/javascript' src='../resources/js/jquery-1.11.1.js'></script>
<style>
body{
	/* width:1200px; */
	margin:100px auto;
}
svg text{
	font-size:12px;
}
rect{
	shape-rendering:crispEdges;
}
</style>
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap-responsive.min.css">
</head>
<body>


    <ul class="breadcrumb">

        <li><a href="/hassis">Página Inicial</a></li>
        <li><a href="/hassis/infograficos">Infográficos</a></li>
        <li><a href="/hassis/infograficos/reclusos">Reclusos</a></li>

        <li class="active">Grafo Bipartido</li>

    </ul>


<h1>Grafo Bipartido</h1><br/>
<h1 id="demo"></h1>

<div>
<form id="relacao" action="bipartidoReclusao" class="form-horizontal"
											method="post" name="cadastro">
	<select class="form-control" id="lado_esquerdo" name="lado_esquerdo" size="1">
		<option ${esq_anterior == "escolaridade" ? 'selected="selected"' : ''} value="escolaridade">Escolaridade</option>
		<option ${esq_anterior == "cidade" ? 'selected="selected"' : ''} value="cidade">Cidade</option>
		<option ${esq_anterior == "etnia" ? 'selected="selected"' : ''} value="etnia">Etnia</option>
		<option ${esq_anterior == "renda" ? 'selected="selected"' : ''} value="renda">Renda</option>
		<option ${esq_anterior == "profissao" ? 'selected="selected"' : ''} value="profissao">Profissão</option>
		
	</select>
	x
	<select class="form-control" id="lado_direito" name="lado_direito" size="1">
		<option ${dir_anterior == "escolaridade" ? 'selected="selected"' : ''} value="escolaridade">Escolaridade</option>
		<option ${dir_anterior == "cidade" ? 'selected="selected"' : ''} value="cidade">Cidade</option>
		<option ${dir_anterior == "etnia" ? 'selected="selected"' : ''} value="etnia">Etnia</option>
		<option ${dir_anterior == "renda" ? 'selected="selected"' : ''} value="renda">Renda</option>
		<option ${dir_anterior == "profissao" ? 'selected="selected"' : ''} value="profissao">Profissão</option>
	</select>
	<button type="submit" class="btn btn-success btn-large">Gerar</button>
	</form>
</div>



<script type="text/javascript">
	//Altura do grafico depende da quantidade de linhas exibidas
	var nLinhasEsq = ${nLinhasEsq};
	var nLinhasDir = ${nLinhasDir};
	var maiorLado = (nLinhasEsq>nLinhasDir )?nLinhasEsq:nLinhasDir;
	
	var height = maiorLado > 10 ? maiorLado : 50
	height = height*12;

</script>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="../resources/js/biPartite.js"></script>
<script>

var width = 1100;/* height =  ${nLinhasEsq*10}; 1300 */
var margin ={b:20, t:50, l:300, r:50};
height = height*1.1;


var svg = d3.select("body")
	.append("svg").attr('width',width).attr('height',(height+margin.b+margin.t))
	.append("g").attr("transform","translate("+ margin.l+","+margin.t+")");

	dados = ${dados};
	console.log("meus dados:");
	console.log(dados);

var data = [ 
	{data:bP.partData(dados,2), id:'relacao_hassis', header:[$( "#lado_esquerdo option:selected" ).text(),$( "#lado_direito option:selected" ).text(), "Relação"]},
];

bP.draw(data, svg);
</script>


</body>
</html>