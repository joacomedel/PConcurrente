package TrabajoPractico6.ej2;

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
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        gestorSala.salirSala();
    }
}
