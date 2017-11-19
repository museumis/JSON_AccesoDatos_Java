/**
 * 
 */
package Tarea13_LeerFicheroJson;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 */
public class Producto {

	//Variables de la clase
	private String referencia;
	private String nombre;
	private String precio;
	private String existencias;

	/**
	 * Constructor de la clase
	 *
	 */
	public Producto() {
		// vacío
	}

	/**
	 * Constructor de la clase
	 *
	 * @param referencia
	 * @param nombre
	 * @param precio
	 * @param existencias
	 */
	public Producto(String referencia, String nombre, String precio, String existencias) {
		this.referencia = referencia;
		this.nombre = nombre;
		this.precio = precio;
		this.existencias = existencias;
	}

	/*
	 * Información de la clase
	 */
	@Override
	public String toString() {
		String cadena = "\n";
		cadena += "Referencia " + this.referencia + "\n";
		cadena += "Producto " + nombre + "\n";
		cadena += "Precio " + this.precio + "\n";
		this.existencias += "Existencias " + this.existencias + "\n";
		return cadena;
	}

	//Get and Set
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getExistencias() {
		return existencias;
	}

	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}

}
