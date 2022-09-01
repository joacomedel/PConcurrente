package TrabajoPractico3.ej2;

import TrabajoPractico3.ej2.Personajes.Personaje;
import TrabajoPractico3.ej2.Personajes.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Jugador humano = new Jugador(100, 2, 4);
        Ogro ogro = new Ogro(50, 40, 20);
        Curandero curandero = new Curandero(30, 20, 40);
        Dañar dañar = new Dañar(ogro, humano);
        Curar curar = new Curar(curandero, humano);
        dañar.start();
        curar.start();
        dañar.join();
        curar.join();
        System.out.println("Termino");
    }
}
