<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<body>

					<table id="divContentDataTable_datatable">
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
	

</body>
	</html>
</jsp:root>