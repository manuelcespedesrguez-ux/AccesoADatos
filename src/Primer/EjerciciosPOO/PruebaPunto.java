package Primer.EjerciciosPOO;

public class PruebaPunto {

    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5);
        Punto p3 = new Punto(4, 6);
        p1.dibujar();
        p2.dibujar();
        p3.dibujar();
    }

}
