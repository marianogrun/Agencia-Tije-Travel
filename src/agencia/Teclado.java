/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

// Teclado.java
// Representa el teclado del sistema

import java.io.Serializable;
import java.util.Scanner; // el programa usa a Scanner para obtener la entrada del usuario
public class Teclado implements Serializable{

     
    

    // devuelve un valor entero introducido por el usuario
    public int obtenerNumero() {
        Scanner entrada= new Scanner(System.in);
        int resp;
        resp=entrada.nextInt();
        entrada.nextLine();
        return resp; // suponemos que el usuario introduce un entero
        
    } // fin del método obtenerNumero
    
    
    
    public String obtenerCadena(String cadena) {
        Scanner entrada= new Scanner(System.in);
        return entrada.nextLine(); // suponemos que el usuario introduce una cadena
    } // fin del método obtenerCadena
} // fin de la clase Teclado
