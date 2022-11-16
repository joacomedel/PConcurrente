package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;



public class Aereopuerto {
    Semaphore semMutex;
    Semaphore semPista = new Semaphore(1);
    Semaphore semPistaAterrizar = new Semaphore(1);
    Semaphore semPistaDespegue = new Semaphore(1);
    int cantAterrizaron = 0;
    int colaDespegue = 0;
    int colaAterrizaje = 0;
    boolean aterizarPrioridad = true;
    int tiempoTarea = 15;
    int estado = 1; // Estado 1 , Cualquiera pasa , Estado 2 Despegue tiene prioridad , Estado 3
                    // aterrizar tiene prioridad

    public void despegar() throws InterruptedException {
        
    }
    public void aterrizar() throws InterruptedException {
        
    }
    public void aterrizarTerminar(){
        

    }

}
