<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->



<head>
<title>Oops Página não encontrada</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords"
	content="404 iphone web template, Andriod web template, Smartphone web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style_404.css"/>" media="all" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>">
</head>
<body>
	<ul class="breadcrumb">

		<li><a href="/hassis">Página Inicial</a></li>

		<li class="active">Esta página não existe</li>

	</ul>
	<!--start-wrap--->

	<div class="wrap">
		<!---start-header---->
		<div class="header">
			<div class="logo">
				<h1>
					<a href="#">HASSIS</a>
				</h1>
			</div>
		</div>
		<!---End-header---->
		<!--start-content------>
		<div class="content">





			<img src="<c:url value="/resources/img/error-img.png"/>"
				title="error" />
			<p>
				<span><label>O</label>ops.....</span>Você requisitou uma página que
				não existe.
			</p>
			<a href="/hassis">Voltar para Página Inicial</a>
			<div class="navbar navbar-inverse navbar-fixed-bottom"
				role="navigation">
				<div class="container">
					<div class="navbar-text pull-left">
						&#169 All rights Reserved | Designed by <a
							href="http://w3layouts.com/">W3Layouts</a>
					</div>
				</div>
			</div>
		</div>
		<!--End-Cotent------>
	</div>
	<!--End-wrap--->
</body>
</html>