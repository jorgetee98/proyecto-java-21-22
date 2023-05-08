package fp.police;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.common.Genero;
import fp.utiles.Checkers;

public class Contenedor_USPolice {
	
	private List<USPolice> uspolices;
	
// 	CONSTRUCTOR	
	// CREA UNA LISTA VACIA
	public Contenedor_USPolice() {
		uspolices = new ArrayList<>();
	}
	// CREA LA LISTA CON LA QUE VAMOS A TRABAJAR CON EL CSV
	public Contenedor_USPolice(List<USPolice> uspolicesLst) {
		uspolices = uspolicesLst;
	}
	
	public Contenedor_USPolice(Stream<USPolice> s) {
		uspolices = s.collect(Collectors.toList());
	}
// 	METODOS
//	(Métodos que pide se piden en la entrega 2, dentro del contenedor)
	
	//	OPERACION BÁSICA A
	//	(Obtener el número de elementos)
	public static Integer ObtenerNumElementosUspolice(List<USPolice> lm) {
		return lm.size();
	}
	
	// 	OPERACION BÁSICA B
	//	(Añadir un elemento)
	public  void AddUspolice(USPolice m) {
		uspolices.add(m);
	}
	
	//	OPERACION BÁSICA C
	//	(Añadir una colección de elementos)
	public void AddElementsUspolice(List<USPolice> lm) {
		uspolices.addAll(lm);
	}
	
	//	OPERACION BÁSICA D
	//	 (Eliminar un elemento)
	public void RemoveUspolice(USPolice m) {
		uspolices.remove(m);
	}
	
	// 	TRATAMIENTO SECUENCIAL 1
	//	(realiza un metodo que compruebe si existe el parametro dado en el CSV)
	public Boolean ExistUspolice(USPolice m) {
		return uspolices.contains(m);
	}
	
	//	TRATAMIENTO SECUENCIAL 2
	//	(calcula la media de la edad de todas las personas asesinadas que forman el CSV)
	public Double MediaEdadesUspolice() {
		Double media = 0.0;
		for(USPolice m: uspolices) {
			media = media + m.getEdad();
		}
		return media/uspolices.size();
	}
	
	//	TRATAMIENTO SECUENCIAL 3
	//	(crea una lista filtrada solo con las personas que vivan en el estado dado como parametro)
	public List<USPolice> ElementsFilter(String estado){
		List<USPolice> res = new ArrayList<>();
		for(USPolice m : uspolices) {
			if(m.getEstado().equals(estado)) {
				res.add(m);
			}
		}
		return res;
	}
	
	//	TRATAMIENTO SECUENCIAL 4 
	//	(crea un Map que tiene como clave un estado(String) y tiene como valor un Set que tiene como dentro las edades que viven en esos estados)
	public Map<String,Set<Integer>> EdadesPorEstado(String edtado) {
		Map<String, Set<Integer>> mapa = new HashMap<String,Set<Integer>>();
		for(USPolice m:uspolices) {
			String e = m.getEstado();
			if(mapa.containsKey(e)) {
				mapa.get(e).add(m.getEdad());
			}
			else {
				Set<Integer> conjunto = new HashSet<Integer>();
				conjunto.add(m.getEdad());
				mapa.put(e, conjunto);
			}
		}
		return mapa;
	}
	
	//	TRATAMIENTO SECUENCIAL 5
	//	(crea un Map actua como un contador // Tiene como clave la edad de la persona y como valor el numero de veces que aparece en el CSV esa edad)
	public Map<Integer,Integer> AcumuladorPorEdades(){
		Map<Integer,Integer> mapa = new HashMap<Integer,Integer>();
		for(USPolice m: uspolices) {
			Integer ed = m.getEdad();
			if(mapa.containsKey(ed)) {
				Integer contador = mapa.get(ed);
				contador++;
				mapa.put(ed, contador);
			}
			else {
				mapa.put(ed, 1);
			}
		}
		return mapa;
	}
//	METODOS DE HASCODE, EQUALS Y TOSTRING 
//	(criterio de igualdad y una representación como cadena.)
	public int hashCode() {
		return Objects.hash(uspolices);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenedor_USPolice other = (Contenedor_USPolice) obj;
		return Objects.equals(uspolices, other.uspolices);
	}

