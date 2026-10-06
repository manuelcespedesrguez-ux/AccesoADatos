package EjercicioSerializable;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private String nombre;
    private int edad;
    private double notaMedia;
    private transient String contraseña;

    private static final long serialVersionUID = 1L;

    public Estudiante(String nombre, int edad, double notaMedia, String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", notaMedia=" + notaMedia +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

}
