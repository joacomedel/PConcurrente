package TrabajoPractico6.embotelladora;

import java.util.Random;

public class Embotellador extends Thread{
    
    Fabrica fabrica;
    public Embotellador(Fabrica fabrica){
        this.fabrica = fabrica;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (;;) {
        try {
            fabrica.embotellar((random.nextInt(2)));
        } catch (Exception e) {}
        }
    }
}
