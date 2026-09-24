package EjerciciosInter;

public class ServicioApp implements ServicioNotificacion {
    
    @Override
    public boolean validarDestinatario(String d) { 
        return d.startsWith("USR_"); 
    }

    @Override
    public void enviarMensaje(String d, String m) {
        System.out.println("[PUSH APP] Para: " + d + " | Mensaje: " + m);
    }
}