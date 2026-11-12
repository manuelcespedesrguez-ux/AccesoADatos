package PracticaExamen;

public class Productos {
    
    private int id;
    private String nombre;
    private double precios;
    private int existencias;

    public Productos(int id, String nombre, double precios, int existencias) {
        this.id = id;
        this.nombre = nombre;
        this.precios = precios;
        this.existencias = existencias;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecios() {
        return precios;
    }

    public int getExistencias() {
        return existencias;
    }    

}
