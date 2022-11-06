package TrabajoPractico6.ej2;

import java.util.Random;

public class NotificarTemperatura extends Thread {
    GestorSala gestorSala;
    public NotificarTemperatura (GestorSala gestorSala){
        this.gestorSala = gestorSala;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            gestorSala.notificarTemperatura(random.nextInt(11)+25);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        
    }
}
