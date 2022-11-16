package TrabajoPractico6.ej5.Threads;

import javax.swing.text.DefaultEditorKit.PasteAction;

import TrabajoPractico6.ej5.Pastel;
import TrabajoPractico6.ej5.RecursosCompartidos.ContenedorCaja;
import TrabajoPractico6.ej5.RecursosCompartidos.Mostrador;

public class Empaquetador extends Thread {
    Mostrador mostrador;
    ContenedorCaja contenedorCaja;
    Pastel pastel;
    public Empaquetador(Mostrador mostrador,ContenedorCaja contenedorCaja){
        this.mostrador = mostrador;
        this.contenedorCaja = contenedorCaja;
    }
    public void run() {
        while(true){
        try {
            pastel = mostrador.tomarPastel();
            contenedorCaja.soltarPastel(pastel);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }   
    }
}
