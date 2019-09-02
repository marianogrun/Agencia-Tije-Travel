/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.io.Serializable;

/**
 *
 * @author Mariano
 */
public class Pantalla implements Serializable{
    
    // muestra un mensaje sin un retorno de carro
    public void mostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    } // fin del método mostrarMensaje

    // muestra un mensaje con un retorno de carro
    public void mostrarLineaMensaje(String mensaje) {
        System.out.println(mensaje);
    } // fin del método mostrarLineaMensaje
    
    
}
