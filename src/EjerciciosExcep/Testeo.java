package EjerciciosExcep;

public class Testeo {
    
    public static void main(String[] args) {
        // Lanzar la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chequear().setVisible(true);
            }
        });
    }

}
