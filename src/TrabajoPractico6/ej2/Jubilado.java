package TrabajoPractico6.ej2;

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
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        gestorSala.salirSala();
    }
}
