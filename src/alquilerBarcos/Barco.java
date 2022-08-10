package alquilerBarcos;

import java.util.Date;

public abstract class Barco {
    protected int matricula;
    protected int metrosEslora;
    protected Date fechaFabricacion;
    protected boolean alquilado;
    protected void incializarBarco(int matricula,int metrosEslora,Date fechaFabricacion) {
        this.matricula = matricula;
        this.metrosEslora = metrosEslora;
        this.fechaFabricacion = fechaFabricacion;
    }
    public boolean esEsteBarco(int matricula){
        return this.matricula == matricula;
    }
}
