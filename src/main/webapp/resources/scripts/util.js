/**
 * 
 */
$(function() {
	var banner = $('#banner');
	var banner_offset = banner.offset();
	var content = $('#content');
	/*
	 * $(window).on('scroll', function() { if ($(window).scrollTop() >
	 * banner_offset.top) { banner.addClass('banner-fijo');
	 * content.addClass('content-banner-fijo'); } else {
	 * banner.removeClass('banner-fijo');
	 * content.removeClass('content-banner-fijo'); } });
	 */
	$(".onlyNumber")
			.keydown(
					function(e) {
						console.log(e.keyCode)
						if ($.inArray(e.keyCode, [ 8 ]) !== -1
								|| (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true))
								|| (e.keyCode >= 35 && e.keyCode <= 40)) {
							return;
						}
						if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57))
								&& (e.keyCode < 96 || e.keyCode > 105)) {
							e.preventDefault();
						}
					});

	$(".btn-menu").hover(function(e) {
		$(".menu-flotante").addClass('active');
	}, function(e) {
	});

	$(".menu-flotante").on("mouseleave", function() {
		$(".menu-flotante").removeClass('active');
	});

	$(".btn-menu").click(function(e) {
		$(".menu-flotante").addClass('active');
		e.preventDefault();
	});
	$(".cerrar-menu").click(function(e) {
		$(".menu-flotante").removeClass('active');
		e.preventDefault();
	});
});

var item = function() {
	function show(id) {
		$("#" + id).removeClass("hide");
	}

	function hide(id) {
		$("#" + id).addClass("hide");
	}

	return {
		show : show,
		hide : hide
	};
}();

var instruction = function() {

	function show(param) {
		$(param).popover('show');
	}

	function hide(param) {
		$(param).popover('hide');
	}

	return {
		show : show,
		hide : hide
	};
}();

/**
 * Namespace para el manejo de errores
 */
var error = function() {
	/**
	 * Función para mostrar un error
	 * 
	 * @param identificador
	 */
	function mostrarError(identificador) {
		$("#" + identificador).removeClass("hide");
	}

	/**
	 * Función para mostrar varios errores
	 * 
	 * @param array
	 */
	function mostrarErrores(array) {
		$(array).each(function() {
			$("#" + this).removeClass("hide");
		});
	}

	/**
	 * Función para ocultar un error
	 * 
	 * @param identificador
	 */
	function ocultarError(identificador) {
		$("#" + identificador).addClass("hide");
	}

	/**
	 * Función para ocultar varios errores
	 * 
	 * @param array
	 */
	function ocultarErrores(array) {
		$(array).each(function() {
			$("#" + this).addClass("hide");
		});
	}
	return {
		mostrarError : mostrarError,
		mostrarErrores : mostrarErrores,
		ocultarError : ocultarError,
		ocultarErrores : ocultarErrores
	};
}();

String.prototype.format = function() {
	var formatted = this;
	for (var i = 0; i < arguments.length; i++) {
		var regexp = new RegExp('\\{' + i + '\\}', 'gi');
		formatted = formatted.replace(regexp, arguments[i]);
	}
	return formatted;
};

String.prototype.formatBold = function() {
	var formatted = this;
	for (var i = 0; i < arguments.length; i++) {
		var regexp = new RegExp('\\{' + i + '\\}', 'gi');
		formatted = formatted.replace(regexp, '<b>' + arguments[i] + '</b>');
	}
	return formatted;
};

String.prototype.formatItalic = function() {
	var formatted = this;
	for (var i = 0; i < arguments.length; i++) {
		var regexp = new RegExp('\\{' + i + '\\}', 'gi');
		formatted = formatted.replace(regexp, '<i>' + arguments[i] + '</i>');
	}
	return formatted;
};

