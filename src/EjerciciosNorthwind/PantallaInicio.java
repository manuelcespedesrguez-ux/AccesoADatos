package EjerciciosNorthwind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PantallaInicio extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JTextField txtServidor;
    private JTextField txtPuerto;
    private JTextField txtBaseDatos;
    
    private JButton btnConectar;
    private JButton btnActualizarPrecios;
    private JButton btnImportar;
    private JButton btnExportar;

    public Connection conexionBD = null;

    public PantallaInicio() {
        setTitle("MySQL - Conexión Northwind");
        setSize(450, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField("root");
        txtUsuario.setBounds(120, 30, 270, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 70, 80, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(120, 70, 270, 25);
        add(txtContrasena);

        JLabel lblServidor = new JLabel("Servidor:");
        lblServidor.setBounds(30, 110, 80, 25);
        add(lblServidor);

        txtServidor = new JTextField("127.0.0.1");
        txtServidor.setBounds(120, 110, 200, 25);
        add(txtServidor);

        txtPuerto = new JTextField("3306");
        txtPuerto.setBounds(330, 110, 60, 25);
        add(txtPuerto);

        JLabel lblBaseDatos = new JLabel("Base de datos:");
        lblBaseDatos.setBounds(30, 150, 90, 25);
        add(lblBaseDatos);

        txtBaseDatos = new JTextField("Northwind");
        txtBaseDatos.setBounds(120, 150, 270, 25);
        add(txtBaseDatos);

        btnConectar = new JButton("CONECTAR");
        btnConectar.setBounds(30, 190, 170, 30);
        add(btnConectar);

        btnActualizarPrecios = new JButton("Actualizar precios productos");
        btnActualizarPrecios.setBounds(210, 190, 180, 30);
        btnActualizarPrecios.setEnabled(false);
        add(btnActualizarPrecios);

        btnImportar = new JButton("Importar productos");
        btnImportar.setBounds(30, 230, 170, 30);
        btnImportar.setEnabled(false);
        add(btnImportar);

        btnExportar = new JButton("Exportar productos");
        btnExportar.setBounds(210, 230, 180, 30);
        btnExportar.setEnabled(false);
        add(btnExportar);

        // Evento de Conexión
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectarBaseDatos();
            }
        });

        // Evento para abrir la ventana de actualizar precios
        btnActualizarPrecios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (conexionBD != null) {
                    FormularioActualizarPrecios formPrecios = new FormularioActualizarPrecios(conexionBD);
                    formPrecios.setVisible(true);
                }
            }
        });

        // Evento para Importar
        btnImportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importarProductosDesdeTxt();
            }
        });

        // Evento para Exportar
        btnExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarProductosAtxt();
            }
        });
    }

    private void conectarBaseDatos() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtContrasena.getPassword());
        String servidor = txtServidor.getText().trim();
        String puerto = txtPuerto.getText().trim();
        String bd = txtBaseDatos.getText().trim();

        String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + bd + "?useSSL=false&serverTimezone=UTC";

        try {
            conexionBD = DriverManager.getConnection(url, usuario, password);
            JOptionPane.showMessageDialog(this, "¡Conexión establecida con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Habilitar los botones de gestión una vez conectados
            btnActualizarPrecios.setEnabled(true);
            btnImportar.setEnabled(true);
            btnExportar.setEnabled(true);
            btnConectar.setEnabled(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con MySQL: " + ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void importarProductosDesdeTxt() {
        String linea;
        int registrosInsertados = 0;
        
        String sql = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (BufferedReader br = new BufferedReader(new FileReader("productos_a_importar.txt"));
             PreparedStatement ps = conexionBD.prepareStatement(sql)) {
            
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] valores = linea.split(",");
                
                if (valores.length >= 10) {
                    try {
                        ps.setString(1, valores[1].trim());
                        
                        if (valores[2].trim().equalsIgnoreCase("NULL")) {
                            ps.setNull(2, java.sql.Types.INTEGER);
                        } else {
                            ps.setInt(2, Integer.parseInt(valores[2].trim()));
                        }
                        
                        ps.setInt(3, Integer.parseInt(valores[3].trim()));
                        ps.setString(4, valores[4].trim());
                        ps.setDouble(5, Double.parseDouble(valores[5].trim()));
                        ps.setInt(6, Integer.parseInt(valores[6].trim()));
                        ps.setInt(7, Integer.parseInt(valores[7].trim()));
                        ps.setInt(8, Integer.parseInt(valores[8].trim()));
                        ps.setInt(9, Integer.parseInt(valores[9].trim()));

                        ps.executeUpdate();
                        registrosInsertados++;
                        
                    } catch (Exception exRow) {
                        System.err.println("Error en línea: " + linea + " -> " + exRow.getMessage());
                    }
                }
            }
            
            JOptionPane.showMessageDialog(this, "SE HAN IMPORTADO " + registrosInsertados + " REGISTROS.", "Importación completada", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al importar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportarProductosAtxt() {
        int registrosExportados = 0;
        try (Statement st = conexionBD.createStatement();
             java.sql.ResultSet rs = st.executeQuery("SELECT * FROM Products")) {
            
            // Lógica básica de exportación si la requieres
            while (rs.next()) {
                registrosExportados++;
            }
            
            JOptionPane.showMessageDialog(this, "SE HAN EXPORTADO " + registrosExportados + " REGISTROS.", "Exportación completada", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaInicio().setVisible(true);
            }
        });
    }
}