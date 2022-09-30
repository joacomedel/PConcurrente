package TrabajoPractico4.ej7;

public class Control extends Thread{
    GestorCruce gestorCruce;

    public Control (GestorCruce gestorCruce){
        this.gestorCruce = gestorCruce;
    }
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                gestorCruce.cambiarSemaforos(i);
                Thread.sleep(40);
            } catch (Exception e) {}

        }
    }
}
