package gdg;

public class MainClass {

	public static void main(String[] args) {
		String terminales="num,+,-,*,/,(,),e";//concatenar e
		String noTerminales="E,T,Ep,Tp,F";
		String reglas="E->T,Ep@e;Ep->+,T,Ep@-,T,Ep@e;T->F,Tp;Tp->*,F,Tp@/,F,Tp@e;F->(,E,)@num";//el separador es @
		
		String produccionPrueba="A->XYZ";
		
		Gramatica g=new Gramatica(reglas,terminales,noTerminales);
		g.imprimirReglas();

	
	}

}
