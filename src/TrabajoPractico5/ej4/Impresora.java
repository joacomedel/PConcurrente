package TrabajoPractico5.ej4;
import java.util.concurrent.Semaphore;

public class Impresora extends Thread {
    private Imprenta imprenta;
    private String nombre;
    public Impresora (Imprenta imprenta ,String nombre) {
        this.imprenta = imprenta;
        this.nombre = nombre; 
    }
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                String hoja;
                hoja = imprenta.agarrarHoja();
                System.out.println("IMPRESORA " + nombre +" IMPRIME: "+ hoja);
                imprenta.terminoImprimir();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }


}
