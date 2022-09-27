package TrabajoPractico3.ej7;

public class ImprimirLetra extends Thread{
    char c;
    Patron patron;
    public ImprimirLetra (char c , Patron patron ){
        this.c = c;
        this.patron = patron;
    }
    @Override
    public void run() {
        
    }
}
