package TrabajoPractico2.ej1;

public class testeoRecurso {
    public static void main (String[] args){
        Cliente juan=new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines=new Cliente ();
        ines.setName ("Ines Garcia");
        juan.start();
        ines.start();
    }
    }
