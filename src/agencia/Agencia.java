/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class Agencia implements Serializable {

    private ArrayList<Sucursal> sucursales;
    private ArrayList<Hotel> hoteles;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Usuario> usuarios;
    private Pantalla pantalla;//La pantalla del sistema
    private Teclado teclado;//La teclado del sistema
    private Control control; //La clase control es la que maneja los métodos deserializar y serializar

    public Agencia() {
        sucursales = new ArrayList<Sucursal>(); //se crea el arraylist de sucursales vacio para luego cargarlo
        hoteles = new ArrayList<Hotel>();//se crea el arraylist de hoteles vacio para luego cargarlo
        vuelos = new ArrayList<Vuelo>();//se crea el arraylist de vuelos vacio para luego cargarlo
        usuarios = new ArrayList<Usuario>();//se crea el arraylist de usuarios vacio para luego cargarlo
        this.pantalla = new Pantalla();//se crea la pantalla para mostrar los mensajes
        this.teclado = new Teclado();//se crea el teclado para leer las entradas del usuario

    }

    //hace correr el sistema. Desde acá surgen todas las demás acciones
    public void run() throws IOException {
        int resp;

        pantalla.mostrarLineaMensaje("\n-------------------------------------------\n\nBienvenido. AGENCIA MMM");
        do {
            pantalla.mostrarLineaMensaje("Ingrese con el usuario creado.");
            pantalla.mostrarLineaMensaje("1-Loguearse");
            
            resp = teclado.obtenerNumero();//llama a funcionar obtener numero de la clase teclado

        } while (resp < 1 || resp > 1);//vuelve a preguntar si no es una opcion correcta
        switch (resp) {
            case 1:
                autenticarUsuario();
                break;
                
                            
        }

        try {
            serializar("agencia.txt");
            EntradaSalida.mostrarString("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    //agregar Sucursal al arrayList de <Sucursales>
    public void agregarSucursales(int codSucursal, String direccSucu, String telefono) {
        sucursales.add(new Sucursal(codSucursal, direccSucu, telefono));
    }//fin del método

    //agregar Hotel al arrayList de <Hoteles>
    public void agregarHoteles(int cod_Hotel, String direccion, String ciudad, String telefono) {
        hoteles.add(new Hotel(cod_Hotel, direccion, ciudad, telefono));
    }//fin del método

    //agregar Vuelo al arrayList de <Vuelos>
    public void agregarVuelos(int nroVuelo, Date fechaYhora, String origenDestino, int asientosTotal, int asientosDisponibles) {
        vuelos.add(new Vuelo(nroVuelo, fechaYhora, origenDestino, asientosTotal, asientosDisponibles));
    }//fin del método

    //agrega el usuario que se requiera segun el caso uso correspondiente
    public void agregarUsuario() {
        String nombreUsuario;
        String claveUsuario;
        String correoElectronico;
        int nroUsu;
        do {
            pantalla.mostrarLineaMensaje("Debe agregar un administrador para Empezar");
            pantalla.mostrarLineaMensaje("1-Crear Administrador");
            
            
            nroUsu = teclado.obtenerNumero();
        } while (nroUsu < 1 || nroUsu > 1); //pregunta hasta que ingrese nro válido

        
        pantalla.mostrarLineaMensaje("Elija el nombre de usuario");
        nombreUsuario = teclado.obtenerCadena("");
        pantalla.mostrarLineaMensaje("Elija su clave");
        claveUsuario = teclado.obtenerCadena("");
        pantalla.mostrarLineaMensaje("indique su correo electronico");
        correoElectronico = teclado.obtenerCadena("");

        usuarios.add(new Administrador(nombreUsuario, claveUsuario, correoElectronico));
       
          
                
      
    }
    
    //metodo para deserializar el archivo agencia.txt si es que el mismo existe
    public Agencia deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Agencia s = (Agencia) o.readObject();
        
        return s;
    }
    
    //serializa los datos del sistema y los guarda en un archivo llamado agencia.txt , si no exite crea uno. 
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    //método para verificar si el usuario que se desea loguear existe en el arrayList de usuarios 
    private void autenticarUsuario() {
        pantalla.mostrarLineaMensaje("Bienvenido nuevamente");
        String nomUsuario, claveUsuario;
        pantalla.mostrarLineaMensaje("Ingrese su nombre de usuario");
        nomUsuario = teclado.obtenerCadena("");
        pantalla.mostrarLineaMensaje("Ingrese su clave de usuario");
        claveUsuario = teclado.obtenerCadena("");
        
        for (int i = 0; i < usuarios.size(); i++) {
            
            if (usuarios.get(i).getNombreUsuario().equals(nomUsuario) && usuarios.get(i).getClaveUsuario().equals(claveUsuario)) {
                pantalla.mostrarLineaMensaje("\n-------------------------------------------\n"
                        + "Bienvenido al SISTEMA AGENCIA MMM!!!!");
                usuarios.get(i).mostrarMenu(usuarios, hoteles, sucursales, vuelos, nomUsuario);
            }
        }//fin del for que recorrer el arrayList de usuarios

    }//fin de método autenticar

}
