
package agencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class Vuelo implements Serializable{
    private int nroVuelo;
    private Date fechaYhora;
    private String origenDestino;
    private int asientosTotal;
    private int asientosDisponibles;
    private boolean clase;
    private Pantalla pantalla;
    private Teclado teclado;

    public Vuelo(int nroVuelo,Date fechaYhora, String origenDestino, int asientosTotal, int asientosDisponibles) {
        this.nroVuelo = nroVuelo;
        this.fechaYhora = fechaYhora;
        this.origenDestino = origenDestino;
        this.asientosTotal = asientosTotal;
        this.asientosDisponibles = asientosDisponibles;
        pantalla=new Pantalla();
        teclado=new Teclado ();
    }// fin del constructor de Vuelo

    public int getNroVuelo() {
        return nroVuelo;
    }

    public void setNroVuelo(int nroVuelo) {
        this.nroVuelo = nroVuelo;
    }

    public Date getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(Date fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public String getOrigenDestino() {
        return origenDestino;
    }

    public void setOrigenDestino(String origenDestino) {
        this.origenDestino = origenDestino;
    }

    public int getAsientosTotal() {
        return asientosTotal;
    }

    public void setAsientosTotal(int asientosTotal) {
        this.asientosTotal = asientosTotal;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
    
    public void reservaVuelo(int nro, int cantAsientos,ArrayList <Vuelo> vuelos){
        for(int i=0;i<vuelos.size();i++){
           if(vuelos.get(i).getNroVuelo()==nro){
               if(vuelos.get(i).getAsientosDisponibles()>=cantAsientos){
                   pantalla.mostrarLineaMensaje("La reserva se realizó correctamente");
               }else{
                   pantalla.mostrarLineaMensaje("No hay asientos disponibles");
               }
           } 
        }
        
    }
    
    
    public void mostrarVuelo(){
       pantalla.mostrarLineaMensaje("Nro de vuelo: "+nroVuelo+" Fecha y hora: "+fechaYhora+" Origen y destino: "+origenDestino+" Asientos Totales:  "+asientosTotal+"");
    }
    
    
    
    
}
