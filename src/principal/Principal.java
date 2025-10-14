package principal;

import modelo.Miembro;

public class Principal {
    public static void main(String[] args) {
        // Crear un objeto de tipo Miembro
        Miembro m1 = new Miembro();

        // Asignar datos usando los setters heredados de Persona
        m1.setNombre("Carlos Andrade");
        m1.setId("M001");
        m1.setTel("555-1234");
        m1.setEmail("carlos@example.com");
        m1.setFechaRegistro("2025-10-14");

        // Mostrar los datos del miembro
        System.out.println("=== DEMO GYM ===");
        System.out.println(m1); // Usa el método toString() de Miembro
    }
}


