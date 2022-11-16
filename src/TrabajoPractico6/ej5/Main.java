package TrabajoPractico6.ej5;

import TrabajoPractico6.ej5.RecursosCompartidos.ContenedorCaja;
import TrabajoPractico6.ej5.RecursosCompartidos.Mostrador;
import TrabajoPractico6.ej5.Threads.BrazoMecanico;
import TrabajoPractico6.ej5.Threads.Empaquetador;
import TrabajoPractico6.ej5.Threads.Horno;

public class Main {
    public static void main(String[] args) {
        ContenedorCaja contenedorCaja = new ContenedorCaja();
        Mostrador mostrador = new Mostrador();
        Horno horno = new Horno(mostrador);
        horno.start();
        Empaquetador[] empaquetadores = new Empaquetador[2];
        BrazoMecanico brazoMecanico = new BrazoMecanico(contenedorCaja);
        brazoMecanico.start();
        for (int i = 0; i < empaquetadores.length; i++) {
            empaquetadores[i] = new Empaquetador(mostrador, contenedorCaja);
            empaquetadores[i].start();
        }
    }
}
