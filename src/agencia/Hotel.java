package agencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Hotel implements Serializable {
    
    private int codHotel;
    private String direccion;
    private String ciudad;
    private String telefono;
    private int NUM_PLAZAS;
    private boolean pensionCompleta=true;
    
    
    private int[] mes1, mes2, mes3, mes4, mes5, mes6, mes7, mes8, mes9, mes10, mes11, mes12;
    private Pantalla pantalla;
    private Teclado teclado;
    
    
    public Hotel(int codHotel, String direccion, String ciudad, String telefono) {
        this.codHotel = codHotel;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        
        pantalla = new Pantalla();
        teclado = new Teclado();
        
    }
    
    public void setcodHotel(int codHotel) {
        this.codHotel = codHotel;
    }
    
    public int getCodHotel() {
        return this.codHotel;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    //carga el número de plazas solicitado por el admin cuando crea un Hotel, en 12 arrays con diferentes extensiones segun los días de cada mes
    public void cargarDias(int numPlazas) {
        NUM_PLAZAS=numPlazas;
        for (int i = 1; i <= 12; i++) {
            switch (i) {
                case 1:                    
                    mes1 = new int[31];                    
                    for (int j = 0; j < mes1.length; j++) {
                        mes1[j] = NUM_PLAZAS;
                    }
                    break;
                case 2:                    
                    mes2 = new int[28];                    
                    for (int j = 0; j < mes2.length; j++) {
                        mes2[j] = NUM_PLAZAS;
                    }
                    break;
                case 3:                    
                    mes3 = new int[31];                    
                    for (int j = 0; j < mes3.length; j++) {
                        mes3[j] = NUM_PLAZAS;
                    }
                    break;
                case 4:                    
                    mes4 = new int[30];                    
                    for (int j = 0; j < mes4.length; j++) {
                        mes4[j] = NUM_PLAZAS;
                    }
                    break;
                case 5:                    
                    mes5 = new int[31];                    
                    for (int j = 0; j < mes5.length; j++) {
                        mes5[j] = NUM_PLAZAS;
                    }
                    break;
                case 6:                    
                    mes6 = new int[30];                    
                    for (int j = 0; j < mes6.length; j++) {
                        mes6[j] = NUM_PLAZAS;
                    }
                    break;
                case 7:                    
                    mes7 = new int[31];                    
                    for (int j = 0; j < mes7.length; j++) {
                        mes7[j] = NUM_PLAZAS;
                    }
                    break;
                case 8:                    
                    mes8 = new int[31];                    
                    for (int j = 0; j < mes8.length; j++) {
                        mes8[j] = NUM_PLAZAS;
                    }
                    break;
                case 9:                    
                    mes9 = new int[30];                    
                    for (int j = 0; j < mes9.length; j++) {
                        mes9[j] = NUM_PLAZAS;
                    }
                    break;
                case 10:                    
                    mes10 = new int[31];                    
                    for (int j = 0; j < mes10.length; j++) {
                        mes10[j] = NUM_PLAZAS;
                    }
                    break;
                case 11:                    
                    mes11 = new int[30];                    
                    for (int j = 0; j < mes11.length; j++) {
                        mes11[j] = NUM_PLAZAS;
                    }
                    break;
                case 12:                    
                    mes12 = new int[31];                    
                    for (int j = 0; j < mes12.length; j++) {
                        mes12[j] = NUM_PLAZAS;
                    }
                    break;                
            }
        }
    }
    
    //verifica en el mes solicitado que según el día de llegada y el de partida, haya cupo en función de la cantidad de huéspedes que quieren reservar
    public void reservaHotel(int anio, int mesLlegada, int mesPartida, int  diaLlegada, int diaPartida, int cantHuesped, String nomCliente, ArrayList<Usuario> usuarios, int nroUsu) {
        boolean habitacionesDisp = true;
        GregorianCalendar calendario1=new GregorianCalendar(anio,mesLlegada-1,diaLlegada);
        Date fechaLlegada=calendario1.getTime();
        GregorianCalendar calendario2=new GregorianCalendar(anio,mesPartida-1,diaPartida);
        Date fechaPartida=calendario2.getTime();
        
        
        
       switch (mesLlegada-1) {
           
            case 0:
                
                
                if(calendario1.get(Calendar.MONTH)+1 == 1)
                 {  for (int i = 0; i < mes1.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 1)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes1[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes1[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 2)
                            {   
                               for (int j = diaLlegada; j < mes1.length; j++) 
                                {  if ((mes1[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes2[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes1.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes1[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes2[j] -= cantHuesped;
                                }    
                                
                               
                            }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                     
                 }
                }
                break;
            case 1:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 2)
                 {  for (int i = 0; i < mes2.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 2)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes2[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes2[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 3)
                            {   
                               for (int j = diaLlegada; j < mes2.length; j++) 
                                {  if ((mes2[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes3[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes2.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes2[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes3[j] -= cantHuesped;
                                }    
                               
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
            case 2:
                pantalla.mostrarLineaMensaje("Entra al switch");
                
                if(calendario1.get(Calendar.MONTH)+1 == 3)
                 {  for (int i = 0; i < mes3.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 3)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes3[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes3[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 4)
                            {   
                               for (int j = diaLlegada; j < mes3.length; j++) 
                                {  if ((mes3[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes4[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes3.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes3[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes4[j] -= cantHuesped;
                                }    
                               
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                      
                 }
                }
                break;
            case 3:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 4)
                 {  for (int i = 0; i < mes4.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 4)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes4[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes4[j] -= cantHuesped;
                                 }
                                
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 5)
                            {   
                               for (int j = diaLlegada; j < mes4.length; j++) 
                                {  if ((mes4[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes5[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes4.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes4[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes5[j] -= cantHuesped;
                                }    
                             
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                        
                 }
                }
                break;
            case 4:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 5)
                 {  for (int i = 0; i < mes5.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 5)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes5[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes5[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 6)
                            {   
                               for (int j = diaLlegada; j < mes5.length; j++) 
                                {  if ((mes5[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes6[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes5.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes5[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes6[j] -= cantHuesped;
                                }    
                              
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
            case 5:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 6)
                 {  for (int i = 0; i < mes6.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 6)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes6[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes6[j] -= cantHuesped;
                                 }
                              
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 7)
                            {   
                               for (int j = diaLlegada; j < mes6.length; j++) 
                                {  if ((mes6[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes7[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes6.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes6[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes7[j] -= cantHuesped;
                                }    
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                         
                 }
                }
                break;
            case 6:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 7)
                 {  for (int i = 0; i < mes7.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 7)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes7[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes7[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 8)
                            {   
                               for (int j = diaLlegada; j < mes7.length; j++) 
                                {  if ((mes7[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes8[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes7.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes7[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes8[j] -= cantHuesped;
                                }    
                               
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
            case 7:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 8)
                 {  for (int i = 0; i < mes8.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 8)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes8[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes8[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 9)
                            {   
                               for (int j = diaLlegada; j < mes8.length; j++) 
                                {  if ((mes8[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes9[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes8.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes8[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes9[j] -= cantHuesped;
                                }    
                                
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                        
                 }
                }
                break;
            case 8:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 9)
                 {  for (int i = 0; i < mes9.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 9)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes9[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes9[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 10)
                            {   
                               for (int j = diaLlegada; j < mes9.length; j++) 
                                {  if ((mes9[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes10[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes9.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes9[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes10[j] -= cantHuesped;
                                }    
                              
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
            case 9:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 10)
                 {  for (int i = 0; i < mes10.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 10)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes10[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes10[j] -= cantHuesped;
                                 }
                                
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 11)
                            {   
                               for (int j = diaLlegada; j < mes10.length; j++) 
                                {  if ((mes10[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes11[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes10.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes10[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes11[j] -= cantHuesped;
                                }    
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                        
                 }
                }
                break;
            case 10:
                     
                
                if(calendario1.get(Calendar.MONTH)+1 == 11)
                 {  for (int i = 0; i < mes11.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 11)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes11[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes11[j] -= cantHuesped;
                                 }
                               
                             }
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 12)
                            {   
                               for (int j = diaLlegada; j < mes1.length; j++) 
                                {  if ((mes11[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes12[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes11.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes11[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes12[j] -= cantHuesped;
                                }    
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
            case 11:
                    
                
                if(calendario1.get(Calendar.MONTH)+1 == 12)
                 {  for (int i = 0; i < mes12.length; i++)
                     {  if (i == diaLlegada)
                        { if(calendario2.get(Calendar.MONTH)+1 == 12)
                          {    
                               for (int j = diaLlegada; j < diaPartida; j++) 
                                { if ((mes12[j] < cantHuesped)&&(habitacionesDisp)) 
                                  {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                  }                                  
                                }
                            for (int j = diaLlegada; j < diaPartida; j++) 
                             {  if (habitacionesDisp)
                                 {  mes12[j] -= cantHuesped;
                                 }
                               
                             }
                            
                             if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                          }
                            if(calendario2.get(Calendar.MONTH)+1 == 1)
                            {   
                               for (int j = diaLlegada; j < mes12.length; j++) 
                                {  if ((mes12[j] < cantHuesped)&&(habitacionesDisp)) 
                                   {   habitacionesDisp = false;
                                    pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                   }                                  
                                }
                               if(habitacionesDisp)
                                 { for (int j = 1; j < diaPartida; j++) 
                                    { if ((mes1[j] < cantHuesped)&&(habitacionesDisp)) 
                                       {   habitacionesDisp = false;
                                           pantalla.mostrarLineaMensaje("No hay habitaciones disponibles en la fecha indicada");
                                       }                                  
                                    }
                                 }
                               
                            for (int j = diaLlegada; j < mes12.length; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes12[j] -= cantHuesped;
                                } 
                            
                            }
                            
                            for (int j = 1; j < diaPartida; j++)
                            { 
                                if (habitacionesDisp) 
                                {
                                    mes1[j] -= cantHuesped;
                                }    
                                
                               
                            }
                            if (habitacionesDisp)
                                {
                                 pantalla.mostrarLineaMensaje("La reserva se realizó satisfactoriamente");
                                }
                        }
                    }
                       
                 }
                }
                break;
                 default:
                pantalla.mostrarLineaMensaje("No es una opción válida");
          
        } 
          for(int i =0; i<usuarios.size(); i++)
          {if (usuarios.get(i).getNombreUsuario().equals(nomCliente))
          { usuarios.get(i).setDatos("Anio: "+anio+" Mes de llegada: "+ mesLlegada+" Dia de llegada: "+diaLlegada+" Mes de partida: "+mesPartida+" Dia partida: "+diaPartida+" Numero de Hotel: "+nroUsu+"");
                  
          }}
    }
     public int getNUM_PLAZAS() {
        return NUM_PLAZAS;
    }
    
    public void setNUM_PLAZAS(int NUM_PLAZAS) {
        this.NUM_PLAZAS = NUM_PLAZAS;}

    public void mostrarHotel(int pension){
        String tipoPension;
        if (pension==1){
            this.pensionCompleta=true;
        }else {
            this.pensionCompleta=false;
        }
        if(pensionCompleta){
            tipoPension="Completa";
        }else{tipoPension="Media Pension";}
        pantalla.mostrarLineaMensaje("Hotel: "+codHotel+", Dirección:"+direccion
                +", Ciudad: "+ciudad+" Teléfono: "+telefono
                +" Nro de plazas: "+NUM_PLAZAS
                +" Tipo de Pensión: "+tipoPension+"");
    }
    
    
    
    
    
    
}
