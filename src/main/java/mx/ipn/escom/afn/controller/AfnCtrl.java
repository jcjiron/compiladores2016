package mx.ipn.escom.afn.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.afn.model.AFN;
import mx.ipn.escom.afn.util.NombreObjetosSesion;
import mx.ipn.escom.afn.util.SessionManager;

@Namespace("/thompson")
public class AfnCtrl extends ActionSupport {

	private List<AFN> listAfns;

	private String literal;

	private Integer id = 1;

	private String cadena;

	private AFN afn;

	private Integer idAfn;
	private Integer idAfn2;

	private Boolean isValida;

	private Integer IdLexema;

	private ArrayList<String> Alfabeto;

	public String index() {
		System.err.println("index AFN");
		SessionManager.set("1", NombreObjetosSesion.ACTION);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		Alfabeto = (ArrayList<String>) SessionManager.get(NombreObjetosSesion.LISTALFABETO);
		if (id == 1) {

			SessionManager.set(id, NombreObjetosSesion.ID);
		} else {
			System.err.println("this id  " + id);
			id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		}
		return "index";
	}

	public String newAfn() {
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		return "newAfn";
	}

	public String createNewAfn() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		Alfabeto = (ArrayList<String>) SessionManager.get(NombreObjetosSesion.LISTALFABETO);
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		if (listAfns == null) {
			listAfns = new ArrayList<AFN>();
			Alfabeto = new ArrayList<String>();
		}
		if(!Alfabeto.contains(literal)){
			Alfabeto.add(literal);
		}
		
		afn = new AFN(literal.charAt(0));
		afn.setName("AFN" + id);
		afn.setIdLexema(id);
		listAfns.add(afn);
		id++;
		SessionManager.set(Alfabeto, NombreObjetosSesion.LISTALFABETO);
		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String newUnir() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newUnir";
	}

	public String newConcatenar() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newConcatenar";
	}

	public String newCerraduraPositiva() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newCerraduraPositiva";
	}

	public String newCerraduraklean() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newCerraduraklean";
	}

	public String newOpcional() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newOpcional";
	}

	public String newUnionEspecial() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newUnionEspecial";
	}

	public String newValidarCadena() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newValidarCadena";
	}

	public String newLexema() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newLexema";
	}
	
	public String newAfd() {
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);

		return "newAfd";
	}

	public String unir() {
		System.err.println(idAfn);
		System.err.println(idAfn2);
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);
		AFN afn2 = new AFN();
		afn2 = getAfnUsed(idAfn2);
		afn.union(afn2);
		listAfns.remove(afn2);
		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String concatenar() {
		System.err.println(idAfn);
		System.err.println(idAfn2);
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);
		AFN afn2 = new AFN();
		afn2 = getAfnUsed(idAfn2);
		afn.concatenacion(afn2);
		listAfns.remove(afn2);
		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String cerraduraPositiva() {
		System.err.println(idAfn);

		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);

		afn.cerraduraPositiva();

		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String cerraduraKlean() {
		System.err.println(idAfn);

		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);

		afn.cerraduraKleene();

		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String opcional() {
		System.err.println(idAfn);

		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);

		afn.opcional();

		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String validarCadena() {
		System.err.println(idAfn);

		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		afn = new AFN();
		afn = getAfnUsed(idAfn);
		isValida = afn.validarCadena(cadena);
		
		IdLexema = afn.getIdLexema();

		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return "cadenaValidad";
	}

	public String idLexema() {
		System.err.println(idAfn);

		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		afn = new AFN();
		afn = getAfnUsed(idAfn);
		
		afn.setIdLexema(IdLexema);

		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}

	public String especial() {
		System.err.println(idAfn);
		System.err.println(idAfn2);
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);
		AFN afn2 = new AFN();
		afn2 = getAfnUsed(idAfn2);
		afn.unionEspecial(afn2);
		listAfns.remove(afn2);
		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}
	public String afd() {
		System.err.println(idAfn);
	
		id = (Integer) SessionManager.get(NombreObjetosSesion.ID);
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		Alfabeto = (ArrayList<String>) SessionManager.get(NombreObjetosSesion.LISTALFABETO);
		AFN afn = new AFN();
		afn = getAfnUsed(idAfn);
		
		afn.convertirAAfd(afn, Alfabeto);;
		
		SessionManager.set(listAfns, NombreObjetosSesion.LISTAFN);
		SessionManager.set(id, NombreObjetosSesion.ID);
		return index();
	}
	private AFN getAfnUsed(Integer id) {

		System.err.println("netro");
		listAfns = (List<AFN>) SessionManager.get(NombreObjetosSesion.LISTAFN);
		for (AFN afn : listAfns) {
			if (afn.getIdLexema() == id) {
				System.err.println(afn);
				return afn;
			}
		}
		return null;
	}
	

	public List<AFN> getListAfns() {
		return listAfns;
	}

	public void setListAfns(List<AFN> listAfns) {
		this.listAfns = listAfns;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AFN getAfn() {
		return afn;
	}

	public void setAfn(AFN afn) {
		this.afn = afn;
	}

	public Integer getIdAfn() {
		return idAfn;
	}

	public void setIdAfn(Integer idAfn) {
		this.idAfn = idAfn;
	}

	public Integer getIdAfn2() {
		return idAfn2;
	}

	public void setIdAfn2(Integer idAfn2) {
		this.idAfn2 = idAfn2;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Boolean getIsValida() {
		return isValida;
	}

	public void setIsValida(Boolean isValida) {
		this.isValida = isValida;
	}

	public Integer getIdLexema() {
		return IdLexema;
	}

	public void setIdLexema(Integer idLexema) {
		IdLexema = idLexema;
	}

}
