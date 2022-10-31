package TrabajoPractico6.ej1;

import java.util.Random;

import EstructurasThreadSafe.*;

public class GestionaTrafico {
    Buffer<Integer> bufferNorte;
    Buffer<Integer> bufferSur;
    int autosCruzaron;
    boolean norteCruzan;
    int autosMax = 5;
    int autosMin = 1;

    public GestionaTrafico() {
        bufferNorte = new Buffer<Integer>();
        bufferSur = new Buffer<Integer>();
        Random random = new Random();
        norteCruzan = random.nextBoolean();
    }

    public synchronized void entrarAutoSur(int id) {
        bufferSur.add(id);
        System.out.println(id + " entra por el sur");
    }

    public synchronized void salirAutoNorte(int id) throws InterruptedException {
        while (!(!norteCruzan && id == (int) bufferSur.peek()))
            this.wait();

        bufferSur.poll();
        autosCruzaron++;
        System.out.println(id + " sale hacia el norte");
        if (autosCruzaron > autosMax && bufferNorte.size() >= autosMin) {
            // los del sur dejan de cruzar hacia el norte , empiezan a cruzar del norte
            norteCruzan = true;
            autosCruzaron = 0;
        }
        this.notifyAll();
    

    }

    public synchronized void entrarAutoNorte(int id) {
        bufferNorte.add(id);
        System.out.println(id + " entra por el norte");
    }

    public synchronized void salirAutoSur(int id) throws InterruptedException {
        while (!(norteCruzan && id == (int) bufferNorte.peek()))
            this.wait();
        bufferNorte.poll();
        autosCruzaron++;
        System.out.println(id + " sale hacia el sur");
        if (autosCruzaron > autosMax && bufferNorte.size() >= autosMin) {
            norteCruzan = false;
            autosCruzaron = 0;
        }
        this.notifyAll();

    }

}