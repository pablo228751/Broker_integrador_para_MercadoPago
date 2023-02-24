package datos;
import java.math.BigDecimal;

public class tipocliente {
    private BigDecimal evento_id;   
    private String categoria;
    private String tarjeta;
    private String legajo;
    private String nombre;
    private String e_s_tc;
    private String nroorden;
    private String fechahora;
    private String usuario;
    private int estado;
    private int retiro;
    private int nrocuenta;
    private int id_tc;
    private String observacion;
    
            
    public tipocliente() {
        super();
    }

    public tipocliente(BigDecimal evento_id,String categoria, String tarjeta, String legajo, String nombre, String e_s_tc, String nroorden, String fechahora, String usuario, int estado, int retiro, int nrocuenta, int id_tc, String observacion) {
        super();
        this.evento_id = evento_id;
        this.categoria = categoria;
        this.tarjeta = tarjeta;
        this.legajo = legajo;
        this.nombre = nombre;
        this.e_s_tc = e_s_tc;
        this.nroorden = nroorden;
        this.fechahora = fechahora;
        this.usuario = usuario;
        this.estado = estado;
        this.retiro = retiro;
        this.nrocuenta = nrocuenta;
        this.id_tc = id_tc;
        this.observacion = observacion;        
    }
    
    
    
    
    public BigDecimal getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(BigDecimal evento_id) {
        this.evento_id = evento_id;
    } 
    
    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getE_s_tc() {
        return e_s_tc;
    }

    public void setE_s_tc(String e_s_tc) {
        this.e_s_tc = e_s_tc;
    } 

    public int getId_tc() {
        return id_tc;
    }

    public void setId_tc(int id_tc) {
        this.id_tc = id_tc;
    }
    public String getNroorden() {
        return nroorden;
    }

    public void setNroorden(String nroorden) {
        this.nroorden = nroorden;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getRetiro() {
        return retiro;
    }

    public void setRetiro(int retiro) {
        this.retiro = retiro;
    }

    public int getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(int nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}
