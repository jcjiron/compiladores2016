<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml" slick-uniqueid="3" dir="ltr"
		class="com_content view-article itemid-482 home j25 mm-hover no-touch uk-notouch wf--n4-active wf-opensans-n4-active wf-opensans-n6-active wf-opensans-n3-active wf-active"
		lang="es-es">
<head>
<!-- base href="http://www.rcc-consultoria.com/" -->
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<s:url id="urlRutaContextoTema"
	value="%{pageContext.request.contextPath}/resources/templates/themes"
	includeContext="true" />
<sj:head debug="true" jqueryui="true" jquerytheme="redmond" locale="us" />
<!--<sj:head debug="true" jqueryui="true" jquerytheme="psilinia-theme1"
	customBasepath="%{urlRutaContextoTema}" locale="es" />-->
<title><s:text name="com.rcc.acronym" /> - <s:text
		name="com.rcc.dependency" /></title>
<link
	href="${pageContext.request.contextPath}/resources/images/favicon.ico"
	rel="shortcut icon" type="image/vnd.microsoft.icon" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/components/bootstrap/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/components/bootstrap/css/bootstrap-theme.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/components/bootstrap/css/scrolling-nav.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/components/dataTables/media/css/jquery.dataTables.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/components/dataTables/media/css/dataTables.jqueryui.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/form.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/scrolling-nav.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/contactos.css"
	type="text/css" />
<jsp:text>
	<![CDATA[
	<script
		src="${pageContext.request.contextPath}/resources/components/bootstrap/js/bootstrap.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/components/bootstrap/js/scrolling-nav.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/components/bootstrap/js/jquery.easing.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/components/dataTables/media/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/scripts/emeth-dataTables.js"
		type="text/javascript"></script>
	]]>
</jsp:text>
<decorator:head />
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<s:include value="header.jsp" />
	<!-- Intro Section -->
	<section id="intro" class="intro-section">
		<div id="content" class="container">
			<div class="row">
				<decorator:body />
			</div>
		</div>
		<s:include value="footer.jsp" />
	</section>
	<input type="text" style="display: none;" id="hdnRutaContexto"
		value="${pageContext.request.contextPath}" />
	<!--<s:hidden cssStyle="display: none;" id="hdnUrlLanguageDataTable"
		value="%{getText('URL_LANGUAGE_DATATABLE')}" />-->
</body>
	</html>
</jsp:root>