package TrabajoPractico6.ej6;


public class Donador extends Thread {
    SalaDeEspera salaDeEspera;
    int id;
    public Donador (SalaDeEspera salaDeEspera,int id){
        this.salaDeEspera = salaDeEspera;
        this.id = id;
    }
    @Override
    public void run() {
        try {
            salaDeEspera.entrarSalaDeEspera(id);
            Thread.sleep(40);
            } catch (InterruptedException e){}
        salaDeEspera.salirSalaDeEspera(id);
    }
}
