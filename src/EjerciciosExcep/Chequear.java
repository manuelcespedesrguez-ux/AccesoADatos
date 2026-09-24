package EjerciciosExcep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Chequear extends JFrame {
    
    private JTextField txtNumerador;
    private JTextField txtDenominador;
    private JTextField txtResultado;

    public Chequear() {
        // Configuración de la ventana
        setTitle("Chequear Racional");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Posicionamiento libre

        // Título superior
        JLabel lblTitulo = new JLabel("Introduce número racional:");
        lblTitulo.setForeground(java.awt.Color.RED);
        lblTitulo.setBounds(50, 20, 250, 25);
        add(lblTitulo);

        // Numerador
        JLabel lblNum = new JLabel("Numerador (<100):");
        lblNum.setBounds(50, 80, 130, 25);
        add(lblNum);

        txtNumerador = new JTextField();
        txtNumerador.setBounds(180, 80, 100, 25);
        add(txtNumerador);

        // Denominador
        JLabel lblDen = new JLabel("Denominador (>-5):");
        lblDen.setBounds(50, 140, 130, 25);
        add(lblDen);

        txtDenominador = new JTextField();
        txtDenominador.setBounds(180, 140, 100, 25);
        add(txtDenominador);

        // Botón Continuar
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(300, 110, 100, 35);
        add(btnContinuar);

        // Resultado
        JLabel lblRes = new JLabel("Resultado:");
        lblRes.setBounds(50, 220, 100, 25);
        add(lblRes);

        txtResultado = new JTextField();
        txtResultado.setBounds(180, 220, 100, 25);
        txtResultado.setEditable(false);
        add(txtResultado);

        // --- LÓGICA DEL BOTÓN Y EXCEPCIONES ---
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double numerador = Double.parseDouble(txtNumerador.getText());
                    double denominador = Double.parseDouble(txtDenominador.getText());

                    // Restricción del intervalo (<100 y >-5)
                    if (numerador >= 100 || denominador <= -5) {
                        throw new ExcepcionIntervalo("Los números están fuera del intervalo.");
                    }

                    // División entre cero
                    if (denominador == 0) {
                        throw new ArithmeticException("División entre cero.");
                    }

                    double resultado = numerador / denominador;
                    txtResultado.setText(String.format(Locale.US, "%.2f", resultado));

                    JOptionPane.showMessageDialog(Chequear.this, "Operación Realizada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Chequear.this, "Debe introducir caracteres numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ExcepcionIntervalo ex) {
                    JOptionPane.showMessageDialog(Chequear.this, ex.getMessage(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(Chequear.this, "División entre cero.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}