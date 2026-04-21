package Tarea1;
import java.util.ArrayList;

class Deposito<T> {
    private ArrayList<T> almacen;

    public Deposito(){
        almacen = new ArrayList<T>();
    }
    public void addElemento(T toAdd){
        almacen.add(toAdd);
    }
    public T getElemento(){
        if (almacen.size() != 0) return almacen.remove(0);
        else return null;
    }
}
