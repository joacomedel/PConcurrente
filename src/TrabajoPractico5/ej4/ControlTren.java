package TrabajoPractico5.ej4;

import java.util.concurrent.Semaphore;

public class ControlTren extends Thread {
    
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String PURPLE = "\u001B[35m";
    
    Semaphore semVacio;
    Semaphore semLleno;
    Semaphore semPasajero;
    Semaphore semTicketMutex;
    Semaphore semTren;
    Semaphore semVolver;
    int n;
    public ControlTren (int n){
        this.n = n;
        semVacio = new Semaphore(n,true); //Semaforo q toman los pasajero para no subirse de mas
        semLleno = new Semaphore(0); //Semaforo que liberan los pasajeros para que el tren viaje 
        semPasajero = new Semaphore(0); //Semaforo que libera el pasajero para que el Vendedor imprima un ticket
        semTicketMutex = new Semaphore(0,true); //Semaforo que libera el vendedor para que el pasajero ya tenga su ticket
        semTren = new Semaphore(0,true);  //Semaforo que libera el tren cuando llegue 
        semVolver = new Semaphore(0); //Semaforo que libera los pasajero al bajarse para indicarle al tren cuando volver
    }
    public void subirse(String nombre) throws InterruptedException{
        System.out.println(GREEN + nombre + " pide ticket");
        semPasajero.release();
        semTicketMutex.acquire();
        semVacio.acquire();
        semLleno.release();
        System.out.println(RED + nombre + " se sube");
    }
    public void bajarse(String nombre) throws InterruptedException{
        semTren.acquire();
        semVolver.release();
        System.out.println(PURPLE + nombre + " Se baja del tren");
    }
    public void darTicket() throws InterruptedException{
        semPasajero.acquire();
        System.out.println(WHITE + "Da ticket");
        semTicketMutex.release();
        Thread.sleep(1); //sacamos el hilo de ejecucion para q continue el pasajero
        
    }
    public void ir() throws InterruptedException{
        semLleno.acquire(n);
        System.out.println(BLUE + "tren termina de ir");
        semTren.release(n);
    }
    public void volver() throws InterruptedException{
        semVolver.acquire(n);
        semVacio.release(n); //Libero para que puedan volver a subir pasajeros 
        System.out.println(YELLOW + "Tren termina de volver");
    }
}   
