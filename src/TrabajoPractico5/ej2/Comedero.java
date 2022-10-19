package TrabajoPractico5.ej2;

import java.util.concurrent.Semaphore;


public class Comedero {
    int n;
    Semaphore semGatos;
    Semaphore semPerros;
    Semaphore mutex;
    boolean primeraEntrada = true;
    boolean hayGatos;
    public Comedero (int n){
        this.n = n;
        semGatos = new Semaphore(n);
        semPerros = new Semaphore(n);
        mutex = new Semaphore(1);
    }
    public void comerPerro () throws InterruptedException{
        semPerros.acquire(1);
        if (semGatos.tryAcquire(n)) {
            
        }
        
    }
    public void comerGato () throws InterruptedException{
        semGatos.acquire(1);
        if (semPerros.tryAcquire(n)) {
            
        }
        
        
    }
    public synchronized boolean entraPrimero(){
        boolean retorna;
        retorna = primeraEntrada;
        primeraEntrada = false;
        return retorna;
    }
    public synchronized void ultimaSalida(){
        primeraEntrada = true;
    }
}

