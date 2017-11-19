/**
 * 
 */
package Tarea12_Serializaciondeserializacion_JSON;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 * Clase pirncipal
 */
public class Main {

	/**
	 * 
	 * Método que serializa objetos libro a Json
	 */
	public static void serializarJSONaObjeto() {

		//Creación de la lista de libros
		ArrayList<Libro> biblioteca = new ArrayList<>();
		biblioteca.add(new Libro("Gestión de BD", "Iván López Montalbán"));
		biblioteca.add(new Libro("Acceso a datos", "Ivana Pez Talbán"));
		biblioteca.add(new Libro("Data", "Ivanca Ezi Bámban"));

		//Preparación
		Gson gp = new GsonBuilder().setPrettyPrinting().create();
		//Creación del JSON
		System.out.println(gp.toJson(biblioteca));

	}//fin de serializar Json

	/**
	 * 
	 * Método que deserializa Objetos a JON
	 */
	public static void deserializarObjetoAJSON() {
	String json ="[\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Gestión de BD\",\r\n" + 
			"    \"autor\": \"Iván López Montalbán\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Acceso a datos\",\r\n" + 
			"    \"autor\": \"Ivana Pez Talbán\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Data\",\r\n" + 
			"    \"autor\": \"Ivanca Ezi Bámban\"\r\n" + 
			"  }\r\n" + 
			"]"; 
	
	//Preparacion
	Gson gs = new Gson();
	Type tipoListado = new TypeToken<List<Libro>>(){}.getType();
	
	ArrayList<Libro> biblioteca = gs.fromJson(json,tipoListado);
	Iterator <Libro> i = biblioteca.iterator();
	while(i.hasNext()) {
		System.out.println(i.next().toString());
	}
	
	System.out.println("");
	
	}//finde deserializar

	public static void gestionPrograma() {
		String[] opciones = { " - Menu Principal -", " 1.Serializar fichero JSon a libros",
				" 2.Deserializar objetos libros a JSon.", " 3.Salir." };
		switch (Utilidades.generarMenu(opciones)) {
		case 1: {
			serializarJSONaObjeto();
			gestionPrograma();
			break;
		}
		case 2: {
			deserializarObjetoAJSON();
			gestionPrograma();
			break;
		}
		case 3: {
			System.out.println("¡Saludos!");
			break;
		}

		default:
			break;
		}
	}

	/**
	 * Método que controla el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		gestionPrograma();
	}

}
