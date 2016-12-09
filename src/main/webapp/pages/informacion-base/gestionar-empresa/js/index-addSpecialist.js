
var varName = undefined;
var varPrimerApellido = undefined;
var varSegundoApellido = undefined;
$(function() {
	
	$("#tblEspecialistas").dataTable();
	
	$("#nombre").change(function(e) {
		
		varName = $(this).val();
		Especialista.obtenerEspecialista();
	});
	
	$("#primerApellido").change(function(e) {
		varPrimerApellido = $(this).val();
		Especialista.obtenerEspecialista();
	});
	
	$("#segundoApellido").change(function(e) {
		varSegundoApellido = $(this).val();
		Especialista.obtenerEspecialista();
	});
});

function getName(){
	$("#nombre").attr("name", "especialista.nombre");
}

function getPrimerApellido(){
	$("#primerApellido").attr("name", "especialista.primerApellido");
}

function getSegundoApellido(){
	$("segundoApellido").attr("name", "especialista.segundoApellido");
}

/**
 * Namespace utilizado para el manejo de funciones y operaciones requeridad en
 * la selección de un recurso.
 */
var Especialista = function() {

	var idEspecialista = undefined;

	function send() {
		$("#frmSeleccionarEspecialista").submit();
	}

	function obtenerEspecialista() {
	
			$("#hdnNombre").val(varName);
			$("#hdnPrimerApellido").val(varPrimerApellido);
			$("#hdnSegundoApellido").val(varSegundoApellido);
			enviarForm();
		
	}

	function enviarForm() {
		var id = "divContentDataTable";
		var formId = "frmHdnObtenerEspecialistas";
		Ajax.enviarFormHidden(id, formId, false, 1);
	}

	function limpiarDatos() {
		$("#hdnNombre").val("");
		$("#hdnPrimerApellido").val("");
		$("#hdnSegundoApellido").val("");
	}

	return {
		send : send,
		obtenerEspecialista : obtenerEspecialista,
		limpiarDatos : limpiarDatos
	};
}();

var Ajax = function() {
	/**
	 * Función para enviar formularios ocultos mediante ajax.
	 */
	function enviarFormHidden(idElementoContent, formId, indicator, dataTable) {
		
		var form = $("#" + formId);
		if (indicator != undefined && indicator == true) {
			$("#" + idElementoContent + "_indicator").removeClass("hidden");
		}
		
		$
				.ajax({
					type : form.attr("method"),
					url : form.attr("action"),
					data : form.serialize(),
					cache : false,
					dataType : 'html',
					success : function(data) {
						$("#" + idElementoContent).html("");
						$("#" + idElementoContent).html(data);

						switch (dataTable) {
						case 1:
							dataTableEMETH.createDataTable(idElementoContent
									+ "_datatable");
							break;
						case 2:
							dataTableEMETH
									.createDataTableWhitOutInfo(idElementoContent
											+ "_datatable");
							break;
						default:

						}

						if (indicator != undefined && indicator == true) {
							$("#" + idElementoContent + "_indicator").addClass(
									"hidden");
						}
					},
					error : function(data) {
						$('html,body').animate({
							scrollTop : $("#divMessageAjaxError").offset().top
						}, $("#hdnMSGSSCROLL").attr("value"));
						item.show("divMessageAjaxError");
						setTimeout(ocultarMessageAjax, $("#hdnMSGSSHOW").attr(
								"value"));
						if (indicator != undefined && indicator == true) {
							$("#" + idElementoContent + "_indicator").addClass(
									"hidden");
						}
					}
				});
	}

	
	

	return {
		enviarFormHidden : enviarFormHidden
		
	};
}();
