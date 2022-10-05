package TrabajoPractico5.ej4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import javax.management.Query;

public class Imprenta {
    private Semaphore semBufferHoja;
    private Semaphore mutexBuffer;
    private Semaphore semOcupado;
    private Queue<String> buffer;

    public Imprenta () {
        buffer = new LinkedList<String>();
        semBufferHoja = new Semaphore(0);
        //semOcupado = new Semaphore(1);
        mutexBuffer = new Semaphore(1);
    }
    public String agarrarHoja() throws InterruptedException {
        String hoja;
        semBufferHoja.acquire();
        mutexBuffer.acquire();
        hoja = buffer.poll();
        mutexBuffer.release();
        return hoja;
    }
    public void terminoImprimir(){
        //semOcupado.release();
    }
    public void agregarHoja(String hoja) throws InterruptedException{
        //semOcupado.acquire();
        //this.hoja = hoja;
        //mutexBuffer.acquire();
        buffer.add(hoja);
        //mutexBuffer.release();
        semBufferHoja.release();
    }


}
