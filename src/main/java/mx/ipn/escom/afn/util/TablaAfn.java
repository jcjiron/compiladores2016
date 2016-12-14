package mx.ipn.escom.afn.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TablaAfn {

	
	public String[][] convertir(ArrayList<Integer[]> afd,String alfabeto) throws IOException{
		
		for(int g=0;g<afd.size();g++){
			System.out.println(afd.get(g)[0]+","+afd.get(g)[1]+","+afd.get(g)[2]);
		}
		
		Integer numFil = 0;
		for(int g=0;g<afd.size();g++){
			if(afd.get(g)[0]>afd.get(g)[1]){
				if(numFil<afd.get(g)[0]){
					numFil=afd.get(g)[0];
				}
			}else{
				if(numFil<afd.get(g)[1]){
					numFil=afd.get(g)[1];
				}
			}
		}
		
		System.err.println(numFil);
		Integer numCol=alfabeto.length()+1;
		numFil+=1;
		String[][] tabla = new String[numFil][numCol];
		
		
		tabla[0][0]="/";
		//para llenar la primera columa con los nodos
		for(Integer g=1;g<numFil;g++){
			tabla[g][0]=g.toString();
		}
		//para rellenar las cabeceras del arreglo
		for(Integer g=1;g<numCol;g++){
			tabla[0][g]=""+alfabeto.charAt(g-1);
		}
		
		for(Integer g=1;g<numFil;g++){
			for(Integer f=1;f<numCol;f++){
				 tabla[g][f]="e";
			}
		}
		
		for(Integer g=0;g<numFil;g++){
			String col= new String();
			for(Integer f=0;f<numCol;f++){
				col+= tabla[g][f];
			}
			System.err.println(col);
		}
		
		for(int g=0;g<afd.size();g++){
			tabla[afd.get(g)[0]][afd.get(g)[2]+1]=""+afd.get(g)[1];
		}
		
		 String ruta = "/home/pared/archivoAfn.txt";
	        File archivo = new File(ruta);
	        BufferedWriter bw;
	       
	            bw = new BufferedWriter(new FileWriter(archivo));
	     
	       
	        
		System.err.println("=============");
		for(Integer g=0;g<numFil;g++){
			String col= new String();
			for(Integer f=0;f<numCol;f++){
				col+=" "+ tabla[g][f];
			}
			System.err.println(col);
			bw.write(col+"\n");
		}
		bw.close();
		return tabla;
	}
}
