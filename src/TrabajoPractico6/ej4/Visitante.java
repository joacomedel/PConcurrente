package TrabajoPractico6.ej4;

public class Visitante extends Thread {
    boolean silla;
    Observatorio observatorio;
    public Visitante(Observatorio observatorio,boolean silla){
        this.observatorio = observatorio;
        this.silla = silla;
    }
    @Override
    public void run() {
        
    }
    
}