package EjerciciosInter;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        List<MetodoPago> pasarelaPago = new ArrayList<>();
        pasarelaPago.add(new PagoTarjeta(100.0));
        pasarelaPago.add(new PagoPaypal("usuario@gmail.com", false));
        pasarelaPago.add(new PagoEfectivo(1000.0));

        double importeTransaccion = 200.0;

        System.out.println("--- Procesando cobros de " + importeTransaccion + "€ ---");
        for (MetodoPago metodo : pasarelaPago) {
            System.out.println("\nMétodo: " + metodo.obtenerDescripcion());
            boolean exito = metodo.realizarPago(importeTransaccion);
            System.out.println("Resultado: " + (exito ? "ACEPTADO" : "RECHAZADO"));
        }
    }

}
