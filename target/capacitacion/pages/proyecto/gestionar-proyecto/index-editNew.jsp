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
		<s:text name="TLT_AGREGAR_PROYECTO" />
	</h1>

	<div class="form form-horizontal form-max">
		<div class="row">
			<div class="col-md-12">
				<s:form method="POST"
					action="%{#pageContext.request.contextPath}/proyecto/gestionar-proyecto">
					<s:hidden name="idSel" />
					<div class="form-group">
						<div class="col-md-4 label-obligatorio control-label">
							<s:text name="LBL_NOMBRE_PROYECTO" />
						</div>
						<div class="col-md-8">
							<s:textfield type="text" name="model.nombre" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-4 label-obligatorio control-label">
							<s:text name="LBL_TIPO_RELACION_PROYECTO" />
						</div>
						<div class="col-md-8">
							<s:select list="listTipoRelaciones" listValue="nombre"
								listKey="idTipo" value="idTipo" name="empresaProyecto.idTipo"></s:select>
						</div>
					</div>

					<s:submit></s:submit>

				</s:form>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>