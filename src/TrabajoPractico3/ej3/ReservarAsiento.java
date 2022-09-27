package TrabajoPractico3.ej3;

import TrabajoPractico2.ej1.ThreadExtends;

public class ReservarAsiento extends Thread {
    private int x;
    private int y;
    private String propietario;
    private Estadio estadio;
    @Override
    public void run() {
        estadio.ReservarAsiento(x, y, propietario);
    }
    public ReservarAsiento (int x , int y , String propietario){
        this.x= x;
        this.y= y;
        this.propietario = propietario;
    }
}
