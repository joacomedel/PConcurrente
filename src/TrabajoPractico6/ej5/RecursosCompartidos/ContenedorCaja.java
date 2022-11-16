package TrabajoPractico6.ej5.RecursosCompartidos;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import EstructurasThreadSafe.Color;
import TrabajoPractico6.ej5.Pastel;

public class ContenedorCaja {
    //recurso compartido entre empaquetadores y brazoAuxiliar
    LinkedList<Pastel> caja = new LinkedList<Pastel>();
    int pesoMaximo = 500;
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
                    System.out.println(Color.getGreen() + "Pongo el pastel en la caja");
                    caja.add(pastel);
                    puedePoner = true;
                }else{
                    //intenta poner y la caja ya esta llena , avisa al brazoMecanico 
                    System.out.println(Color.getPurple() + "Intento poner el pastel , pero estaba lleno , avisa");
                    cajaLlena=true;
                    condPuedeRetirar.signalAll();
                }
            }
            if (!puedePoner) {
                System.out.println(Color.getRed() + "No pudo poner pastel , espera");
                condCajaValida.await();
            }
        }
        lock.unlock();
    }
    public LinkedList<Pastel> retirarCaja() throws InterruptedException{
        LinkedList<Pastel> cajaRetorna;
        lock.lock();
        while (!cajaLlena) {
            System.out.println(Color.getYellow() + "La caja no esta llena , espera a que se llene");
            condPuedeRetirar.await();
            System.out.println(Color.getYellow() + "Termino de esperar");
        }
        System.out.println(Color.getYellow() + "La caja esta llena se la lleva ");
        cajaRetorna = caja;
        hayCaja = false;
        caja = null;
        lock.unlock();
        return cajaRetorna;
        
    }
    public void reponerCaja(){
        lock.lock();
        System.out.println(Color.getCyan() + "repone la caja");
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
