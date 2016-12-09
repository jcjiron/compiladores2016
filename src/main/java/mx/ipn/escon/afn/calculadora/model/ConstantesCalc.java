package mx.ipn.escon.afn.calculadora.model;

public abstract interface ConstantesCalc {
	Character SUMA='+';
	Character RESTA='-';
	Character MULTIPLICACION='*';
	Character DIVISION='/';
	Character PARENTESIS_IZQ='(';
	Character PARENTESIS_DER=')';
	Character POTENCIA='^';
	Character FIN='$';
	
	
	int TOKEN_SUMA=10;
	int TOKEN_RESTA=20;
	int TOKEN_MULTIPLICACION=30;
	int TOKEN_DIVISION=40;
	int TOKEN_PARENTESIS_IZQ=50;
	int TOKEN_PARENTESIS_DER=60;
	int TOKEN_POTENCIA=70;
	int TOKEN_NUM=80;
	int TOKEN_FIN=1024;
	
}
