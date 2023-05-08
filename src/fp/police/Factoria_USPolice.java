package fp.police;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import fp.utiles.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import fp.common.Genero;

public class Factoria_USPolice {
	public static List<USPolice> leerUSPolices(String ruta){
		//Método que realiza la lectura del CSV y elimina el encabezado para evitar problemas de parseo.
		List<USPolice> res = new ArrayList<USPolice>();
		try {
			//Leemos el CSV
			List<String> muertes = Files.readAllLines(Paths.get(ruta));
			//Eliminamos la primera linea(encabezado)
			muertes.remove(0);
			for(String muerte:muertes) {
				//Bucle para parsear los datos que vienen dados en cada linea del CSV separados por comas
				USPolice m = parsearUspolices(muerte);
				res.add(m);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static USPolice parsearUspolices (String linea) {
		//Método donde parsea cada línea que lee del CSV y separa cada parte troceada en su dato correspondiente.
		USPolice res;
		String slice[] = linea.split(",");
		String nombre = slice[0].trim();
		LocalDate fecha = LocalDate.parse(slice[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yy"));
		String forma = slice[2].trim();
		String armado = slice[3].trim();
		Integer edad = Integer.parseInt(slice[4].trim());
		Genero genero = Genero.valueOf(slice[5].trim().toUpperCase());
		String estado = slice[6].trim();
		Boolean enfermedad_mental = Boolean.parseBoolean(slice[7].trim().toLowerCase());
		Double rango_de_pobreza = Double.parseDouble(slice[8].trim());
		
		//Creamos un nuevo tipo USPolice con los datos parseados
		res = new USPolice(nombre, fecha, forma, armado, edad, genero, estado, enfermedad_mental, rango_de_pobreza);
		return res;
		
	}

}
