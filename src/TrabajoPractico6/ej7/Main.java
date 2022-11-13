package TrabajoPractico6.ej7;

public class Main {
    public static void main(String[] args) {
        Canibal[] canibales = new Canibal[50];
        Olla olla = new Olla();
        Cocinero cocinero = new Cocinero(olla);
        for (int i = 0; i < canibales.length; i++) {
        canibales[i] = new Canibal(olla);
        canibales[i].start();    
        }
        cocinero.start();
    }
}
