package Tarea1;

abstract class Producto {
    private int serie;
    // NOTA : Todas las líneas asociadas a la variable "precio" deben ser eliminadas o retrabajadas una vez se implemente el enum
    private int precio;

    public Producto(int serieIn, int precioIn) {
        this.serie = serieIn;
        this.precio = precioIn;
    }
    public int getSerie() {return this.serie;}
    public int getPrecio() {return this.precio;}
}

