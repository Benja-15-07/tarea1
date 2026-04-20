package Tarea1;

abstract class Bebida extends Producto{
    public Bebida(int serieIn, int precioIn) {super(serieIn, precioIn);}

    public abstract String beber();
}
