package TrabajoPractico3.ej3;

public class Estadio {
    private Asiento[][] matrizAsientos;
    private String nombre;
    public Estadio (int x , int y , String nombre ){
        matrizAsientos = new Asiento[x][y];
        this.nombre = nombre;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrizAsientos[x][y]= new Asiento();
            }
        }

    }
    public synchronized boolean ReservarAsiento(int x , int y , String propietario){
        boolean reservado = false;
        if (!matrizAsientos[x][y].getOcupado()) {
            matrizAsientos[x][y].setOcupado(true);
            matrizAsientos[x][y].setPropietario(propietario);
        }
        return reservado;
    }
    public String getNombre() {
        return nombre;
    }
}
