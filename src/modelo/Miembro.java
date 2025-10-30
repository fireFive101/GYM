package modelo;

import modelo.Actividad; // Para los métodos de inscripción

public class Miembro extends Persona {
    
    // Atributos propios
    private String fechaRegistro;
    
    // Relación de asociación 1:0..1 con Membresia
    private Membresia membresiaActual; 

    // CONSTRUCTOR: Llama a super() para inicializar atributos de Persona
    public Miembro(String nombre, String id, String telefono, String email, 
                   String fechaRegistro) {
        
        super(nombre, id, telefono, email); 
        this.fechaRegistro = fechaRegistro;
        this.membresiaActual = null; // Inicialmente sin membresía
    }

    // Métodos del Diagrama UML
    
    /**
     * Intenta inscribir al miembro en una actividad.
     * @return El resultado del intento de agregar al miembro a la actividad.
     */
    public boolean inscribirseAClase(Actividad actividad) {
        if (membresiaActual == null) {
            System.out.println(this.getNombre() + " no tiene una membresía activa para inscribirse.");
            return false;
        }
        return actividad.agregarMiembro(this);
    }

    public boolean cancelarInscripcion(Actividad actividad) {
        return actividad.eliminarMiembro(this);
    }

    public Membresia verMembresia() {
        return this.membresiaActual;
    }

    public void renovarMembresia(Membresia nueva) {
        this.membresiaActual = nueva;
    }

    // Getters y Setters
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        String infoMembresia = (membresiaActual != null) ? 
            "Membresía: " + membresiaActual.getTipo() : "Sin Membresía Activa";
            
        return super.toString() + 
               "\n  - Rol: Miembro" +
               "\n  - Fecha Registro: " + fechaRegistro +
               "\n  - " + infoMembresia;
    }
}