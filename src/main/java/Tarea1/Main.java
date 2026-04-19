package Tarea1;

public class Main {
    static public void main(String[] args) {
        Moneda m1 = new Moneda1500();
        Expendedor ex = new Expendedor(2, 500);
        Comprador c1 = new Comprador(m1, 1, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queBebiste());
        m1 = new Moneda1500();
        c1 = new Comprador(m1, 1, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queBebiste());
        m1 = new Moneda1500();
        c1 = new Comprador(m1, 1, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queBebiste());
    }
}