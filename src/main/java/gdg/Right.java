package gdg;

public class Right {
	private String[] cad;
	private Integer count;
	
	public Right(){
	  cad=null;
	  count=null;
	}
	
	public Right(String[] cad){
		this.cad=cad;
		count=cad.length;
	}
	
	public String[] getCad() {
		return cad;
	}

	public void setCad(String[] cad) {
		this.cad = cad;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		String s="";
		for(String c:cad){
			s+=c;
		}
		return s;
	}
}
