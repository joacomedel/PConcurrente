package TrabajoPractico3.ej2;
import TrabajoPractico3.ej2.Personajes.Curandero;
import TrabajoPractico3.ej2.Personajes.Personaje;

public class Curar extends Thread {
    Curandero curandero;
    Personaje curado;
    @Override
    public void run() {
        curandero.Curar(curado);
    }
    public Curar (Curandero curandero,Personaje pj){
        this.curandero = curandero;
        this.curado = pj;
    }
}