/**
 * Namespace para el manejo de ajax
 */
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
	function enviarFormHidden2(idElementoContent, formId) {
	
		var form = $("#" + formId);
		
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

	/**
	 * Función que permite llenar el contenido del componente domicilio.
	 */
	function llenarCombo(idCombo, formId, indicator) {
		var form = $("#" + formId);
		if (indicator != undefined) {
			if (indicator == true) {
				$("#" + idCombo + "_indicator").removeClass("hidden");
			}
		}
		$
				.ajax({
					type : form.attr("method"),
					url : form.attr("action"),
					data : form.serialize(),
					cache : false,
					dataType : 'json',
					success : function(data) {
						var combo = $('#' + idCombo);
						var valorCombo = $('#' + idCombo + "_lastValue");
						if (valorCombo.val() != "") {
							llenarComboVacio(idCombo, false);
						} else {
							llenarComboVacio(idCombo, true);
						}
						if (data.elemento != null) {
							if (data.elemento.length != 0) {
								$("#divMSG83").addClass("hidden");
								$
										.each(
												data.elemento,
												function(i, value) {
													if (i == 0) {
														$("#txtEstado")
																.val(
																		value.entidad.nombre);
														$("#hdnEstado")
																.val(
																		value.claveEntidad);
														$("#txtDelegacion")
																.val(
																		value.municipio.nombre);
														$("#hdnDelegacion")
																.val(
																		value.claveMunicipio);
														if (value.ciudad != null) {
															$("#txtCiudad")
																	.val(
																			value.ciudad.nombre);
														} else {
															$("#txtCiudad")
																	.val(
																			"Sin información");
														}
													}
													combo
															.append('<option value='
																	+ value.idAsentamiento
																	+ '>'
																	+ value.asentamiento.value
																	+ '</option>');
												});
								if (valorCombo.length == 1
										&& valorCombo.val() != undefined
										&& valorCombo.val() != ""
										&& valorCombo.val() != null
										&& valorCombo.val() != -1) {
									combo.val(valorCombo.val());
									combo.trigger("change");
								}
							} else {
								$("#txtEstado").val("");
								$("#txtDelegacion").val("");
								$("#txtCiudad").val("");
								$("#divMSG83").html(
										$("#hdnMSG83").text().formatItalic(
												$("#txtCP").val()));
								$("#divMSG83").removeClass("hidden");
							}
							if (indicator != undefined) {
								if (indicator == true) {
									$("#" + idCombo + "_indicator").addClass(
											"hidden");
								}
							}
						} else {
							$("#textoErrorLlenarCombo")
									.text(
											"La consulta efectuada se realizo satisfactoriamente, sin embargo no devolvio elementos.");
							$.publish("dialogErrorLlenarCombo");
							if (indicator != undefined) {
								if (indicator == true) {
									$("#" + idCombo + "_indicator").addClass(
											"hidden");
								}
							}
						}
					},
					error : function(data) {
						$("#textoErrorLlenarCombo")
								.text(
										"Se detectaron problemas de conexión con el servidor. Favor de reintentar.");
						$.publish("dialogErrorLlenarCombo");
						if (indicator != undefined) {
							if (indicator == true) {
								$("#" + idCombo + "_indicator").addClass(
										"hidden");
							}
						}
					}
				});
	}

	function llenarComboVacio(idCombo, status) {
		var combo = $('#' + idCombo);
		if ($("#" + idCombo).length > 0) {
			combo.empty().append('<option value="-1">Seleccione</option>')
					.find('option:first').attr("selected", "selected");
		}
		if (status) {
			$('#' + idCombo + "_lastValue").val("");
			combo.val("-1");
			combo.trigger("change");
		}
	}

	function ocultarMessageAjax() {
		item.hide("divMessageAjaxError");
	}

	function cerrarErrorLlenarCombo() {
		$.publish("cerrarDialogoErrorLlenarCombo");
	}

	return {
		enviarFormHidden : enviarFormHidden,
		enviarFormHidden2 : enviarFormHidden2,
		llenarCombo : llenarCombo,
		llenarComboVacio : llenarComboVacio,
		ocultarMessageAjax : ocultarMessageAjax
	};
}();

var resource = function() {

	function showDialog(image) {
		$("#imgShowResource").attr("src", image);
		$.publish("tcpShowDialog");
	}

	function closeDialog() {
		$.publish("tcpCloseDialog");
	}

	function download(path) {

	}

	return {
		showDialog : showDialog,
		closeDialog : closeDialog,
		download : download
	};
}();

