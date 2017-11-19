package Tarea14_EscrituraFicheroJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 
 * Clase para serializacion y deserializacion de ficheros JSON
 * 
 * @author Ismael Mart�n Ram�rez
 * 
 * https://museumis.github.io/Si/
 * 
 * Nota: Para la implementacion de la clase es necesario tener la libreria GSON
 * ->Project/properties/Java Build Path/add External Jar/ (hay un zip en el
 * proyecto)
 * 
 * Nota: Esta clase esta realizada apartir de varios ejemplos,ret�cala a tu
 * gusto.
 * 
 * Nota: Los comentario que inician con *** deber�n ser implementados para
 * utilizar clase.
 * 
 * Nota: Se indicar� como 'Object' los atributos que necesitan de un objeto para
 * ejecutar,cambialo al necesario.
 *
 * Nota: El objeto que implemente esta clase debe tener el m�todo toString()
 * implementado.
 *
 */
public class JsonFull {

	public JsonFull() {
		// TODO
	}

	// ********************************
	//Principales M�todos
	// ********************************

	/**
	 * 
	 * M�todo que escribe ficheros en formato JSON
	 * 
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

		System.out.println("Fichero JSON creado con �xito.");
	}//Fin de escribir Json

	/**
	 * 
	 * M�todo que lee un fichero JSON
	 */
	public static void leerFicheroJSON(String ruta) {
		//Preparativos
		InputStream fis;
		Gson g = new Gson();
		try {
			fis = new FileInputStream(ruta);
			JsonReader r = new JsonReader(new InputStreamReader(fis, "UTF-8"));
			//Lectura
			r.beginArray();
			while (r.hasNext()) {
				//***	Producto o = g.fromJson(r, Producto.class);
				//**	System.out.println(o.toString());
			}
			r.close();
			//Excepciones
		} catch (FileNotFoundException e) {
			System.out.println("Hubo un error.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Hubo un error.");//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hubo un error.");//e.printStackTrace();
		}

	}//Fin de leer fichero json

	/**
	 * 
	 * M�todo que serializa objetos libro a Json
	 */
	public static void serializarJSONaObjeto() {

		//Creaci�n de la lista de libros
		//***	ArrayList<Libro> biblioteca = new ArrayList<>();
		//***	biblioteca.add(new Libro("Gesti�n de BD", "Iv�n L�pez Montalb�n"));
		//***biblioteca.add(new Libro("Acceso a datos", "Ivana Pez Talb�n"));
		//***biblioteca.add(new Libro("Data", "Ivanca Ezi B�mban"));

		//Preparaci�n
		Gson gp = new GsonBuilder().setPrettyPrinting().create();
		//Creaci�n del JSON
		//***	System.out.println(gp.toJson(biblioteca));

	}//fin de serializar Json

	/**
	 * 
	 * M�todo que deserializa Objetos a JON
	 */
	public static void deserializarObjetoAJSON() {
		String json = "[\r\n" + "  {\r\n" + "    \"titulo\": \"Gesti�n de BD\",\r\n"
				+ "    \"autor\": \"Iv�n L�pez Montalb�n\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"titulo\": \"Acceso a datos\",\r\n" + "    \"autor\": \"Ivana Pez Talb�n\"\r\n" + "  },\r\n"
				+ "  {\r\n" + "    \"titulo\": \"Data\",\r\n" + "    \"autor\": \"Ivanca Ezi B�mban\"\r\n" + "  }\r\n"
				+ "]";

		//Preparacion
		Gson gs = new Gson();
		Type tipoListado = new TypeToken<List<Object>>() {
		}.getType();

		ArrayList<Object> biblioteca = gs.fromJson(json, tipoListado);
		Iterator<Object> i = biblioteca.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}

		System.out.println("");

	}//finde deserializar

	// ********************************
	// Utilidades
	// ********************************

	/**
	 * Metodo para generar menus
	 * 
	 * @param opciones
	 * del menu
	 * @return respuesta
	 */
	public static int generarMenu(String[] opciones) {
		Scanner entrada = new Scanner(System.in);
		int respuesta = -1;
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(opciones[i]);

		}
		System.out.print("Opcion: ");
		try {
			respuesta = entrada.nextInt();
		} catch (Exception e) {
			System.out.println("Opci�n incorrecta.");
			generarMenu(opciones);
		}

		if ((respuesta < 1) || (respuesta > opciones.length)) {
			System.out.println("Opci�n incorrecta.");
			generarMenu(opciones);
		}
		return respuesta;

	}// Fin de generar Menu

	/**
	 * Metodo para obtener texto por teclado
	 * 
	 * @param pregunta
	 * @return respuesta
	 */
	public static String pedirTexto(String pregunta) {
		Scanner entrada = new Scanner(System.in);
		System.out.print(pregunta);
		return entrada.nextLine();
	}// Fin de pedir texto
}
