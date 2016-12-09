package gdg;

public class Production {

	private Right right;
	private Left left;
	
	public Production(){
		right=null;
		left=null;
	}
	
	public Production(Right r,Left l){
		right=r;
		left=l;
	}
	
	public Production(String cadLeft,String[] cadRight){
		right=new Right(cadRight);
		left=new Left(cadLeft);
	}
	
	
	
	//=======================================================
	//=======================================================
	public Right getRight() {
		return right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	public Left getLeft() {
		return left;
	}

	public void setLeft(Left left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String cad=getLeft().getCad()+"->";
		for(int i=0;i<getRight().getCad().length;i++){
			cad+=getRight().getCad()[i];
		}
		return cad;
	}
	
	private boolean contains(String l) {
		if(left.getCad().equals(l)){
			return true;
		}else{
			for(String cad:right.getCad()){
				if(cad.equals(l)){
					return true;
				}
			}
		}
		return false;
	}
}
