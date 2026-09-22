package EjerciciosPOO;

public class Almacen {

    private int capacidad;
    private int cantidad;

    public Almacen(int capacidad) {
        this.capacidad = (capacidad > 0) ? capacidad : 1;
        this.cantidad = 0;
    }

    public boolean meter() {
        if (cantidad < capacidad) {
            cantidad++;
            return true;
        }
        return false;
    }

    public boolean sacar() {
        if (cantidad > 0) {
            cantidad--;
            return true;
        }
        return false;
    }

    public void rellenar() {
        cantidad = capacidad;
    }

    public int getCantidad() {
        return cantidad;
    }

}
