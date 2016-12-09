package mx.ipn.escon.afn.calculadora.model;

public class MiFloat {
	private float f;
	


	public MiFloat(float f){
		this.f=f;
	}
	
	public MiFloat(){
		
	}
	
	public MiFloat(String s){
		this.f=Float.parseFloat(s);
	}
	
	public void resta(MiFloat f2){
		f=(f-f2.getF());
	}
	
	public void division(MiFloat f2){
		f=(f/f2.getF());
	}
	
	public void suma(MiFloat f2){
		f=(f+f2.getF());
	}
	
	public void multiplicacion(MiFloat f2){
		f=(f*f2.getF());
	}
	
	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}
	
	public void setF(String f) {
		this.f = Float.parseFloat(f);
	}
	
}
