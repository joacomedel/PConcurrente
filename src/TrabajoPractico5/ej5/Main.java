package TrabajoPractico5.ej5;

public class Main {
    public static void main(String[] args) {
        Avion[] aviones = new Avion[20];
        Aereopuerto aereopuerto = new Aereopuerto();
        for (int i = 0; i < aviones.length; i++) {
            aviones[i]= new Avion(aereopuerto);
            aviones[i].start();
        }
    }
}
