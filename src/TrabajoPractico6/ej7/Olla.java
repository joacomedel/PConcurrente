package TrabajoPractico6.ej7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import EstructurasThreadSafe.Color;

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
            System.out.println(Color.getRed() + "Canival no encontro comida , le avisa al cocinero y espera");
            vacia.signal();
            yaLlena.await();
            System.out.println(Color.getWhite() + "Cocinero le avisa que ya esta lleno");
            //Es un while ya que en lo que me avisa y vuelvo a intentar comer pueden haber terminado la comida
        } //Si la olla tiene comida , como y me voy
        System.out.println(Color.getBlue() + "Canival come , Ahora hay " + comidaCant);
        comidaCant--;
        lock.unlock();
    }
    public void rellenarOlla() throws InterruptedException{
        lock.lock();
        while (comidaCant > 0) {
            //Si entro y la olla tiene comida , espero a que se vacie 
            System.out.println(Color.getYellow() + "Encontro la olla llena y espera que se vacie");
            vacia.await();
            System.out.println(Color.getYellow() + "Le avisaron q la olla se vacio");
        }//Si cuando entro ya esta la olla vacia directamente la lleno
        yaLlena.signalAll();
        comidaCant = comidaMax;
        System.out.println(Color.getGreen() + "Llena la olla" + "Ahora hay " + comidaCant);
        lock.unlock();
    }
}

