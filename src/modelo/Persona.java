package modelo;

public class Persona{

  private String nombre;
  private String id;
  private String tel;
  private String email;
  private String fechaRegistro;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecharegistro(){
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro){
        this.fechaRegistro = fechaRegistro;
    }
    
  
}

