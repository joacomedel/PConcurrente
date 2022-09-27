package TrabajoPractico3.ej2.Personajes;

public abstract class Personaje  {
    protected int vida;
    protected int dañoFisico;
    protected int dañoMagico;
    //Se puede agregar mas atributos como arm , armMagica
    // Se puede implementar un sistema de vida maxima
    public void dañar (Personaje pj){
        pj.recibirDaño((int)((dañoFisico*2)+(dañoMagico*0.5)));
    }
    protected synchronized void  recibirDaño(int daño){
        //System.out.println("Vida Actual : " + vida);
        //System.out.println("RECIBO DAÑO : " + daño);
        vida = vida - daño;
        //System.out.println("Vida Actualizada : " + vida);
    }
    protected synchronized void recibirCuracion(int cantCuracion) {
        //System.out.println("Vida Actual : " + vida);
        //System.out.println("RECIBO CURACION : " + cantCuracion);
        vida += cantCuracion;
        //System.out.println("Vida Actualizada : " + vida);
    }
    public Personaje(int vida , int dañoFisico , int dañoMagico){
        this.vida = vida;
        this.dañoFisico = dañoFisico;
        this.dañoMagico = dañoMagico;
    }
    public int getVida() {
        return vida;
    }
}
