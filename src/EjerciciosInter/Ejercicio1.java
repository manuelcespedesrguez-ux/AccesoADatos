package EjerciciosInter;

public class Ejercicio1 {
    public static int cuentaPrestados(Object[] objetos) {
        int contador = 0;
        for (Object obj : objetos) {
            if (obj instanceof Prestable prestable) {
                if (prestable.estaPrestado()) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static int publicacionesAnterioresA(Publicacion[] lista, int ano) {
        int contador = 0;
        for (Publicacion pub : lista) {
            if (pub.getAnoPublicacion() < ano) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Publicacion[] publicaciones = new Publicacion[4];
        publicaciones[0] = new Libro("L01", "Cien Años de Soledad", 1967);
        publicaciones[1] = new Libro("L02", "El Nombre del Viento", 2007);
        publicaciones[2] = new Revista("R01", "National Geographic", 1988, 120);
        publicaciones[3] = new Revista("R02", "PC World", 1995, 45);

        // Prestar uno de los libros
        ((Libro) publicaciones[0]).prestar();

        // Mostrar datos almacenados
        System.out.println("--- Lista de Publicaciones ---");
        for (Publicacion p : publicaciones) {
            System.out.println(p);
        }

        // Mostrar estadísticas
        System.out.println("\nPublicaciones prestadas: " + cuentaPrestados(publicaciones));
        System.out.println("Publicaciones anteriores a 1990: " + publicacionesAnterioresA(publicaciones, 1990));
    }
}
