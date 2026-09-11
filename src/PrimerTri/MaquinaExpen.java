package PrimerTri;

public class MaquinaExpen {

    private short Capacidad;
    private short NumeroDeElementos = 0;

    MaquinaExpen(short Capacidad) {
        this.Capacidad = Capacidad;
    }

    public short DimeNumeroDeElementos() {
        return (NumeroDeElementos);
    }

    public short DimeCapacidad() {
        return (Capacidad);
    }

    public boolean HayElemento() {

        return (NumeroDeElementos != 0);
    }

    public boolean HayHueco() {
        return (NumeroDeElementos != Capacidad);
    }

    public void MeteElemento() {
        NumeroDeElementos++;
    }

    public void SacaElemento() {
        NumeroDeElementos--;
    }

    public void RellenaAlmacen() {
        NumeroDeElementos = Capacidad;
    }
}
