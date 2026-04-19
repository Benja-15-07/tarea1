package Tarea1;
import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> bebidas;
    private int precio;
    public Deposito(int precioIn){
        bebidas = new ArrayList<Bebida>();
        this.precio = precioIn;
    }
    public void addBebida(Bebida toAdd){
        bebidas.add(toAdd);
    }
    public Bebida getBebida(){
        if (bebidas.size() != 0) return bebidas.remove(0);
        else return null;
    }
    public int getPrecio(){return this.precio;}
}
