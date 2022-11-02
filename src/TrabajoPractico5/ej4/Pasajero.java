package TrabajoPractico5.ej4;

public class Pasajero extends Thread {
    ControlTren controlTren;
    String nombre;
    public Pasajero(ControlTren controlTren,String nombre) {
        this.controlTren = controlTren;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        try {
            controlTren.subirse(nombre);
            controlTren.bajarse(nombre);
        } catch (InterruptedException e) {
        }
    }
}
