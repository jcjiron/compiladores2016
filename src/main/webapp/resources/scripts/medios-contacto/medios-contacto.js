var _divEmergenciaBase = "divEmergencia";
var _divEmergencia;
var _formBase = "frmContacto";
var _formContacto = _formBase;
var _idTipoContacto;
var _contacto;
var _contactos;
var _operationAdd = "!addContact";
var _operationEdit = "!editContact";
var _operation;

$(function() {
	$("#btnAdd").bind("click", agregarContacto);
	$("#btnDialogAceptar").bind("click", agregar);
	$("#btnDialogCancelar").bind("click", cancelar);
	$("#btnDialogDeleteAceptar").bind("click", eliminar);
	$("#btnDialogDeleteCancelar").bind("click", cancelarEliminarContacto);
	$("#slcListTipoContactos").bind("change", cambioTipoContacto);
	$("input[name='contactoSel.idCategoriaFalse']").bind("click",
			seleccionarCategoria);
	_idTipoContacto = $("#slcListTipoContactos").val();
	$("input[name='contactoSel.idCategoriaFalse']").prop("checked", false);
	obtenerContactosJSON();
});

function seleccionarCategoria() {
	if (!(_idTipoContacto == undefined || _idTipoContacto == null || _idTipoContacto == -1)) {
		$("#slcListTipoContactos").removeClass("field-error");
		var categoriaContacto = $(
				"input[name='contactoSel.idCategoriaFalse']:checked").val();
		$("#hdnIdCategoria" + _contacto).val(categoriaContacto);
		if (categoriaContacto == 3) {
			$("#" + _divEmergencia).removeClass("hidden");
		} else {
			$("#" + _divEmergencia).addClass("hidden");
		}
	} else {
		$("#slcListTipoContactos").addClass("field-error");
	}
}

function eliminarContacto(idContacto) {
	$("#hdnIdContactoDelete").val(idContacto);
	$.publish("showDlgDeleteContact");
	$("#dlgDeleteContact").removeClass("dlgContact");
}

function cancelarEliminarContacto() {
	$.publish("closeDlgDeleteContact");
	$("#dlgDeleteContact").addClass("dlgContact");
}

function agregarContacto() {
	_operation = _operationAdd;
	$.publish("showDlgContact");
	$("#dlgContact").removeClass("dlgContact");
}

function cancelar() {
	$.publish("closeDlgContact");
	$("#dlgContact").addClass("dlgContact");
	$("#" + _divEmergencia).addClass("hidden");
	limpiarFormulario();
	limpiarErrores();
}

function agregar() {
	if (_formBase != _formContacto) {
		var form = $("#" + _formContacto);
		$.ajax({
			type : form.attr("method"),
			url : form.attr("action") + _operation,
			data : form.serialize(),
			cache : false,
			dataType : 'json',
			success : function(data) {
				var error = data.result.error;
				var valido = gestionarErrores(error)
				if (valido) {
					$.publish("closeDlgContact");
					$("#dlgContact").addClass("dlgContact");
					limpiarFormulario();
					limpiarErrores();
					_contactos = data.result.listContactos;
					mostrarContactos(_contactos);
				}
			},
			error : function(data) {
				alert("Error al realizar la operación");
			}
		});
	} else {
		$("#slcListTipoContactos").addClass("field-error");
	}
}

function eliminar() {
	var form = $("#frmDeleteContacto");
	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		dataType : 'json',
		success : function(data) {
			var error = data.result.error;
			var valido = gestionarErrores(error)
			if (valido) {
				$.publish("closeDlgDeleteContact");
				$("#dlgDeleteContact").addClass("dlgContact");
				_contactos = data.result.listContactos;
				mostrarContactos(_contactos);
			}
		},
		error : function(data) {
			alert("Error al realizar la operación");
		}
	});
}

function obtenerContactosJSON() {
	$.ajax({
		type : 'get',
		url : $("#hdnRutaContexto").val()
				+ '/coach/gestionar-coach!getContactsJSON',
		cache : false,
		dataType : 'json',
		success : function(data) {
			_contactos = data.listContactosSel;
		},
		error : function(data) {
			alert("Error al realizar la operación");
		}
	});
}

function mostrarContactos(contactos) {
	$.ajax({
		type : 'get',
		url : $("#hdnRutaContexto").val()
				+ '/coach/gestionar-coach!getContacts',
		cache : false,
		dataType : 'html',
		success : function(data) {
			$("#divContactos").html(data);
		},
		error : function(data) {
			alert("Error al realizar la operación");
		}
	});
}

