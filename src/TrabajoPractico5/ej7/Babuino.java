package TrabajoPractico5.ej7;

import java.util.Random;

public class Babuino extends Thread {
    Cuerda cuerda;
    public Babuino(Cuerda cuerda){
        this.cuerda = cuerda;
    }
    @Override
    public void run() {
        Random random = new Random();
        try {
            if (random.nextBoolean()) {
                cuerda.cruzarNorte();
            }else{
                cuerda.cruzarSur();
            }
        } catch (InterruptedException e) {}
    }
}
