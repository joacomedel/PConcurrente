package TrabajoPractico5.ej6;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[25];
        Mirador mirador = new Mirador();
        Encargado encargado = new Encargado(mirador);
        encargado.start();
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona(mirador);
            personas[i].start();
        }
    }
}
