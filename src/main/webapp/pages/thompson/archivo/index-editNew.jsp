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

	AFN por Archivo
	<div class="form-group">
		<s:form method="POST"
			action="%{#pageContext.request.contextPath}/thompson/archivo"
			enctype="multipart/form-data">
			<div class="col-md-4 label-obligatorio control-label">
				<s:text name="Archivo" />
			</div>
			<div class="col-lg-4">
				<input type='file' name="archivo.fileUpload" accept=".txt" />
				<s:fielderror fieldName="archivo.fileUpload" theme="bootstrap" />
			</div>
			<div class="col-md-3 col-md-offset-4">
				<s:submit value="Registrar" title="Aceptar"
					cssClass="btn btn-success" />
			</div>
		</s:form>
	</div>
</body>
	</html>
</jsp:root>