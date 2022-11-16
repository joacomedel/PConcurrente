package TrabajoPractico6.ej5.RecursosCompartidos;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import TrabajoPractico6.ej5.Pastel;
import TrabajoPractico6.embotelladora.Caja;

public class ContenedorCaja {
    //recurso compartido entre empaquetadores y brazoAuxiliar
    LinkedList<Pastel> caja = new LinkedList<Pastel>();
    int pesoMaximo;
    Lock lock = new ReentrantLock(); 
    Condition condCajaValida = lock.newCondition();
    Condition condPuedeRetirar = lock.newCondition();
    boolean hayCaja = true;
    boolean cajaLlena = false;
    
    public void soltarPastel(Pastel pastel) throws InterruptedException{
        //empaquetador intenta poner su pastel en la caja
        lock.lock();
        boolean puedePoner = false;
        while (!puedePoner) {
            //intenta ponerlo hasta que pueda
            if (hayCaja && !cajaLlena) {
                if (puedePonerPastel(pastel)) {
                    caja.add(pastel);
                    puedePoner = true;
                }else{
                    //intenta poner y la caja ya esta llena , avisa al brazoMecanico 
                    cajaLlena=true;
                    condPuedeRetirar.signalAll();
                }
            }
            if (!puedePoner) {
                condCajaValida.await();
            }
        }
        lock.unlock();
    }
    public LinkedList<Pastel> retirarCaja() throws InterruptedException{
        LinkedList<Pastel> cajaRetorna;
        lock.lock();
        while (!cajaLlena) {
            condPuedeRetirar.await();
        }
        cajaRetorna = caja;
        hayCaja = false;
        caja = null;
        lock.unlock();
        return cajaRetorna;
        
    }
    public void reponerCaja(){
        lock.lock();
        hayCaja=true;
        cajaLlena=false;
        caja = new LinkedList<Pastel>();
        condCajaValida.signalAll();
        lock.unlock();
    }
    private boolean puedePonerPastel(Pastel pastel) {
        return pesoCaja()+pastel.getPeso() <= pesoMaximo; 
    }
    private int pesoCaja(){
        int retorna = 0;
        for (int i = 0; i < caja.size(); i++) {
            retorna += caja.get(i).getPeso();
        }
        return retorna;
    }
}
