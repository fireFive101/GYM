package modelo;

public abstract class Persona { // 'abstract' porque en el UML no se instancia una Persona pura

    // Atributos
    private String nombre;
    private String id;
    private String telefono; // Lo cambié a 'telefono' para mayor claridad (en lugar de 'tel')
    private String email;

    // CONSTRUCTOR REQUERIDO: Inicializa los atributos base y es llamado por 'super()'
    public Persona(String nombre, String id, String telefono, String email) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos del Diagrama UML
    public String obtenerInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
    }

    public void actualizarDatos(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters (para acceso a los atributos)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    // Método toString() para una representación legible
    @Override
    public String toString() {
        return obtenerInformacion();
    }
}