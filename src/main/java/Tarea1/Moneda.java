package Tarea1;

abstract class Moneda {
    public Moneda(){}
    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}