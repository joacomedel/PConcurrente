package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;

import org.w3c.dom.events.MutationEvent;




public class Aereopuerto {
    Semaphore semMutex = new Semaphore(1);
    Semaphore semPista = new Semaphore(1);
    Semaphore puedeAterrizar = new Semaphore(0);
    Semaphore puedeDespegar = new Semaphore(0);
    int aterrizaronSeguido = 0;
    int colaDespegue = 0;
    int colaAterrizaje = 0;
    int tiempoTarea = 15;

    public void despegar() throws InterruptedException {
        semMutex.acquire();
        colaDespegue++;
        if (colaAterrizaje > 0) {
            semMutex.release();
            puedeDespegar.acquire();
            semPista.acquire();
            aterrizaronSeguido = 0;
            semPista.release();
            puedeAterrizar.release();
        }else {
            semMutex.release();
            semPista.acquire();
            semMutex.acquire();
            aterrizaronSeguido = 0;
            semMutex.release();
            semPista.release();
        }
    }
    public void aterrizar() throws InterruptedException {
        semMutex.acquire();
        

    }

    

}
