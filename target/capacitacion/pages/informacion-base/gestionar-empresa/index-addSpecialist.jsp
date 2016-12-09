<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<![CDATA[
    <script
        src="${pageContext.request.contextPath}/pages/informacion-base/gestionar-empresa/js/index-addSpecialist.js"
        type="text/javascript"></script>
    ]]>
</head>
<body>
	<h1>Agregar Especialista</h1>

	<div class="form form-horizontal form-max">
		<div class="row">
			<div class="col-md-12">


				<div class="form-group">
					<div class="col-md-4 label-obligatorio control-label">
						<s:text name="LBL_NOMBRE" />
					</div>
					<div class="col-md-8">
						<s:textfield id="nombre" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-4 label-obligatorio control-label">
						<s:text name="LBL_PRIMER_APELLIDO" />
					</div>
					<div class="col-md-8">
						<s:textfield id="primerApellido" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-4 label-obligatorio control-label">
						<s:text name="LBL_SEGUNDO_APELLIDO" />
					</div>
					<div class="col-md-8">
						<s:textfield id="segundoApellido" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group" id="divContentDataTable">
					<table id="tblEspecialistas">
						<thead>
							<tr class="center">
								<th class="column">nombre</th>
								<th class="column">actions</th>

							</tr>
						</thead>

						<tbody>

							<s:iterator value="listEspecialistas" status="status">
								<tr class="center">


									<td><s:property value="nombre" /></td>
									<td>actiones maped</td>


								</tr>
							</s:iterator>

						</tbody>
					</table>
				</div>
				<s:form id="frmHdnObtenerEspecialistas" method="POST"
					action="%{#pageContext.request.contextPath}/informacion-base/gestionar-empresa!especialistaByExample"
					cssClass="hidden">
					<s:hidden name="nombre" id="hdnNombre" />
					<s:hidden name="primerApellido" id="hdnPrimerApellido" />
					<s:hidden name="segundoApelldio" id="hdnSegundoApellido" />
				</s:form>
			</div>
		</div>
	</div>

</body>
	</html>
</jsp:root>