var image = function() {

	var FORMAT_PNG = "image/png";
	var FORMAT_JPG = "image/jpg";
	var FORMAT_JPEG = "image/jpeg";
	const
	SIZE2M = "2465792";

	function validateFormat(format) {
		return (format == FORMAT_PNG || format == FORMAT_JPG || format == FORMAT_JPEG) ? true
				: false;
	}

	function showImage(input, idImage, idError, idErrorServer, pathImageAvatar) {
		$('#' + idError).addClass('hide');
		$('#' + idErrorServer).addClass('hide');
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			var format = input.files[0].type
			if (!(input.files[0].size < 1024 * 1024 * 1)) {
				$(".erasable").addClass("hide");
				$("#" + idError).removeClass("hide");
				$('#' + idImage).attr('src', pathImageAvatar);
			} else {

				if (validateFormat(format)) {
					reader.onload = function(e) {
						$('#' + idImage).attr('src', e.target.result);
					}
					reader.readAsDataURL(input.files[0]);
				} else {
					$(".erasable").addClass("hide");
					$("#" + idError).removeClass("hide");
					$('#' + idImage).attr('src', pathImageAvatar);
				}
			}
		}
	}

	function selectImage(idImage) {
		$("#" + idImage).click();
	}

	function validateSize(size) {
		return (Number(size) <= Number(SIZE2M)) ? true : false;
	}

	return {
		showImage : showImage,
		selectImage : selectImage,
		validateSize : validateSize
	};
}();

