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
                cruzarNorteASur();
            }else{
                cruzarSurANorte();
            }
        } catch (InterruptedException e) {}
    }
    public void dormir() throws InterruptedException{
        Thread.sleep(20);
    }
    public void cruzarNorteASur() throws InterruptedException{
        cuerda.cruzarNorteEntrada();
        this.dormir();
        cuerda.cruzarNorteSalida();
    }
    public void cruzarSurANorte() throws InterruptedException{
        cuerda.cruzarSurEntrada();
        this.dormir();
        cuerda.cruzarSurSalida();
    }
}
