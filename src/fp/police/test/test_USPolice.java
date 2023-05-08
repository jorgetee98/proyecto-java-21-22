package fp.police.test;

import java.time.LocalDate;
import fp.common.Genero;
import fp.police.USPolice;

public class test_USPolice {
	public static void main(String[] args) {
		//Asesinatos dados de ejemplo, para comprobar el constructor
		USPolice p1 = new USPolice("Peter",LocalDate.of(2015, 03, 01),"shot","umbrellas",42,Genero.M,"OK",false,32.5);
		USPolice p2 = new USPolice("Patry",LocalDate.of(2015, 03, 05),"shot","knife",31,Genero.F,"LA",true,12.8);
		
		//Comprobamos la funcionalidad del metodo ToString
		System.out.println("METODO TO STRING:");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("");
	    
	    //Comprobamos la funcionalidad del metodo Equals
	    System.out.println("METODO DE IGUALDAD");
	    if(p1.equals(p2)) { 
			System.out.println("El accidente p1 es igual al p2");
		} else {
			System.out.println("El accidente p1 es distinto del p2");
		}
	    if(p2.equals(p2)) { 
			System.out.println("El accidente p2 es igual al p2");
		} else {
			System.out.println("El accidente p2 es distinto del p2");
		}
	    System.out.println("");
	    
	    //Comprobamos la funcionalidad del metodo CompareTo
	    System.out.println("METODO DE COMPARACION NATURAL");
	    int resp = p2.compareTo(p1);
	    if(resp == 0) {
			System.out.println("Los accidentes ocurrieron a la vez");
		} 
		else if(resp > 0) {
			System.out.println("El accidente p2 ocurrio despues del p1");
		}
		else
			System.out.println("El accidente p1 ocurrio despues del p2");
		}
}
