package TrabajoPractico6.embotelladora;

public class Main {
    public static void main(String[] args) {
        Embotellador[] embotellador = new Embotellador[10];
        Fabrica fabrica = new Fabrica();
        Almacen almacen = new Almacen();
        Empaquetador empaquetador = new Empaquetador(fabrica,almacen);
        for (int i = 0; i < embotellador.length; i++) {
            embotellador[i]=new Embotellador(fabrica);
            embotellador[i].start();
        }
        empaquetador.start();
        
    }
}
