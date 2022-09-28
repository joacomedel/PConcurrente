package TrabajoPractico4.ej4;

public class Impresora extends Thread {
    Imprenta imprenta;
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                imprenta.impresoraImprime();
                Thread.sleep(20);
                System.out.println("CLAK CLANK CLANKKS");
            } catch (InterruptedException e) {
            }
        }
    }
}
