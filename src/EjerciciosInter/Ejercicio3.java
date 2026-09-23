package EjerciciosInter;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        Calculable c = new Circulo(5.0);
        Calculable r = new Rectangulo(4.0, 6.0);

        System.out.printf("Área del Círculo: %.2f\n", c.calcularArea());
        System.out.printf("Área del Rectángulo: %.2f\n", r.calcularArea());
    }

}
