/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class Cliente extends Usuario implements Serializable{
        private int codTurista;
        private String nombre;
        private String apellido;
        private Pantalla pantalla;
        private Teclado teclado;
        private int codigoHotel;
        private String estadia;
    public Cliente(String nombreUsuario, String claveUsuario, String correoElectronico) {
        super(nombreUsuario, claveUsuario, correoElectronico); //los primeros 4 parámetros del constructor son los de la super clase. Los otros son los propios
        pantalla=new Pantalla();
        teclado=new Teclado ();
        
    }
   @Override 
   public String getNombreUsuario() {
        return nombreUsuario;
    }
  @Override 
    public String getClaveUsuario() {
        return claveUsuario;
    }
  @Override 
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    @Override
    public void mostrarMenu(ArrayList<Usuario> usuarios,  ArrayList<Hotel> hoteles, ArrayList<Sucursal> sucursales, ArrayList<Vuelo> vuelos, String nomCliente){
        int nroUsu;
        do {
            pantalla.mostrarLineaMensaje("¿Que desea hacer?");
            pantalla.mostrarLineaMensaje("1-Consultar Viaje");
            pantalla.mostrarLineaMensaje("2-Salir");
            nroUsu = teclado.obtenerNumero();
            
        } while (nroUsu < 1 || nroUsu > 2); //pregunta hasta que ingrese nro válido
        switch(nroUsu)
        { case 1: 
        for(int i =0; i<usuarios.size(); i++)
          {if (usuarios.get(i).getNombreUsuario().equals(nomCliente))
          { pantalla.mostrarLineaMensaje(usuarios.get(i).getDatos());
               break;
       
        }
          } 
        case 2: 
            break;
                    } 
    }    
        
    public void mostrarCliente(){
        pantalla.mostrarLineaMensaje("Usuario: "+nombreUsuario+"Correo Electrónico: "+correoElectronico+"");
    }

    @Override
    public String toString() {
        return "Cliente";
    }
    
    
}
