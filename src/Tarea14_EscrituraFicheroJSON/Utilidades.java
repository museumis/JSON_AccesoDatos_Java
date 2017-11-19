/**
 * 
 */
package Tarea14_EscrituraFicheroJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 */
public class Utilidades {

	// ********************************
	// Manejo XML
	// ********************************

	/**
	 * 
	 * Leer fichero XML mediate STAX
	 * 
	 * @param urlXML
	 * @return listado de libros
	 */
	public static ArrayList<Libro> leerXML_Stax(String urlXML) {
		int event = 0;
		try {
			// preparativos
			ArrayList<Libro> listado = new ArrayList<>();
			Libro libro = null;
			XMLInputFactory f = XMLInputFactory.newInstance();
			XMLStreamReader r = f.createXMLStreamReader(new FileReader(urlXML));

			// Lectura
			while (r.hasNext()) {
				event = r.next();

				if (event == XMLStreamConstants.START_ELEMENT) {
					String nodo = r.getLocalName();
					switch (nodo) {
					case "libro": {
						libro = new Libro();
						libro.setIsbn(r.getAttributeLocalName(0));
						break;
					}
					case "ISBN": {
						libro.setIsbn(r.getElementText());
						break;
					}
					case "titulo": {
						libro.setTitulo(r.getElementText());
						break;
					}

					case "autor": {
						libro.anadirAutores(r.getElementText());
						break;
					}
					case "editorial": {
						libro.setEditorial(r.getElementText());
						break;
					}
					}

				}
				if ((event == XMLStreamConstants.END_ELEMENT) && (r.getLocalName() == "libro")) {
					listado.add(libro);
				}
			} // Fin while

			// Mostrar
			for (int i = 0; i < listado.size(); i++) {
				System.out.println(listado.get(i));
			}
			return listado;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}// Fin de leer xmlStax
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
			System.out.println("Opción incorrecta.");
			generarMenu(opciones);
		}

		if ((respuesta < 1) || (respuesta > opciones.length)) {
			System.out.println("Opción incorrecta.");
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
