package TrabajoPractico5.ej4;

import java.util.concurrent.Semaphore;

public class ControlTren extends Thread {
    Semaphore semVacio;
    Semaphore semLleno;
    Semaphore semPasajero;
    Semaphore semTicketMutex;
    Semaphore semTren;
    int n;
    public ControlTren (int n){
        this.n = n;
        semVacio = new Semaphore(n);
        semLleno = new Semaphore(0);
        semPasajero = new Semaphore(0);
        semTicketMutex = new Semaphore(0);
        semTren = new Semaphore(0);
    }
    public void subirse(String nombre) throws InterruptedException{
        semVacio.acquire();
        System.out.println(nombre + " pide ticket");
        semPasajero.release();
        semTicketMutex.acquire();
        semLleno.release();
        System.out.println(nombre + " se sube");
    }
    public void bajarse(String nombre) throws InterruptedException{
        System.out.println(nombre + " espera q llegue el tren");
        semTren.acquire();
        semVacio.release();
        System.out.println(nombre + " Se baja del tren");
    }
    public void darTicket() throws InterruptedException{
        semPasajero.acquire();
        System.out.println("Da ticket");
        semTicketMutex.release();
    }
    public void ir() throws InterruptedException{
        semLleno.acquire(n);
        System.out.println("tren termina de ir");
        semTren.release(n);
    }
    public void volver() throws InterruptedException{
        semVacio.acquire(n);
        semVacio.release(n);
        System.out.println("Tren termina de volver");
    }
}   
