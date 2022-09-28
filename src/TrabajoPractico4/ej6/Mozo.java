package TrabajoPractico4.ej6;

public class Mozo extends Thread {
    Sala sala;
    public Mozo (Sala sala){
        this.sala = sala;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sala.esperarCliente();
                sala.atenderCliente();
            } catch (Exception e) {}
        }
    }
}
