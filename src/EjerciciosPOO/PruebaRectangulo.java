package EjerciciosPOO;

public class PruebaRectangulo {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo();
        r1.setAlto(3);
        r1.setAncho(6);
        r1.setAlto(-4); // Inválido, conserva el 3
        r1.setAncho(0); // Inválido, conserva el 6
        System.out.println("R1 - Alto: " + r1.getAlto() + ", Ancho: " + r1.getAncho());
        System.out.println("R1 - Área: " + r1.area() + ", Perímetro: " + r1.perimetro());
        
        Rectangulo r2 = new Rectangulo();
        System.out.println("R2 - Alto: " + r2.getAlto());
    }
}
