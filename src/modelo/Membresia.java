package modelo;

import java.util.List;

public class Membresia {
    
    // Atributos
    private String tipo;
    private double costoMensual;
    private List<String> beneficios;

    // Constructor
    public Membresia(String tipo, double costoMensual, List<String> beneficios) {
        this.tipo = tipo;
        this.costoMensual = costoMensual;
        this.beneficios = beneficios;
    }

    // Métodos del Diagrama UML
    
    public List<String> obtenerBeneficios() {
        return this.beneficios;
    }

    public double calcularCostoAnual() {
        return this.costoMensual * 12;
    }

    public void actualizarCosto(double nuevoCosto) {
        this.costoMensual = nuevoCosto;
    }
    
    // Getters y Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getCostoMensual() { return costoMensual; }
    public void setCostoMensual(double costoMensual) { this.costoMensual = costoMensual; }
    
    public void setBeneficios(List<String> beneficios) { this.beneficios = beneficios; }

    @Override
    public String toString() {
        return "Membresía: " + tipo + " | Costo Mensual: $" + costoMensual;
    }
}