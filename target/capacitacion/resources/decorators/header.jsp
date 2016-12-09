<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<s:set var="idUsuario"
		value="%{#session[@mx.gob.edomex.sma.seipa.util.ObjetosSession@USUARIO.getNombre()].idUsuario}" />
	<section id="topwrap">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header page-scroll">
					<div style="float: left; width: 45px;">
						<img
							src="${pageContext.request.contextPath}/resources/images/logo.png"
							class="logo" />
					</div>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand page-scroll" href="#page-top"><s:property
							value="getText('com.sprach.globalName')" /></a>
				</div>
				<div id="bs-example-navbar-collapse-1"
					class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a
							title="Our Collection of Templates &amp; Themes"
							data-toggle="dropdown" class="dropdown-toggle" href="#"
							aria-expanded="false">Dropdown example<b class="caret"> <!--  -->
							</b></a>
							<ul class="dropdown-menu">
								<li><a href="/template-categories/all">All Templates
										&amp; Themes</a></li>
								<li class="dropdown-header">Template &amp; Theme
									Categories:</li>
								<li><a href="/template-categories/navigation-menus">Navigation
										and Navbars</a></li>
							</ul></li>
						<li><a>Students</a></li>
						<li><a>Groups</a></li>
						<li><a>Coaches</a></li>
						<li><a>Managers</a></li>
						<li><a>Coordinators</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	</section>
</jsp:root>