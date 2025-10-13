import java.util.List;
import java.util.ArrayList;

public class Actividad {
    // Atributos (campos)
    private String nombreActividad;
    private String horario;
    private int capacidadMaxima;
    
    // Relación implícita de muchos a muchos con Miembro
    private List<Miembro> miembrosInscritos; 
    

    private Instructor instructorAsignado; 

    // Constructor
    public Actividad(String nombreActividad, String horario, int capacidadMaxima) {
        this.nombreActividad = nombreActividad;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.miembrosInscritos = new ArrayList<>(); // Inicializa la lista de miembros
        this.instructorAsignado = null; // Se asignará más tarde
    }

    // Métodos del Diagrama UML

    /**
     * Agrega un miembro a la lista de inscritos si hay capacidad.
     * @param miembro El miembro a agregar.
     * @return true si la inscripción fue exitosa, false si no hay capacidad.
     */
    public boolean agregarMiembro(Miembro miembro) {
        if (miembrosInscritos.size() < capacidadMaxima && !miembrosInscritos.contains(miembro)) {
            return miembrosInscritos.add(miembro);
        }
        return false;
    }

    /**
     * Elimina un miembro de la lista de inscritos.
     * @param miembro El miembro a eliminar.
     * @return true si el miembro fue eliminado, false si no estaba inscrito.
     */
    public boolean eliminarMiembro(Miembro miembro) {
        return miembrosInscritos.remove(miembro);
    }

    /**
     * Devuelve la información de disponibilidad de la actividad.
     * @return Un String que describe los cupos disponibles.
     */
    public String mostrarDisponibilidad() {
        int cuposDisponibles = capacidadMaxima - miembrosInscritos.size();
        if (cuposDisponibles > 0) {
            return "Actividad: " + nombreActividad + " | Horario: " + horario + 
                   " | Cupos disponibles: " + cuposDisponibles + " de " + capacidadMaxima;
        } else {
            return "Actividad: " + nombreActividad + " | Horario: " + horario + " | CUPOS AGOTADOS.";
        }
    }
    
    // Getters y Setters (adicionales, pero necesarios para la gestión)

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Instructor getInstructorAsignado() {
        return instructorAsignado;
    }

    public void setInstructorAsignado(Instructor instructorAsignado) {
        this.instructorAsignado = instructorAsignado;
    }

    public List<Miembro> getMiembrosInscritos() {
        return miembrosInscritos;
    }
}
