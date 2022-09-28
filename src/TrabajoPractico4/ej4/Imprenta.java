package TrabajoPractico4.ej4;

import java.util.concurrent.Semaphore;

public class Imprenta {
    private Semaphore semHayHoja;
    private Semaphore semHojaIn;
    public void impresoraImprime()throws InterruptedException{
        semHayHoja.acquire();
    }
    public Imprenta () {
        semHayHoja = new Semaphore(0);
    }
    public void añadirHoja() throws InterruptedException{
        semHayHoja.release();
        semHojaIn.acquire();
        
        semHojaIn.release();
    }

}
