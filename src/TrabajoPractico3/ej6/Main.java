package TrabajoPractico3.ej6;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int maxElem = 50000;
        final int cantHilos = 5;
        final int elementosPorHilo = maxElem / cantHilos;
        int[] arreglo = new int[maxElem];
        cargarArreglo(arreglo);
        Sumador[] arregloHilos = new Sumador[cantHilos];
        
        for (int i = 0; i < cantHilos-1; i++) 
        {
            arregloHilos[i] = new Sumador(arreglo, elementosPorHilo*i, elementosPorHilo*(i+1));
            arregloHilos[i].start();
        }
        arregloHilos[cantHilos-1] = new Sumador(arreglo, elementosPorHilo*(cantHilos-1), elementosPorHilo*(cantHilos) + (maxElem % cantHilos));
        arregloHilos[cantHilos-1].start();

        for (int i = 0; i < cantHilos; i++) 
        {
            arregloHilos[i].join();
        }

        System.out.println("Concurrente: " + Sumador.getAcumuladorTotal());

        //Acumula de manera secuencial
        int acumulador = 0;
        for(int i : arreglo)
        {
            acumulador += i;
        }
        System.out.println("Secuencial: " +acumulador);
    }

    public static void cargarArreglo(int[] arreglo) {
        Random random = new Random();
        int longitud = arreglo.length;
        for (int i = 0; i < longitud; i++) {
            arreglo[i] = random.nextInt(10);
        }
    }
}
