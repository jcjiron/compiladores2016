<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
<jsp:text>
	<![CDATA[
    <script
        src="${pageContext.request.contextPath}/pages/informacion-base/gestionar-empresa/js/index.js"
        type="text/javascript"></script>
    ]]>
</jsp:text>
</head>
<body>
	<!-- Body -->
	<s:set var="title" value="%{getText('GESTIONAR_EMPRESA')}" />
	<s:set var="colNombre" value="%{getText('NOMBRE_EMPRESA')}" />
	<s:set var="colCorreo" value="%{getText('CORREO_EMPRESA')}" />
	<div class="row">
		<div class="col-md-12">
			<h1>${title}</h1>
		</div>
	</div>
	<div class="form form-horizontal form-max">
		<div class="row">
			<div class="col-md-12">
				<table id="tblEmpresas">
					<thead>
						<tr>
							<th>${colNombre}</th>
							<th>${colCorreo}</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listEmpresas" var="e">
							<tr>
								<td>${e.nombre}</td>
								<td>${e.cuenta.correo}</td>
								<td><a href="${pageContext.request.contextPath}/informacion-base/gestionar-empresa/${e.idEmpresa}/edit"><img
										src="${pageContext.request.contextPath}/resources/images/icons/edit.png" /></a>
									<a href="${pageContext.request.contextPath}/informacion-base/gestionar-empresa/${e.idEmpresa}/deleteConfirm"><img
										src="${pageContext.request.contextPath}/resources/images/icons/delete.png" /></a>
									<a href="${pageContext.request.contextPath}/informacion-base/gestionar-empresa/${e.idEmpresa}"><img
										src="${pageContext.request.contextPath}/resources/images/icons/check.png" /></a>
									<a href="${pageContext.request.contextPath}/informacion-base/gestionar-empresa/${e.idEmpresa}/addSpecialist"><img
										src="${pageContext.request.contextPath}/resources/images/icons/add.png" /></a>
									<a href="${pageContext.request.contextPath}/proyecto/gestionar-proyecto/${e.idEmpresa}/editNew"><img
										src="${pageContext.request.contextPath}/resources/images/icons/courses.png" /></a>		
										</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>
