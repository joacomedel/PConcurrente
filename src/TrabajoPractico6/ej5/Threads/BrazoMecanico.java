package TrabajoPractico6.ej5.Threads;

import java.util.LinkedList;

import TrabajoPractico6.ej5.Pastel;
import TrabajoPractico6.ej5.RecursosCompartidos.ContenedorCaja;

public class BrazoMecanico extends Thread{
    ContenedorCaja contenedorCaja;
    LinkedList<Pastel> caja;
    public BrazoMecanico (ContenedorCaja contenedorCaja){
        this.contenedorCaja = contenedorCaja;
    }
    @Override
    public void run() {
        try {
            caja = contenedorCaja.retirarCaja();
            Thread.sleep(40);
            caja = null;
            contenedorCaja.reponerCaja();
        } catch (InterruptedException e) {
        }
        
    }
}
