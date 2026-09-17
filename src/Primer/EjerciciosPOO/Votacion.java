package Primer.EjerciciosPOO;

public class Votacion {
    
    private String nombreCandidato;
    private int votos;
    
    private static String nombreMasVotado = "Ninguno";
    private static int votosMasVotado = 0;

    public Votacion(String nombre) {
        this.nombreCandidato = nombre;
        this.votos = 0;
    }

    public void votar() {
        this.votos++;
        if (this.votos > votosMasVotado) {
            votosMasVotado = this.votos;
            nombreMasVotado = this.nombreCandidato;
        }
    }

    public int getVotos() { return votos; }
    public String getNombre() { return nombreCandidato; }
    
    public static String getLider() {
        return nombreMasVotado + " con " + votosMasVotado + " votos";
    }
    
}