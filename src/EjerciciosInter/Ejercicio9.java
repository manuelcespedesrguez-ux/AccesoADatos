package EjerciciosInter;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
    
    public static void main(String[] args) {
        List<Gestionable> elementos = new ArrayList<>();
        elementos.add(new Producto("P01", "Portátil"));
        elementos.add(new Cliente("C01", "cliente@empresa.com"));

        // Activar todos mediante polimorfismo
        for (Gestionable g : elementos) {
            g.activar();
            System.out.println(g);
        }
    }

}
