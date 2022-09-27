package TrabajoPractico3.ej6;

public class Sumador extends Thread {
    private int[] arreglo;
    private int inicio;
    private int fin;
    private int acumulador;
    static int acumuladorTotal;
    public Sumador(int[] arreglo,int inicio , int fin){
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
    }
    public void run() {
        for (int i = inicio; i < fin; i++) {
            acumulador = acumulador + arreglo[i];
        }
        acumular(this.acumulador);
    }
    public int getAcumulador() {
        return acumulador;
    }
    public static synchronized void acumular(int acumulador){
        Sumador.acumuladorTotal += acumulador;
    }
    public static int getAcumuladorTotal() {
        return Sumador.acumuladorTotal;
    }
    public static void setAcumuladorTotal(int acumuladorTotal) {
        Sumador.acumuladorTotal = acumuladorTotal;
    }
}
