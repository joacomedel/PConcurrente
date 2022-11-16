package TrabajoPractico5.ej5;

import java.util.Random;

public class Avion extends Thread {
    Aereopuerto aereopuerto;

    public Avion (Aereopuerto aereopuerto){
        this.aereopuerto = aereopuerto;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            if (random.nextBoolean()) {
                aereopuerto.despegar();
            }else{
                aereopuerto.aterrizar();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
