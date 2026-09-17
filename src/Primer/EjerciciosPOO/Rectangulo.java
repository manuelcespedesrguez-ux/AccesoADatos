package Primer.EjerciciosPOO;

public class Rectangulo {
    private int alto = 1;
    private int ancho = 1;

    public void setAlto(int alto) {
        if (alto >= 2) { // Modificado para el apartado d
            this.alto = alto;
        }
    }
    public void setAncho(int ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }
    public int getAlto() { return alto; }
    public int getAncho() { return ancho; }
    
    public int area() { return alto * ancho; }
    public int perimetro() { return 2 * (alto + ancho); }
}