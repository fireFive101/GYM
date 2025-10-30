package logica;

public class gimnasio {

    public class Usuario {
    private String nombre;
    private int edad;
    private String membresia;
    public Usuario(String nombre, int edad, String membresia) {
        this.nombre = nombre;
        this.edad = edad;
        this.membresia = membresia;
    }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getMembresia() { return membresia; }
    @Override
    public String toString() {
        return "Usuario: " + nombre + ", Edad: " + edad + ", Membresía: " + membresia;
    }
    }

    public class Entrenamiento {
    private String tipo;
    private int duracion;  // en minutos
    private Usuario usuario;
    public Entrenamiento(String tipo, int duracion, Usuario usuario) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.usuario = usuario;
    }
    public String getTipo() { return tipo; }
    public int getDuracion() { return duracion; }
    public Usuario getUsuario() { return usuario; }
    @Override
    public String toString() {
        return "Entrenamiento: " + tipo + ", Duración: " + duracion + " min, Usuario: " + usuario.getNombre();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Entrenamiento> entrenamientos = new ArrayList<>();

    public void agregarUsuario(String nombre, int edad, String membresia) {
        usuarios.add(new Usuario(nombre, edad, membresia));
    }

    public void agregarEntrenamiento(String tipo, int duracion, Usuario usuario) {
        entrenamientos.add(new Entrenamiento(tipo, duracion, usuario));
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientos;
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder("Reporte del Gimnasio:\n");
        reporte.append("Usuarios:\n");
        for (Usuario u : usuarios) {
            reporte.append(u.toString()).append("\n");
        }
        reporte.append("Entrenamientos:\n");
        for (Entrenamiento e : entrenamientos) {
            reporte.append(e.toString()).append("\n");
        }
        return reporte.toString();
    }
}  
    
}
