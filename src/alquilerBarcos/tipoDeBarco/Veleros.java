package alquilerBarcos.tipoDeBarco;

import java.util.Date;

import alquilerBarcos.Barco;

public class Veleros extends Barco {
    private int mastiles;
    public Veleros (int matricula,int metrosEslora,Date fechaFabricacion,int mastiles){
        //incializarBarco(matricula,metrosEslora,fechaFabricacion);
        super(matricula,metrosEslora,fechaFabricacion);
        this.mastiles = mastiles;

    }
    

    public int obtenerModulo (){
        int modulo = super.obtenerModulo()+mastiles;
        return modulo;
    } 
}
