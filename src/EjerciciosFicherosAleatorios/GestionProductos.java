package EjerciciosFicherosAleatorios;

import java.io.RandomAccessFile;

public class GestionProductos {
    
    public static void main(String[] args) {
        
        String[] nombres = {"Manzana", "Plátano", "Yogur", "Arroz", "Bizcocho de naranja"};
        int[] existencias = {50, 80, 150, 99, 50};
        double[] precios = {0.5, 0.6, 0.35, 2.5, 3.25};

        try (RandomAccessFile rafita = new RandomAccessFile("productos.dat", "rw")) {

            rafita.setLength(0);

            for(int i = 0; i < nombres.length; i++) {
                int id = i + 1;
                
                Producto pepito = new Producto(id, nombres[i], existencias[i], precios[i]);
                
                rafita.writeInt(pepito.getIdentificador());
                rafita.writeChars(pepito.getNombre());
                rafita.writeInt(pepito.getExistencias());
                rafita.writeDouble(pepito.getPrecio());
            }

            System.out.println("El fichero se ha creado correctamente y se han guardado los 5 productos");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }

}
