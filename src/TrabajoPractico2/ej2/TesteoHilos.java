package TrabajoPractico2.ej2;

class TesteoHilos{
    public static void main (String[] args){
    MiEjecucion miHilo= new MiEjecucion();
    miHilo.start();
    try {
        miHilo.hacerMas();
        miHilo.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println("En el main");
    }
    }
