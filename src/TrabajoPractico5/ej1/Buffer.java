package TrabajoPractico5.ej1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private Semaphore semBuffer;
    private Queue<Pedido> buffer;
    public Buffer (){
        semBuffer = new Semaphore(0);
        buffer = new LinkedList<Pedido>();
    }
    public  Pedido poll() throws InterruptedException{
        Pedido ped;
        semBuffer.acquire();
        synchronized (this){
            ped = buffer.poll();
        }
        return ped;
    }
    public  void add(Pedido ped){
        synchronized (this){
            buffer.add(ped);
        }
        semBuffer.release();
    }
}