var validator = new function() {

	var MONTHS = {
		ENERO : {
			id : 0,
			valor : "Enero"
		},
		FEBRERO : {
			id : 1,
			valor : "Febrero"
		},
		MARZO : {
			id : 2,
			valor : "Marzo"
		},
		ABRIL : {
			id : 3,
			valor : "Abril"
		},
		MAYO : {
			id : 4,
			valor : "Mayo"
		},
		JUNIO : {
			id : 5,
			valor : "Junio"
		},
		JULIO : {
			id : 6,
			valor : "Julio"
		},
		AGOSTO : {
			id : 7,
			valor : "Agosto"
		},
		SEPTIEMBRE : {
			id : 8,
			valor : "Septiembre"
		},
		OCTUBRE : {
			id : 9,
			valor : "Octubre"
		},
		NOVIEMBRE : {
			id : 10,
			valor : "Noviembre"
		},
		DICIEMBRE : {
			id : 11,
			valor : "Diciembre"
		}
	};

	var naturalRegex = /\d*/;
	var positiveRegex = /(^\d*\.?\d*[1-9]+\d*$)|(^[1-9]+\d*\.\d*$)/;
	var realRegex = /^[+-]?\d*(\.\d{1,3})?$/;
	var dateRegex = /(([0-9]){2})\/(([0-9]){2})\/(([0-9]){4})/;
	var whiteSpaceRegex = /^\s+$/;
	var twitterRegex = /^@(\w){1,15}$/;
	var phoneRegex = /(^[0-9]{7,10})/;
	var ladaRegex = /(^[0-9]{5})/;
	var nameRegex = /^[a-z\u00E0-\u00FC\sA-Z\u00C0-\u00DC\s]+$/;
	var emailRegex = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
	var CP5 = /\d{5}/;
	var CP8 = /[a-zA-Z]\d{4}[a-zA-Z][a-zA-Z][a-zA-Z]/;
	var CP6 = /\d{6}/;
	var CP7 = /\d{7}/;
	var CPUSA = /\d{5}-\d{4}/;
	var CPCAN = /[a-zA-Z]\d[a-zA-Z]\s\d[a-zA-Z]\d/;
	var COLONIA = /[a-zA-ZñÑ1-9\s]{2,100}/;
	var rfcRegex = /^[A-Z]{4}\d{6}[A-Z0-9]{3}/;
	var curpRegex = /^[A-Z]{4}\d{6}[A-Z0-9]{8}$/;
	var NscRegex = /\d{1,20}/;
	var UrlRegex = /^(?:([A-Za-z]+):)?(\/{0,3})([0-9.\-A-Za-z]+)(?::(\d+))?(?:\/([^?#]*))?(?:\?([^#]*))?(?:#(.*))?$/;

	function validateField(field, regex) {
		return regex.test(field);
	}

	function whiteSpace(field) {
		return field.trim() == "";
	}

	function date(field) {
		return validateField(field, dateRegex);
	}

	function real(field) {
		return validateField(field, realRegex);
	}

	function positive(field) {
		return validateField(field, positiveRegex);
	}

	function natural(field) {
		return validateField(field, naturalRegex);
	}

	function twitter(field) {
		return validateField(field, twitterRegex);
	}

	function phone(field) {
		return validateField(field, phoneRegex);
	}

	function lada(field) {
		return validateField(field, ladaRegex);
	}

	function names(field) {
		return validateField(field, nameRegex);
	}

	function size(field, min, max) {
		return (field.length < min || field.length > max);
	}

	function email(field) {
		return validateField(field, emailRegex);
	}

	function rfc(field) {
		return validateField(field, rfcRegex);
	}
	function NSC(field) {
		return validateField(field, NscRegex);
	}
	function cp5(field) {
		return validateField(field, CP5);
	}
	function cp8(field) {
		return validateField(field, CP8);
	}
	function cp7(field) {
		return validateField(field, CP7);
	}
	function cp6(field) {
		return validateField(field, CP6);
	}
	function cpCAN(field) {
		return validateField(field, CPCAN);
	}
	function cpUSA(field) {
		return validateField(field, CPUSA);
	}
	function colonia(field) {
		return validateField(field, COLONIA);
	}
	function curp(field) {
		return validateField(field, curpRegex);
	}
	function Url(field) {
		return validateField(field, UrlRegex);
	}
	function isValidDate(day, month, year) {
		var validDate = false;
		if ((month >= MONTHS.ENERO.id && month <= MONTHS.DICIEMBRE.id)
				&& (day >= 1 && day <= 31)) {
			if ((month == MONTHS.ABRIL.id || month == MONTHS.JUNIO.id
					|| month == MONTHS.SEPTIEMBRE.id || month == MONTHS.NOVIEMBRE.id)
					&& (day <= 30)) {
				validDate = true;
			} else if ((month == MONTHS.ENERO.id || month == MONTHS.MARZO.id
					|| month == MONTHS.MAYO.id || month == MONTHS.JULIO.id
					|| month == MONTHS.AGOSTO.id || month == MONTHS.OCTUBRE.id || month == MONTHS.DICIEMBRE.id)
					&& (day <= 31)) {
				validDate = true;
			} else if ((month == MONTHS.FEBRERO.id) && (day < 30)) {
				var validLeapYear = false;
				if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
					validLeapYear = true;
				}
				if (validLeapYear == true && day <= 29) {
					validDate = true;
				} else if (validLeapYear == false && day <= 28) {
					validDate = true;
				}
			}
		}
		return validDate;
	}

	function codigoPostal(field, pais) {
		alert(pais);
	}

	function codigoPostal(field, pais) {
		if (pais == '15' || pais == '14' || pais == '22' || pais == '21'
				|| pais == '20' || pais == '19' || pais == '16' || pais == '12'
				|| pais == '10' || pais == '7' || pais == '6') {
			return cp5(field);
		}
		if (pais == '1') {
			return cp8(field);
		}
		if (pais == '3') {
			return cpCAN(field);
		}
		if (pais == '5' || pais == '8') {
			return cp6(field);
		}
		if (pais == '4') {
			return cp7(field);
		}
		if (pais == '11') {
			return cpUSA(field);
		}
	}
	function sizeCp(field, pais) {
		if (pais == '15' || pais == '14' || pais == '22' || pais == '21'
				|| pais == '20' || pais == '19' || pais == '16' || pais == '12'
				|| pais == '10' || pais == '7' || pais == '6') {
			return (field.length < 5 || field.length > 5);
		}
		if (pais == '1') {
			return (field.length < 8 || field.length > 8);
		}
		if (pais == '3' || pais == '4') {
			return (field.length < 7 || field.length > 7);
		}
		if (pais == '5' || pais == '8') {
			return (field.length < 6 || field.length > 6);
		}
		if (pais == '11') {
			return (field.length < 10 || field.length > 10);
		}
	}

	return {
		NSC : NSC,
		validateField : validateField,
		whiteSpace : whiteSpace,
		date : date,
		real : real,
		positive : positive,
		natural : natural,
		twitter : twitter,
		phone : phone,
		lada : lada,
		names : names,
		size : size,
		email : email,
		cp5 : cp5,
		cp8 : cp8,
		cp7 : cp7,
		cp6 : cp6,
		cpCAN : cpCAN,
		cpUSA : cpUSA,
		colonia : colonia,
		rfc : rfc,
		codigoPostal : codigoPostal,
		sizeCp : sizeCp,
		colonia : colonia,
		curp : curp,
		Url : Url,
		isValidDate : isValidDate
	};
}();
