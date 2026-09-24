package EjerciciosInter;

public class Informe implements Imprimible {
    
    private String titulo;
    private String contenido;

    public Informe(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    @Override
    public void mostrarInformacionCompleta() {
        System.out.println("INFORME: " + titulo + "\nContenido: " + contenido);
    }

}
