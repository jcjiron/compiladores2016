

function agregarPalabra() {
	var regla = $("#Reglas").val();
	$("#hdnRegla").val(regla);
	
	var id = "divContenReglas";
	var formId = "frmHdnRegla";
	Ajax.enviarFormHidden2(id, formId);

}