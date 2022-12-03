package semestral.dbconx.Models;

public class Acerca {
    private int cod_acer;
    private String imagen;
    private String acerca;

    
    public Acerca(int cod_acer, String imagen, String acerca) {
        this.cod_acer = cod_acer;
        this.imagen = imagen;
        this.acerca = acerca;
    }
    public int getCod_acer() {
        return cod_acer;
    }
    public void setCod_acer(int cod_acer) {
        this.cod_acer = cod_acer;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getAcerca() {
        return acerca;
    }
    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }


}
