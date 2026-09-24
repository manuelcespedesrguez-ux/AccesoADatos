package EjerciciosInter;

public class Coche implements ConfiguracionVehi {
    
    private int velocidadActual;

    public Coche() {
        this.velocidadActual = VELOCIDAD_MINIMA;
    }

    @Override
    public void acelerar(int incremento) {
        velocidadActual += incremento;
        if (velocidadActual > VELOCIDAD_MAXIMA) {
            velocidadActual = VELOCIDAD_MAXIMA;
            System.out.println("Límite máximo alcanzado (120 km/h).");
        }
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }

    @Override
    public void frenar(int decremento) {
        velocidadActual -= decremento;
        if (velocidadActual < VELOCIDAD_MINIMA) {
            velocidadActual = VELOCIDAD_MINIMA;
            System.out.println("El coche está detenido.");
        }
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }

}
