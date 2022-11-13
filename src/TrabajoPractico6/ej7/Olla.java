package TrabajoPractico6.ej7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {
    private Lock lock = new ReentrantLock();
    private Condition vacia = lock.newCondition();
    private Condition yaLlena = lock.newCondition();
    private int comidaMax = 10;
    private int comidaCant = comidaMax; //La olla arranca llena 

    public void comer() throws InterruptedException {
        lock.lock();
        while(comidaCant < 0){
            //Si la olla esta vacia le aviso al cocinero , y espero q la llene 
            vacia.signal();
            yaLlena.await();
        } //Si la olla tiene comida , como y me voy
        comidaCant--;
        lock.unlock();
    }
    public void rellenarOlla() throws InterruptedException{
        lock.lock();
        while (comidaCant > 0) {
            //Si entro y la olla tiene comida , espero a que se vacie 
            vacia.await();
        }//Si cuando entro ya esta la olla vacia directamente la lleno
        yaLlena.signalAll();
        comidaCant = comidaMax;
        lock.unlock();
    }
}

