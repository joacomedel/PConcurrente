package TrabajoPractico3.ej4;

import TrabajoPractico3.ej2.Main;

public class Jaula {
    public static void main(String[] args) {
        final int hamsCant = 4;
        final String rojo = "\u001B[31m";
        final String azul = "\u001B[34m";
        final String verde = "\u001B[32m";
        final String amarillo = "\u001B[33m";
        Actividad actividadAr[] = {new Actividad("Correr"),new Actividad("Hamaca"), new Actividad("Descansar")};
        Hamster hamsterAr[] = new Hamster[hamsCant];
        hamsterAr[0] = new Hamster("pepito", actividadAr , rojo);
        hamsterAr[1] = new Hamster("juanito", actividadAr , azul);
        hamsterAr[2] = new Hamster("lolito", actividadAr , verde);
        hamsterAr[3] = new Hamster("panchito", actividadAr , amarillo);
        for (int i = 0; i < hamsCant; i++) {
            hamsterAr[i].start();
        }
        
        
    }
}
