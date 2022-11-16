package TrabajoPractico6.ej5.Threads;

import java.util.Random;

import TrabajoPractico6.ej5.Pastel;
import TrabajoPractico6.ej5.RecursosCompartidos.Mostrador;

public class Horno extends Thread {
    Mostrador mostrador;
    int cantPasteles;
    char[] tipos = {'A','B','C'};
    public Horno(Mostrador mostrador){
        this.mostrador = mostrador;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < cantPasteles; i++) {
            mostrador.ponerPastel(new Pastel(tipos[random.nextInt(3)]));
        }
        
    }
}
