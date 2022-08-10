package alquilerBarcos;

import java.util.ArrayList;
import java.util.Date;

import alquilerBarcos.tipoDeBarco.Deportivos;
import alquilerBarcos.tipoDeBarco.Veleros;
import alquilerBarcos.tipoDeBarco.YateDeLujo;


public class SistemaBarcos {
    private ArrayList<Barco> colBarcos = new ArrayList<Barco>();
    private ArrayList<Cliente> colCliente = new ArrayList<Cliente>();
    private ArrayList<Alquiler> colAlquiler = new ArrayList<Alquiler>();

    
    public Cliente newCliente(String nombre , String apellido, int dni){
        Cliente clienteOut = new Cliente(nombre, apellido, dni);
        colCliente.add(clienteOut);
        return clienteOut;
    }
    public Veleros newVelero(int matricula,int metrosEslora,Date fechaFabricacion,int mastiles){
        Veleros veleroOut = new Veleros(matricula, metrosEslora, fechaFabricacion, mastiles);
        colBarcos.add(veleroOut);
        return veleroOut;
    }
    public Deportivos newDeportivo(int matricula,int metrosEslora,Date fechaFabricacion,int CV){
        Deportivos deportivoOut = new Deportivos(matricula, metrosEslora, fechaFabricacion, CV);
        colBarcos.add(deportivoOut);
        return deportivoOut;
    }
    public YateDeLujo newYate(int matricula,int metrosEslora,Date fechaFabricacion,int CV, int camarotes){
        YateDeLujo yateOut = new YateDeLujo(matricula, metrosEslora, fechaFabricacion, CV, camarotes);
        colBarcos.add(yateOut);
        return yateOut;
    }
    public Alquiler newAlquiler (Cliente cliente, Barco barco,int posicionAmarre){
        Alquiler alquilerOut = new Alquiler(posicionAmarre, barco,cliente);
        colAlquiler.add(alquilerOut);
        return alquilerOut;
    }
}
