package TrabajoPractico4.ej7;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    Semaphore norteEntrada;
    Semaphore oesteEntrada;
    Semaphore surSalida;
    Semaphore esteSalida;


    public GestorCruce(){
        norteEntrada = new Semaphore(1,true);
        oesteEntrada = new Semaphore(1,true);
        surSalida = new Semaphore(1,true);
        esteSalida = new Semaphore(1,true);
    }
    public void cambiarSemaforos(int i) throws Exception{
        if (i%2 == 0) {
            System.out.println("Inteto habilitar paso este");
            surSalida.acquire();
            System.out.println("HABILITO PASO ESTE");
            esteSalida.release();
        }else{
            System.out.println("Inteto habilitar paso sur");
            esteSalida.acquire();
            System.out.println("HABILITO PASO SUR");
            surSalida.release();
            
        }
    }
    public void llegadaOeste() throws InterruptedException{
        oesteEntrada.acquire();
        System.out.println("LLEGO OESTE");
        salirEste();
    }
    public void llegadaNorte() throws InterruptedException{
        norteEntrada.acquire();
        System.out.println("LLEGO NORTE");
        salirSur();
        
    }
    private void salirEste() throws InterruptedException{
        esteSalida.acquire();
        esteSalida.release();
        oesteEntrada.release();
        System.out.println("SALGO ESTE");
    }
    private void salirSur() throws InterruptedException{
        surSalida.acquire();
        surSalida.release();
        System.out.println("SALGO SUR ");
        norteEntrada.release();
        
    }
}
