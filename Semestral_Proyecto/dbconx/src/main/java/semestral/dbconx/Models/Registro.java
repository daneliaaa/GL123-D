package semestral.dbconx.Models;

public class Registro {
    private String correo;
    private String nombre;
    private String contraseña;

    
    public Registro(String correo, String nombre, String contraseña) {
        this.correo = correo;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
