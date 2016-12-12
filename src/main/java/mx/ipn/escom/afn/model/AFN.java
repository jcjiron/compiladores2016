/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.afn.model;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author juancarlos
 */
public class AFN {

	@Override
	public String toString() {
		return "AFN [name=" + name + "]";
	}

	public static char EPSILON = 'e';

	private String name;
	private int idLexema;
	private Estado EdoInicial = null;
	private Estado EdoAceptacion = null;
	private Integer id;

	private ArrayList<Estado> recorrido;

	public HashMap<Estado, Integer> colleccionEstadosAceptacion = null;
	private ArrayList<Estado> estadosAceptacion;
	private ArrayList<String> lexema;
	private ArrayList<Integer> token;
	private String simboloGramatica;

	public AFN(char car) {

		Estado aux = new Estado(getNewId());
		Estado aux1 = new Estado(getNewId());

		aux.addTransicion(car, aux1);
		EdoAceptacion = aux1;
		EdoInicial = aux;

		colleccionEstadosAceptacion = new HashMap();

	}

	public AFN() {
		colleccionEstadosAceptacion = new HashMap();
	}

	public void crearBasico(char sim) {
		Estado aux = new Estado(getNewId());
		Estado aux1 = new Estado(getNewId());
		aux.addTransicion(sim, aux1);
		EdoAceptacion = aux1;
		EdoInicial = aux;
	}

	public void addCadenaVacia() {
		Estado e = new Estado(getNewId());
		Estado aux = EdoAceptacion;
		aux.addTransicion(EPSILON, e);
		EdoAceptacion = e;
	}

	public void moverA(char car, Estado e) {
		Estado aux = EdoAceptacion;
		aux.addTransicion(car, e);
		EdoAceptacion = e;
	}

	// esta funcion tiene un error
	public void concatenacion(AFN f) {
		Estado aux = EdoAceptacion;// 2
		Estado estadoAux1 = f.EdoInicial;// 3
		aux.setTrans(estadoAux1.getTrans());
		EdoAceptacion = f.EdoAceptacion;// 4
	}

	public void union(AFN f) {
		/* Agregando el nuevo estado inicial y sus transiciones */
		Estado auxIni = EdoInicial;
		Estado auxIni2 = f.getEdoInicial();

		Estado auxInicio = new Estado(getNewId());
		Estado auxFinal = new Estado(getNewId());

		auxInicio.addTransicion(EPSILON, auxIni);
		auxInicio.addTransicion(EPSILON, auxIni2);
		EdoInicial = auxInicio;
		/* Agregando las transiciones al nuevo estado final */

		Estado auxFin = EdoAceptacion;
		Estado auxFin2 = f.getEdoAceptacion();

		auxFin.addTransicion(EPSILON, auxFinal);
		auxFin2.addTransicion(EPSILON, auxFinal);
		EdoAceptacion = auxFinal;
	}

	public void cerraduraKleene() {
		Estado auxIni = EdoInicial;
		Estado auxAceptacion = EdoAceptacion;

		Estado inicio = new Estado(getNewId());
		Estado fin = new Estado(getNewId());

		auxAceptacion.addTransicion(EPSILON, auxIni);
		auxAceptacion.addTransicion(EPSILON, fin);

		inicio.addTransicion(EPSILON, auxIni);
		inicio.addTransicion(EPSILON, fin);

		EdoInicial = inicio;
		EdoAceptacion = fin;
	}

	public void cerraduraPositiva() {
		Estado auxIni = EdoInicial;
		Estado auxAceptacion = EdoAceptacion;

		Estado inicio = new Estado(getNewId());
		Estado fin = new Estado(getNewId());

		inicio.addTransicion(EPSILON, auxIni);
		auxAceptacion.addTransicion(EPSILON, fin);
		auxAceptacion.addTransicion(EPSILON, auxIni);

		EdoInicial = inicio;
		EdoAceptacion = fin;
	}

	public void opcional() {
		Estado auxIni = EdoInicial;
		Estado auxAceptacion = EdoAceptacion;

		Estado inicio = new Estado(getNewId());
		Estado fin = new Estado(getNewId());

		inicio.addTransicion(EPSILON, auxIni);
		auxAceptacion.addTransicion(EPSILON, fin);
		inicio.addTransicion(EPSILON, fin);

		EdoInicial = inicio;
		EdoAceptacion = fin;
	}

	public String getNewId() {
		return java.util.UUID.randomUUID().toString();
	}

	public Estado getEdoInicial() {
		return EdoInicial;
	}

	public Estado getEdoAceptacion() {
		return EdoAceptacion;
	}

	public void setEdoInicial(Estado EdoInicial) {
		this.EdoInicial = EdoInicial;
	}

