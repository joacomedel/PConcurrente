package TrabajoPractico4.ej4;

public class Imprenta {
    private int poscUltimoIntentoA;
    private int poscUltimoIntentoB;
    private Impresora[] impresorasA;
    private Impresora[] impresorasB; 
    public Imprenta (int tipoAMax , int tipoBMax){
        impresorasA = new Impresora[tipoAMax];
        impresorasB = new Impresora[tipoBMax];
         poscUltimoIntentoA = 0;
         poscUltimoIntentoB = 0;
            for (int i = 0; i < tipoAMax; i++) {
            //TIPOA
            impresorasA[i]= new Impresora('A');
            impresorasA[i].start();
        }
        for (int j = 0; j < tipoBMax; j++) {
            //TIPOB
            impresorasB[j]= new Impresora('B');
            impresorasB[j].start();
        }
        System.out.println("Termina Creacion IMPRENTA");
    }
    public void imprimirTipoA(String aImprimir) {
        int i = 0;
        boolean imprimio;
        do {
            imprimio = impresorasA[i].imprimirIntenta(aImprimir);
            i++;
        } while (!imprimio && i < impresorasA.length);
        if (!imprimio) {
            int t;
            synchronized(this){
                t = poscUltimoIntentoA;
                poscUltimoIntentoA++;
            }
            impresorasA[t].imprimirEspera(aImprimir);
        }
    } 
    public void imprimirTipoB(String aImprimir) {
        int i = 0;
        boolean imprimio;
        do {
            imprimio = impresorasB[i].imprimirIntenta(aImprimir);
            i++;
        } while (!imprimio && i < impresorasB.length);
        if (!imprimio) {
            int t;
            synchronized(this){
                t = poscUltimoIntentoB;
                poscUltimoIntentoB++;
            }
            impresorasB[t].imprimirEspera(aImprimir);
        }
    }
    public void imprimir(String aImprimir) {
        //DE MANERA RANDOM MANDA A IMPRIMIER EN A O B
    }
    public synchronized void sumarIntentoA(){
        poscUltimoIntentoA++;
    }
    public synchronized void sumarIntentoB(){
        poscUltimoIntentoB++;
    }
    
}
