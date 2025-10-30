package modelo;

import java.util.List;
import java.util.ArrayList;

public class Actividad {
    
    // Atributos
    private String nombreActividad;
    private String horario;
    private int capacidadMaxima;
    
    // Relación de agregación: mantiene una lista de Miembros inscritos
    private List<Miembro> miembrosInscritos; 
    
    // Relación de asociación 1:1 con Instructor (para gestión interna)
    private Instructor instructorAsignado; 

    // Constructor
    public Actividad(String nombreActividad, String horario, int capacidadMaxima) {
        this.nombreActividad = nombreActividad;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.miembrosInscritos = new ArrayList<>();
        this.instructorAsignado = null; 
    }

    // Métodos del Diagrama UML
    
    /**
     * Agrega un miembro a la lista de inscritos.
     * @return true si la inscripción fue exitosa, false si no hay cupo o ya está inscrito.
     */
    public boolean agregarMiembro(Miembro miembro) {
        if (miembrosInscritos.size() < capacidadMaxima && !miembrosInscritos.contains(miembro)) {
            miembrosInscritos.add(miembro);
            return true;
        }
        return false;
    }

    /**
     * Elimina un miembro de la lista de inscritos.
     */
    public boolean eliminarMiembro(Miembro miembro) {
        return miembrosInscritos.remove(miembro);
    }

    /**
     * Devuelve la disponibilidad actual de la actividad.
     */
    public String mostrarDisponibilidad() {
        int disponibles = capacidadMaxima - miembrosInscritos.size();
        return "Actividad: " + nombreActividad + " | Cupos disponibles: " + disponibles + 
               " de " + capacidadMaxima;
    }
    
    // Getters y Setters
    public String getNombreActividad() { return nombreActividad; }
    public void setNombreActividad(String nombreActividad) { this.nombreActividad = nombreActividad; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public List<Miembro> getMiembrosInscritos() { return miembrosInscritos; }

    public Instructor getInstructorAsignado() { return instructorAsignado; }
    public void setInstructorAsignado(Instructor instructorAsignado) { this.instructorAsignado = instructorAsignado; }
}