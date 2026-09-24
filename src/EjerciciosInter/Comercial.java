package EjerciciosInter;

public class Comercial extends Empleado implements Bonificable {
    private double ventasRealizadas;
    private double porcentajeComision;

    public Comercial(String nombre, double salarioBase, double ventasRealizadas, double porcentajeComision) {
        super(nombre, salarioBase);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularBonificacion() {
        return ventasRealizadas * porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + calcularBonificacion();
    }
}