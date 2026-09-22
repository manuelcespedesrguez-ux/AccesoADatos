package EjerciciosPOO;

public class PruebaMaquina {

    public static void main(String[] args) {
        Maquina m1 = new Maquina();
        m1.reponer(0); // Repone Agua (3 uds)

        System.out.println("Compra correcta (0, 60): " + m1.comprar(0, 60));
        System.out.println("Pago insuficiente (0, 50): " + m1.comprar(0, 50));
        System.out.println("Pago superior (0, 100): " + m1.comprar(0, 100));
        System.out.println("Código inválido (9, 60): " + m1.comprar(9, 60));

        m1.comprar(0, 60);
        m1.comprar(0, 60); 
        System.out.println("Producto agotado (0, 60): " + m1.comprar(0, 60));

        Maquina m2 = new Maquina(); 
        m2.reponer(0);
        System.out.println("M2 Existencias de agua: " + m2.getExistencias(0)); // 3
    }

}
