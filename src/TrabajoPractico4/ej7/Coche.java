package TrabajoPractico4.ej7;

import java.util.jar.Attributes.Name;

public class Coche extends Thread{
    String nombre;
    GestorCruce gestorCruce;
    char llegada;
    public Coche (String nombre,GestorCruce gestorCruce,char llegada){
        this.nombre = nombre;
        this.gestorCruce = gestorCruce;
        this.llegada = llegada;
    }
    @Override
    public void run() {
        cruzar();
    }
    public void cruzar(){
        try {
            if (llegada == 'O') {
                gestorCruce.llegadaOeste();
            }
            if (llegada == 'N') {
                gestorCruce.llegadaNorte();
            }
        } catch (Exception e) {cruzar();}

    }
}
