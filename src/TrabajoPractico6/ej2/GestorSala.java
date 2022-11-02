package TrabajoPractico6.ej2;


public class GestorSala {
    //Monitor
    int temp;
    int cantPersonas;
    int tHumbral;
    int cantColaJubilados;
    public GestorSala(){
        cantPersonas=0;
        tHumbral = 30;
    }
    public synchronized void entrarSala() throws InterruptedException {
        boolean noHayJubilado = (cantColaJubilados != 0);
        while(!(noHayJubilado && (getHumb1() || getHumb2())))this.wait();
        cantPersonas++;
    }
    public synchronized void entrarSalaJubilado(String nombre) throws InterruptedException{
        cantColaJubilados++;
        while(!(getHumb1() || getHumb2()))wait();
        cantColaJubilados--;
        cantPersonas++;
    }
    public synchronized void salirSala(){
        cantPersonas--;
        this.notifyAll();
    }
    public synchronized void notificarTemperatura(int temp){
        this.temp = temp;
    }
    private synchronized boolean getHumb1(){
        return (temp <= tHumbral && cantPersonas <= 50);
    }
    private synchronized boolean getHumb2(){
        return (temp > tHumbral && cantPersonas <=35);
    }
}
