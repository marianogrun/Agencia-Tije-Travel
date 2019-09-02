
package agencia;

import java.io.Serializable;


public class Sucursal implements Serializable {
    private int codSucursal;
    private String direccSucu;
    private String teleSucu;
    private Pantalla pantalla;
    private Teclado teclado;

    public Sucursal(int codSucursal, String direccSucu, String teleSucu) {
        this.codSucursal = codSucursal;
        this.direccSucu = direccSucu;
        this.teleSucu = teleSucu;
        pantalla=new Pantalla();
        teclado=new Teclado ();
    }

    public int getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(int codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getDireccSucu() {
        return direccSucu;
    }

    public void setDireccSucu(String direccSucu) {
        this.direccSucu = direccSucu;
    }

    public String getTeleSucu() {
        return teleSucu;
    }

    public void setTeleSucu(String teleSucu) {
        this.teleSucu = teleSucu;
    }

    public void mostrarSucursal (){
       pantalla.mostrarLineaMensaje("Código de sucursal: "+teleSucu+" Dirección: "+direccSucu+" Teléfono: "+teleSucu+"");
   }
    
    
    
    
}