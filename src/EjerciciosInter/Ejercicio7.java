package EjerciciosInter;

public class Ejercicio7 {
    
    public static void main(String[] args) {
        Factura f = new Factura(101, "TechCorp", 1500.0);

        Imprimible imp = f;
        imp.mostrarInformacionCompleta();

        Resumible res = f;
        System.out.println("Resumen: " + res.obtenerResumen());

        Imprimible inf = new Informe("Balance Anual", "Resultados positivos.");
        inf.mostrarInformacionCompleta();
    }

}
