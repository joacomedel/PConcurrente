package TrabajoPractico6.embotelladora;
;

public class Empaquetador extends Thread{
    Fabrica fabrica;
    int botellas;
    Almacen almacen;
    public Empaquetador (Fabrica fabrica,Almacen almacen){
        this.fabrica = fabrica;
        this.almacen = almacen;
        botellas =0; 
    }
    public void run() {
        while (true) {
            try {
                botellas += fabrica.empaquetarCajas();
                System.out.println(botellas);
            } catch (InterruptedException e) {}
        }
    }
}
