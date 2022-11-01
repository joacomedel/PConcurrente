package TrabajoPractico5.ej4;

public class VendedorTickets extends Thread {
    ControlTren controlTren;

    public VendedorTickets(ControlTren controlTren) {
        this.controlTren = controlTren;
    }

    public void run() {
        while (true) {
            try {
                controlTren.darTicket();
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