	public String toString() {
		return "Contenedor_USPolice [uspolices=" + uspolices + "]";
	}
	
// ## ENTREGA 3 ##
// BLOQUE 1
	
	
	//apartado 6(existe)
	public Boolean ExisteStreamUSPolice (String estado) {
		Long l = this.uspolices.stream()
					  .filter(e -> e.getEstado().equals(estado)).count();
		if (l>0){
			return true;
		}
		else {
			return false;
		}
	}
	
	//apartado 7(contador)
	public Map<Integer,Long> ContadorEdadesUSpolice() {
		return uspolices.stream()
				.collect(Collectors.groupingBy(USPolice::getEdad,
						Collectors.counting()));
	}
	
	//apartado 8
	//seleccion con filtrado (filtra y muestra solo los casos en los que los asesinados tenian la edad dada por parametro)
	public List<USPolice> SeleccionConFiltradoUSpolice(Integer edad){
		List<USPolice> res =  new ArrayList<USPolice>();
		res = this.uspolices.stream()
							.filter(l->l.getEdad().equals(edad)).collect(Collectors.toList());
		return res;
	}
	
	//apartado 9
	//selecciona el tipo USPolice que contenga la edad maxima en él
	public USPolice SeleccionMaximo() {
		return uspolices.stream().max(Comparator.comparing(i->i.getEdad())).get();
	}
	
	//apartado 10
	//seleccion con filtrado y ordenacion (filtra por las edades iguales a las dadas)
	public List<USPolice> SeleccionConFiltradoUSpoliceOrd(Integer edad){
		return uspolices.stream().sorted(Comparator.comparing(USPolice::getNombre))
							.filter(l->l.getEdad().equals(edad)).collect(Collectors.toList());
	
	}
	
// BLOQUE 2
	
	//apartado 11.1 y 12 (metodo 4 de la entrega 2 y usando un mapping)
	//Agrupa las distintas edades que hay en cada estado.
	public Map<String,Set<Integer>> EdadesPorEstadoStream() {
		return uspolices.stream()
    			.collect(Collectors.groupingBy(USPolice::getEstado, 
    					Collectors.mapping(USPolice::getEdad, Collectors.toSet())));
	}
	//apartado 11.2 (metodo 5 de la entrega 2)
	//Acumula a modo de contador las veces que se repiten las edades en el CSV
	public Map<Integer, Long> AcumuladorPorEdadesStreams() { 
        return uspolices.stream()
        		.collect(Collectors.groupingBy(USPolice::getEdad, Collectors.counting()));
	}
	
	//apartado 13
	//Devuelve el tipo base que tenga mayor edad de cada estado.
	public Map<String, USPolice> ObtenerMayorEdadPorEstado(){
		Map<String, List<USPolice>> aux = uspolices.stream().collect(Collectors.groupingBy(USPolice::getEstado));
		return aux.entrySet().stream()
				.collect(Collectors.toMap(v -> v.getKey(), 
						v -> Collections.max(v.getValue(), Comparator.comparing(USPolice::getEdad))));
	}
	
	//apartado 14
	//Devuelve los n asesinates realizados a las personas de menor edad de cada estado
	public SortedMap<String, List<USPolice>> NAsesinatosSegunEstadosDeMenorEdad(Integer n){
		return uspolices.stream().collect(Collectors.groupingBy(i-> i.getEstado(),
						TreeMap::new, Collectors.collectingAndThen(Collectors.toList(), l->Naux(l,n))));
	}
	
	//apartado 15
	//Devulve la clave con el valor mas mayor del map ( la edad mas repetida en este caso )
	public Integer EdadMasRepetida(){
		Map<Integer,Long> res = AcumuladorPorEdadesStreams();
		return res.entrySet().stream().max(Comparator.comparing(i->i.getValue())).get().getKey();
	}
	

	
//FUNCIONES AUXILIARES
	public List<USPolice> Naux(List<USPolice> l , Integer n){
		return l.stream().sorted(Comparator.comparing(i->i.getEdad())).limit(n).collect(Collectors.toList());
	}
}
