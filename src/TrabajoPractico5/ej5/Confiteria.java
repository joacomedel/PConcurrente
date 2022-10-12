package TrabajoPractico5.ej5;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Buffer bufferComida;
    private Buffer bufferBebidas;
    private Semaphore semEspacio;
    public Confiteria (){
        bufferBebidas = new Buffer();
        bufferComida = new Buffer();
        semEspacio = new Semaphore(2);
    }
    public void cocinar() throws InterruptedException{
        Pedido ped = bufferComida.poll();
        ped.atender();
        semEspacio.release();

    }
    public void servirBebida() throws InterruptedException{
        Pedido ped = bufferBebidas.poll();
        ped.atender();
        semEspacio.release();
    }
    public void pedirBebida(Pedido ped) throws InterruptedException{
        semEspacio.acquire();
        bufferBebidas.add(ped);
        ped.salirPedido();
    }
    public void pedirComida(Pedido ped) throws InterruptedException{
        semEspacio.acquire();
        bufferComida.add(ped);
        ped.salirPedido();
    }
    public void pedirBebidaComida(Pedido pedB , Pedido pedC) throws InterruptedException{
        this.pedirBebida(pedB);
        this.pedirComida(pedC);
    }
}
