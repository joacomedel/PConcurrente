package TrabajoPractico4.ej4;

import java.util.concurrent.Semaphore;

public class Impresora extends Thread{
    private char tipo;
    private Semaphore semEsperaHoja;
    private Semaphore semOcupado;
    private String aImprimir;
    public Impresora(char tipo){
        this.tipo = tipo;
        semEsperaHoja = new Semaphore(1);
        semOcupado = new Semaphore(1);
        try {
            semOcupado.release();
            semEsperaHoja.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        int i = 0;
        while (i<=2) {
            try {
                semEsperaHoja.acquire();
                semOcupado.acquire();
                System.out.println("Intentado imprimir");
                Thread.sleep(7);
                System.out.println("Logro imprimir: " + aImprimir);
                aImprimir = "";
                semOcupado.release();
            } catch (Exception e) {}
            i++;
        }
    }
    public boolean imprimirIntenta(String aImprimir){
        boolean bool = false;
        this.aImprimir= aImprimir;
        if (semOcupado.tryAcquire()) {
            semEsperaHoja.release();
            bool = true;
        }
        return bool;
    }
    public void imprimirEspera(String aImprimir){
        this.aImprimir= aImprimir;
        try {
            semOcupado.acquire();
            semEsperaHoja.release();
        } catch (Exception e) {
        }
    }
    public char getTipo() {
        return tipo;
    } 
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
