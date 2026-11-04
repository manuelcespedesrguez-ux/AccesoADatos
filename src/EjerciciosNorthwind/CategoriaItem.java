package EjerciciosNorthwind;

public class CategoriaItem {
    private int id;
    private String nombre;

    public CategoriaItem(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}