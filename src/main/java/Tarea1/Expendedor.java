package Tarea1;

/**
 * La clase Expendedor maneja los procesos principales del programa.
 * Es el encargado de recibir el dinero de un comprador, y responder apropiadamente según el producto que se pida.
*/
class Expendedor{
    /** Depósitos tipo Producto para cada producto disponible diferente */
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;

    /** Depósito reservado para almacenar las monedas del vuelto */
    private Deposito<Moneda> monVu;

    /**
     * Método constructor que inicializa todos los depósitos
     * Los depósitos de productos son llenados con una cantidad dada de elementos por igual,
     * El depósito de monedas de vuelto comienza vacío.
     *
     * @param size El tamaño de cada depósito de productos.
     */
    public Expendedor(int size){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        snickers = new Deposito<Producto>();
        super8 = new Deposito<Producto>();

        for(int i = 0;i < size;i++){
            coca.addElemento(new CocaCola(i+100));
            sprite.addElemento(new Sprite(i+200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i));
            super8.addElemento(new Super8(i+50));
        }
        monVu = new Deposito<Moneda>();
    }

    /**
     * Método principal, recibe una moneda y un tipo de producto y procesa si la moneda es suficiente para comprar el
     * producto elegido, devuelve el producto si corresponde y entrega monedas al depósito del vuelto si el pago es
     * mayor al precio del producto.
     *
     * @param dinero Moneda que el usuario usa para comprar un producto.
     * @param type Identificador numérico del tipo de producto elegido por el usuario.
     * @return El producto elegido por el usuario si el dinero es suficiente
    */
    public Producto comprarProducto(Moneda dinero, int type){
        /** La mayoría de la lógica sólo se ejecuta si hay dinero en primer lugar.*/
        if(dinero != null) {
            /**
             * Si hay dinero, se asigna el depósito dep del cual extraer
             * y se asigna el elemento productoActual del enum al que corresponde el producto deseado
            */
            Deposito<Producto> dep;
            Precios productoActual;

            if (type == Precios.COCACOLA.getID()) {
                dep = coca;
                productoActual = Precios.COCACOLA;
            }
            else if (type == Precios.SPRITE.getID()) {
                dep = sprite;
                productoActual = Precios.SPRITE;
            }
            else if (type == Precios.FANTA.getID()) {
                dep = fanta;
                productoActual = Precios.FANTA;
            }
            else if (type == Precios.SNICKERS.getID()) {
                dep = snickers;
                productoActual = Precios.SNICKERS;
            }
            else if (type == Precios.SUPER8.getID()) {
                dep = super8;
                productoActual = Precios.SUPER8;
            }
            else {
                dep = null;
                productoActual = null;
            }

            /**
             * Si el tipo de producto es válido y el depósito existe
             * y el dinero del cliente es mayor o igual al precio del producto entonces:
            */
            if (dep != null && dinero.getValor() >= productoActual.getPrecio()) {
                Producto auxOut = (Producto) dep.getElemento();
                /**
                 * Se revisa que queden productos en el depósito
                 * Si quedan: se entrega el producto deseado y se rellena el vuelto con monedas de 100.
                */
                if(auxOut != null) {
                    int cantidadVuelto = (dinero.getValor() - productoActual.getPrecio()) / 100;
                    for (int i = 0; i < cantidadVuelto; i++) {
                        monVu.addElemento(new Moneda100());
                    }
                    return auxOut;
                }
                /** Si no quedan: no se entrega ningún producto y el vuelto es la misma moneda inicial*/
                else {
                    monVu.addElemento(dinero);
                    return null;
                }
            }
            /**
             * Si el depósito no existe o el dinero es menor al precio del producto deseado,
             * no se entrega ningún producto y el vuelto es la misma moneda inicial
            */
            else {
                monVu.addElemento(dinero);
                return null;
            }
        }
        /** Si no hay dinero, no se compra ningún producto y no queda nada en el depósito del vuelto.*/
        else {
            monVu.addElemento(null);
            return null;
        }
    }
    /**
     * Retira y devuelve el primer elemento del depósito de vuelto.
     *
     * @return La primera moneda que llegó al depósito
    */
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}