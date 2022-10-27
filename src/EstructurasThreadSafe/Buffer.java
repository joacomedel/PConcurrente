package EstructurasThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class Buffer<E> {
    private Semaphore semBuffer;
    private Queue<E> buffer;
    public Buffer (){
        semBuffer = new Semaphore(0);
        buffer = new LinkedList<E>();
    }
    
    public  E poll() throws InterruptedException{
        E ped;
        semBuffer.acquire();
        synchronized (this){
            ped = buffer.poll();
        }
        return ped;
    }
    public  void add(E ped){
        synchronized (this){
            buffer.add(ped);
        }
        semBuffer.release();
    }
    public synchronized E peek (){
        return buffer.peek();
        
    }
    public synchronized int size (){
        return buffer.size();
    }
    
}
