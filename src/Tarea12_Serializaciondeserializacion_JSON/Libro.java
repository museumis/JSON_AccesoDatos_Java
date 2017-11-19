package Tarea12_Serializaciondeserializacion_JSON;

import java.io.Serializable;

/**
 * 
 * @author Ismael M
 *
 */
public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4302725085116527753L;
	private String titulo;
	private String autor;

	// Contructor
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	// Constructor completo
	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}
	
	/*
	 * Informacion de la clase
	 */
	@Override
	public String toString() {
		String cadena = "\n-----------\n";
		cadena += "\nTitulo: " + this.titulo;
		cadena += "\nAutor: " + this.autor;

		return cadena;
	}

	//Get and Set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
