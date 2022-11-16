package TrabajoPractico6.ej5.RecursosCompartidos;

import java.rmi.ConnectIOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.text.DefaultEditorKit.PasteAction;

import EstructurasThreadSafe.Color;
import TrabajoPractico6.ej5.Pastel;

public class Mostrador {
    //recurso compartido entre horno y empaquetadores
    Lock lock = new ReentrantLock();
    Queue<Pastel> pasteles = new LinkedList<Pastel>();
    Condition condHayPastel = lock.newCondition();

    public void ponerPastel(Pastel pastel){
        //Horno entra y deja un pastel en la que
        lock.lock();
        System.out.println(Color.getWhite() + "Horno agrega pastel");
        pasteles.add(pastel);
        condHayPastel.signal();
        //Avisa por las dudas al Empaquetador, que puso un pastel 
        lock.unlock();
    }
    public Pastel tomarPastel() throws InterruptedException{
        //Empaquetador entra y toma un pastel , si no hay espera a que se genere
        Pastel pastel;
        lock.lock();
        if (pasteles.size() == 0) {
            //Si no hay pasteles espera a que el horno de alguno
            System.out.println(Color.getBlack() + "No hay pasteles , empaquetador espera");
            condHayPastel.await();
            System.out.println(Color.getBlack() + "Termino de esperar , toma el pastel");
        }else System.out.println(Color.getBlack() + "Empaquetador toma el pastel sin esperar ");
        //Si hay pasteles , entonces no espera nada
        pastel = pasteles.poll();
        lock.unlock();
        return pastel;
    }

}
