package TrabajoPractico5.ej4;

public class Tren extends Thread {
    ControlTren controlTren;

    public Tren(ControlTren controlTren) {
        this.controlTren = controlTren;
    }

    @Override
    public void run() {
        while (true) {
            try {
                controlTren.ir();
                controlTren.volver();
            } catch (Exception e) {
            }
        }
    }
}
