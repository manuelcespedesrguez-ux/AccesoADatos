package EjerciciosInter;

public abstract class Empleado {
    
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public void mostrarDatos() {
        System.out.println("Empleado: " + nombre + " | Salario Total: " + calcularSalario() + "€");
    }

    public abstract double calcularSalario();

}
