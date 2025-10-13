public class EquipoGym {

    private String nombre;
    private String tipo; // "Cardio" o "Pesos"
    private boolean disponible;

    public EquipoGym(String nombre, String tipo, boolean disponible) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    // Métodos
    public void marcarDisponible() {
        disponible = true;
    }

    public void marcarEnUso() {
        disponible = false;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Representación en texto (opcional, útil para depurar)
    @Override
    public String toString() {
        return "Equipo: " + nombre +
               " | Tipo: " + tipo +
               " | Disponible: " + (disponible ? "Sí" : "No");
    }
}

