package TrabajoPractico5.ej1;

public class Cliente extends Thread{
    Confiteria conf;
    Pedido pedA;
    Pedido pedB;
    String tipo;
    public Cliente (Confiteria conf,String tipo,Pedido pedA){
        this.pedA = pedA;
        this.conf = conf;
        this.tipo = tipo;

    }
    public Cliente (Confiteria conf,Pedido pedA, Pedido pedB){
        this.pedA = pedA;
        this.pedB = pedB;
        this.conf = conf;
    }
    @Override
    public void run() {
        try {
            switch (tipo) {
                case "B":
                    conf.pedirBebida(pedA);
                    break;
                case "C":
                    conf.pedirComida(pedA);
                    break;
                case "BC":
                    conf.pedirBebidaComida(pedA,pedB);
                    break;
            }
        } catch (Exception e) {}
    }
}
