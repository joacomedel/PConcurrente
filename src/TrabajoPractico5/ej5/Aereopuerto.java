package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;

import javax.swing.plaf.synth.SynthMenuItemUI;

public class Aereopuerto {
    Semaphore semMutex;
    //Semaphore semPista;
    Semaphore semPistaAterrizar = new Semaphore(1);
    Semaphore semPistaDespegue = new Semaphore(1);
    int cantAterrizaron;
    int cantDespegaron;
    boolean aterizarPrioridad = true;
    int tiempoTarea = 15;

    public void despegar() throws InterruptedException {
        semPistaDespegue.acquire();
        

    }
    public void aterrizar() throws InterruptedException{

    }
}
