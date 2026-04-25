package Tarea1;

import java.util.Scanner;

public class main_interactivo {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Moneda moneda = null;
        Expendedor expendedor = new Expendedor(5);
        Comprador comprador = null;
        boolean quedarte = true;

        System.out.println("Ves una expendedora\n1)Comprar algo\n2)Irte");

        if(sc.nextInt()==1){
            while(quedarte){
                System.out.println("¿Que moneda usaras?\n1) 100\n2) 500\n3) 1000\n4) 1500\n5)Probar sin usar monedas");
                switch (sc.nextInt()){
                    case 1:
                        moneda = new Moneda100();
                        break;
                    case 2:
                        moneda = new Moneda500();
                        break;
                    case 3:
                        moneda = new Moneda1000();
                        break;
                    case 4:
                        moneda = new Moneda1500();
                        break;
                    case 5:
                        moneda = null;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        continue;
                }

                System.out.println("En la expendedora hay:\n1)Coca Cola\n2)Sprite" +
                                         "\n3)Fanta\n4)Snickers\n5)Super8\n6)Irte");

                boolean seleccionando = true;
                while (seleccionando) {
                    int opcion = sc.nextInt();

                    if (opcion == 6) {
                        quedarte = false;
                        seleccionando = false;
                    } else if (opcion < 1 || 6 < opcion) {
                        System.out.println("Ingreso invalido");
                        continue;
                    } else {
                        try {
                            comprador = new Comprador(moneda, opcion, expendedor);
                            moneda = null;
                            seleccionando = false;
                        } catch (NoHayProductoException e) {
                            System.out.println(e.getMessage());
                        } catch (PagoInsuficienteException e) {
                            System.out.println(e.getMessage());
                        } catch (PagoIncorrectoException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if(comprador != null) {


                    if (comprador.queConsumiste() != null) {
                        System.out.println("Compraste algo\n¿Consumir?\n1)si\n2)no");
                        if (sc.nextInt() == 1) {
                            System.out.println(comprador.queConsumiste());
                        }
                    }

                    System.out.println("¿Tomar el vuelto?\n1)si\n2)no");
                    if (sc.nextInt() == 1) {
                        System.out.println("Sacaste: " + comprador.cuantoVuelto());
                    }


                    System.out.println("¿Volver a intentar?\n1)si\n2)no");
                    if (sc.nextInt() == 2) {
                        quedarte = false;
                    }
                }
                comprador = null;
            }
        }
        sc.close();
    }
}
