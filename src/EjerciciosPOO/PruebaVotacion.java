package EjerciciosPOO;

public class PruebaVotacion {

    public static void main(String[] args) {
    
        System.out.println("Líder inicial: " + Votacion.getLider());
        Votacion ana = new Votacion("Ana");
        Votacion bruno = new Votacion("Bruno");
        Votacion carla = new Votacion("Carla");

        ana.votar();   
        bruno.votar(); 
        bruno.votar(); 
        carla.votar(); 
        carla.votar();
        ana.votar();   
        ana.votar();   
        
        System.out.println("Líder final: " + Votacion.getLider());
    }
}