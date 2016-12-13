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
		<s:text name="Validacion de cadena" />
	</h1>


	<div class="form-group">
		<div class="col-md-4 label-obligatorio control-label">
			<s:text name="Cadena" />
		</div>
		<div class="col-md-8">
			<s:property value="cadena" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-4 label-obligatorio control-label">
			<s:text name="Estado" />
		</div>
		<div class="col-md-8">
			<s:property value="isValida" />
		</div>
	</div>
	<s:if test="isValida eq true">
		

		<s:iterator value="afn.simboloGramatica" var="f" status="incr">
			<s:set var="cnt" value="%{#incr.index}" />
			
			<div class="form-group">
				<div class="col-md-4 ">
					<s:text name="afn.token[#cnt]" />
				</div>

				<div class="col-md-4">
					<s:property value="f" />

				</div>
				<div class="col-md-4">
					
					<s:property value="afn.expresionReg[#cnt]" />
				</div>
			</div>
		</s:iterator>

	</s:if>
</body>
	</html>
</jsp:root>