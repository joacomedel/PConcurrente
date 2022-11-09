package TrabajoPractico6.embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica {
    private final Lock lock = new ReentrantLock();
    private final Caja[] cajas = {new Caja(),new Caja()};
    private final Condition esperaCaja = lock.newCondition();
    private boolean hayCajasLlenas;
    public int empaquetarCajas() throws InterruptedException {
        lock.lock();
        int retorna = 0;
        while(!hayCajasLlenas){
            System.out.println("Espera una caja");
            esperaCaja.await();
            System.out.println("Termino de esperar alguna caja");
        } 
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].getLlena()) {
                retorna += cajas[i].empaquetar();
            }
        }
        hayCajasLlenas = false;
        lock.unlock();
        return retorna;
    }
    public void embotellar(int i) throws InterruptedException{
        if (cajas[i].embotellar()) {
            lock.lock();
            hayCajasLlenas = true;
            esperaCaja.signal();
            lock.unlock();
        }
    }
}

