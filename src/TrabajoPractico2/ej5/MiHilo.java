package TrabajoPractico2.ej5;

import java.util.Scanner;

public class MiHilo implements Runnable {
    String nombreHilo;

    
    public MiHilo(String nombre){
    nombreHilo=nombre;
    }
    Scanner sc = new Scanner(System.in);
    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aquí
    public void run() {
        
        this.multiplicar(i, j);
        System.out.println("Comenzando " + nombreHilo);
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + nombreHilo + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando " + nombreHilo);
    }
    public void multiplicar(int i , int j){
        //
    }
    
}
