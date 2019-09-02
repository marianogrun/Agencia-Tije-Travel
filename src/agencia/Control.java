/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.io.*;

/**
 *
 * @author Mariano
 */
public class Control {

    private Pantalla pantalla;

    public Control()
    {
        pantalla=new Pantalla();
    }
        
        
    public void ejecutarDes() {

        Agencia agencia = new Agencia();

        boolean seguir;
        try {
            agencia = agencia.deSerializar("agencia.txt");
            seguir = EntradaSalida.leerBoolean("Agencia MMM\nDesea ingresar?");
            agencia.run();
        } catch (Exception e) {
            
            agencia.agregarUsuario();
            try {
                agencia.serializar("agencia.txt");
                pantalla.mostrarLineaMensaje("El inicio fue exitoso. Ahora vuelva a ingresar con su usuario"
                        + " y clave");
                //EntradaSalida.mostrarString("El arranque ha sido exitoso. ");
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }

        /*while (seguir) {
            String usuario = EntradaSalida.leerString("Ingrese el usuario:");
            String password = EntradaSalida.leerPassword("Ingrese la password:");

            Persona p = sistemaInscripcion.buscarPersona(usuario + ":" + password);

            if (p == null) {
                EntradaSalida.mostrarString("ERROR: La combinacion usuario/password ingresada no es valida.");
            } else {
                seguir = p.proceder(sistemaInscripcion);  // POLIMORFISMO!!!!
            }
        }*/
    }
}
