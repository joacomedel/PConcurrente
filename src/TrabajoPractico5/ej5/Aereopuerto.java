package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;

public class Aereopuerto {
    Semaphore semMutex;
    Semaphore semPista;
    Semaphore semAterrizar;
    Semaphore semDespegar;
    int cantAterrizaron;
    int cantDespegaron;
    boolean aterizarPrioridad = true;

    public void despegar() throws InterruptedException {
        semDespegar.acquire();
        semAterrizar.acquire();
        semMutex.acquire();
        cantDespegaron++;
        semMutex.release();
    }
    public void aterrizar(){
        cantAterrizaron++;
    }
}
