package TrabajoPractico6.ej5;

public class Pastel {
    private final char tipo;
    private final static int[] pesos = {40,50,90};
    private final int peso;

    public Pastel(char tipo) {
        this.tipo = tipo;
        this.peso = pesos[(int) tipo % 3];
    }
    public int getPeso() {
        return peso;
    }
}
