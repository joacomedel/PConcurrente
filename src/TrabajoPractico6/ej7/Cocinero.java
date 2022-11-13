package TrabajoPractico6.ej7;

public class Cocinero extends Thread{
    Olla olla;
    public Cocinero(Olla olla){
        this.olla = olla;
    }
    @Override
    public void run() {
        while(true){
            try {olla.rellenarOlla();} catch (InterruptedException e) {}
        }
    }
}
