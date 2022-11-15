package TrabajoPractico5.ej6;

public class Encargado extends Thread {
    Mirador mirador;
    public Encargado(Mirador mirador){
        this.mirador = mirador;
    }
    @Override
    public void run() {
        while(true){
            try {
                mirador.controlarTobogan();
            } catch (InterruptedException e) {}
        }
    }
}
