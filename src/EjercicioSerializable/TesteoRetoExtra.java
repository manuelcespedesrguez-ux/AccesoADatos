package EjercicioSerializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TesteoRetoExtra {

    public static void main(String[] args) {
    

     ArrayList<Estudiante> estibanez = new ArrayList<>();

        estibanez.add(new Estudiante("Carlos", 19, 7, "cba321"));
        estibanez.add(new Estudiante("Antonio", 25, 9.99, "bca231"));
        estibanez.add(new Estudiante("Marta", 21, 8.9, "bac213"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("estudiantes.ser"))) {
            oos.writeObject(estibanez);
            System.out.println(estibanez);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error " + e.getMessage() + " al intentar guardar el estudiante");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("estudiantes.ser"))){
            ArrayList<Estudiante> estudiantosos = (ArrayList<Estudiante>) ois.readObject();
            System.out.println("Después: " + estudiantosos);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error " + e.getMessage() + " al intentar leer");
        }

}

}