package TrabajoPractico6.ej6;


import EstructurasThreadSafe.Buffer;
import EstructurasThreadSafe.Color;


public class SalaDeEspera {
    private int camillas;
    private int revistas;
    private Buffer<Integer> entradas;

    public SalaDeEspera(){
        camillas = 4;
        revistas = 9;
        entradas = new Buffer<Integer>();
    }
    public synchronized void entrarSalaDeEspera(int id) throws InterruptedException{
        boolean tieneRevista = false;
        System.out.println(Color.getBlack() + id + " intenta entrar");
        entradas.add(id);
        while (!siguienteEnCamillas(id) ) {
            //Si no hay camillas intenta agarrar revista y esperar
            if(!tieneRevista && revistas > 0){
                revistas--; //Si no tiene revistas , y hay revistas disponibles agarra una 
                tieneRevista = true;
                System.out.println(Color.getBlue() +id +" Agarro revista y espera");
            }else System.out.println(Color.getCyan() + id +" Espera");
            this.wait();
        }
        entradas.poll();
        if (tieneRevista){
            //Si cuando agarro la camilla tenia revista , la deja 
            tieneRevista = false;
            revistas++;
            System.out.println(Color.getGreen() +id + " Agarra camilla y deja revista");
            this.notify();
        }else  System.out.println(Color.getWhite() +id +" Agarra camilla");
        camillas--;
    }
    public synchronized void salirSalaDeEspera(int id){
        camillas++;
        System.out.println(Color.getRed() +id + " sale " + Color.reset());
        this.notifyAll();
    }
    public synchronized boolean siguienteEnCamillas(int id){
        return camillas > 0 && id == entradas.peek();
    }
}
