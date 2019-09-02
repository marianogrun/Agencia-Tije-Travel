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
public class Vendedor extends Usuario implements Serializable{
    private Pantalla pantalla;
    private Teclado teclado;
    public Vendedor(String nombreUsuario, String claveUsuario, String correoElectronico) {
        super(nombreUsuario, claveUsuario, correoElectronico);//los primeros 4 parámetros del constructor son los de la super clase. Los otros son los propios
        pantalla=new Pantalla();
        teclado=new Teclado ();
        
    }
    
    
    
    @Override
    public void mostrarMenu(ArrayList<Usuario> usuarios, ArrayList<Hotel> hoteles, ArrayList<Sucursal> sucursales, ArrayList<Vuelo> vuelos, String nomUsuario){
        int nroUsu;
        String nombreUsuario;
        String claveUsuario;
        String correoElectronico;
        String fechaLlegada;
        String fechaPartida;
        String nomCliente;
        int cantHuesped, anio, mesLlegada, mesPartida, diaLlegada, diaPartida, cantAsientos, tipoClase;
        do {
            pantalla.mostrarLineaMensaje("¿Que desea hacer?");
            pantalla.mostrarLineaMensaje("1-Ingresar nuevo cliente");
            pantalla.mostrarLineaMensaje("2-Consultar clientes");
            pantalla.mostrarLineaMensaje("3-Consultar hoteles");
            pantalla.mostrarLineaMensaje("4-Consultar vuelos");
            pantalla.mostrarLineaMensaje("5-Salir");
            nroUsu = teclado.obtenerNumero();
       } while (nroUsu < 1 || nroUsu > 5); //pregunta hasta que ingrese nro válido
       
        switch (nroUsu)
            
        {  
            case 1:
                pantalla.mostrarLineaMensaje("Elija el nombre de usuario");
                nombreUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Elija su clave");
                claveUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("indique su correo electronico");
                correoElectronico = teclado.obtenerCadena("");
                usuarios.add(new Cliente(nombreUsuario, claveUsuario, correoElectronico));
                break;
            case 2:
                 for(int i=0;i<usuarios.size();i++){
                     if(usuarios.get(i).toString().equals("Cliente")){
                         pantalla.mostrarLineaMensaje(usuarios.get(i).getNombreUsuario());
                     }
                 } 
                break;
               
            case 3:
                
                 for (int i=0; i<hoteles.size(); i++)
                 {
                     pantalla.mostrarLineaMensaje("\nCodigo:"+hoteles.get(i).getCodHotel()
                             +"   Ciudad:"+hoteles.get(i).getCiudad()
                             +"   Direccion:"+hoteles.get(i).getDireccion()
                             +"   Telefono:"+hoteles.get(i).getTelefono()
                             +"   Plazas totales:"+hoteles.get(i).getNUM_PLAZAS());}
                    pantalla.mostrarLineaMensaje("\n\n Para agregar una reserva de hotel ingrese el codigo del mismo, si quiere volver ingrese cero.");
                    nroUsu = teclado.obtenerNumero();
                    if(nroUsu != 0)
                    {
                       for (int i=0; i < hoteles.size(); i++){
                          if (hoteles.get(i).getCodHotel() == nroUsu){
                            pantalla.mostrarLineaMensaje("Ingrese el año de la reserva");
                            anio = teclado.obtenerNumero();
                            pantalla.mostrarLineaMensaje("Ingrese el número de mes de llegada");
                            mesLlegada = teclado.obtenerNumero();
                            pantalla.mostrarLineaMensaje("Ingrese el día de llegada");
                            diaLlegada = teclado.obtenerNumero();
                             pantalla.mostrarLineaMensaje("Ingrese el número de mes de partida");
                            mesPartida = teclado.obtenerNumero();
                            pantalla.mostrarLineaMensaje("Ingrese el día de partida");
                            diaPartida = teclado.obtenerNumero();
                       
                            pantalla.mostrarLineaMensaje("Ingrese la cantidad de huespedes");
                            cantHuesped = teclado.obtenerNumero();
                            pantalla.mostrarLineaMensaje("Ingrese el nombre de usuario del Cliente");
                            nomCliente =teclado.obtenerCadena("");
                            hoteles.get(i).reservaHotel(anio, mesLlegada, mesPartida, diaLlegada, diaPartida, cantHuesped, nomCliente, usuarios, nroUsu);
                          }else {
                              pantalla.mostrarLineaMensaje("No se encontró el código de hotel solicitado");
                          }
                    
                       }
                    }mostrarMenu(usuarios,hoteles,sucursales,vuelos, nomUsuario); 
                   
                break;
            case 4:
                 for(int i=0; vuelos.size()>= i; i++)
                 {pantalla.mostrarLineaMensaje("\nNumero:"+ vuelos.get(i).getNroVuelo()
                         +"   Origen y Destino:"+vuelos.get(i).getOrigenDestino()
                         +"   Fecha y Hora de Salida:"+ vuelos.get(i).getFechaYhora()
                         +"   Asientos Totales:"+vuelos.get(i).getAsientosTotal()
                         +"   Asientos Disponibles:"+vuelos.get(i).getAsientosDisponibles());}
                 
                 for (int i=0; i<vuelos.size(); i++)
                 {   
                     vuelos.get(i).mostrarVuelo();
                     }
                    pantalla.mostrarLineaMensaje("\n\n Para agregar una reserva de vuelo ingrese el codigo del mismo, si quiere volver ingrese cero.");
                    nroUsu = teclado.obtenerNumero();
                    if(nroUsu != 0)
                    {
                       for (int i=0; i < vuelos.size(); i++){
                          if (vuelos.get(i).getNroVuelo()== nroUsu){
                                                 
                            pantalla.mostrarLineaMensaje("Ingrese la cantidad de asientos");
                            cantAsientos = teclado.obtenerNumero();
                            
                            vuelos.get(i).reservaVuelo(nroUsu,cantAsientos, vuelos);
                            
                          }else {
                              pantalla.mostrarLineaMensaje("No se encontró el código de vuelo solicitado");
                          }
                    
                       }
                    }mostrarMenu(usuarios,hoteles,sucursales,vuelos, nomUsuario); 
                   
                break;
        
            default:pantalla.mostrarLineaMensaje("No es el case valido");
                 
                    }
        
                    
    }
    
    
    public void mostrarVendedor(){
       pantalla.mostrarLineaMensaje("Nombre del vendedor: "+nombreUsuario+" Correo Electrónico: "+correoElectronico+"");
   }

    @Override
    public String toString() {
        return "Vendedor";
    }
    
    
 }

    
    
     

