package TrabajoPractico6.ej2;

import java.util.Random;

public class Persona extends Thread{
    GestorSala gestorSala;
    String nombre;
    public Persona(GestorSala gestorSala, String nombre){
        this.gestorSala = gestorSala;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        try {
            gestorSala.entrarSala();
            Random random = new Random();
            Thread.sleep(random.nextInt(40)+100);
            gestorSala.salirSala();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
