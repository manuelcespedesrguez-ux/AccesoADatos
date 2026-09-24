package EjerciciosInter;

public class ServicioCorreo implements ServicioNotificacion {

    public ServicioCorreo() {
    }
    
    @Override
    public boolean validarDestinatario(String d) { return d.contains("@"); }

    @Override
    public void enviarMensaje(String d, String m) {
        System.out.println("[EMAIL] Para: " + d + " | Mensaje: " + m);
    }

}
