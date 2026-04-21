package Tarea1;

public enum Precios {
    COCACOLA(800, 1),
    SPRITE(600, 2),
    FANTA(700, 3),
    SNICKERS(900, 4),
    SUPER8(200, 5);
    private int precio;
    private int id;
    Precios(int precio, int id){
        this.precio=precio;
        this.id = id;
    }
    public int getPrecio(){
        return precio;
    }
    public int getID(){
        return id;
    }
}
