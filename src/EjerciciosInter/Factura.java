package EjerciciosInter;

public class Factura implements Imprimible, Resumible {
    
    private int numero;
    private String cliente;
    private double total;

    public Factura(int numero, String cliente, double total) {
        this.numero = numero;
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public void mostrarInformacionCompleta() {
        System.out.println("Factura #" + numero + " - Cliente: " + cliente + " - Total: " + total + "€");
    }

    @Override
    public String obtenerResumen() {
        return "Factura #" + numero + " (" + total + "€)";
    }

}
