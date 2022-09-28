package TrabajoPractico4.ej6;

import java.util.concurrent.Semaphore;

public class Sala {
    Semaphore semMozoOcupado;
    Semaphore semEntroEmpleado;
    Semaphore semMozoTermino;
    //Semaphore semSaleEmpleado;
    public Sala (){
        semMozoOcupado = new Semaphore(1);
        semEntroEmpleado = new Semaphore(0,true);
        semMozoTermino = new Semaphore(0);
        //semSaleEmpleado = new Semaphore(0);
    }
    public void esperarCliente() throws InterruptedException {
        semEntroEmpleado.acquire();
    }
    public void atenderCliente() throws InterruptedException{
        semMozoTermino.release();
        semMozoTermino.acquire();
    }
    public void entraEmpleado() throws InterruptedException{
        semMozoOcupado.acquire();
        semEntroEmpleado.release();
        semMozoTermino.acquire();

    }
    public void saleEmpleado(){
        semMozoOcupado.release();
    }
}
