package semestral.dbconx.Models;

public class Login {
    private int cod_log;
    private String correo;
    private String contraseña;

    
    public Login(int cod_log, String correo, String contraseña) {
        this.cod_log = cod_log;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public int getCod_log() {
        return cod_log;
    }
    public void setCod_log(int cod_log) {
        this.cod_log = cod_log;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
   
}
