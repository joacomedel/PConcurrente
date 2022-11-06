package TrabajoPractico6.ej2;

import java.util.Random;

public class GestorSala {
    //Monitor
    int temp;
    int cantPersonas;
    int maxPersonas;
    int tHumbral;
    int cantColaJubilados;
    public GestorSala(){
        cantPersonas=0;
        tHumbral = 30;
    }
    public synchronized void entrarSala() throws InterruptedException {
        boolean hayJubilado = (cantColaJubilados == 0);
        while(!hayJubilado && !hayLugar()){
            System.out.println("Persona no puede entra , espera");
            this.wait();}
        System.out.println("Entra Persona");
        cantPersonas++;
    }
    public synchronized void entrarSalaJubilado(String nombre) throws InterruptedException{
        cantColaJubilados++;
        while(!hayLugar()){
            System.out.println("Jubilado no puede entra , espera");
            wait();
        }
        System.out.println("Entra Jubilado");
        cantColaJubilados--;
        cantPersonas++;
    }
    public synchronized void salirSala(){
        
        cantPersonas--;
        this.notifyAll();
        System.out.println("Sale Persona/Jubilado");
    }
    public synchronized void notificarTemperatura(int temp){
        this.temp = temp;
        if (temp <= tHumbral) {
            maxPersonas = 50;
        }else maxPersonas = 30;
        System.out.println("Cambio temperatura a " + temp);
    }
    private synchronized boolean hayLugar(){
        //Si la temperatura es menor a 30 y hay menos de 50 personas puede entrar
        return cantPersonas <= maxPersonas;
    }
    
}
