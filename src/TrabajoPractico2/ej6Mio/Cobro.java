package TrabajoPractico2.ej6Mio;

public class Cobro implements Runnable {
    
    private int precioCobro;
    ClienteSM cliente;
    
    public void run() {
        precioCobro = 0;
        int cantProductos = cliente.getProductosComprados();
        for (int i = 0; i < cantProductos; i++) {
            precioCobro = precioCobro + cliente.getProductoSM(i).getPrecio();
        }
        
    }
    public int getPrecioCobro() {
        return precioCobro;
    }
    public Cobro (ClienteSM cliente){
        this.cliente = cliente;
    }
}
