package TrabajoPractico6.ej6;


public class Main {
    public static void main(String[] args) {
        Donador[] donadores = new Donador[20];
        SalaDeEspera salaDeEspera = new SalaDeEspera();
        for (int i = 0; i < donadores.length; i++) {
            donadores[i] = new Donador(salaDeEspera,i);
            donadores[i].start();
        }
    }
}
