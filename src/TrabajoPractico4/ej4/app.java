package TrabajoPractico4.ej4;

public class app {
    public static void main(String[] args) {
        Imprenta imprenta = new Imprenta(2, 2);
        for (int i = 0; i < 4; i++) {
            imprenta.imprimirTipoA("Impresion A numero : " + i);
            //imprenta.imprimirTipoB("Impresion B numero : " + i);
        }
    }
}
