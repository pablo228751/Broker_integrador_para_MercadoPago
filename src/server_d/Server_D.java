package server_d;

import conexiones.conexiones;
import consultas.consulta_ecommerce;
import consultas.consulta_ip_sql;
import datos.dispositivos;
import datos.eventos;
import datos.tipocliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static server_d.Server_D.inicio;
import static server_d.Server_D.ip_egreso;
import static server_d.Server_D.ip_ingreso;
import static server_d.Server_D.lista_egr;
import static server_d.Server_D.lista_ingr;

public class Server_D extends conexiones {
    
    public static consulta_ecommerce consulta_ecommerce= new consulta_ecommerce();  
    public static consulta_ip_sql Consulta_ing= new consulta_ip_sql();
    public static consulta_ip_sql Consulta_egr= new consulta_ip_sql(); 
    public static List<dispositivos> lista_ingr=new ArrayList<>();
    public static List<dispositivos> lista_egr=new ArrayList<>();
    public static List<tipocliente> lista=new ArrayList<>(); 
    public static List<eventos> lista_dni=new ArrayList<>(); 
    public static List<eventos> lista_event_sql=new ArrayList<>();
    public static List<eventos> lista_insert_sql=new ArrayList<>();
   
  
    public static void main(String[] args) {
        
        hilo_uno hilo_uno = new hilo_uno();
        //hilo_dos hilo_dos = new hilo_dos();
        Thread hilo1 = new Thread (hilo_uno);
        //Thread hilo2 = new Thread (hilo_dos);
        
        hilo1.start();
        //hilo2.start(); 
    }
    ///////////////////////// BUSCO EN SQL Y SEPARO IPs///////////////////////////////
    public static void ip_ingreso() {         
            lista_ingr=Consulta_ing.ip_ingreso();
            System.out.println("INGRESOS");
            for(int i=0;i<lista_ingr.size();i++){
            System.out.println(lista_ingr.get(i).getIp());
            }
            System.out.println("");
    }
    public static void ip_egreso() {         
            lista_egr=Consulta_egr.ip_egreso();
            System.out.println("EGRESOS");
            for(int i=0;i<lista_egr.size();i++){
            System.out.println(lista_egr.get(i).getIp());
            }
            System.out.println("");
    }  
         ////////////////////////////////CONSULTAS Mysql INGRESOS///////////////////////////////////////////
    public static void inicio(){     
          ///////////CONSULTA 1        
            /*
            lista=consulta_eventos_mysql.ip_ingreso();
            for(int i=0;i<lista.size();i++){            
                System.out.println(lista.get(i).getEvento_id()+"    "+lista.get(i).getE_s()+"    "+lista.get(i).getTarjeta()+"    "+lista.get(i).getPago());
            }
             consulta_eventos.lista=lista;
             */
             ///////////CONSULTA 2        
            
            
            consulta_ecommerce.lista_ingr=lista_ingr;
            consulta_ecommerce.lista_egr=lista_egr;
            consulta_ecommerce.tipocliente();
            
           /*
            //////////CONSULTA 3          
            
            consulta_eventos.lista_ingr=lista_ingr;
            consulta_eventos.lista_egr=lista_egr;
            consulta_eventos.lista=lista;
            consulta_eventos.insert();
            */
            
       
    }
      /*
        ////////////////////////////////CONSULTAS DNI///////////////////////////////////////////
    public static void dni(){
            consulta_eventos_mysql.lista_ingr=lista_ingr;
            consulta_eventos_mysql.lista_egr=lista_egr;
            consulta_eventos_mysql.dni();
           
            
        }  */  
}
class hilo_uno implements Runnable
{    
    public void run ()
    {
        while(true){
        ip_ingreso();
        ip_egreso();
        
            try{
            System.out.println("");
            System.out.println("");
            System.out.println("SERVER_D:::::: EJECUTANDO THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> THREAD 3 Ecommerce --> ");
            System.out.println("");
            System.out.println("");
        //consulta_eventos_mysql.lista_ingr=lista_ingr;
        //consulta_eventos_mysql.lista_egr=lista_egr;
        inicio();
            }catch(Exception e){
                System.out.println("SERVER_D:::::: ERROR EN THREAD 3 Ecommerce inicio Server_D "+e);
            }
              try
                {
                Thread.sleep (9000);  // El tiempo en milisegundos
                } 
                catch (Exception e)
                {
                     System.out.println("SERVER_D:::::: Error Thread_!3 Ecommerce Sleep");
                    }
        }
        
    }
}

/*
class hilo_dos implements Runnable
{    
    public void run ()
    {
        while(true){
            System.out.println("");
            System.out.println("");
            System.out.println("EJECUTANDO THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> THREAD 1--> ");
            System.out.println("");
            System.out.println("");
            try
                {
                Thread.sleep (4000);  // El tiempo en milisegundos
                } 
                catch (Exception e)
                {
                     System.out.println("Errot Thread_!1");
                    }
            dni();
        }
        
    }
}
*/
