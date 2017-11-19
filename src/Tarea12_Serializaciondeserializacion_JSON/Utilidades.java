/**
 * 
 */
package Tarea12_Serializaciondeserializacion_JSON;

import java.util.Scanner;

/**
 * @author Ismael Martín Ramírez
 *
 * https://museumis.github.io/Si/
 *
 */
public class Utilidades {
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
