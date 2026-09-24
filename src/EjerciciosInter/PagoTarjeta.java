package EjerciciosInter;

public class PagoTarjeta implements MetodoPago {
    
    private double saldoDisponible;

    public PagoTarjeta(double saldoDisponible) { 
        this.saldoDisponible = saldoDisponible; 
    }

    @Override
    public boolean realizarPago(double importe) {
        if (importe <= saldoDisponible) {
            saldoDisponible -= importe;
            System.out.println("Pago con Tarjeta completado: " + importe + "€");
            return true;
        }
        System.out.println("Pago con Tarjeta rechazado: Saldo insuficiente.");
        return false;
    }

    @Override
    public String obtenerDescripcion() { 
        return "Pago mediante Tarjeta de Crédito/Débito"; 
    }

}
