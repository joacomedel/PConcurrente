package TrabajoPractico5.ej6;

public class Persona extends Thread {
    Mirador mirador;
    public Persona (Mirador mirador){
        this.mirador = mirador;
    }
    @Override
    public void run() {
        try {
            mirador.usarTobogan();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
