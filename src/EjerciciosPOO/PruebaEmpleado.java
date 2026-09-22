package EjerciciosPOO;

public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Ana", "1111A");
        Empleado e2 = new Empleado("Luis", "2222B");
        e1.setNombre("Marta");
        System.out.println(e1.getNombre() + " - " + e1.getDni());
        System.out.println(e2.getNombre() + " - " + e2.getDni());
    }
}
