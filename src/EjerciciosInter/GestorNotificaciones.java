package EjerciciosInter;

public class GestorNotificaciones {

    public GestorNotificaciones(ServicioSMS servicioSMS) {
    }
    private ServicioNotificacion servicio;

    public void GestorNotificaciones(ServicioNotificacion servicio) {
        this.servicio = servicio;
    }

    public void notificar(String destinatario, String mensaje) {
        if (servicio.validarDestinatario(destinatario)) {
            servicio.enviarMensaje(destinatario, mensaje);
        } else {
            System.out.println("Error: Destinatario '" + destinatario + "' no es válido para este servicio.");
        }
    }

}
