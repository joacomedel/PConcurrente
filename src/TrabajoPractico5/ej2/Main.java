package TrabajoPractico5.ej2;

public class Main {
    public static void main(String[] args) {
        Perro[] perros = new Perro[10];
        Gato[]  gatos = new Gato[10];
        Comedero comedero = new Comedero(10);
        for (int i = 0; i < 10; i++) {
            gatos[i] = new Gato(comedero);
            perros[i] = new Perro(comedero);
            gatos[i].start();
            perros[i].start();
        }
    }
}
