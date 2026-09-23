package EjerciciosInter;

public class Ejercicio10 {
    
    public static void main(String[] args) {
        GestorNotificaciones gestorEmail;
        gestorEmail = new GestorNotificaciones(new ServicioSMS());
        gestorEmail.notificar("manu@ejemplo.com", "Bienvenido a la plataforma");

        GestorNotificaciones gestorSMS = new GestorNotificaciones(new ServicioSMS());
        gestorSMS.notificar("600112233", "Tu código de verificación es 4821");
    }

}