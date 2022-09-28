package TrabajoPractico4.ej4;
import java.util.concurrent.Semaphore;

public class Impresora extends Thread {
    private String hoja;
    private Imprenta imprenta;

    public Impresora (Imprenta imprenta) {
        this.imprenta = imprenta; 
        
    }
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println(imprenta.agarrarHoja());
                imprenta.terminoImprimir();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }


}
