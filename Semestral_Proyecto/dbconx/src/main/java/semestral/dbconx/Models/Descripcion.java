package semestral.dbconx.Models;

public class Descripcion {
    private int cod_desc; 
    private String titulo; 
    private String imagen;
    private String descripcion;

 
    public Descripcion(int cod_desc, String titulo, String imagen, String descripcion) {
        this.cod_desc = cod_desc; 
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getCod_desc() {
        return cod_desc;
    }
    public void setCod_desc(int cod_desc) {
        this.cod_desc = cod_desc;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
