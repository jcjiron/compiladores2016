<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
<![CDATA[
	<script
		src="${pageContext.request.contextPath}/pages/thompson/archivo/js/index-validarCadena.js"
		type="text/javascript"></script>
	]]>
</head>
<body>

	<!-- Body -->

	AFN por Archivo
	<br /> Validar Cadena
	<div class="form-group">


		<div class="form-group">
			<div class="col-md-4 label-obligatorio control-label">
				<s:text name="Cadena" />
			</div>
			<div class="col-md-8">
				<s:textfield id="cadena" cssClass="form-control" />
			</div>
		</div>
		<div class="col-md-3 col-md-offset-4">
			<button type="button" onclick="agregarPalabra();">Validar</button>
		</div>

		<div id="divContenValidacion">
			<!--  -->
		</div>
		<s:form id="frmHdnCadena" method="POST"
			action="%{#pageContext.request.contextPath}/thompson/archivo!validarCadena"
			cssClass="hidden">
			<s:hidden name="cadena" id="hdnCadena" />
		</s:form>
	</div>
</body>
	</html>
</jsp:root>