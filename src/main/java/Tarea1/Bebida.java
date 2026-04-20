package Tarea1;

abstract class Bebida extends Producto{
    private int serie;
    private int precio;

    public Bebida(int serieIn, int precioIn) {super(serieIn, precioIn);}

    public abstract String beber();
}
