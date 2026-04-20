package Tarea1;

public enum Precios {
    COCACOLA(800),
    SPRITE(600),
    FANTA(700),
    SNICKERS(900),
    SUPER8(200);
    private int precio;
    Precios(int precio){
        this.precio=precio;
    }
    public int getPrecio(){
        return precio;
    }
}
