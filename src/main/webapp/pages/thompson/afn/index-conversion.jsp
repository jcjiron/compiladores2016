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
	<div class="row">
		<div class="col-md-4  ">
			<!--  -->
		</div>
		<div class="col-md-8">
			<table>

				<tbody>
					<s:iterator var="fil" value="af" status="stat">

						<tr>
							<s:iterator var="ll" value="#fil">
								<th><s:property value="ll" /></th>

							</s:iterator>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
	</html>
</jsp:root>