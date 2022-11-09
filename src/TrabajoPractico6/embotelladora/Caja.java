package TrabajoPractico6.embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caja {
    private int cantBotella = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition vacia = lock.newCondition();

    public boolean embotellar() throws InterruptedException{
        lock.lock();
        while (cantBotella >= 10) {
            System.out.println("Espera que se vacie");
            vacia.await();
            System.out.println("Termino de esperar q se vacie");
        }
        cantBotella++;
        lock.unlock();
        return cantBotella == 10;
    }
    public int empaquetar(){
        lock.lock();
        int retorna;
        retorna = cantBotella;
        cantBotella = 0;
        vacia.signalAll();
        lock.unlock();
        return retorna;
    }
    public boolean getLlena() {
        lock.lock();
        boolean retorna = cantBotella == 10;
        lock.unlock();
        return retorna;
    }


}
