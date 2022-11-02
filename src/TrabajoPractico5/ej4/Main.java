package TrabajoPractico5.ej4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        ControlTren controlTren = new ControlTren(10);
        Tren tren = new Tren(controlTren);
        tren.start();
        VendedorTickets vendedorTickets = new VendedorTickets(controlTren);
        vendedorTickets.start();

        Pasajero[] pasajeros = new Pasajero[20];
        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero(controlTren,getNombre()+i);
            pasajeros[i].start();
        }
    }
    public static String getNombre() {
        String[] nombres = {"Joaquin","Mateo","Ignacio","Nacho"};
        String[] apellidos = {"Illesca","Severini","Lopez","Perez"};
        Random random = new Random();
        return nombres[random.nextInt(4)]+ " "+ apellidos[random.nextInt(4)];
    }
}