function mostrarError(idCampo) {
	$("#" + idCampo).addClass("error");
}

function cambioTipoContacto() {
	var idTipo = $("#slcListTipoContactos").val();
	$("#slcListTipoContactos").removeClass("field-error");
	_idTipoContacto = idTipo;
	$("input[name='contactoSel.idCategoriaFalse']").prop("checked", false);
	limpiarErrores();
	$("#" + _divEmergencia).addClass("hidden");
	if (idTipo == 1) {
		_contacto = "Telefono";
		$("#hdnIdTipoContactoTelefono").val(_idTipoContacto);
		$("#divTelefono").removeClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 2) {
		_contacto = "Movil";
		$("#hdnIdTipoContactoMovil").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").removeClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 3) {
		_contacto = "Email";
		$("#hdnIdTipoContactoEmail").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").removeClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 4) {
		_contacto = "Fax";
		$("#hdnIdTipoContactoFax").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").removeClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 5) {
		_contacto = "LinkedIn";
		$("#hdnIdTipoContactoLinkedIn").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").removeClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 6) {
		_contacto = "Facebook";
		$("#hdnIdTipoContactoTelefono").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").removeClass("hidden");
		$("#divTwitter").addClass("hidden");
	} else if (idTipo == 7) {
		_contacto = "Twitter";
		$("#hdnIdTipoContactoTwitter").val(_idTipoContacto);
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").removeClass("hidden");
	} else {
		_contacto = "";
		$("#divTelefono").addClass("hidden");
		$("#divMovil").addClass("hidden");
		$("#divEmail").addClass("hidden");
		$("#divFax").addClass("hidden");
		$("#divLinkedIn").addClass("hidden");
		$("#divFacebook").addClass("hidden");
		$("#divTwitter").addClass("hidden");
	}
	_formContacto = _formBase + _contacto;
	_divEmergencia = _divEmergenciaBase + _contacto;
	$("#" + _divEmergencia).addClass("hidden");
	limpiarErrores();
}

function limpiarFormulario() {
	$("#slcListTipoContactos").val("-1");
	$("input[name='contactoSel.idCategoriaFalse']").prop("checked", false);
	$("#" + _formContacto).trigger("reset");
	cambioTipoContacto();
}

function editarContacto(idContacto) {
	_operation = _operationEdit;
	var contacto = obtenerContacto(idContacto);
	if (contacto != null) {
		$("#slcListTipoContactos").val(contacto.idTipo);
		cambioTipoContacto();
		var rdCategoria = $("#rdCategoria_" + contacto.idCategoria);
		rdCategoria.prop("checked", true);
		seleccionarCategoria();
		$("#hdnIdContacto" + _contacto).val(contacto.id);
		if (_contacto == "Telefono") {
			$("#txTelephoneCodeArea").val(contacto.auxiliar);
			$("#txTelephone").val(contacto.contacto);
			$("#txTelephoneExtension").val(contacto.auxiliarA);
		} else if (_contacto == "Movil") {
			$("#txMobileCodeArea").val(contacto.auxiliar);
			$("#txMobileTelephone").val(contacto.contacto);
		} else if (_contacto == "Email") {
			$("#txEmail").val(contacto.contacto);
		} else if (_contacto == "Fax") {
			$("#txFaxCodeArea").val(contacto.auxiliar);
			$("#txFaxTelephone").val(contacto.contacto);
			$("#txFaxExtension").val(contacto.auxiliarA);
		} else if (_contacto == "LinkedIn") {
			$("#txLinkedIn").val(contacto.contacto);
		} else if (_contacto == "Facebook") {
			$("#txFacebook").val(contacto.contacto);
		} else if (_contacto == "Twitter") {
			$("#txTwitter").val(contacto.contacto);
		}
		if (rdCategoria.val() == 3) {
			$("#txEmergencia" + _contacto).val(contacto.emergencia);
			$("#txRelation" + _contacto).val(contacto.relation);
		}
		$.publish("showDlgContact");
	}
}

function obtenerContacto(idContacto) {
	var size = _contactos.length;
	for (var i = 0; i < size; i++) {
		if (_contactos[i].id == idContacto) {
			return _contactos[i];
		}
	}
	return null;
}