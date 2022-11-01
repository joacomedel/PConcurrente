package TrabajoPractico5.ej4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ControlTren controlTren = new ControlTren(10);
        Tren tren = new Tren(controlTren);
        tren.start();
        VendedorTickets vendedorTickets = new VendedorTickets(controlTren);
        vendedorTickets.start();

        Pasajero[] pasajeros = new Pasajero[40];
        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero(controlTren, getNombre());
            pasajeros[i].start();
        }
    }
    public static String getNombre() {
        String[] nombres = {"Joaquin","Matias","Ignacio","Nacho"};
        String[] apellidos = {"Medel","Severini","Tartaglia","Perez"};
        Random random = new Random();
        return nombres[random.nextInt(4)]+ " "+ apellidos[random.nextInt(4)];
    }
}
