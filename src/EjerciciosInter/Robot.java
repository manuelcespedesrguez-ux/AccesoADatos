package EjerciciosInter;

public class Robot implements Saludable{
    
    private String modelo;

    public Robot(String modelo) { this.modelo = modelo; }

    @Override
    public void saludar() {
        System.out.println("Inicializando saludo. Modelo: " + modelo);
    }

}
