package EjerciciosSwing;

import javax.swing.*;
import EjerciciosSwing.Ventanas.PantallaInicio;

public class ConexionSwing {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PantallaInicio pantallaInicio = new PantallaInicio();
            pantallaInicio.setVisible(true);
        });
    }
}