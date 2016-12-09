package gdg;

public class Element {

	private Production prod;
	private Integer count;
	
	public Element(){
		prod=null;
		count=null;
	}
	
	public Element(Production p, Integer c){
		prod=p;
		count=c;
	}
	
	
	
	
	//=======================================================
	//=======================================================
	public Production getProd() {
		return prod;
	}

	public void setProd(Production prod) {
		this.prod = prod;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
