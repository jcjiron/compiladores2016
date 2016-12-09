package mx.ipn.escon.afn.calculadora.model;

public class SintacticoCalculadora implements ConstantesCalc{
	public static final String FLAG_E="FLAG_E";
	public static final String FLAG_EP="FLAG_Ep";
	public static final String FLAG_T="FLAG_T";
	public static final String FLAG_TP="FLAG_TP";
	public static final String FLAG_F="FLAG_F";
	public static final String FLAG_SINTAC="FLAG_SINTAC";
	
	private LexicoCalculadora lexic;
	private String expr;
	
	public SintacticoCalculadora(String expr){
		this.expr=expr;
		lexic=new LexicoCalculadora(expr);
		lexic.separarNoTerminales();
	}
	
	public boolean sintac(MiFloat f){
		if(E(f)){
			if(lexic.getToken()==TOKEN_FIN)
				return true;
		}
		return false;
	}
	
	boolean E(MiFloat v){
		if(T(v))
			if(Ep(v))
				return true;
		return false;
	}
	
	boolean T(MiFloat v){
		if(F(v))
			if(Tp(v))
				return true;
		return false;
	}
	
	boolean Tp(MiFloat v){
		int tok;
		MiFloat v2=new MiFloat();
		tok=lexic.getToken();
		switch(tok){
		case TOKEN_MULTIPLICACION:
			if(F(v2)){
				v.multiplicacion(v2);
				if(Tp(v))
					return true;
			}
			return false;
		case TOKEN_DIVISION:
			if(F(v2)){
				v.division(v2);
				if(Tp(v))
					return true;
			}
			return false;
		}
		
		lexic.regresarToken();
		return true;
	}
	
	boolean Ep(MiFloat v){
		int tok;
		MiFloat v2=new MiFloat();
		tok=lexic.getToken();
		switch(tok){
		case TOKEN_SUMA:
			if(T(v2)){
				v.suma(v2);
				if(Ep(v))
					return true;
			}
			return false;
		case TOKEN_RESTA:
			if(T(v2)){
				v.resta(v2);
				if(Ep(v))
					return true;
			}
			return false;
			
			default:
				lexic.regresarToken();
				return true;
		}
		
	}
	
	boolean F(MiFloat v){
		int tok;
		tok=lexic.getToken();
		switch(tok){
		case TOKEN_PARENTESIS_IZQ:
			if(E(v)){
				tok=lexic.getToken();
				if(tok==TOKEN_PARENTESIS_DER){
					return true;
				}
			}
			return false;
		case TOKEN_NUM:
			v.setF(lexic.getLexema());
			return true;
		}
		return false;
	}
	
	/*boolean Ep(MiFloat v){
	int tok;
	MiFloat v2=new MiFloat();
	tok=lexic.getToken();
	if(tok==TOKEN_SUMA||tok==TOKEN_RESTA){
		if(T(v2)){
			//v=v+((tok==TOKEN_SUMA)?v2:-v2);
			v=v.suma((tok==TOKEN_SUMA)?v2:v2.multiplicacion(new MiFloat("-1")));
			if(Ep(v))
				return true;
		}
		return false;
	}
	lexic.regresarToken();
	return true;
}*/
	
}
