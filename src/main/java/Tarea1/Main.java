/**
 * Tarea 1 de Desarrollo Orientado a Objetos
 * @author Benjamín Antonio Rivas Sepulveda
 * @author Ignacio Moisés Lama Méndez
 * @author Joaquín Enrique Jara Troncoso
*/
package Tarea1;

public class Main {
    static public void main(String[] args) {
        Moneda m1 = new Moneda1500();
        Expendedor ex = new Expendedor(2, 500);
        Comprador c1 = new Comprador(m1, 5, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queConsumiste());
        m1 = new Moneda1000();
        c1 = new Comprador(m1, 5, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queConsumiste());
        m1 = new Moneda500();
        c1 = new Comprador(m1, 5, ex);
        System.out.println(c1.cuantoVuelto());
        System.out.println(c1.queConsumiste());
    }
}