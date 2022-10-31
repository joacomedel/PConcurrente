package TrabajoPractico5.ej2;

public class Perro extends Thread {
    Comedero comedero;
    public Perro (Comedero comedero){
        this.comedero = comedero;
    }
    public void run() {
        try {comedero.comerPerro();}catch(Exception e){}
    }
}
    
