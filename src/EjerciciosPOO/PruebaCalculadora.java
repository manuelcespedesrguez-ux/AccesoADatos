package EjerciciosPOO;

public class PruebaCalculadora {
    
    public static void main(String[] args) {
       
        Calculadora calc = new Calculadora();
        System.out.println(calc.sumar(2, 3)); 
        System.out.println(calc.sumar(2, 3, 4)); 
        System.out.println(calc.sumar(2.5, 3.0)); 
    }
}
