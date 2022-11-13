package TrabajoPractico6.ej7;

public class Canibal extends Thread {
    Olla olla;
    public Canibal(Olla olla){
        this.olla = olla;
    }
    @Override
    public void run() {
        try {olla.comer();} catch (InterruptedException e) {}
    }
}
