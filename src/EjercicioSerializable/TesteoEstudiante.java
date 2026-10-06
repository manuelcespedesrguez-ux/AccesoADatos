package EjercicioSerializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TesteoEstudiante {
    
    public static void main(String[] args) {
        
        Estudiante fulgencio = new Estudiante("Ana", 20, 8.5, "abc123");
        System.out.println("Antes: " + fulgencio);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("estudiantes.ser"))) {
            oos.writeObject(fulgencio);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error " + e.getMessage() + " al intentar guardar el estudiante");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("estudiantes.ser"))){
            Estudiante estudiantoso = (Estudiante) ois.readObject();
            System.out.println("Después: " + estudiantoso);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error " + e.getMessage() + " al intentar leer");
        }

    }

}
