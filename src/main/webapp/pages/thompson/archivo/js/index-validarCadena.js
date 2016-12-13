

function agregarPalabra() {
	var cadena = $("#cadena").val();
	$("#hdnCadena").val(cadena);
	
	var id = "divContenValidacion";
	var formId = "frmHdnCadena";
	Ajax.enviarFormHidden2(id, formId);

}