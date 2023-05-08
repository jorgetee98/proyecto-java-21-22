package fp.police.test;

import java.util.List;

import fp.police.Factoria_USPolice;
import fp.police.USPolice;

public class Factoria_Test {
		// TEST: PRUEBA DE LOS M�TODOS CREADOS EN <Factoria_USPolice> PARA VER SI LEE BIEN EL CSV.
	
			// Funci�n que lee el CSV y dice cuantos registros contiene
		public static void main(String[] args) {
		List<USPolice> usp = Factoria_USPolice.leerUSPolices("./data/PoliceKillingsUS_bueno.csv");
		System.out.println("Asesinatos por policias en E.E.U.U. le�dos:"+ usp.size());
		
			// Funci�n que muestra por pantalla el primer registro que lee
		for(USPolice m: usp) {
			System.out.println(m);
			break;
		}

	}

}
