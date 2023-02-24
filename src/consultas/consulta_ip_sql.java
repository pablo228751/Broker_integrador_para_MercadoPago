package consultas;
import Interfaces.operaciones;
import conexiones.conexiones;
import datos.dispositivos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class consulta_ip_sql implements operaciones<dispositivos>{
    
        private static final String SQL_selectIP="SELECT * FROM barrera_local WHERE activa = 1 and ingegr=?";
        private ResultSet rs;
        private PreparedStatement ps;
        private Connection con;
        
    @Override
    public int update(dispositivos t) {return 0;}
    @Override
    public int delete(int key) {return 0;}
    @Override
    public dispositivos select(int key) {return null;}
    @Override
    public List<dispositivos> selectAll() {return null;}
    
    @Override
    public List<dispositivos> ip_ingreso() {
            cerrar_con();
            List<dispositivos> lista= new ArrayList<>();
            try{
                con=conexiones.Conexion_SQL();
                ps=con.prepareStatement(SQL_selectIP);
                ps.setString(1, "I");
                rs=ps.executeQuery();
            
            while(rs.next()){
                dispositivos disp= new dispositivos();            
                disp.setIp(rs.getString("ip"));
                disp.setDatabase(rs.getString("base"));
                disp.setUser(rs.getString("usuario"));
                disp.setPassword(rs.getString("clave"));
                disp.setPort(rs.getString("puerto"));
                lista.add(disp);        
            }
                rs.close();
                con.close();
            
                }catch(SQLException e){
                    System.out.println("Thread 0 -->Error consulta_eventos INGRESO "+e);            
                }
            return lista;    
    }

    @Override
    public List<dispositivos> ip_egreso(){
        cerrar_con();
            List<dispositivos> lista= new ArrayList<>();
            try{
                con=conexiones.Conexion_SQL();
                ps=con.prepareStatement(SQL_selectIP);
                ps.setString(1, "E");
                rs=ps.executeQuery();
            
            while(rs.next()){
                dispositivos disp= new dispositivos();           
                disp.setIp(rs.getString("ip"));
                disp.setDatabase(rs.getString("base"));
                disp.setUser(rs.getString("usuario"));
                disp.setPassword(rs.getString("clave"));
                disp.setPort(rs.getString("puerto"));
                lista.add(disp);             
            }
                rs.close();
                con.close();
                }catch(SQLException e){
                    System.out.println("Thread 0 -->Error consulta_eventos EGRESO "+e);
            
                }
                return lista;
    }

    
    @Override
    public List<dispositivos> insert() {return null;}

    @Override
    public List<dispositivos> dni() {return null;}

    private void cerrar_con() {
        for(int i=0;i<=10;i++){
                            try{
                                if (rs != null) rs.close();
                                if (ps != null) ps.close();
                                if (con != null) 
                              { if ( !con.isClosed() ) { con.close(); }
                                   }
                            }
                                catch (SQLException e){
                                // ignore
                                   }
        }
                
    }

    @Override
    public List<dispositivos> tipocliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

