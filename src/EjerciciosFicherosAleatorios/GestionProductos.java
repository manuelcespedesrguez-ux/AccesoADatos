package EjerciciosFicherosAleatorios;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GestionProductos {

    public static void main(String[] args) {
        String[] nombres = {"Manzana", "Plátano", "Yogur", "Arroz", "Galletas"};
        int[] existencias = {50, 80, 150, 99, 120};
        double[] precios = {0.5, 0.6, 0.35, 2.5, 1.80};

        Scanner sc = new Scanner(System.in);

        try (RandomAccessFile rafita = new RandomAccessFile("productos.dat", "rw")) {

            // PASO 1: Crear e introducir productos
            rafita.setLength(0);
            for (int i = 0; i < nombres.length; i++) {
                int id = i + 1;
                Producto pepito = new Producto(id, nombres[i], existencias[i], precios[i]);

                rafita.writeInt(pepito.getIdentificador());
                rafita.writeChars(pepito.getNombre());
                rafita.writeInt(pepito.getExistencias());
                rafita.writeDouble(pepito.getPrecio());
            }
            System.out.println("Fichero creado con éxito");

            System.out.println("\nVamos a listar los productos guardados");
            rafita.seek(0); 

            while (rafita.getFilePointer() < rafita.length()) {
                int id = rafita.readInt();
                String nombre = leerNombre(rafita);
                int stock = rafita.readInt();
                double precio = rafita.readDouble();

                System.out.println("ID: " + id + "\nNombre: " + nombre + "\nStock: " + stock + "\nPrecio: " + precio + "$");
            }

            System.out.print("Introduce el ID del producto a consultar (1-5): ");
            int idBusqueda = sc.nextInt();

            if (idBusqueda >= 1 && idBusqueda <= 5) {
                long posicion = (idBusqueda - 1) * 40L;
                rafita.seek(posicion);

                int id = rafita.readInt();
                String nombre = leerNombre(rafita);
                int stock = rafita.readInt();
                double precio = rafita.readDouble();

                System.out.println("Encontrado -> ID: " + id + ", Nombre: " + nombre + ", Stock: " + stock + ", Precio: " + precio + "$");
            } else {
                System.out.println("ID fuera de rango.");
            }

            System.out.print("Introduce el ID del producto que deseas modificar sus existencias: ");
            int idExistencias = sc.nextInt();
            System.out.print("Nuevas existencias: ");
            int nuevasExistencias = sc.nextInt();

            if (idExistencias >= 1 && idExistencias <= 5 && nuevasExistencias >= 0) {
                long posExistencias = (idExistencias - 1) * 40L + 28;
                rafita.seek(posExistencias);
                rafita.writeInt(nuevasExistencias);
                System.out.println("Existencias actualizadas correctamente.");
            } else {
                System.out.println("Datos o ID no válidos.");
            }

            System.out.print("Introduce el ID del producto para cambiar su precio: ");
            int idPrecio = sc.nextInt();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();

            if (idPrecio >= 1 && idPrecio <= 5 && nuevoPrecio >= 0) {
                long posPrecio = (idPrecio - 1) * 40L + 32; 
                rafita.seek(posPrecio);
                rafita.writeDouble(nuevoPrecio);
                System.out.println("Precio actualizado correctamente.");
            } else {
                System.out.println("Datos o ID no válidos.");
            }

            System.out.println("\nNuevo listado guardado: ");
            rafita.seek(0);

            while (rafita.getFilePointer() < rafita.length()) {
                int id = rafita.readInt();
                String nombre = leerNombre(rafita);
                int stock = rafita.readInt();
                double precio = rafita.readDouble();

                System.out.println("ID: " + id + "\nNombre: " + nombre + "\nStock: " + stock + "\nPrecio: " + precio + "$");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        sc.close();
    }

    public static String leerNombre(RandomAccessFile raf) throws IOException {
        char[] chars = new char[12];
        for (int i = 0; i < 12; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars).trim();
    }
}