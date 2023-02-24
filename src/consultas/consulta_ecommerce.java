package consultas;

import Interfaces.operaciones;
import conexiones.conexiones;
import datos.dispositivos;
import datos.eventos;
import datos.tipocliente;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class consulta_ecommerce implements operaciones<tipocliente> {

    // private static final String SQL_selectAll = "SELECT TOP (1000) dbo.tipocliente.categoria, dbo.tipocliente.tarjeta, dbo.tipocliente.legajo, dbo.tipocliente.nombre, dbo.tipocliente.e_s FROM dbo.tipocliente WHERE dbo.tipocliente.categoria in (5,6)";
    private static final String SQL_selectAll = "SELECT dbo.tipocliente.categoria, dbo.tipocliente.tarjeta, dbo.tipocliente.legajo, dbo.tipocliente.nombre, dbo.tipocliente.e_s, dbo.tipocliente.nroorden, dbo.tipocliente.fechahora, dbo.tipocliente.usuario, dbo.tipocliente.estado, dbo.tipocliente.retiro, dbo.tipocliente.nrocuenta, dbo.tipocliente.id_tc, dbo.tipocliente.observacion FROM dbo.tipocliente WHERE dbo.tipocliente.estado < 4";
    private static final String SQL_Pago = "SELECT evento_id from eventosmae where fecha_entrada=CONVERT(DATE,GETDATE()) and tarjeta='' and pago='SI' and fecha_salida is null";
    private static final String Mysql_selectAll = "SELECT tipocliente.categoria, tipocliente.tarjeta, tipocliente.legajo, tipocliente.nombre, tipocliente.e_s FROM tipocliente WHERE tipocliente.categoria in (5,6) LIMIT 1000";
    private static final String SQL_selectAll_TODO = "SELECT TOP (1000) dbo.tipocliente.categoria, dbo.tipocliente.tarjeta, dbo.tipocliente.legajo, dbo.tipocliente.nombre, dbo.tipocliente.e_s FROM dbo.tipocliente";
    private static final String Mysql_selectAll_TODO = "SELECT tipocliente.categoria, tipocliente.tarjeta, tipocliente.legajo, tipocliente.nombre, tipocliente.e_s FROM tipocliente LIMIT 1000";
    private static final String SQL_INSERT_evento = "INSERT INTO dbo.tipocliente_ec (dbo.tipocliente_ec.categoria, dbo.tipocliente_ec.legajo, dbo.tipocliente_ec.e_s, dbo.tipocliente_ec.fecha_entrada, dbo.tipocliente_ec.hora_entrada, dbo.tipocliente_ec.fecha_salida, dbo.tipocliente_ec.hora_salida) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_INSERT_evento_mysql = "REPLACE INTO tipocliente VALUES (?,?,?,?,?)";
    private static final String SQL_update_estado = "UPDATE tipocliente SET estado=? WHERE tarjeta=?";
    private static final String SQL_update_pago = "UPDATE eventos SET pago='SI' WHERE evento_id=? and pago != 'SI'";
    private static final String SQL_Eliminar_estado3 = "DELETE FROM tipocliente WHERE tarjeta=?";
    public static List<tipocliente> lista_event_sql = new ArrayList<>();
    public static List<tipocliente> lista_event_sql2 = new ArrayList<>();
    public static List<dispositivos> lista_ingr = new ArrayList<>();
    public static List<dispositivos> lista_egr = new ArrayList<>();
    public static List<tipocliente> lista_pago = new ArrayList<>();
    public static List<tipocliente> item1 = new ArrayList();
    public static List<tipocliente> item2 = new ArrayList<>();
    public static String lista2 = null;
    public static String lista3 = null;
    public static String consul = " ";
    public static String consul2 = " ";
    private PreparedStatement ps;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps_mysql;
    private Connection con_mysql;
    private ResultSet rs_mysql;
    private String x;
    private String y;
    public static int contador = 4000;
    public boolean estado_consulta = true;

    @Override
    public List<tipocliente> tipocliente() {
        System.out.println("1_Recorre TipoCliente.... ");
        lista_event_sql.clear();
        lista_event_sql2.clear();
        lista_pago.clear();

        ///CONSUlta 1 SQl SERVER
        try {
            con = conexiones.Conexion_SQL();
            ps = con.prepareStatement(SQL_selectAll);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(9) == 0) {
                    tipocliente c_tipocliente = new tipocliente();
                    c_tipocliente.setCategoria(rs.getString(1));
                    c_tipocliente.setTarjeta(rs.getString(2));
                    c_tipocliente.setLegajo(rs.getString(3));
                    c_tipocliente.setNombre(rs.getString(4));
                    c_tipocliente.setE_s_tc(rs.getString(5));
                    c_tipocliente.setNroorden(rs.getString(6));
                    c_tipocliente.setFechahora(rs.getString(7));
                    c_tipocliente.setUsuario(rs.getString(8));
                    c_tipocliente.setEstado(rs.getInt(9));
                    c_tipocliente.setRetiro(rs.getInt(10));
                    c_tipocliente.setNrocuenta(rs.getInt(11));
                    c_tipocliente.setId_tc(rs.getInt(12));
                    c_tipocliente.setObservacion(rs.getString(13));

                    lista_event_sql.add(c_tipocliente);
                } else if (rs.getInt(9) == 3) {
                    tipocliente c2_tipocliente = new tipocliente();
                    c2_tipocliente.setCategoria(rs.getString(1));
                    c2_tipocliente.setTarjeta(rs.getString(2));
                    c2_tipocliente.setLegajo(rs.getString(3));
                    c2_tipocliente.setNombre(rs.getString(4));
                    c2_tipocliente.setE_s_tc(rs.getString(5));
                    c2_tipocliente.setNroorden(rs.getString(6));
                    c2_tipocliente.setFechahora(rs.getString(7));
                    c2_tipocliente.setUsuario(rs.getString(8));
                    c2_tipocliente.setEstado(rs.getInt(9));
                    c2_tipocliente.setRetiro(rs.getInt(10));
                    c2_tipocliente.setNrocuenta(rs.getInt(11));
                    c2_tipocliente.setId_tc(rs.getInt(12));
                    c2_tipocliente.setObservacion(rs.getString(13));

                    lista_event_sql2.add(c2_tipocliente);

                }
            }
        } catch (SQLException e) {
            System.out.println("Thread 3 Ecommerce -->Error consulta_eventos selectAll " + e);
        }
        System.out.println("2_Guardando lista con Registros......");

        try {
            ps.close();
            rs.close();
            //con.close();
        } catch (SQLException ex) {
            System.out.println("Error1_ consulta_ecommerce " + ex);
        }
        
        ////// FIN consulta1 SQL
        
        
        
        /////////////// Consulta 2 SQL (Revisar PAGO=SI) //////////////
                ///CONSUlta 1 SQl SERVER
        try {
            //con = conexiones.Conexion_SQL();
            ps = con.prepareStatement(SQL_Pago);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(9) == 0) {
                    tipocliente d1_tipocliente = new tipocliente();
                    d1_tipocliente.setEvento_id(rs.getBigDecimal(1));
                    lista_pago.add(d1_tipocliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error consulta2_eventos SQL " + e);
        }

        try {
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error1_ consulta2_ecommerce SQL " + ex);
        }
        
        ///// UPDATE en BARRERAS DE SAIDAS PAGO='SI' ////////////////////
        if (lista_pago != null && !lista_pago.isEmpty()) {
            cerrar_con_mysql();
            for (int j = 0; j < lista_egr.size(); j++) {
                conexiones.host = lista_egr.get(j).getIp().trim();
                conexiones.database = lista_egr.get(j).getDatabase().trim();
                conexiones.user = lista_egr.get(j).getUser().trim();
                conexiones.password = lista_egr.get(j).getPassword().trim();
                conexiones.port = lista_egr.get(j).getPort().trim();
                con_mysql = conexiones.Conexion_mysql();                
                    for (int i = 0; i < lista_pago.size(); i++) {
                        //System.out.println("Update Pago Egresos..: " + lista_event_sql.get(i).getCategoria().trim() + " NOMBRE " + lista_event_sql.get(i).getNombre().trim() + " TARJETA " + lista_event_sql.get(i).getTarjeta().trim() + " LEGAJO: " + lista_event_sql.get(i).getLegajo().trim());
                        try {
                            ps_mysql = con_mysql.prepareStatement(SQL_update_pago);
                            ps_mysql.setBigDecimal(1, lista_pago.get(i).getEvento_id());                            
                            ps_mysql.executeUpdate();

                        } catch (Exception e) {
                            System.out.println("Thread 3 Ecommerce EGRESOS-->Error En Metodo Update Pago " + e);
                        }
                    }
                    try {
                        ps_mysql.close();
                        con_mysql.close();
                    } catch (SQLException ex) {
                        System.out.println("Error22_ consulta_ecommerce pago " + ex);
                    }
            }
            
        }
        
        ///// FIN UPDATE salids pago=SI
        
        
        
        
        ////////////// FIN consulta2 SQL ////////////////////////////

        if (lista_event_sql != null && !lista_event_sql.isEmpty() || lista_event_sql2 != null && !lista_event_sql2.isEmpty()) {

            System.out.println("3_Actualizando registros en Egresos.... ");
            /////EGRESOS////////////
            cerrar_con_mysql();
            for (int j = 0; j < lista_egr.size(); j++) {

                conexiones.host = lista_egr.get(j).getIp().trim();
                conexiones.database = lista_egr.get(j).getDatabase().trim();
                conexiones.user = lista_egr.get(j).getUser().trim();
                conexiones.password = lista_egr.get(j).getPassword().trim();
                conexiones.port = lista_egr.get(j).getPort().trim();
                con_mysql = conexiones.Conexion_mysql();

                if (lista_event_sql != null && !lista_event_sql.isEmpty()) {
                    for (int i = 0; i < lista_event_sql.size(); i++) {

                        System.out.println("Guardando Egresos.. Categoria: " + lista_event_sql.get(i).getCategoria().trim() + " NOMBRE " + lista_event_sql.get(i).getNombre().trim() + " TARJETA " + lista_event_sql.get(i).getTarjeta().trim() + " LEGAJO: " + lista_event_sql.get(i).getLegajo().trim());
                        try {

                            ps_mysql = con_mysql.prepareStatement(SQL_INSERT_evento_mysql);
                            ps_mysql.setString(1, lista_event_sql.get(i).getCategoria());
                            ps_mysql.setString(2, lista_event_sql.get(i).getTarjeta());
                            ps_mysql.setString(3, lista_event_sql.get(i).getLegajo());
                            ps_mysql.setString(4, lista_event_sql.get(i).getNombre());
                            //ps_mysql.setString(5, lista_event_sql.get(i).getE_s_tc());
                            ps_mysql.setString(5, "E");
                            ps_mysql.executeUpdate();

                        } catch (Exception e) {
                            System.out.println("Thread 3 Ecommerce EGRESOS-->Error En Metodo INSERT 'MySQL' " + e);
                        }
                    }
                    try {
                        ps_mysql.close();
                        //con_mysql.close();
                    } catch (SQLException ex) {
                        System.out.println("Error21_ consulta_ecommerce " + ex);
                    }
                }

                ////// Elimino estados=3 que vienen en lista_event_sql2 en Egresos /////////////////
                if (lista_event_sql2 != null && !lista_event_sql2.isEmpty()) {

                    for (int i = 0; i < lista_event_sql2.size(); i++) {

                        System.out.println("Eliminando estados 3 de Egresos...Tarjeta: " + lista_event_sql2.get(i).getTarjeta().trim());
                        try {

                            ps_mysql = con_mysql.prepareStatement(SQL_Eliminar_estado3);
                            ps_mysql.setString(1, lista_event_sql2.get(i).getTarjeta());
                            ps_mysql.executeUpdate();

                        } catch (Exception e) {
                            System.out.println("Thread 3 Ecommerce EGRESOS-->Error En Metodo INSERT 'MySQL' " + e);
                        }
                    }
                    try {
                        ps_mysql.close();
                        con_mysql.close();
                    } catch (SQLException ex) {
                        System.out.println("Error21_ Eliminar estado 3 " + ex);
                    }
                }

                ////// FINNN Elimino estados=3 que vienen en lista_event_sql2 /////////////////     
                try {
                    ps_mysql.close();
                    con_mysql.close();
                } catch (SQLException ex) {
                    System.out.println("Error22_  " + ex);
                }

            }

            /////INGRESOS///////////////
            cerrar_con_mysql();

            System.out.println("4_Actualizando registros en Ingresos.... ");
            for (int j = 0; j < lista_ingr.size(); j++) {
                conexiones.host = lista_ingr.get(j).getIp().trim();
                conexiones.database = lista_ingr.get(j).getDatabase().trim();
                conexiones.user = lista_ingr.get(j).getUser().trim();
                conexiones.password = lista_ingr.get(j).getPassword().trim();
                conexiones.port = lista_ingr.get(j).getPort().trim();
                con_mysql = conexiones.Conexion_mysql();

                if (lista_event_sql != null && !lista_event_sql.isEmpty()) {
                    for (int i = 0; i < lista_event_sql.size(); i++) {
                        System.out.println("Guardando Ingresos... Categoria: " + lista_event_sql.get(i).getCategoria().trim() + " NOMBRE " + lista_event_sql.get(i).getNombre().trim() + " TARJETA " + lista_event_sql.get(i).getTarjeta().trim() + " LEGAJO: " + lista_event_sql.get(i).getLegajo().trim());

                        try {
                            ps_mysql.close();
                            ps_mysql = con_mysql.prepareStatement(SQL_INSERT_evento_mysql);
                            ps_mysql.setString(1, lista_event_sql.get(i).getCategoria().trim());
                            ps_mysql.setString(2, lista_event_sql.get(i).getTarjeta().trim());
                            ps_mysql.setString(3, lista_event_sql.get(i).getLegajo().trim());
                            ps_mysql.setString(4, lista_event_sql.get(i).getNombre().trim());
                            //ps_mysql.setString(5, lista_event_sql.get(i).getE_s_tc().trim());
                            ps_mysql.setString(5, "S");
                            ps_mysql.executeUpdate();
                        } catch (Exception e) {
                            System.out.println("Thread 3 Ecommerce INGRESOS -->Error En Metodo INSERT 'MySQL' " + e);
                            InetAddress ping;
                            String ip = conexiones.host.trim(); // Ip de la máquina remota
                            try {
                                ping = InetAddress.getByName(ip);
                                if (ping.isReachable(5000)) {
                                    System.out.println("Thread 3 Ecommerce INGRESOS-->PING------> a IP: " + ip + " RESPONDE CORRECTAMENTE");
                                    System.out.println("");
                                } else {
                                    System.out.println("Thread 3 Ecommerce INGRESOS-->NO HAY PING------> a IP: " + ip + " ERROR ERROR!!!");
                                    System.out.println("");
                                }
                            } catch (IOException ex) {
                                System.out.println("Thread 3 Ecommerce INGRESOS-->Error en Ping " + ex);
                            }
                        }
                    }
                    try {
                        ps_mysql.close();
                        //con_mysql.close();
                    } catch (SQLException ex) {
                        System.out.println("Error3_ consulta_ecommerce " + ex);
                    }
                }

                             ////// Elimino estados=3 que vienen en lista_event_sql2 en INGRESOS/////////////////
                if (lista_event_sql2 != null && !lista_event_sql2.isEmpty()) {

                    for (int i = 0; i < lista_event_sql2.size(); i++) {

                        System.out.println("Eliminando estados 3 de Egresos...Tarjeta: " + lista_event_sql2.get(i).getTarjeta().trim());
                        try {

                            ps_mysql = con_mysql.prepareStatement(SQL_Eliminar_estado3);
                            ps_mysql.setString(1, lista_event_sql2.get(i).getTarjeta());
                            ps_mysql.executeUpdate();

                        } catch (Exception e) {
                            System.out.println("Thread 3 Ecommerce EGRESOS-->Error En Metodo INSERT 'MySQL' " + e);
                        }
                    }
                    try {
                        ps_mysql.close();
                        con_mysql.close();
                    } catch (SQLException ex) {
                        System.out.println("Error21_ Eliminar estado 3 " + ex);
                    }
                }

                ////// FINNN Elimino estados=3 que vienen en lista_event_sql2 en INGRESOS /////////////////  
                cerrar_con_mysql();

            }
            ////////UPDATE campo estado en SQL////////////

            con = conexiones.Conexion_SQL();
            if (lista_event_sql != null && !lista_event_sql.isEmpty()) {
                for (int i = 0; i < lista_event_sql.size(); i++) {
                    System.out.println("Update SQL... Categoria: " + lista_event_sql.get(i).getCategoria().trim() + " NOMBRE " + lista_event_sql.get(i).getNombre().trim() + " TARJETA " + lista_event_sql.get(i).getTarjeta().trim() + " LEGAJO: " + lista_event_sql.get(i).getLegajo().trim());

                    try {
                        ps = con.prepareStatement(SQL_update_estado);
                        ps.setString(1, "4");
                        ps.setString(2, lista_event_sql.get(i).getTarjeta().trim());
                        ps.executeUpdate();
                        ps.close();
                    } catch (Exception e) {
                        System.out.println("Thread 0 EC -->Error En Metodo update estado 'SQL' " + e);

                    }
                }
                try {
                    //con.close();
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error4_ al cerrar conexiones_ecommerce " + ex);
                }
            }

            /////// ELimino estado=3 de SQL Server ////////////////////////         
            if (lista_event_sql2 != null && !lista_event_sql2.isEmpty()) {
                for (int i = 0; i < lista_event_sql2.size(); i++) {
                    System.out.println("Eliminando estados 3 de Egresos...Tarjeta: " + lista_event_sql2.get(i).getTarjeta().trim());

                    try {
                        ps = con.prepareStatement(SQL_Eliminar_estado3);
                        ps.setString(1, lista_event_sql2.get(i).getTarjeta());
                        ps.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Thread 0 EC -->Error En Metodo eliminar estados=3 'SQL' " + e);

                    }
                }
                try {
                    con.close();
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error4_ al cerrar conexiones_ecommerce_estado3 " + ex);
                }
            }

            ////////////// FIN elimino estado=3 de Sql Server /////////////////////////////
        }
        System.out.println("FIN de CICLO.... ");
        cerrar_con_mysql();
        cerrar_con();

        return null;

    }

    ////////////////////////////////////////PROCESO actualizar TODO/////////////////////////////////////////
    ////////EL PROCESO DEMORA PROMEDIO 5 seg.(5000)*4000(vueltas)=20000000(milisegundoss,(20000)segundos, (5.5) horas).

    private void actualizar_tipocliente() {
        if (contador <= 10) {
            estado_consulta = false;
            contador = 4000;
        }
        contador--;
        System.out.println("");
        System.out.println("METODO ACTUALIZAR TIPOCLIENTE, VALOR DE CONTADOR= " + contador);
        System.out.println("");

    }

    @Override
    public List<tipocliente> ip_egreso() {
        return null;
    }

    @Override
    public List<tipocliente> dni() {
        return null;
    }

    private void cerrar_con() {
        for (int i = 0; i <= 10; i++) {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    if (!con.isClosed()) {
                        con.close();
                    }
                }
            } catch (SQLException e) {
                // ignore
            }
        }

    }

    private void cerrar_con_mysql() {
        for (int i = 0; i <= 10; i++) {
            try {
                if (rs_mysql != null) {
                    rs_mysql.close();
                }
                if (ps_mysql != null) {
                    ps_mysql.close();
                }
                if (con_mysql != null) {
                    if (!con_mysql.isClosed()) {
                        con_mysql.close();
                    }
                }
            } catch (SQLException e) {
                // ignore
            }
        }
    }

    @Override
    public List<tipocliente> ip_ingreso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<tipocliente> insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(tipocliente t) {
        return 0;
    }

    @Override
    public int delete(int key) {
        return 0;
    }

    @Override
    public tipocliente select(int key) {
        return null;
    }

    @Override
    public List<tipocliente> selectAll() {
        return null;
    }

}
