package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;

public class Pedido {
    private boolean terminado;
    private Semaphore atendido;
    private String nombre;
    public Pedido(String nombre){
        this.nombre = nombre;
        atendido = new Semaphore(0);
        terminado = false;
    }
    public void atender(){
        terminado = true;
        atendido.release();
    }
    public void salirPedido() throws InterruptedException{
        atendido.acquire();
    }
}
