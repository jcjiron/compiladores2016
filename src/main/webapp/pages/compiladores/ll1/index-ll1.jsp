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



				<div class="form-group ">
					<div class="col-md-4 label-obligatorio control-label">Vt</div>
					<div class="col-md-4">
						<s:property value="vt " />
					</div>
				</div>


				<div class="form-group">
					<div class="col-md-4 label-obligatorio control-label">VnT</div>
					<div class="col-md-4">
						<s:property value="vnt " />
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-4  control-label">lista de reglas</div>
					<div class="col-md-4">
						<s:iterator value="listReglas" var="reg">
							<p>
								<s:property value="reg" />
							</p>
						</s:iterator>
					</div>

				</div>
				
			</div>

		</div>
		<div class="row">
			<div class="col-md-4  ">
				<!--  -->
			</div>
			<div class="col-md-8">
				<table>
					<thead>
						<tr>
							<th>----</th>
							<s:iterator var="str" value="ll1.col">
								<th><s:property value="str" /></th>

							</s:iterator>
						</tr>
					</thead>

					<tbody>
						<s:iterator var="fil" value="ll1.filas" status="stat">

							<tr>
								<td><s:property value="fil" /></td>
								<s:iterator var="ll" value="ll1.ll1[#stat.count-1]">
									<th><s:property value="ll" /></th>

								</s:iterator>
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