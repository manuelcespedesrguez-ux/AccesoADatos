package EjerciciosInter;

public class Cliente implements  Gestionable {
    
    private String id;
    private String email;
    private boolean activo;

    public Cliente(String id, String email) {
        this.id = id;
        this.email = email;
        this.activo = true;
    }

    @Override 
    public String getId() {
        return id; 
    }
    @Override 
    public void activar() { 
        this.activo = true; 
    }
    @Override 
    public void desactivar() { 
        this.activo = false; 
    }
    @Override
    public boolean estaActivo() { 
        return activo; 
    }

    @Override public String toString() { 
        return "Cliente[" + id + "] " + email + " - Activo: " + activo; 
    }

}
