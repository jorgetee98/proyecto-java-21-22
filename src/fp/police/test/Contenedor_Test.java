package fp.police.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import fp.common.Genero;
import fp.police.USPolice;
import fp.police.Factoria_USPolice;
import fp.police.Contenedor_USPolice;

public class Contenedor_Test {
	// PRUEBA DE LOS TRATAMIENTOS SECUENCIALES DEL CONTENEDOR
	private static Contenedor_USPolice uspolices = new Contenedor_USPolice();

	public static void main(String[] args) {
		Test_lectura("./data/PoliceKillingsUS_bueno.csv");
		//Creamos una lista del tipo USPolice llamada "CSV" para almacenar los datos que lee el método <leerUSPolices>
		//List<USPolice> CSV = Factoria_USPolice.leerUSPolices("./data/PoliceKillingsUS_bueno.csv");
		//Contenedor_USPolice con2 = new Contenedor_USPolice(CSV);
		USPolice p1 = new USPolice("Ramon",LocalDate.of(2015, 03, 01),"shot","banana",19,Genero.M,"ES",true,0.2);
		
		System.out.println("Entrega 2:");
		System.out.println("");
		Test_ExistUspolice(p1);//1
		Test_MediaEdadesUspolice();//2
		Test_ElementsFilter("DE");//3
		Test_EdadesPorEstado("WA");//4
		Test_AcumuladorPorEdades();//5
		System.out.println("");
		
		System.out.println("Entrega 3:");
		System.out.println("");
		System.out.println("Bloque 1:");
		Test_ExisteStreamUSPolice("WA");//6
		Test_ContadorEdadesUSPolice ();//7
		Test_SeleccionConFiltradoUSpolice(16);//8
		Test_SeleccionMaximo();//9
		Test_SeleccionConFiltradoUSpoliceOrd(16);//10
		System.out.println("");
		System.out.println("Bloque 2:");
		System.out.println("");
		Test_EdadesPorEstadoStream();//11.1 y 12
		Test_AcumuladorPorEdadesStreams();//11.2
		Test_ObtenerMayorEdadPorEstado();//13
		Test_NAsesinatosSegunEstadosDeMenorEdad(1);//14
		Test_EdadMasRepetida();//15
	}
	//lectura del csv para la realizacion del test
	private static void Test_lectura(String fichero) {
		List<USPolice> lista = Factoria_USPolice.leerUSPolices(fichero);
		uspolices = new Contenedor_USPolice(lista);
	}
	
//TEST ENTREGA 2
	
	private static void Test_ExistUspolice(USPolice p) {
		System.out.println("¿Existe p1?: "+ uspolices.ExistUspolice(p));
	}
	
	//Test del método que nos devuelve la media de las edades de todos los registros
	private static void Test_MediaEdadesUspolice() {
		Double d = uspolices.MediaEdadesUspolice();
		System.out.println("Media de las edades de los asesinados: "+ d);
	}
	
	//Test del método que nos devuelve una lista del tipo USPolice con todos los registros que tengan como estado el que se da por parametro
	private static void Test_ElementsFilter(String estado) {
		List<USPolice> list = uspolices.ElementsFilter(estado);
		System.out.println("Lista de registros que tienen "+ estado + " como estado: "+ list);
	}
	
	//Test del método que nos devuelve un diccionario donde la clave es el estado de EEUU y el valor es un conjunto de todas las edades de las personas que residen en ese estado
	private static void Test_EdadesPorEstado(String estado) {
		Map<String, Set<Integer>> mapa = uspolices.EdadesPorEstado(estado);
		System.out.println("Agrupacion de edades segun el estado: "+ mapa);
	}
	
	//Test del método que devuelve un diccionario(Contador) con las veces que aparece cada edad en el CSV
	private static void Test_AcumuladorPorEdades() {
		Map<Integer,Integer> mapa = uspolices.AcumuladorPorEdades();
		System.out.println("Contador de las veces que aparece cada edad en el CSV: "+ mapa);
	}
	
	//TEST ENTREGA 3
	//Bloque 1
	//6
	private static void Test_ExisteStreamUSPolice(String estado) {
		System.out.println("Existe algun registro que tenga como estado, "+ estado+":"+ uspolices.ExisteStreamUSPolice(estado));
	}
	//7
	private static void Test_ContadorEdadesUSPolice () {
		System.out.println("Contador de edades del csv: "+ uspolices.ContadorEdadesUSpolice());
	}
	//8
	private static void Test_SeleccionConFiltradoUSpolice(Integer edad) {
		System.out.println("Seleccion de los csv que contengan la edad dada : "+ uspolices.SeleccionConFiltradoUSpolice(edad));
	}
	
	//9
	private static void Test_SeleccionMaximo() {
		System.out.println("Seleccion del registro con edad maxima: "+ uspolices.SeleccionMaximo());
	}
	//10
	private static void Test_SeleccionConFiltradoUSpoliceOrd(Integer edad) {
		System.out.println("Seleccion ordenada de los csv que contengan la edad dada:" + uspolices.SeleccionConFiltradoUSpoliceOrd(edad));
	}
	
	//Bloque 2
	
	//11.1 y 12
	//Test del metodo que agrupa las distintas edades que hay en cada estado.
	private static void Test_EdadesPorEstadoStream() {
		Map<String,Set<Integer>> mapa = uspolices.EdadesPorEstadoStream();
		System.out.println("Edades existentes en cada estado: "+ mapa);
	}
	//11.2
	//Test del metodo que acumula a modo de contador las veces que se repiten las edades en el CSV
	private static void Test_AcumuladorPorEdadesStreams() {
		System.out.println("Contador de las veces que aparece cada edad en el CSV: "+ uspolices.AcumuladorPorEdadesStreams());
	}
	//13
	//Test del metodo que devuelve el tipo base que tenga mayor edad de cada estado.
	private static void Test_ObtenerMayorEdadPorEstado() {
		System.out.println("Tipo base de mayor edad en cada estado: "+ uspolices.ObtenerMayorEdadPorEstado());
	}
	//14
	//Test del metodo que devuelve los n asesinates realizados a las personas de menor edad de cada estado
	private static void Test_NAsesinatosSegunEstadosDeMenorEdad(Integer n) {
		System.out.println("N personas asesinadas de menor edad por estado: "+ uspolices.NAsesinatosSegunEstadosDeMenorEdad(n));
	}
	//15
	//Test del metodo que devulve la clave con el valor mas mayor del map ( la edad mas repetida en este caso )
	private static void Test_EdadMasRepetida() {
		System.out.println("Edad mas repetida de todo el dataset: "+ uspolices.EdadMasRepetida());
	}
}


