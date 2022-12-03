package semestral.dbconx.Models;

public class Paises {
    private int codpais;
    private String nombre;
    private int moro;
    private int mplata;
    private int mbronce;

    
    public Paises(int codpais, String nombre, int moro, int mplata, int mbronce) {
        this.codpais = codpais;
        this.nombre = nombre;
        this.moro = moro;
        this.mplata = mplata;
        this.mbronce = mbronce;
    }
    public int getCodpais() {
        return codpais;
    }
    public void setCodpais(int codpais) {
        this.codpais = codpais;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getMoro() {
        return moro;
    }
    public void setMoro(int moro) {
        this.moro = moro;
    }
    public int getMplata() {
        return mplata;
    }
    public void setMplata(int mplata) {
        this.mplata = mplata;
    }
    public int getMbronce() {
        return mbronce;
    }
    public void setMbronce(int mbronce) {
        this.mbronce = mbronce;
    }

}
