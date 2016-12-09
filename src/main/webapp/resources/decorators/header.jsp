<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	
	<section id="topwrap">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header page-scroll">
					<div style="float: left; width: 180px;">
						<img
							src="${pageContext.request.contextPath}/resources/images/logoEscom.png"
							class="logo" />
					</div>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>


				</div>
				<s:set var="actionUser"
					value="%{#session[@mx.ipn.escom.afn.util.NombreObjetosSesion@ACTION]}" />
				
				
				<s:if test="%{#actionUser eq 1}">
					<div id="bs-example-navbar-collapse-1"
						class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newAfn">basico</a>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newUnir">Unir</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newConcatenar">Concatenar</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newCerraduraPositiva">Cerradura
									+</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newCerraduraklean">Cerradura
									*</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newOpcional">Opcional</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newUnionEspecial">Union
									Especial</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newValidarCadena">Validar
									cadena</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newLexema">Lexema</a></li>
							<li><a class="navbar-brand page-scroll"
								href="${pageContext.request.contextPath}/thompson/afn!newAfd">Convertir
									AFD</a></li>
						</ul>
					</div>
				</s:if>

				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	</section>
</jsp:root>