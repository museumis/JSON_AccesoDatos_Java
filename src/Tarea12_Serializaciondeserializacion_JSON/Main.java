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
 * @author Ismael Mart�n Ram�rez
 *
 * https://museumis.github.io/Si/
 *
 * Clase pirncipal
 */
public class Main {

	/**
	 * 
	 * M�todo que serializa objetos libro a Json
	 */
	public static void serializarJSONaObjeto() {

		//Creaci�n de la lista de libros
		ArrayList<Libro> biblioteca = new ArrayList<>();
		biblioteca.add(new Libro("Gesti�n de BD", "Iv�n L�pez Montalb�n"));
		biblioteca.add(new Libro("Acceso a datos", "Ivana Pez Talb�n"));
		biblioteca.add(new Libro("Data", "Ivanca Ezi B�mban"));

		//Preparaci�n
		Gson gp = new GsonBuilder().setPrettyPrinting().create();
		//Creaci�n del JSON
		System.out.println(gp.toJson(biblioteca));

	}//fin de serializar Json

	/**
	 * 
	 * M�todo que deserializa Objetos a JON
	 */
	public static void deserializarObjetoAJSON() {
	String json ="[\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Gesti�n de BD\",\r\n" + 
			"    \"autor\": \"Iv�n L�pez Montalb�n\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Acceso a datos\",\r\n" + 
			"    \"autor\": \"Ivana Pez Talb�n\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"titulo\": \"Data\",\r\n" + 
			"    \"autor\": \"Ivanca Ezi B�mban\"\r\n" + 
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
			System.out.println("�Saludos!");
			break;
		}

		default:
			break;
		}
	}

	/**
	 * M�todo que controla el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		gestionPrograma();
	}

}
