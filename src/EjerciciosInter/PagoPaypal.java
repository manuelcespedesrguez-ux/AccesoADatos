package EjerciciosInter;

public class PagoPaypal implements MetodoPago {

    public PagoPaypal(String usuariogmailcom, boolean par) {
    }
    
    private String email;
    private boolean usuarioVerificado;

    public void PagoPayPal(String email, boolean usuarioVerificado) {
        this.email = email;
        this.usuarioVerificado = usuarioVerificado;
    }

    @Override
    public boolean realizarPago(double importe) {
        if (usuarioVerificado) {
            System.out.println("Pago con PayPal (" + email + ") procesado: " + importe + "€");
            return true;
        }
        System.out.println("Pago con PayPal rechazado: Cuenta no verificada.");
        return false;
    }

    @Override
    public String obtenerDescripcion() {
        return "Pago mediante PayPal (" + email + ")"; 
    }

}
