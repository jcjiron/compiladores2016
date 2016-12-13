package mx.ipn.escom.afn.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SintacticoAFN implements ConstantesAFN {
	private static final String SEPARADOR=",";
	
	private String expr;
	private LexicoAFN lexic;
	private ArrayList<String> expres;
	private AFN[] afns;

	public SintacticoAFN(String expr) {
		this.expr = expr;
		lexic = new LexicoAFN(expr);
	}

	public SintacticoAFN() {

	}

	public boolean cargarArchivo(String ruta) {
		boolean flag=true;
		expres=new ArrayList<String>();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		

		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null){
				System.out.println(linea);
				expres.add(linea);
			}
			afns=new AFN[expres.size()];
			for(int i=0;i<expres.size();i++){
				String[] aux=expres.get(i).split(SEPARADOR);
				expr = aux[0];
				int idLexema=Integer.parseInt(aux[1]);
				String simGra=aux[2];
				
				lexic = new LexicoAFN(expr);
				if(!sintack(afns[i]=new AFN())){
					flag=false;
				}else{
					afns[i].setIdLexema(idLexema);
					afns[i].setSimbGra(simGra);
					afns[i].setExpreRe(expr);
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
	public AFN unionEspecial(){
		for(int i=1;i<afns.length;i++){
			afns[0].unionEspecialAux(afns[i]);
		}
		return afns[0];
	}

	public boolean sintack(AFN f) {
		if (E(f))
			if (lexic.getToken() == TOKEN_FIN)
				return true;
		return false;
	}

	public boolean E(AFN f) {
		if (T(f))
			if (Ep(f))
				return true;
		return false;
	}

	public boolean Ep(AFN f) {
		AFN f2 = new AFN();
		int tok;
		tok = lexic.getToken();
		if (tok == TOKEN_OR) {
			if (T(f2)) {
				f.union(f2);
				if (Ep(f))
					;
				return true;
			}
			return false;
		}
		lexic.regresarToken();// epsilon
		return true;
	}

	public boolean T(AFN f) {
		if (c(f))
			if (Tp(f))
				return true;
		return false;
	}

	public boolean Tp(AFN f) {
		AFN f2 = new AFN();
		int tok;
		tok = lexic.getToken();
		if (tok == TOKEN_CONCATENACION) {
			if (c(f2)) {
				f.concatenacion(f2);
				if (Tp(f))
					return true;
			}
			return false;
		}
		lexic.regresarToken();
		return true;
	}

	public boolean c(AFN f) {
		if (f(f))
			if (cp(f))
				return true;
		return false;
	}

	public boolean cp(AFN f) {
		int tok = lexic.getToken();
		switch (tok) {
		case TOKEN_KLEENE:
			f.cerraduraKleene();
			return cp(f);
		case TOKEN_POSITIVO:
			f.cerraduraPositiva();
			return cp(f);
		case TOKEN_OPCIONAL:
			f.opcional();
			return cp(f);
		default:
			lexic.regresarToken();
			return true;
		}
	}

	public boolean f(AFN f) {
		int tok = lexic.getToken();
		switch (tok) {
		case TOKEN_IZQUIERDO:
			if (E(f)) {
				tok = lexic.getToken();
				if (tok == LexicoAFN.TOKEN_DERECHO)
					;
				return true;
			}
			return false;
		case TOKEN_SIMBOLO:
			// problemas
			f.crearBasico(lexic.getLexema());
			return true;
		}
		return false;
	}

}
