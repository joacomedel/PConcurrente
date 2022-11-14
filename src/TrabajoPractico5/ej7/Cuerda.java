package TrabajoPractico5.ej7;

import java.util.concurrent.Semaphore;

import EstructurasThreadSafe.Color;

public class Cuerda {
    //Semaphore cuerda = new Semaphore(5);;
    final private Semaphore esperaNorte = new Semaphore(5);
    final private Semaphore esperaSur = new Semaphore(5);;
    final private Semaphore mutex = new Semaphore(1);
          private int cantCruzando = 0 ;
    final private int cantCuerda = 5;
    final private int tiempoTarea = 25;
    public void cruzarNorte() throws InterruptedException {
        System.out.println(Color.getGreen() + "Baubino del norte intenta entrar");
        esperaNorte.acquire();
        mutex.acquire();
        if (cantCruzando == 0) {
            esperaSur.acquire(cantCuerda);
            System.out.println(Color.getBlue() +"Baubino del norte entra y es el primero");
        }else System.out.println(Color.getCyan() +"Baubino del norte entra ");
        cantCruzando++;
        mutex.release();
        
        Thread.sleep(tiempoTarea);
        mutex.acquire();
        cantCruzando--;
        if (cantCruzando == 0) {
            esperaSur.release(cantCuerda);
            System.out.println(Color.getBlue() +"Baubino del norte sale y es el ultimo");
        }else System.out.println(Color.getCyan() +"Baubino del norte sale ");
        mutex.release();
        esperaNorte.release();
    }
    public void cruzarSur() throws InterruptedException {
        System.out.println(Color.getRed() +"Baubino del sur intenta entrar");
        esperaSur.acquire();
        mutex.acquire();
        if (cantCruzando == 0) {
            esperaNorte.acquire(cantCuerda);
            System.out.println(Color.getYellow() + "Baubino del sur entra y es el primero");
        } else System.out.println(Color.getPurple() + "Baubino del sur entra ");
        cantCruzando++;
        mutex.release();
        Thread.sleep(tiempoTarea);
        mutex.acquire();
        cantCruzando--;
        if (cantCruzando == 0) {
            esperaNorte.release(cantCuerda);
            System.out.println(Color.getYellow() + "Baubino del sur sale y es el ultimo");
        } else System.out.println(Color.getPurple() + "Baubino del sur sale ");
        mutex.release();
        esperaSur.release();
    }
}
