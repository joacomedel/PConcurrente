package TrabajoPractico6.ej1;
public class Main {
    public static void main(String[] args) {
        GestionaTrafico gestionaTrafico = new GestionaTrafico();
        final int cantAutos = 20;
        Auto[] autos = new Auto[cantAutos];
        for (int i = 0; i < cantAutos; i++) {
            if (i % 2 ==0) {
                autos[i] = new Auto('S', gestionaTrafico, i);
            }else {autos[i] = new Auto('N', gestionaTrafico, i);}
            autos[i].start();
        }
        


    }

}
