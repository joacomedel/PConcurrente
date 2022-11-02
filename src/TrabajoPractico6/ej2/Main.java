package TrabajoPractico6.ej2;

public class Main {
    public static void main(String[] args) {
        GestorSala gestorSala = new GestorSala();
        Persona[] personas = new Persona[80];
        Jubilado[] jubilados = new Jubilado[40];
        NotificarTemperatura notificador = new NotificarTemperatura(gestorSala);
        for (int i = 0; i < jubilados.length; i++) {
            personas[i] = new Persona(gestorSala, null);
            personas[i*2]= new Persona(gestorSala, null);
            jubilados[i] = new Jubilado(gestorSala, null);
            personas[i].start();
            jubilados[i].start();
            personas[i+1].start();
        }
    }
}
