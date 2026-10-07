package EjerciciosFicherosAleatorios;

public class Producto {
    
    private  int id;
    private String nombre;
    private int existencias;
    private double precio;
    
    public Producto(int id, String nombre, int existencias, double precio) {
        this.id = id;
        this.nombre = formatearNombre(nombre);
        this.existencias = existencias;
        this.precio = precio;
    }

    private String formatearNombre(String nombre) {

        if (nombre.length() > 12) {
            return nombre.substring(0, 12);
        } else {
            StringBuilder sebas = new StringBuilder(nombre);
            while (sebas.length() < 12) {
                sebas.append(" ");
            }
            return sebas.toString();
        }

    }

    public int getIdentificador() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = formatearNombre(nombre);
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "FicherosAleatorios [identificador=" + id + ", nombre=" + nombre + ", existencias="
                + existencias + ", precio=" + precio + "€]";
    }

}
