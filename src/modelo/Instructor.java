package modelo;

// Importamos la clase Actividad para usarla en el método impartirClase()
import modelo.Actividad; 

public class Instructor extends Persona {
    
    // Atributos propios
    private String especialidad;
    private int experienciaAnos;

    // CONSTRUCTOR: Llama a super() para inicializar atributos de Persona
    public Instructor(String nombre, String id, String telefono, String email, 
                      String especialidad, int experienciaAnos) {
        
        super(nombre, id, telefono, email); 
        this.especialidad = especialidad;
        this.experienciaAnos = experienciaAnos;
    }

    // Métodos del Diagrama UML
    
    /**
     * Simula la acción de impartir una clase específica.
     * @param actividad La clase o actividad que el instructor impartirá.
     */
    public void impartirClase(Actividad actividad) {
        System.out.println("El instructor " + this.getNombre() + 
                           " (" + this.especialidad + ") está impartiendo la clase: " + 
                           actividad.getNombreActividad());
        // Lógica de negocio adicional (ej. registrar la clase en un log)
    }

    public void asignarEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int obtenerExperiencia() {
        return this.experienciaAnos;
    }

    // Getters y Setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getExperienciaAnos() { return experienciaAnos; }
    public void setExperienciaAnos(int experienciaAnos) { this.experienciaAnos = experienciaAnos; }
    
    @Override
    public String toString() {
        return super.toString() + 
               "\n  - Rol: Instructor" +
               "\n  - Especialidad: " + especialidad + 
               "\n  - Experiencia: " + experienciaAnos + " años";
    }
}