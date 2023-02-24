package datos;

import java.math.BigDecimal;

public class eventos {
        private BigDecimal evento_id;
        private int barrera_id;
        private String tarjeta;
        private String e_s;        
        private String fecha_entrada;
        private String hora_entrada;
        private String pago;
        private String fecha_salida;
        private String hora_salida;
        private int mae_id;
        private String nombre;
        private String estado;
        private String e_s_tc;
        private String dni;
        private int barrera_entrada;
        private int barrera_salida;
        private String estado_impresora;
        private String guardia;

    public eventos() {super(); } 

    public eventos(BigDecimal evento_id, int barrera_id, String tarjeta, String e_s, String fecha_entrada, String hora_entrada, String pago, String fecha_salida, String hora_salida,int mae_id,String nombre, String estado, String e_s_tc, String dni, int barrera_entrada , int barrera_salida, String estado_impresora, String guardia) {
        super();
        this.evento_id = evento_id;
        this.barrera_id = barrera_id;
        this.tarjeta = tarjeta;
        this.e_s = e_s;
        this.fecha_entrada = fecha_entrada;
        this.hora_entrada = hora_entrada;
        this.pago = pago;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.mae_id = mae_id;
        this.nombre = nombre;
        this.estado = estado;
        this.e_s = e_s_tc;
        this.dni = dni;
        this.barrera_entrada = barrera_entrada;
        this.barrera_salida = barrera_salida;
        this.estado_impresora = estado_impresora;
        this.guardia = guardia;
    }
    public BigDecimal getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(BigDecimal evento_id) {
        this.evento_id = evento_id;
    }

    public int getBarrera_id() {
        return barrera_id;
    }

    public void setBarrera_id(int barrera_id) {
        this.barrera_id = barrera_id;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getE_s() {
        return e_s;
    }

    public void setE_s(String e_s) {
        this.e_s = e_s;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
     public int getMae_id() {
        return mae_id;
    }
     public void setMae_id(int mae_id) {
        this.mae_id = mae_id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public String getEstado() {
        return estado;
    }
     public void setEstado(String estado) {
        this.estado = estado;
    }
     public String getE_s_tc() {
        return e_s_tc;
    }

    public void setE_s_tc(String e_s_tc) {
        this.e_s_tc = e_s_tc;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getBarrera_entrada() {
        return barrera_entrada;
    }

    public void setBarrera_entrada(int barrera_entrada) {
        this.barrera_entrada = barrera_entrada;
    }
    public int getBarrera_salida() {
        return barrera_salida;
    }

    public void setBarrera_salida(int barrera_salida) {
        this.barrera_salida = barrera_salida;
    }
    public String getEstado_impresora() {
        return estado_impresora;
    }

    public void setEstado_impresora(String estado_impresora) {
        this.estado_impresora = estado_impresora;
    }
    public String getGuardia() {
        return guardia;
    }

    public void setGuardia(String guardia) {
        this.guardia = guardia;
    }

    
    
}
