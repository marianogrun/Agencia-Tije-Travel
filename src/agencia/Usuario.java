package agencia;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Usuario implements Serializable {

    public String nombreUsuario;
    public String claveUsuario;
    public String correoElectronico;
    public ArrayList<Usuario> usuarios;
    public String datos;

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
    

    // el constructor de Usuarios es invocado por las subclases mediante super()
    public Usuario(String nombreUsuario, String claveUsuario, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
        this.correoElectronico = correoElectronico;
        usuarios = new ArrayList<Usuario>();
        
        
    }// fin del constructor de Usuarios;
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    /**
     *
     * @param usuarios
     * @param hoteles
     * @param sucursales
     * @param vuelos
     * @param nombreUsuario
     */
    public abstract void mostrarMenu(ArrayList<Usuario> usuarios, ArrayList<Hotel> hoteles, ArrayList<Sucursal> sucursales, ArrayList<Vuelo> vuelos, String nombreUsuario);
    

}
