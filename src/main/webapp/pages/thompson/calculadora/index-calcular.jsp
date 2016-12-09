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
	<br />
	<br />
	<br />
	<br />



	<div class="form-group">
		<div class="col-md-4 label-obligatorio control-label">la cadena es</div>
		<div class="col-md-8">
			<s:property value="valida"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-4 label-obligatorio control-label">Resultado</div>
		<div class="col-md-8">
			<s:property value="resultado" />
		</div>
	</div>

</body>
	</html>
</jsp:root>