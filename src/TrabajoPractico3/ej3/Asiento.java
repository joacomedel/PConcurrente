package TrabajoPractico3.ej3;

public class Asiento {
    private String propietario;
    private boolean ocupado;
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public boolean getOcupado(){
        return ocupado;
    }
    public Asiento (){
        ocupado = false;
        propietario = "";
    } 
}
