package EjerciciosInter;

public class Producto implements Gestionable {

    private String id;
    private String nombre;
    private boolean activo;

    public Producto(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activo = false;
    }

    @Override public String getId() { return id; }
    @Override public void activar() { this.activo = true; }
    @Override public void desactivar() { this.activo = false; }
    @Override public boolean estaActivo() { return activo; }

    @Override public String toString() { return "Producto[" + id + "] " + nombre + " - Activo: " + activo; }
}
