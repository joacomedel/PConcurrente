package TrabajoPractico5.ej1;

public class Mozo extends Thread {
    Confiteria conf;
    public Mozo (Confiteria conf){
        this.conf = conf; 
    }
    @Override
    public void run() {
        while(true){
            try {
                conf.servirBebida();
            } catch (InterruptedException e) {}
        }
    }
}
