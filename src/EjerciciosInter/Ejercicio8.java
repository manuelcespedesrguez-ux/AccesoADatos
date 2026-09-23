package EjerciciosInter;

public class Ejercicio8 {
    
    public static void main(String[] args) {
        Empleado emp1 = new EmpleadoFijo("Ana", 1800.0);
        Empleado emp2 = new Comercial("Carlos", 1200.0, 15000.0, 0.05);

        emp1.mostrarDatos();
        emp2.mostrarDatos();
    }

}
