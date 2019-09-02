package agencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Administrador extends Usuario implements Serializable {

    private int cantVendedores;
    private int cantClientes;
    private int cantHoteles;
    private int cantVuelos;

    private Pantalla pantalla;
    private Teclado teclado;

    public Administrador(String nombreUsuario, String claveUsuario, String correoElectronico) {
        super(nombreUsuario, claveUsuario, correoElectronico); //los primeros 4 parámetros del constructor son los de la super clase. Los otros son los propios

        pantalla = new Pantalla();
        teclado = new Teclado();
    }// fin del constructor de Administradores

    public int getCantVendedores() {
        return cantVendedores;
    }

    public void setCantVendedores(int cantVendedores) {
        this.cantVendedores = cantVendedores;
    }

    public int getCantClientes() {
        return cantClientes;
    }

    public void setCantClientes(int cantClientes) {
        this.cantClientes = cantClientes;
    }

    public int getCantHoteles() {
        return cantHoteles;
    }

    public void setCantHoteles(int cantHoteles) {
        this.cantHoteles = cantHoteles;
    }

    public int getCantVuelos() {
        return cantVuelos;
    }

    public void setCantVuelos(int cantVuelos) {
        this.cantVuelos = cantVuelos;
    }

    @Override
    public void mostrarMenu(ArrayList<Usuario> usuarios, ArrayList<Hotel> hoteles, ArrayList<Sucursal> sucursales, ArrayList<Vuelo> vuelos, String nomUsuario) {
        int nroUsu, codHotel, numPlazas;
        String direccion;
        String nombreUsuario;
        String claveUsuario;
        String correoElectronico;
        String ciudad, telefono;
        String origenDestino;
        String direccSucu;
        String teleSucu;
        Date fechaYhora;
        int nroVuelo;
        int asientosTotal, asientosDisponibles;
        int codSucursal, pension;
        int anio, mes, dia, hora, minutos;
        GregorianCalendar calendario;

        do {
            pantalla.mostrarLineaMensaje("¿Que desea hacer?");
            pantalla.mostrarLineaMensaje("1-Crear nuevo Administrador");
            pantalla.mostrarLineaMensaje("2-Crear nuevo Vendedor");
            pantalla.mostrarLineaMensaje("3-Cargar nuevo Hotel");
            pantalla.mostrarLineaMensaje("4-Cargar nuevo Vuelo");
            pantalla.mostrarLineaMensaje("5-Cargar nueva Sucursal");
            pantalla.mostrarLineaMensaje("6-Consultar datos");
            pantalla.mostrarLineaMensaje("7-Salir");
            nroUsu = teclado.obtenerNumero();
        } while (nroUsu < 1 || nroUsu > 7); //pregunta hasta que ingrese nro válido

        switch (nroUsu) {
            case 1:
                pantalla.mostrarLineaMensaje("Elija el nombre de usuario");
                nombreUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Elija su clave");
                claveUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("indique su correo electronico");
                correoElectronico = teclado.obtenerCadena("");
                usuarios.add(new Administrador(nombreUsuario, claveUsuario, correoElectronico));
                break;

            case 2:
                pantalla.mostrarLineaMensaje("Elija el nombre de usuario");
                nombreUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Elija su clave");
                claveUsuario = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("indique su correo electronico");
                correoElectronico = teclado.obtenerCadena("");
                usuarios.add(new Vendedor(nombreUsuario, claveUsuario, correoElectronico));
                
                break;

            case 3:
                pantalla.mostrarLineaMensaje("Ingrese el código de Hotel");
                codHotel = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese la dirección del Hotel");
                direccion = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Ingrese la ciudad donde se encuentra el Hotel");
                ciudad = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Ingrese el teléfono del Hotel");
                telefono = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Ingrese el número de plazas del Hotel");
                numPlazas = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Pensión completa o media pensión? : \n1- Completa\n2-Media Pensión");
                pension=teclado.obtenerNumero();
                hoteles.add(new Hotel(codHotel, direccion, ciudad, telefono));
                hoteles.get(hoteles.size() - 1).cargarDias(numPlazas);
                hoteles.get(hoteles.size()-1).mostrarHotel(pension);
                mostrarMenu(usuarios,hoteles,sucursales,vuelos, nomUsuario);
                break;

            case 4:
                pantalla.mostrarLineaMensaje("Ingrese el numero del vuelo");
                nroVuelo = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Fecha de salida del vuelo:\nIngrese el año");
                anio = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese el mes");
                mes = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese el dia");
                dia = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese la hora del vuelo");
                hora = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese los minutos");
                minutos = teclado.obtenerNumero();
                calendario = new GregorianCalendar(anio, mes, dia, hora, minutos);
                fechaYhora = calendario.getTime();
                pantalla.mostrarLineaMensaje("Ingrese el origen y destino del vuelo");
                origenDestino = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Ingrese con cuantos asientos cuenta el vuelo");
                asientosTotal = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese los asientos disponibles");
                asientosDisponibles = teclado.obtenerNumero();

                vuelos.add(new Vuelo(nroVuelo, fechaYhora, origenDestino, asientosTotal, asientosDisponibles));
                vuelos.get(vuelos.size()-1).mostrarVuelo();
                break;

            case 5:
                pantalla.mostrarLineaMensaje("Ingrese el codigo de la sucursal");
                codSucursal = teclado.obtenerNumero();
                pantalla.mostrarLineaMensaje("Ingrese la direccion de la sucursal");
                direccSucu = teclado.obtenerCadena("");
                pantalla.mostrarLineaMensaje("Ingrese el telefono de la sucursal");
                teleSucu = teclado.obtenerCadena("");

                sucursales.add(new Sucursal(codSucursal, direccSucu, teleSucu));
                break;

            case 6:
                do {
                    pantalla.mostrarLineaMensaje("¿Que datos desea obtener?");
                    pantalla.mostrarLineaMensaje("1-Consultar Hoteles");
                    pantalla.mostrarLineaMensaje("2-Consultar Vuelos");
                    pantalla.mostrarLineaMensaje("3-Consultar Sucursales");
                    pantalla.mostrarLineaMensaje("4-Consultar Vendedores");
                    pantalla.mostrarLineaMensaje("5-Consultar Clientes");
                    pantalla.mostrarLineaMensaje("6-Consultar Administradores");
                    pantalla.mostrarLineaMensaje("7-Salir");
                    nroUsu = teclado.obtenerNumero();
                } while (nroUsu < 1 || nroUsu > 7);

                switch (nroUsu) {
                    case 1:
                        for (int i = 0; i < hoteles.size(); i++) {
                            pantalla.mostrarLineaMensaje("Codigo:" + hoteles.get(i).getCodHotel()
                                    + "   Ciudad:" + hoteles.get(i).getCiudad()
                                    + "   Direccion:" + hoteles.get(i).getDireccion()
                                    + "   Telefono:" + hoteles.get(i).getTelefono()
                                    + "   Plazas totales:" + hoteles.get(i).getNUM_PLAZAS());
                        }

                        break;

                    case 2:
                        for (int i = 0; vuelos.size() >= i; i++) {
                            pantalla.mostrarLineaMensaje("Numero:" + vuelos.get(i).getNroVuelo()
                                    + "   Origen y Destino:" + vuelos.get(i).getOrigenDestino()
                                    + "   Fecha y Hora de Salida:" + vuelos.get(i).getFechaYhora()
                                    + "   Asientos Totales:" + vuelos.get(i).getAsientosTotal()
                                    + "   Asientos Disponibles:" + vuelos.get(i).getAsientosDisponibles());
                        }

                        break;
                    case 3:
                        for (int i = 0; sucursales.size() >= i; i++) {
                            sucursales.get(i).mostrarSucursal();

                        }
                        break;
                    case 4: { for(int i=0;i<usuarios.size();i++){
                     if(usuarios.get(i).toString().equals("Vendedor")){
                         pantalla.mostrarLineaMensaje(usuarios.get(i).getNombreUsuario());
                     }
                 } 
                        
                    }
                    break;
                    case 5:  for(int i=0;i<usuarios.size();i++){
                     if(usuarios.get(i).toString().equals("Cliente")){
                         pantalla.mostrarLineaMensaje(usuarios.get(i).getNombreUsuario());
                     }
                     
                 } 
                    break;
                    case 6:
                        for(int i=0;i<usuarios.size();i++){
                     if(usuarios.get(i).toString().equals("Administrador")){
                         pantalla.mostrarLineaMensaje(usuarios.get(i).getNombreUsuario());
                     }
                     
                 } 

                

                break;

            default:
                pantalla.mostrarLineaMensaje("Esta saliendo del menu de administrador");

        }

    }

}

    @Override
    public String toString() {
        return "Administrador";
    }
    
    
}
