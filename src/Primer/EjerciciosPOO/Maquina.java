package Primer.EjerciciosPOO;

public class Maquina {
    
    private Almacen[] almacenes;
    private int[] precios;

    public Maquina() {
        almacenes = new Almacen[]{new Almacen(3), new Almacen(2), new Almacen(2)};
        precios = new int[]{60, 130, 100}; // Agua(0), Naranja(1), Cola(2)
    }

    public void reponer(int codigo) {
        if (codigo >= 0 && codigo < almacenes.length) almacenes[codigo].rellenar();
    }

    public void setPrecio(int codigo, int nuevoPrecio) {
        if (codigo >= 0 && codigo < almacenes.length && nuevoPrecio > 0) {
            precios[codigo] = nuevoPrecio;
        }
    }

    public int getExistencias(int codigo) {
        if (codigo >= 0 && codigo < almacenes.length) return almacenes[codigo].getCantidad();
        return 0;
    }

    public boolean comprar(int codigo, int pagoCentimos) {
        if (codigo >= 0 && codigo < almacenes.length) {
            if (precios[codigo] == pagoCentimos && almacenes[codigo].getCantidad() > 0) {
                return almacenes[codigo].sacar();
            }
        }
        return false;
    }

}
