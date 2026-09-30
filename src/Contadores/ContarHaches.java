package Contadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarHaches {

    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Manuel\\Desktop\\Visual\\AccesoAdatos\\src\\datos.txt";

        int totalHachesIntercaladas = 0;
        int totalPalabrasConHache = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                // Dividimos la línea en palabras
                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase();

                    boolean tieneHacheIntercaladaEnPalabra = false;

                    for (int i = 1; i < palabra.length(); i++) {
                        char actual = palabra.charAt(i);
                        char anterior = palabra.charAt(i - 1);

                        if (actual == 'h' && anterior != 'c') {
                            totalHachesIntercaladas++;
                            tieneHacheIntercaladaEnPalabra = true;
                        }
                    }
                    if (tieneHacheIntercaladaEnPalabra) {
                        totalPalabrasConHache++;
                    }
                }
            }

            System.out.println("Total de haches intercaladas: " + totalHachesIntercaladas);
            System.out.println("Total de palabras con hache intercalada: " + totalPalabrasConHache);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
