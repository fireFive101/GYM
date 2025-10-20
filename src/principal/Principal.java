package principal;

import modelo.Miembro;
import modelo.Instructor;
import modelo.Actividad;

public class Principal {
    public static void main(String[] args) {
        // 1. CREAR EL MIEMBRO EXISTENTE
        Miembro m1 = new Miembro();
        m1.setNombre("Carlos Andrade");
        m1.setId("M001");
        m1.setTel("555-1234");
        m1.setEmail("carlos@example.com");
        m1.setFechaRegistro("2025-10-14");

        // 2. CREAR UN INSTRUCTOR
        // Usando el nuevo constructor que incluye los datos de Persona
        Instructor i1 = new Instructor(
            "Laura Pérez", 
            "I005", 
            "555-5678", 
            "laura@gym.com",
            "Yoga", 
            5
        );

        // 3. CREAR UNA ACTIVIDAD
        Actividad yogaManana = new Actividad("Yoga Matinal", "08:00 - 09:00", 2);
        
        // Asignar el instructor a la actividad
        yogaManana.setInstructorAsignado(i1);

        // 4. MOSTRAR INFORMACIÓN Y PROBAR LÓGICA
        System.out.println("=== DEMO GYM - MIEMBRO ===");
        System.out.println(m1);
        
        System.out.println("\n=== DEMO GYM - INSTRUCTOR ===");
        System.out.println(i1);

        System.out.println("\n=== DEMO GYM - INSCRIPCIONES ===");
        
        // Mostrar disponibilidad antes de la inscripción
        System.out.println(yogaManana.mostrarDisponibilidad()); 

        // Inscribir al miembro m1 (debería ser exitoso)
        boolean inscrito = yogaManana.agregarMiembro(m1);
        System.out.println("Inscripción de " + m1.getNombre() + ": " + (inscrito ? "ÉXITO" : "FALLÓ"));
        
        // Crear un segundo miembro para llenar la capacidad (2/2)
        Miembro m2 = new Miembro();
        m2.setNombre("Ana García");
        m2.setId("M002");
        yogaManana.agregarMiembro(m2);

        // Intento de inscripción fallido (capacidad máxima es 2)
        Miembro m3 = new Miembro();
        m3.setNombre("Pedro Ruiz");
        m3.setId("M003");
        boolean inscritoFallido = yogaManana.agregarMiembro(m3);
        System.out.println("Inscripción de " + m3.getNombre() + ": " + (inscritoFallido ? "ÉXITO" : "FALLÓ"));

        // Mostrar disponibilidad después de los intentos
        System.out.println(yogaManana.mostrarDisponibilidad());
        
        // Mostrar lista de inscritos
        System.out.println("\nMiembros Inscritos en " + yogaManana.getNombreActividad() + ":");
        for (Miembro m : yogaManana.getMiembrosInscritos()) {
            System.out.println("- " + m.getNombre());
        }
    }
}
