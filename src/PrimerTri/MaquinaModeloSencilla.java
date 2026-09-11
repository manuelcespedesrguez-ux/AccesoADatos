package PrimerTri;

public class MaquinaModeloSencilla {

    public MaquinaExpen Deposito1Euro = new MaquinaExpen((short) 8);
    public MaquinaExpen Deposito01Euro = new MaquinaExpen((short) 15);

    public MaquinaExpen DepositoCocaCola = new MaquinaExpen((short) 10);
    public MaquinaExpen DepositoNaranja = new MaquinaExpen((short) 5);
    public MaquinaExpen DepositoAgua = new MaquinaExpen((short) 8);

    private float PrecioCocaCola = 1.0f;
    private float PrecioNaranja = 1.3f;
    private float PrecioAgua = 0.6f; // precio recomendado

    public void PonPrecios(float CocaCola, float Naranja, float Agua) {
        PrecioCocaCola = CocaCola;
        PrecioNaranja = Naranja;
        PrecioAgua = Agua;
    }

    public float DimePrecioCocaCola() {
        return PrecioCocaCola;
    }

    public float DimePrecioNaranja() {
        return PrecioNaranja;
    }

    public float DimePrecioAgua() {
        return PrecioAgua;
    }

    public void MostrarEstadoMaquina() {
        System.out.print("CocaColas: " + DepositoCocaCola.DimeNumeroDeElementos() + " ");

        System.out.print("Naranjas: " + DepositoNaranja.DimeNumeroDeElementos() + " ");
        System.out.println("Agua: " + DepositoAgua.DimeNumeroDeElementos() + " ");

        System.out.print("1 Euro: " + Deposito1Euro.DimeNumeroDeElementos() + " ");
        System.out.println("0.1 Euro: " + Deposito01Euro.DimeNumeroDeElementos() + " ");
        System.out.println();
    }
}