package EjerciciosInter;

public class PagoEfectivo implements MetodoPago {
 
    private double limiteMaximo;

    public PagoEfectivo(double limiteMaximo) { 
        this.limiteMaximo = limiteMaximo; 
    }

    @Override
    public boolean realizarPago(double importe) {
        if (importe <= limiteMaximo) {
            System.out.println("Pago en Efectivo entregado: " + importe + "€");
            return true;
        }
        System.out.println("Pago en Efectivo rechazado: Supera el límite legal de " + limiteMaximo + "€");
        return false;
    }

    @Override
    public String obtenerDescripcion() { 
        return "Pago presencial en Efectivo"; 
    }
}
