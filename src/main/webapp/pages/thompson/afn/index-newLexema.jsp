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
	<!-- Body -->
	<h1>
		<s:text name="Id Lexema" />
	</h1>
	<s:form method="POST"
		action="%{#pageContext.request.contextPath}/thompson/afn!idLexema">
		
		<s:select name="idAfn" list="listAfns" listValue="name"
			listKey="idLexema" />
		
		<div class="form-group">
						<div class="col-md-4 label-obligatorio control-label">
							<s:text name="id Lexema" />
						</div>
						<div class="col-md-8">
							<s:textfield name="idLexema" cssClass="form-control" />
						</div>
					</div>
		<div>
			<s:submit value="Aceptar" />
		</div>
	</s:form>
</body>
	</html>
</jsp:root>