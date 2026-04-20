package Tarea1;
import java.util.ArrayList;

class Deposito<T> {
    private ArrayList<T> almacen;
    // NOTA : Todas las líneas asociadas a la variable "precio" deben ser eliminadas una vez se implemente el enum
    private int precio;
    public Deposito(int precioIn){
        almacen = new ArrayList<T>();
        this.precio = precioIn;
    }
    public void addElemento(T toAdd){
        almacen.add(toAdd);
    }
    public T getElemento(){
        if (almacen.size() != 0) return almacen.remove(0);
        else return null;
    }
    public int getPrecio(){return this.precio;}
}
