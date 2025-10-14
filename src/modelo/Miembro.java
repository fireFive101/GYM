package modelo;

public class Miembro extends Persona{

  private String fechaRegistro;

  public String getFecharegistro() {
        return fechaRegistro;
  }

  public void setFecharegistro(String fecharegistro) {
        this.fechaRegistro = fecharegistro;
  }
  

  @Override
  public String toString() {
        return "Miembro{" +
                "nombre='" + getNombre() + '\'' +
                ", id='" + getId() + '\'' +
                ", tel='" + getTel() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }
}
