package TrabajoPractico5.ej7;

public class Main {
    public static void main(String[] args) {
        Babuino[] babuinos = new Babuino[20];
        Cuerda cuerda = new Cuerda();
        for (int i = 0; i < babuinos.length; i++) {
            babuinos[i] = new Babuino(cuerda);
            babuinos[i].start();
        }
    }
}
