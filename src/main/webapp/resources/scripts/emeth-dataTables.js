/**
 * Namespace que permite realizar operaciones con el componente de DataTable
 * 
 * @author Jorge Eduardo Álvarez Hernández
 * @version 1.0 "Aug 24, 2015"
 */
var dataTableEMETH = function() {

	/**
	 * Permite agregar una fila en una Tabla especificada
	 * 
	 * @param idTable
	 *            {String} identificador de la tabla a la que se quiere agregar
	 *            el elemento
	 * @param row
	 *            {Array} cada uno de los elemento que van a ser agregados en la
	 *            fila
	 */
	function addRow(idTable, row) {

		$("#" + idTable).dataTable().fnAddData([ row ], true);

	}

	/**
	 * Borra un elemento de la tabla
	 * 
	 * @param table
	 *            {String} tabla a la que se quiere eliminar un elemento
	 * 
	 * @param row
	 *            {Obeject} elemento que van a ser eliminado de la tabla
	 */
	function deleteRow(table, element) {
		$("#" + table.id).DataTable().row($(element).parents('tr')).remove()
				.draw();
	}

	function deleteRowId(table, element) {
		$("#" + table).DataTable().row($(element).parents('tr')).remove()
				.draw();
	}
	/**
	 * Borra todos los elementos de la tabla
	 * 
	 * @param table
	 *            {String} tabla de la que se quieren eliminar todos los
	 *            registros
	 */
	function deleteRows(table) {
		$('#' + table).DataTable().rows().remove().draw();
	}
	/**
	 * Verifica que un elemento exista en una tabla, en caso de que exista
	 * regresa verdadero, verifica un valor de referencia contra los elementos
	 * de una columna, en caso de ser requerido mustra un mensaje pasando como
	 * parametro el elemento que esta repetido.
	 * 
	 * @param idTabla
	 *            {String} identificador de la tabla en la que se realizará la
	 *            comparación
	 * @param value
	 *            {String} valor de referencia que se busca encontrar en la
	 *            tabla
	 * @param index
	 *            {Integer} índice que indica sobre que columna debe realizarse
	 *            la busqueda
	 * @param idMessage
	 *            {String} (opcional) indica el identificador del texto del
	 *            mensaje que se mostrará en caso de que exista un elemento
	 *            repetido
	 * @param message
	 *            {String} mensaje original
	 * @returns {Boolean} verdadero en caso de que exista un elemento repetido,
	 *          falso en caso contrario
	 * 
	 */
	function exist(idTable, value, index, idMessage, message) {
		var table = $("#" + idTable).dataTable();
		for (var i = 0; i < table.fnSettings().fnRecordsTotal(); i++) {
			if (value === table.fnGetData(i, index)) {
				if (idMessage != undefined && message != undefined
						&& idMessage !== null && idMessage !== '') {
					$("#" + idMessage).text(message.format({
						4 : value
					}));
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Crea una tabla por medio del componente DataTables 1.10 sin aplicarle
	 * ningún tema
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table ha ser creado como
	 *            objeto DataTable
	 * @returns Objeto DataTable creado
	 */
	function createDataTableWhitOutInfo(idTable, aoColumnDefs) {
		return $("#" + idTable).dataTable({
			"bFilter" : false,
			"bSort" : false,
			"bLengthChange" : false,
			"bPaginate" : false,
			"bInfo" : false,
			"autoWidth" : false,
			"aoColumnDefs" : aoColumnDefs
//			,
//			"language" : {
//				"url" : $("#hdnRutaContexto").val() + getUrlLanguage()
//			}
		});
	}

	/**
	 * Crea una tabla por medio del componente DataTables 1.10
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table ha ser creado como
	 *            objeto DataTable
	 * @returns Objeto DataTable creado
	 */
	function createDataTable(idTable, aoColumnDefs) {
		return $('#' + idTable).dataTable({
//			language : {
//				url : $("#hdnRutaContexto").val() + getUrlLanguage()
//			},
			"aoColumnDefs" : aoColumnDefs,
			"columnDefs" : [ {
				"targets" : 'no-sort',
				"orderable" : false
			} ]
		});
	}

	/**
	 * Obtiene la ruta en la que se encuentra el archivo de configuración del
	 * lenguaje utilizado para el componente de DataTable
	 * 
	 * @returns String con la ruta del archivo con la configuración del lenguaje
	 */
	function getUrlLanguage() {
		return $("#hdnUrlLanguageDataTable").val();
	}

	return {
		addRow : addRow,
		deleteRow : deleteRow,
		deleteRowId : deleteRowId,
		deleteRows : deleteRows,
		exist : exist,
		createDataTableWhitOutInfo : createDataTableWhitOutInfo,
		createDataTable : createDataTable
	};
}();