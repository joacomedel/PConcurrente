package TrabajoPractico5.ej7;

import java.nio.file.ProviderMismatchException;
import java.util.concurrent.Semaphore;

import EstructurasThreadSafe.Color;

public class Cuerda {
    final private int cantCuerda = 5;
    final private Semaphore esperaNorte = new Semaphore(cantCuerda);
    final private Semaphore esperaSur = new Semaphore(cantCuerda);;
    final private Semaphore mutex = new Semaphore(1);
    private int cantCruzando = 0;
    private int permisosSur = cantCuerda;
    private int permisosNorte = cantCuerda;

    public void cruzarNorteEntrada() throws InterruptedException {
        System.out.println(Color.getGreen() + "Baubino del norte intenta entrar");
        mutex.acquire();
        if (permisosNorte == 0) {
            System.out.println(Color.getBlack() + "Babuino del norte no puede entrar , espera");
            mutex.release();
            esperaNorte.acquire();
            mutex.acquire();
        } else
            esperaNorte.acquire();

        permisosNorte--;
        if (cantCruzando == 0) {
            esperaSur.acquire(cantCuerda);
            permisosSur = 0;
            System.out.println(Color.getBlue() + "Baubino del norte entra y es el primero");
        } else
            System.out.println(Color.getCyan() + "Baubino del norte entra ");
        cantCruzando++;
        mutex.release();
    }

    public void cruzarNorteSalida() throws InterruptedException {
        mutex.acquire();
        cantCruzando--;
        if (cantCruzando == 0) {
            esperaSur.release(cantCuerda);
            permisosSur = cantCuerda;
            System.out.println(Color.getBlue() + "Baubino del norte sale y es el ultimo");
        } else
            System.out.println(Color.getCyan() + "Baubino del norte sale ");
        permisosNorte++;
        esperaNorte.release();
        mutex.release();
    }

    public void cruzarSurEntrada() throws InterruptedException {
        System.out.println(Color.getRed() + "Baubino del sur intenta entrar");
        mutex.acquire();
        if (permisosSur == 0) {
            System.out.println(Color.getBlack() + "Babuino del sur no puede entrar , espera");
            mutex.release();
            esperaSur.acquire();
            mutex.acquire();
        } else
            esperaSur.acquire();

        permisosSur--;
        if (cantCruzando == 0) {
            esperaNorte.acquire(cantCuerda);
            permisosNorte = 0;
            System.out.println(Color.getYellow() + "Baubino del sur entra y es el primero");
        } else
            System.out.println(Color.getPurple() + "Baubino del sur entra ");
        cantCruzando++;
        mutex.release();
    }

    public void cruzarSurSalida() throws InterruptedException {
        mutex.acquire();
        cantCruzando--;
        if (cantCruzando == 0) {
            esperaNorte.release(cantCuerda);
            permisosNorte = cantCuerda;
            System.out.println(Color.getYellow() + "Baubino del sur sale y es el ultimo");
        } else
            System.out.println(Color.getPurple() + "Baubino del sur sale ");
        permisosSur++;
        esperaSur.release();
        mutex.release();
    }
}
