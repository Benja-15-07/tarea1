package Tarea1;

abstract class Producto {
    private int serie;

    public Producto(int serieIn) {
        this.serie = serieIn;
    }
    public abstract String consumir();

    public int getSerie() {return this.serie;}
}

