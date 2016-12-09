package ll1;

public class MainClass {

	public static void main(String[] args) {
		String vt="num,+,-,*,/,(,),e";
		String vnt="E,T,Ep,Tp,F";
		
		String reglas="E->T,Ep;"
				+ "Ep->+,T,Ep@-,T,Ep@e;"
				+ "T->F,Tp;"
				+ "Tp->*,F,Tp@/,F,Tp@e;"
				+ "F->(,E,)@num";
		
		String produccionPrueba="A->XYZ";
		
		LL1 ll1=new LL1( vt,  vnt, reglas);
		ll1.imprimirTablaLL1();
		
		String cadena="28+5*(16-9)";
		ll1.validarCadena(cadena);

	

	}

}
