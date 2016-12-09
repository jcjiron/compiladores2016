package gdg;

public class Left {

	private String cad;
	private Integer count;
	
	public Left(){
		  cad=null;
		  count=null;
	}
	
	public Left(String cad){
		this.cad=cad;
		count=cad.length();
	}
	
	public String getCad() {
		return cad;
	}

	public void setCad(String cad) {
		this.cad = cad;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
