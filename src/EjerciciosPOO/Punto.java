package EjerciciosPOO;

public class Punto {
    private int x, y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(int v) {
        this.x = v;
        this.y = v;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void dibujar() {
        System.out.println("Punto en (" + x + ", " + y + ")");
    }
}
