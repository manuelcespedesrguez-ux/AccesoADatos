package Contadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContarPalabras {

    public static void main(String[] args) {
        // COn esto se asocia File al fichero de texto, le puse una ruta absoluta porque
        // si no no me fucaba
        File archivo = new File("C:\\Users\\Manuel\\Desktop\\Visual\\AccesoAdatos\\src\\datos.txt");
        int totalPalabras = 0;

        // Se comprieba si el fichero existe antes de leerlo
        if (archivo.exists()) {
            try {
                Scanner lectura = new Scanner(archivo);

                // Recorremos el archivo
                while (lectura.hasNext()) {
                    lectura.next(); // Lee la siguiente palabra
                    totalPalabras++;
                }

                lectura.close();
                System.out.println("El número total de palabras es: " + totalPalabras);

            } catch (FileNotFoundException e) {
                System.out.println("Error: No se ha encontrado el archivo.");
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }

}
