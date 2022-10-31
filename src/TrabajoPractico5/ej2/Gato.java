package TrabajoPractico5.ej2;

public class Gato extends Thread{
    Comedero comedero;
    public Gato (Comedero comedero){
        this.comedero = comedero;
    }
    public void run() {
        try {comedero.comerGato();}catch(Exception e){}
    }
}
