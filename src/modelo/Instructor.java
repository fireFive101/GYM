package modelo;

// Asumimos que la clase Persona existe y está en el paquete 'modelo'
public class Instructor extends Persona { 
    private String especialidad;
    private int experienciaAnos;

    // CONSTRUCTOR (debe llamar a super() para inicializar atributos de Persona)
    public Instructor(String nombre, String id, String tel, String email, String especialidad, int experienciaAnos) {
        // Inicializa atributos de Persona
        super(nombre, id, tel, email); 
        this.especialidad = especialidad;
        this.experienciaAnos = experienciaAnos;
    }

    // GETTERS Y SETTERS ya proporcionados en su ejemplo.

    // Método toString() (opcional, pero recomendado)
    @Override
    public String toString() {
        return super.toString() + 
               "\n  - Rol: Instructor" +
               "\n  - Especialidad: " + especialidad + 
               "\n  - Experiencia: " + experienciaAnos + " años";
    }
}
