package mx.ipn.escom.afn.model;

public interface ConstantesAFN {
	public static Character CONCATENACION='&';
	public static Character OR='|';
	public static Character CERRADURA_KLEENE='*';
	public static Character CERRADURA_POSITIVA='+';
	public static Character OPCIONAL='?';
	public static Character PARENTESIS_DERECHO=')';
	public static Character PARENTESIS_IZQUIERDO='(';
	public static Character FIN='$';
	
	public  final int TOKEN_CONCATENACION=5;
	public  final int TOKEN_OR=10;
	public  final int TOKEN_KLEENE=20;
	public  final int TOKEN_POSITIVO=30;
	public  final int TOKEN_OPCIONAL=40;
	public  final int TOKEN_DERECHO=50;
	public  final int TOKEN_IZQUIERDO=60;
	public  final int TOKEN_SIMBOLO=70;
	public  final int TOKEN_FIN=1024;
}
