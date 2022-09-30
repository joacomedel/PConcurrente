package TrabajoPractico4.ej7;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    Semaphore norteSur;
    Semaphore oesteEste;

    public GestorCruce(){
        norteSur = new Semaphore(1,true);
        oesteEste = new Semaphore(0,true);
    }
    public void cambiarSemaforos(int i) throws Exception{
        if (i%2 == 0) {
            oesteEste.acquireUninterruptibly();
            norteSur.release();
        }else{
            norteSur.acquireUninterruptibly();
            oesteEste.release();
        }
    }
    public void llegadaOeste() throws InterruptedException{
        oesteEste.acquire();
        System.out.println("SALIENDO OESTE ESTE");
        oesteEste.release();
    }
    public void llegadaNorte() throws InterruptedException{
        norteSur.acquire();
        System.out.println("SALIENDO OESTE ESTE");
        norteSur.release();
    }
}
