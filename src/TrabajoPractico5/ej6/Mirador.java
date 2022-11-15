package TrabajoPractico5.ej6;

import java.util.concurrent.Semaphore;

import EstructurasThreadSafe.Color;

public class Mirador {
    
    Semaphore semEscalera = new Semaphore(10,true);
    Semaphore semToboganes = new Semaphore(2);
    Semaphore semEncargado = new Semaphore(0);

    public void usarTobogan() throws InterruptedException {
        System.out.println(Color.getBlack() + "Intenta entrar a la escalera");
        semEscalera.acquire();
        System.out.println(Color.getRed() + "Intenta entrar al tobogan");
        semToboganes.acquire();
        System.out.println(Color.getYellow() + "Entro al tobogan y libera la escalera");
        semEscalera.release();
        Thread.sleep(15);
        semEncargado.release();
        System.out.println(Color.getWhite() + "Termino de usar el tobogan le avisa al encargado");
    }
    public void controlarTobogan() throws InterruptedException{
        System.out.println(Color.getBlue() + "Espera que alguna persona termine de usar el tobogan");
        semEncargado.acquire();
        semToboganes.release();
        System.out.println(Color.getCyan() + "Deja q alguna persona use el tobogan");
    }


}
