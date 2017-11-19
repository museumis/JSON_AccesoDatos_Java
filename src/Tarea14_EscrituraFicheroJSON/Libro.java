package Tarea14_EscrituraFicheroJSON;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Ismael M
 *
 */
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4302725085116527753L;
	private String titulo;
	private String isbn;
	private String editorial;
	private ArrayList<String> autores=new ArrayList<>();

	// Contructor
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	// Constructor completo
	public Libro(String titulo, ArrayList<String> autor) {
		this.titulo = titulo;
		this.autores = autor;
	}

	/*
	 * Informacion de la clase
	 */
	@Override
	public String toString() {
		String cadena = "\n-----------\n";
		cadena += "\nIsbn: " + this.isbn;
		cadena += "\nTitulo: " + this.titulo;
		cadena += "\nEditorial: " + this.editorial;
		for (int i = 0; i < this.autores.size(); i++) {
			cadena += "\nAutor: " + this.autores.get(i);
		}

		return cadena;
	}

	public void anadirAutores(String autor) {
		this.autores.add(autor);
	}

	//Get and Set

	public String getTitulo() {
		return titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

}
