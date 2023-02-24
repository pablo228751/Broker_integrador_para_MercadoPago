package Interfaces;


import java.util.List;

public interface operaciones<T> {
    public List<T> insert();
    public int update(T t);
    public int delete(int key);
    public T select(int key);
    public List<T> selectAll();
    public List<T> ip_ingreso();
    public List<T> ip_egreso(); 
    public List<T> tipocliente();
    public List<T> dni(); 
}

