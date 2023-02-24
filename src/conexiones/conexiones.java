package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexiones {
           public static Connection Conexion_sql=null;
           public static Connection Conexion_mysql= null;           
           public static String port=null;
           public static String database=null;
           public static String user=null;
           public static String password=null;
           public static String url = null;
           public static String host = null;

           public static String host_SQL ="prueba.dyndns.org";
           public static String port_SQL ="1433";
           public static String database_SQL="pruebaacc";
           public static String user_SQL ="baseDB";
           public static String password_SQL="pass";
           
                      
public static Connection Conexion_SQL(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conexionURL="jdbc:sqlserver://"+host_SQL+":"+port_SQL+";databaseName="+database_SQL+";user="+user_SQL+";password="+password_SQL+";";
            Conexion_sql=DriverManager.getConnection(conexionURL);
            }catch(SQLException e){
                   System.err.println(e);
            }catch (ClassNotFoundException ex) {
                   Logger.getLogger(conexiones.class.getName()).log(Level.SEVERE, null, ex);
               }
            return Conexion_sql;
}          
                         
public static Connection Conexion_mysql(){     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url ="jdbc:mysql://" + host + ":" + port + "/" + database;
            Conexion_mysql = DriverManager.getConnection(url,user,password);           
            boolean validar = Conexion_mysql.isValid(50000);
            System.out.println("");
            System.out.println(validar ? "MySQL EXITOSA, IP: "+host+" base: "+database : "ERROR EN Conexion_2");   
            } catch (ClassNotFoundException ex) {
            System.out.println("");
            System.out.println("Error en Clase Conexiones MySQL  "+host+"  ");
            }catch (SQLException ex) {
                   System.out.println("");
                   System.out.println("Error Al 'Validar' conexiones.Conexion_mysql "+host+" puerto: "+port+" "+ex);
            }
            return Conexion_mysql;    
    }
    
}
    

    
