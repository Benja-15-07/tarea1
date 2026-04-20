package Tarea1;

abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){}
    public int getSerie(){
        return this.hashCode();
    }
    public abstract int getValor();

    @Override
    public String toString() {
        return "valor:"+this.getValor()+"; serie:"+this.getSerie();
    }

    @Override
    public int compareTo(Moneda o) {
        return this.getValor()-o.getValor();
    }
}