	public void setEdoAceptacion(Estado EdoAceptacion) {
		this.EdoAceptacion = EdoAceptacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLexema() {
		return idLexema;
	}

	public void setIdLexema(Integer idLexema) {
		this.idLexema = idLexema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Estado> cerraduraEpsilon(Estado e) {
		ArrayList<Estado> R = new ArrayList();
		ArrayList<Estado> S = new ArrayList();
		Estado aux;

		S.add(e);
		while (!S.isEmpty()) {
			aux = S.remove((S.size() - 1));
			R.add(aux);
			for (Transicion t : aux.getTrans()) {
				if (t.getSimbolo() == EPSILON) {
					if (!R.contains(t.getDestino())) {
						S.add(t.getDestino());
					}
				}
			}
		}

		return R;
	}

	public ArrayList<Estado> cerraduraEpsilon(ArrayList<Estado> C) {
		ArrayList<Estado> R = new ArrayList();
		ArrayList<Estado> auxList;
		for (Estado e : C) {
			auxList = cerraduraEpsilon(e);
			for (Estado edo : auxList) {
				if (!R.contains(edo)) {
					R.add(edo);
				}
			}
		}
		return R;
	}

	public ArrayList<Estado> mover(Estado e, char simbolo) {
		ArrayList<Estado> R = new ArrayList();
		ArrayList<Estado> S = new ArrayList();
		Estado aux;

		S.add(e);
		while (!S.isEmpty()) {
			aux = S.remove((S.size() - 1));
			for (Transicion t : aux.getTrans()) {
				if (t.getSimbolo() == simbolo) {
					if (!R.contains(t.getDestino())) {
						S.add(t.getDestino());
						R.add(t.getDestino());
					}
				}
			}
		}
		return R;
	}

	public ArrayList<Estado> mover(ArrayList<Estado> C, char simbolo) {
		ArrayList<Estado> R = new ArrayList();
		ArrayList<Estado> auxList;
		for (Estado e : C) {
			auxList = mover(e, simbolo);
			for (Estado edo : auxList) {
				if (!R.contains(edo)) {
					R.add(edo);
				}
			}
		}
		return R;
	}

	public ArrayList<Estado> irA(ArrayList<Estado> C, char simbolo) {
		ArrayList<Estado> R;

		R = cerraduraEpsilon(mover(C, simbolo));
		return R;
	}

	public void unionEspecial(AFN f1) {

		Estado iniAux = new Estado(getNewId());

		iniAux.addTransicion(EPSILON, f1.EdoInicial);
		iniAux.addTransicion(EPSILON, EdoInicial);
		EdoInicial = iniAux;

		// agrega el estado de aceptacion del automata padre
		if (!colleccionEstadosAceptacion.containsKey(EdoAceptacion)) {
			colleccionEstadosAceptacion.put(EdoAceptacion, idLexema);

		}
		// agrega el estado de aceptacion del automata que se unio
		if (!colleccionEstadosAceptacion.containsKey(f1.EdoAceptacion)) {
			colleccionEstadosAceptacion.put(f1.EdoAceptacion, f1.idLexema);
		}
	}

	public boolean validarCadena(String cadena) {
		String auxCad = "";
		estadosAceptacion = new ArrayList<Estado>();
		lexema = new ArrayList<String>();
		token = new ArrayList<Integer>();

		ArrayList<Estado> C = cerraduraEpsilon(EdoInicial);
		for (int i = 0; i < cadena.length(); i++) {
			C = irA(C, cadena.charAt(i));
			if (C.isEmpty()) {
				return false;
			} else {
				auxCad += cadena.charAt(i);
				// System.out.println(i);
				for (Estado e : C) {
					if (colleccionEstadosAceptacion.containsKey(e)) {
						estadosAceptacion.add(e);
						lexema.add(auxCad);
						token.add(colleccionEstadosAceptacion.get(e));

						auxCad = "";
						C = cerraduraEpsilon(EdoInicial);

						if (i == cadena.length() - 1) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}



	public void convertirAAfd(AFN afn, ArrayList<String> alfabeto) {
		ArrayList<ColeccionEstados> c = new ArrayList<>();
		ArrayList<ColeccionEstados> q = new ArrayList<>();
		int i = 0;
		ArrayList<ArrayList<ArrayList<Estado>>> afd = new ArrayList<ArrayList<ArrayList<Estado>>>(alfabeto.size());
		ColeccionEstados estado = new ColeccionEstados();
		estado.setI(cerraduraEpsilon(afn.EdoInicial));
		estado.setId(i);
		c.add(estado);
		q.add(estado);

		for (ColeccionEstados arrayList : c) {
			for (Estado array : arrayList.getI()) {
				System.err.println(array.getId());
			}
			System.err.println("\n");
		}

		do {
			ColeccionEstados estadoAux = new ColeccionEstados();
			System.err.println(q.get(q.size() - 1));
			estadoAux = q.remove(q.size() - 1);
			for (String alfa : alfabeto) {
				ColeccionEstados x = new ColeccionEstados();
				x.setI(afn.irA(estadoAux.getI(), alfa.charAt(0)));
				if (c.contains(x)) {
					afd.get(estadoAux.getId()).add(alfabeto.indexOf(alfa), x.getI());
				} else {
					x.setId(++i);
					c.add(x);
					q.add(x);
				}
			}
		} while (!q.isEmpty());

	}

	public ArrayList<Estado> getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(ArrayList<Estado> recorrido) {
		this.recorrido = recorrido;
	}

	public ArrayList<Estado> getEstadosAceptacion() {
		return estadosAceptacion;
	}

	public void setEstadosAceptacion(ArrayList<Estado> estadosAceptacion) {
		this.estadosAceptacion = estadosAceptacion;
	}

	public ArrayList<String> getLexema() {
		return lexema;
	}

	public void setLexema(ArrayList<String> lexema) {
		this.lexema = lexema;
	}

	public ArrayList<Integer> getToken() {
		return token;
	}

	public void setToken(ArrayList<Integer> token) {
		this.token = token;
	}
	
	public void setSimboloGramatica(String sim){
		simboloGramatica=sim;
	}
	
	public String getSimboloGramatica(){
		return simboloGramatica;
	}

}
