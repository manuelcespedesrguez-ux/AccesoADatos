package PracticaExamen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

    private static final String URL = "jdbc:mysql://localhost:3306/northwind?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    public static void main(String[] args) {
        
        List<Productos> sergio = new ArrayList<>();

        String sql = "SELECT productID, productName, CategoryID, UnitPrice, UnitsInStock FROM Products WHERE CategoryID = ? AND UnitPrice >= ? ORDER BY productID ASC";


        try (Connection conexion = DriverManager.getConnection(URL, user, password); PreparedStatement preparado = conexion.prepareStatement(sql)){

            preparado.setInt(1, 1);
            preparado.setDouble(2, 18.00);

            try (ResultSet fordRs = preparado.executeQuery()) {
                while (fordRs.next()){
                    int id = fordRs.getInt("ProductID");
                    String nombre = fordRs.getString("ProductName");
                    double precio = fordRs.getDouble("UnitPrice");
                    int stock = fordRs.getInt("UnitsInStock");

                    Productos producto1 = new Productos(id, nombre, precio, stock);
                    sergio.add(producto1);
                }
            }

            if (sergio.isEmpty()) {
                System.out.println("No se encuentran productos con ese criterio");
            } else {
                System.out.println("Lista de productos: ");
                for (Productos producto1 : sergio) {
                    System.out.println(producto1.getId() + " " + producto1.getNombre() + " " + producto1.getPrecios() + " " + producto1.getExistencias());
                }
            }


        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        String actualizarSQL = "UPDATE Products SET UnitsInStock = UnitsInStock + ? WHERE ProductID = ? AND CategoryID = ?";

        try (Connection conexion2 = DriverManager.getConnection(URL, user, password); PreparedStatement preparado2 = conexion2.prepareStatement(actualizarSQL)) {
            
            preparado2.setInt(1, 5);
            preparado2.setInt(2, 1);
            preparado2.setInt(3, 1);

            int filasActualizadas = preparado2.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Los productos se han actualizado correctamente, se han actualizado las siguientes filas: " + filasActualizadas);
            } else {
                System.out.println("No se encuentran productos para actualizar con ese criterio");
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        try (BufferedWriter manolin = new BufferedWriter(new FileWriter("informe_existencias.txt"))) {
            
            manolin.write("Id Nombre Precio Existencias");
            manolin.newLine();

            for (Productos pepix : sergio) {
               
                String linea = pepix.getId() + " | " + pepix.getNombre() + " | " + pepix.getPrecios() + " | " + pepix.getExistencias();
                manolin.write(linea);
                manolin.newLine();
            }

            System.out.println("El fichero se ha creado correctamente");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }

}