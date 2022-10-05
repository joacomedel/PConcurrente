package TrabajoPractico5.ej4;

public class App {
    public static void main(String[] args) {
        Imprenta imprenta = new Imprenta();
        Impresora impresora2 = new Impresora(imprenta , "impresora 2");
        Impresora impresora = new Impresora(imprenta, "impresora 1");
        Usuario usuario = new Usuario(imprenta,0);
        Usuario usuario2 = new Usuario(imprenta,5);
        impresora.start();
        impresora2.start();
        usuario.start();
        usuario2.start();
    }
    
}
