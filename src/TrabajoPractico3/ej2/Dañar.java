package TrabajoPractico3.ej2;

import TrabajoPractico3.ej2.Personajes.Personaje;

public class Dañar extends Thread {
    Personaje personajeDañado;
    Personaje personajeDañador;//??
    @Override
    public void run() {
        personajeDañador.dañar(personajeDañado);
    }
    public Dañar (Personaje personajeDañador,Personaje pj){
        this.personajeDañador = personajeDañador;
        this.personajeDañado = pj;
    }
}
