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
	<div class="form form-horizontal form-max">
		<div class="row">
			<div class="col-md-12">
				<s:form method="POST" 
					action="%{#pageContext.request.contextPath}/compiladores/ll1/">


					
						<div class="form-group ">
							<div class="col-md-4 label-obligatorio control-label">Vt</div>
							<div class="col-md-4">
								<s:textfield name="vt" cssClass="form-control" />
							</div>
						</div>
					
					
					<div class="form-group">
						<div class="col-md-4 label-obligatorio control-label">VnT</div>
						<div class="col-md-4">
							<s:textfield name="vnt" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4 label-obligatorio control-label">reglas</div>
						<div class="col-md-4">
							<s:textfield name="reglas" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<s:submit value="Aceptar" />
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>