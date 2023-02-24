package datos;

public class dispositivos {
    private String descripcion;
    private String ip;
    private String ingegr;
    private String database;
    private String user;
    private String password;
    private String port;

    public dispositivos(String descripcion, String ip, String ingegr, String database, String user, String password, String port) {
        this.descripcion = descripcion;
        this.ip = ip;
        this.ingegr = ingegr;
        this.database = database;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public dispositivos() {
    } 
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIngegr() {
        return ingegr;
    }

    public void setIngegr(String ingegr) {
        this.ingegr = ingegr;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    

}