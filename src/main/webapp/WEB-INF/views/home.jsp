<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>HASSIS - Página Inicial</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style_404.css"/>" media="all" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-responsive.min.css">
</head>
<body>
	<ul class="breadcrumb">
		<li class="active">Página Inicial</li>
	</ul>

	<div class="header">
			<div class="logo">
				<h1>
					<a href="#">HASSIS</a>
				</h1>
			</div>
		</div>


<div class="bg-4">
  <div class="container">
	<div class="row">
	   <div class="col-sm-4 col-xs-6">
      
        <div class="panel panel-default">
          <div class="panel-thumbnail"><a href="questionario_reclusos" title="Cadastro de Reclusos"><img src="<c:url value="/resources/img/reclusos.jpg"/>" class="img-responsive"></a></div>
          <div class="panel-body">
            <p>Cadastro de Reclusos</p>
            <p></p>

          </div>
        </div><!--/panel-->
      </div><!--/col-->
      
      <div class="col-sm-4 col-xs-6">
      
      	<div class="panel panel-default">
          <div class="panel-thumbnail"><a href="questionario_assistidos" title="Cadastros de Internação Compulsória"><img src="<c:url value="/resources/img/internacao.jpg"/>" class="img-responsive"></a></div>
          <div class="panel-body">
            <p>Cadastros de Internação Compulsória</p>
            <p></p>
            
          </div>
        </div><!--/panel--> 
      </div><!--/col-->
      
      <div class="col-sm-4 col-xs-6">
      
      	<div class="panel panel-default">
          <div class="panel-thumbnail"><a href="infograficos" title="Infográficos"><img src="<c:url value="/resources/img/infograficos.jpg"/>" class="img-responsive"></a></div>
          <div class="panel-body">
            <p>Infográficos</p>
            <p></p>
            
          </div>
        </div><!--/panel--> 

      </div><!--/col--> 

      
	</div><!--/row-->
  </div><!--/container-->
</div>

	<div class="navbar navbar-inverse navbar-fixed-bottom"
		role="navigation">
		<div class="container">
			<div class="navbar-text pull-left">
				<p>
					<a href="#">Sobre</a>
				</p>
			</div>
				<div class="col-sm-8 col-sm-offset-2 text-center">

      <ul class="list-inline center-block">
        <li>
        	UFAL
        </li>
         <li>
        	IC
        </li>
         <li>
        	<img height="42" width="42" src="<c:url value="/resources/img/logo-GSD.svg"/>" class="img-responsive">
        </li>
      </ul>
      
  	</div><!--/col-->
		</div>
	</div>

</body>
</html>
