package fp.police;

import fp.utiles.Checkers;
import java.time.LocalDate;
import java.util.Objects;
import fp.common.Genero;

public class USPolice {
	//Declaramos las propiedades basicas del tipo USPolice.
	private String nombre;
	private LocalDate fecha;
	private String forma;
	private String armado;
	private Integer edad;
	private Genero genero;
	private String estado;
	private Boolean enfermedad_mental;
	private Double rango_de_pobreza;
	
	//Constructor 1 ( usando todas las propiedades )
	public USPolice (String nombre, LocalDate fecha, String forma, String armado, Integer edad,Genero genero, String estado, Boolean enfermedad_mental, Double rango_de_pobreza) {
		Checkers.check("Edad errónea", edad>0);
		Checkers.check("Nombre no válido", !(nombre.charAt(0) >= '0' && nombre.charAt(0) <= '9'));
		this.nombre = nombre;
		this.fecha = fecha;
		this.forma = forma;
		this.armado = armado;
		this.edad = edad;
		this.genero = genero;
		this.estado = estado;
		this.enfermedad_mental = enfermedad_mental;
		this.rango_de_pobreza = rango_de_pobreza;
	}
	
	//Declaramos la propiedad derivada
	public Integer getAñoMuerte() {
		return this.fecha.getYear();
	}

	//Realizacion de los metodos setters(que nos dejan modificar el valor de esas propiedades) y getters(que nons) de todas las propiedades.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Checkers.check("Nombre no válido", !(nombre.charAt(0) >= '0' && nombre.charAt(0) <= '9'));
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getArmado() {
		return armado;
	}

	public void setArmado(String armado) {
		this.armado = armado;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		Checkers.check("Edad errónea", edad>0);
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getEnfermedad_mental() {
		return enfermedad_mental;
	}

	public void setEnfermedad_mental(Boolean enfermedad_mental) {
		this.enfermedad_mental = enfermedad_mental;
	}

	public Double getRango_de_pobreza() {
		return rango_de_pobreza;
	}

	public void setRango_de_pobreza(Double rango_de_pobreza) {
		this.rango_de_pobreza = rango_de_pobreza;
	}
	//Constructor 2
	public USPolice(String forma, String armado, Boolean enfermedad_mental) {
		super();
		this.forma = forma;
		this.armado = armado;
		this.enfermedad_mental = enfermedad_mental;
	}
	//Metedo HashCode (obtenemos el identificador de la propiedad de 32 bits)
	public int hashCode() {
		return Objects.hash(armado, edad, enfermedad_mental, estado, fecha, forma, genero, nombre, rango_de_pobreza);
	}

	//Descripcion del metodo equals (comprueba si el valor de sus propiedades son iguales)
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		USPolice other = (USPolice) obj;
		return Objects.equals(armado, other.armado) && Objects.equals(edad, other.edad)
				&& Objects.equals(enfermedad_mental, other.enfermedad_mental) && Objects.equals(estado, other.estado)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(forma, other.forma) && genero == other.genero
				&& Objects.equals(nombre, other.nombre) && Objects.equals(rango_de_pobreza, other.rango_de_pobreza);
	}
	
	//Metodo toString (muestra por pantalla todas las propiedades, tanto basicas como derivadas
	public String toString() {
		return "USPolice [nombre=" + nombre + ", fecha=" + fecha + ", forma=" + forma + ", armado=" + armado + ", edad="
				+ edad + ", genero=" + genero + ", estado=" + estado + ", enfermedad_mental=" + enfermedad_mental
				+ ", rango_de_pobreza=" + rango_de_pobreza + ", getAñoMuerte()=" + getAñoMuerte() + "]";
	}
	
	//Metedo compareTo (Compara el orden natural de una propiedad, en este caso de la fecha)
	public int compareTo(USPolice p) {
        int r;
        if (p ==null) {
            throw new NullPointerException();
        }
        r = getFecha().compareTo(p.getFecha());
        if (r == 0) {
            r = getEdad().compareTo(p.getEdad());
        }
        return r;
    }
	
	
	
}
	
	
