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
		<s:text name="Union Especial AFN" />
	</h1>
	<s:form method="POST"
		action="%{#pageContext.request.contextPath}/thompson/afn!especial">
		<s:select name="idAfn" list="listAfns" listValue="name"
			listKey="idLexema" />
		<s:select name="idAfn2" list="listAfns" listKey="idLexema"
			listValue="name" />
		<div>
			<s:submit value="unir" />
		</div>
	</s:form>
</body>
	</html>
</jsp:root>