package Primer.EjerciciosPOO;

public class Telefono {
    
    private String[] historial;
    private int indiceUltima;
    private int validasGuardadas;

    public Telefono(int capacidad) {
        if (capacidad < 1) capacidad = 1;
        historial = new String[capacidad];
        indiceUltima = -1;
        validasGuardadas = 0;
    }

    public void llamar(String numero) {
        indiceUltima = (indiceUltima + 1) % historial.length;
        historial[indiceUltima] = numero;
        if (validasGuardadas < historial.length) {
            validasGuardadas++;
        }
    }

    public String ultimaLlamada() {
        return llamada(0);
    }

    public String llamada(int n) {
        if (validasGuardadas == 0 || n < 0 || n >= validasGuardadas) {
            return null;
        }
        int index = (indiceUltima - n + historial.length) % historial.length;
        return historial[index];
    }

}
