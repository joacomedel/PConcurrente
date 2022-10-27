package TrabajoPractico6.ej1;
public class Auto extends Thread{
    char tipo;
    int id;
    GestionaTrafico gestionaTrafico;
    public Auto (char tipo , GestionaTrafico gestionaTrafico, int id){
        this.tipo = tipo;
        this.gestionaTrafico = gestionaTrafico;
        this.id = id;
    }
    public void run() {
        cruzar();
    }
    public void cruzar(){
        switch (tipo) {
            case 'S':
                gestionaTrafico.entrarAutoSur(id);
                gestionaTrafico.salirAutoNorte(id);
                break;
            case 'N':
                gestionaTrafico.entrarAutoNorte(id);
                gestionaTrafico.salirAutoSur(id);
                break;
        }
    }
}
