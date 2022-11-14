package TrabajoPractico5.ej5;

public class Avion extends Thread {
    int tipo;
    Aereopuerto aereopuerto;

    public Avion (int tipo ,Aereopuerto aereopuerto){
        this.tipo = tipo;
        this.aereopuerto = aereopuerto;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }
}
