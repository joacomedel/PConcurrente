package TrabajoPractico5.ej5;

public class Chef extends Thread{
    Confiteria conf;
    public Chef (Confiteria conf){
        this.conf = conf;
    }
    @Override
    public void run() {
        while (true) {
            try {
                conf.cocinar();
            } catch (InterruptedException e) {}
        }
    }
}
