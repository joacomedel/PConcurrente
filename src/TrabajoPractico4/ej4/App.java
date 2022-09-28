package TrabajoPractico4.ej4;

public class App {
    public static void main(String[] args) {
        Imprenta imprenta = new Imprenta();
        Impresora impresora = new Impresora(imprenta);
        Usuario usuario = new Usuario(imprenta,0);
        Usuario usuario2 = new Usuario(imprenta,5);
        impresora.start();
        usuario.start();
        usuario2.start();
    }
    
}
