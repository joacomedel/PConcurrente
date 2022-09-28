package TrabajoPractico4.ej4;

import java.util.concurrent.Semaphore;

public class Imprenta {
    private Semaphore semHayHoja;
    private Semaphore semOcupado;
    private String hoja;

    public Imprenta () {
        semHayHoja = new Semaphore(0);
        semOcupado = new Semaphore(1);
    }
    public String agarrarHoja() throws InterruptedException {
        semHayHoja.acquire();
        return hoja;
    }
    public void terminoImprimir(){
        semOcupado.release();
    }
    public void agregarHoja(String hoja) throws InterruptedException{
        semOcupado.acquire();
        this.hoja = hoja;
        semHayHoja.release();
    }


}
