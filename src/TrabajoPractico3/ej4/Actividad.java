package TrabajoPractico3.ej4;

public class Actividad {
    private String nombre;
    private boolean enUso;

    public Actividad (String nombre){
        this.nombre = nombre;
        enUso = false;
    }
    public synchronized boolean usar(){
        boolean retorno = false;
        if (!enUso) {
            enUso = true;
            retorno = true;
        }
        return retorno;
    }
    public void dejarDeUsar(){
        enUso = false;
    }
    public String getNombre() {
        return nombre;
    }

}
