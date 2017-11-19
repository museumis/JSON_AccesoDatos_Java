/**
 * 
 */
package Tarea14_EscrituraFicheroJSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.stream.JsonWriter;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 */
public class Main {

	/**
	 * 
	 * Método que escribe ficheros en formato JSON
	 * @param urlJson
	 * @param libros
	 */
	public static void escribirFicheroJSON(String urlJson, ArrayList<Libro> libros) {
		//Preparativos
		JsonWriter w;
		try {
			w = new JsonWriter(new FileWriter(urlJson));
			Iterator<Libro> x = libros.iterator();
			//Lectura
			// Array Onjetos
			w.beginArray();
			while (x.hasNext()) {
				//Objeto
				w.beginObject();
				Libro libro = x.next();
				//Atributos
				w.name("isbn").value(libro.getIsbn());
				w.name("titulo").value(libro.getTitulo());
				w.name("editorial").value(libro.getEditorial());
				w.name("autores");
				//atributo que es una lista
				w.beginArray();
				ArrayList<String> listaAutores = libro.getAutores();
				for (int i = 0; i < listaAutores.size(); i++) {
					w.value(listaAutores.get(i));
				}
				//fin de la lista
				w.endArray();
				//Fin de objeto
				w.endObject();
			}
			//Fin de Array objetos
			w.endArray();
			w.close();
		} catch (IOException e) {
			System.out.println("Hubo un error.");//e.printStackTrace();
		}

		System.out.println("Fichero JSON creado con éxito.");
	}//Fin de escribir Json

	public static void gestionPrograma() {
		System.out.println("Lectura de XML y creacion de fichero JSON");
		String urlXML = "src\\Tarea14_EscrituraFicheroJSON\\libros.xml";
		String urlJson = "src\\Tarea14_EscrituraFicheroJSON\\libros.json";
		ArrayList<Libro> listado = new ArrayList<>();

		//Obtener listado de libros del fichero XML
		System.out.println("-Lectura del fichero XML-");
		listado = Utilidades.leerXML_Stax(urlXML);
		//Escribir Json con el listado anterior
		System.out.println("\n-Escritura del fichero JSON-\n");

		escribirFicheroJSON(urlJson, listado);
	}

	/**
	 * Método que
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		gestionPrograma();
	}

}
