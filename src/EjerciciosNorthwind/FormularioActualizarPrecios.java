package EjerciciosNorthwind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FormularioActualizarPrecios extends JFrame {

    private Connection conexionBD;
    private JTextField txtCategoria;
    private JTextField txtPorcentaje;
    private JButton btnActualizar;

    // CONSTRUCTOR QUE RECIBE LA CONEXIÓN
    public FormularioActualizarPrecios(Connection conexion) {
        this.conexionBD = conexion;
        setTitle("Actualizar Precios por Categoría");
        setSize(380, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        JLabel lblCategoria = new JLabel("ID Categoría:");
        lblCategoria.setBounds(30, 30, 120, 25);
        add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(160, 30, 160, 25);
        add(txtCategoria);

        JLabel lblPorcentaje = new JLabel("Porcentaje aumento:");
        lblPorcentaje.setBounds(30, 70, 120, 25);
        add(lblPorcentaje);

        txtPorcentaje = new JTextField();
        txtPorcentaje.setBounds(160, 70, 160, 25);
        add(txtPorcentaje);

        btnActualizar = new JButton("Actualizar Precios");
        btnActualizar.setBounds(90, 120, 190, 30);
        add(btnActualizar);

        // Evento para realizar la actualización en la BD
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPreciosPorCategoria();
            }
        });
    }

    private void actualizarPreciosPorCategoria() {
        String catStr = txtCategoria.getText().trim();
        String porStr = txtPorcentaje.getText().trim();

        if (catStr.isEmpty() || porStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int categoryId = Integer.parseInt(catStr);
            double porcentaje = Double.parseDouble(porStr);

            // Sentencia SQL para actualizar el precio incrementándolo según el porcentaje
            String sql = "UPDATE Products SET UnitPrice = UnitPrice * (1 + ? / 100) WHERE CategoryID = ?";

            try (PreparedStatement ps = conexionBD.prepareStatement(sql)) {
                ps.setDouble(1, porcentaje);
                ps.setInt(2, categoryId);

                int filasAfectadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Se han actualizado los precios de " + filasAfectadas + " productos correctamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cierra la ventana tras actualizar
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce valores numéricos válidos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar en la base de datos: " + ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
}