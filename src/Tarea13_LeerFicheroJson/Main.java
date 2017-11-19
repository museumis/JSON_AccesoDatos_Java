/**
 * 
 */
package Tarea13_LeerFicheroJson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 */
public class Main {
	/**
	 * 
	 * Método que lee un fichero JSON
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
				Producto o = g.fromJson(r, Producto.class);
				System.out.println(o.toString());
			}
			r.close();
			//Excepciones
		} catch (FileNotFoundException e) {
			System.out.println("Hubo un error.");e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Hubo un error.");//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Hubo un error.");//e.printStackTrace();
		}

	}//Fin de leer fichero json

	/**
	 * Método que incia el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Lectura de Ficheros JSON");
		leerFicheroJSON("src\\Tarea13_LeerFicheroJson\\productos.json");
	}

}
