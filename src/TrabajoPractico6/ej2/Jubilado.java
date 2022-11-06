package TrabajoPractico6.ej2;

import java.util.Random;

public class Jubilado extends Thread{
    GestorSala gestorSala;
    String nombre;
    public Jubilado(GestorSala gestorSala, String nombre){
        this.gestorSala = gestorSala;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        try {
            gestorSala.entrarSalaJubilado(nombre);
            Random random = new Random();
            Thread.sleep(random.nextInt(40)+100);
            gestorSala.salirSala();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
