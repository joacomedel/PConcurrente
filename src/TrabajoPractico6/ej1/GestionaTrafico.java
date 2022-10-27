package TrabajoPractico6.ej1;
import java.util.Random;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import EstructurasThreadSafe.*;
public class GestionaTrafico{
    Buffer<Integer> bufferNorte;
    Buffer<Integer> bufferSur;
    int autosCruzaron;
    boolean norteCruzan;
    int autosMax = 10;
    int cantMinima = 1;
    public GestionaTrafico(){
        bufferNorte = new Buffer<Integer>();
        bufferSur = new Buffer<Integer>();
        Random random = new Random();
        norteCruzan = random.nextBoolean();
    }
    public void entrarAutoSur(int id){
        bufferSur.add(id);
        System.out.println(id + "entra por el sur");
    }
    public void salirAutoNorte(int id) throws InterruptedException{
        boolean puedenCruzar = false;
        while (!puedenCruzar) {
            bufferSur.wait();
            if (!norteCruzan) {
                if (bufferSur.peek() == id) {
                    bufferSur.poll();
                    System.out.println(id + "cruzando hacia el norte");
                    autosCruzaron++;
                    
                    if (autosCruzaron >= autosMax && bufferSur.size() >= cantMinima)norteCruzan = true;
                }
            }
            
        }
    }
    public void entrarAutoNorte(int id){
        bufferNorte.add(id);
    }
    public void salirAutoSur(int id){

    }
    
    
}