<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
</head>
<body>
	<h1>
		<s:text name="LBL_DELETE_CONFIRM_ESPECIALISTA"></s:text>
	</h1>
	<div>
		<s:form method="POST"
			action="%{#pageContext.request.contextPath}/informacion-base/gestionar-especialista/%{model.idPersona}">
			<s:hidden name="_method" value="DELETE" />
			<div>
				<s:property value="model.nombre" />
			</div>

			<div>
				<s:property value="model.cuenta.correo" />
			</div>
			<s:submit></s:submit>
			<a
				href="${pageContext.request.contextPath}/informacion-base/gestionar-especialista/">
				Cancelar</a>
		</s:form>
	</div>
</body>
	</html>
</jsp:root>