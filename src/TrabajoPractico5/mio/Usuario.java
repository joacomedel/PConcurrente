package TrabajoPractico5.mio;

import java.util.concurrent.Semaphore;

public class Usuario extends Thread {
    String hoja;
    Imprenta imprenta;
    int numInicio;
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            try {
                imprenta.agregarHoja("Hoja numero " + (i+numInicio));
            } catch (Exception e) {}
        }    
    }
    public Usuario (Imprenta imprenta, int numInicio){
        this.imprenta= imprenta;
        this.numInicio = numInicio;

    }

}
