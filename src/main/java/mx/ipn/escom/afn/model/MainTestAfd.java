package mx.ipn.escom.afn.model;

import java.io.IOException;
import java.util.ArrayList;

import mx.ipn.escom.afn.util.TablaAfn;

public class MainTestAfd {

	public static void main(String[] args) {
		AFN f1=new AFN('b');
		AFN f2=new AFN('b');
		AFN f3=new AFN('a');
		AFN f4=new AFN('a');

		f1.cerraduraKleene();
		f1.concatenacion(f3);
		f1.union(f2);
		f1.concatenacion(f4);
		
		ArrayList<Integer[]>afd= f1.convertToAfd(f1, "ab");
		
		for(int g=0;g<afd.size();g++){
			System.out.println(afd.get(g)[0]+","+afd.get(g)[1]+","+afd.get(g)[2]);
		}
		
		TablaAfn tabla = new TablaAfn();
		try {
			tabla.convertir(afd,"ab");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
