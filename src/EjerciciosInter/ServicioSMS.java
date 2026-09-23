package EjerciciosInter;

public class ServicioSMS implements ServicioNotificacion {
    
    @Override
    public boolean validarDestinatario(String d) { 
        return d.matches("\\d{9}"); 
    }

    @Override
    public void enviarMensaje(String d, String m) {
        System.out.println("[SMS] Para: " + d + " | Mensaje: " + m);
    }

}