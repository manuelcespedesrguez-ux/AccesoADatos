package EjerciciosPOO;

public class PruebaTelefono {

    public static void main(String[] args) {
       
        Telefono t = new Telefono(3);
        String[] nums = {"111", "222", "333", "444", "555"};
        for (String num : nums) {
            t.llamar(num);
            System.out.println("Registrado: " + num + " | Última: " + t.ultimaLlamada());
        }
        System.out.println("Llamada 0: " + t.llamada(0)); 
        System.out.println("Llamada 1: " + t.llamada(1)); 
        System.out.println("Llamada 2: " + t.llamada(2)); 
        System.out.println("Llamada 3: " + t.llamada(3)); 
    }
    
}
