package TrabajoPractico3.ej2.Personajes;

public class Curandero extends Personaje {
    public Curandero(int vida, int dañoFisico, int dañoMagico) {
        super(vida, dañoFisico, dañoMagico);
        //TODO Auto-generated constructor stub
    }

    public void Curar(Personaje pj) {
        pj.recibirCuracion(dañoMagico * 2);
    } // Se puede implementar un sistema de vida maxima
}
