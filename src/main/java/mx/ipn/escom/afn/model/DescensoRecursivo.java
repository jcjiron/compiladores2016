package mx.ipn.escom.afn.model;

public class DescensoRecursivo implements ConstantesAFN{
	
	private String expr;

	private LexicoAFN lexic;
	
	public DescensoRecursivo(String expr){
		this.expr=expr;
		lexic=new LexicoAFN(expr);	
	}
	
	public boolean sintack(AFN f){
		if(E(f))
			if(lexic.getToken()==TOKEN_FIN)
				return true;
		return false;
	}
	
	public boolean E(AFN f){
		if(T(f))
			if(Ep(f))
				return true;
		return false;
	}
	
	public boolean Ep(AFN f){
		AFN f2=new AFN();
		int tok;
		tok=lexic.getToken();
		if(tok==TOKEN_OR){
			if(T(f2)){
				f.union(f2);
				if(Ep(f));
				return true;
			}
			return false;
		}
		lexic.regresarToken();//epsilon
		return true;
	}
	
	public boolean T(AFN f){
		if(c(f))
			if(Tp(f))
				return true;
		return false;
	}
	
	public boolean Tp(AFN f){
		AFN f2=new AFN();
		int tok;
		tok=lexic.getToken();
		if(tok==TOKEN_CONCATENACION){
			if(c(f2)){
				f.concatenacion(f2);
				if(Tp(f))
					return true;
			}
			return false;
		}
		lexic.regresarToken();
		return true;
	}
	
	public boolean c(AFN f){
		if(f(f))
			if(cp(f))
				return true;
		return false;
	}
	
	public boolean cp(AFN f){
		int tok=lexic.getToken();
		switch(tok){
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
	
	public boolean f(AFN f){
		int tok=lexic.getToken();
		switch(tok){
		case TOKEN_IZQUIERDO:
			if(E(f)){
				tok=lexic.getToken();
				if(tok==LexicoAFN.TOKEN_DERECHO);
				return true;
			}
			return false;
		case TOKEN_SIMBOLO:
			//problemas
			f.crearBasico(lexic.getLexema());
			return true;
		}
		return false;
	}
	
	
}
