package TrabajoPractico5.ej2;

import java.util.Random;
import java.util.concurrent.Semaphore;



public class Comedero {
    int n; //Espacio comedor
    int maxCambio;
    Semaphore semGatos;
    Semaphore semPerros;
    Semaphore mutex;
    boolean primeraEntrada = true;
    int cantEnComedero = 0;
    //int cantComieron = 0;
    
    public Comedero(int n,int maxCambio){
        this.n = n;
        semGatos = new Semaphore(n);
        semPerros = new Semaphore(n);
        mutex = new Semaphore(1);
    }
    public void comerPerro()throws InterruptedException {
        mutex.acquire();
        if (primeraEntrada) {
            System.out.println("Primera Entrada Perro");
            primeraEntrada = false;
            semGatos.acquire(n);
        }
        mutex.release();
        semPerros.acquire();
        //ystem.out.println(semPerros.availablePermits() + " Permisos del Perro");
        mutex.acquire();
        cantEnComedero++;
        System.out.println("Cantidad en el comedero " + cantEnComedero);
        mutex.release();
        System.out.println("Come el perro");
        dormir();
        salePerro();
    }
    public void salePerro() throws InterruptedException{
        semPerros.release();
        mutex.acquire();
        cantEnComedero--;
        System.out.println("Cantidad en el comedero " + cantEnComedero);
        if (cantEnComedero == 0) {
            semGatos.release(n);
            primeraEntrada = true;
            System.out.println("Sale el ultimo perro");
        }else System.out.println("Sale un perro");
        mutex.release();
    }
    public void comerGato()throws InterruptedException{
        mutex.acquire();
        if (primeraEntrada) {
            System.out.println("Primera Entrada Gato");
            primeraEntrada = false;
            semPerros.acquire(n);
        }
        mutex.release();
        semGatos.acquire();
        //System.out.println(semGatos.availablePermits() + " Permisos del gato");
        mutex.acquire();
        cantEnComedero++;
        //cantComieron++;
        System.out.println("Cantidad en el comedero " + cantEnComedero);
        mutex.release();
        System.out.println("Come el gato");
        dormir();
        saleGato();
    }
    public void saleGato()throws InterruptedException{
        semGatos.release();
        mutex.acquire();
        cantEnComedero--;
        System.out.println("Cantidad en el comedero " + cantEnComedero);
        if (cantEnComedero == 0) {
            semPerros.release(n);
            primeraEntrada=true;
            System.out.println("Sale el ultimo Gato");
        }else System.out.println("Sale un gato");
        mutex.release();
    }
    public void dormir()throws InterruptedException{
        Random random = new Random();
        Thread.sleep(random.nextInt(15));
    }

}

