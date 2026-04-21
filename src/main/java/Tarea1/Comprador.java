package Tarea1;

/**
 * La clase del cliente y usuario de Expendedor.
 * Al ser instanciado, instantáneamente compra un producto con una moneda.
 * Almacena el consumo del producto que compra y el vuelto que recibe moneda por moneda.
 */
class Comprador {
    /** sonido almacena el string de "consumir" de cada producto. */
    private String sonido;
    /** vuelto almaacena el valor total de todas las monedas recojidas del expendedor. */
    private int vuelto;

    /**
     * Método constructor que recibe el dónde, qué y cómo de la compra del consumidor, y maneja el recibo de vuelto
     *
     * @param m Moneda con la que se compra el producto
     * @param cualProducto El número identificador del producto a comprar
     * @param exp La instancia del expendedor al que le va a comprar
    */
    public Comprador(Moneda m, int cualProducto, Expendedor exp){
        Producto b = exp.comprarProducto(m, cualProducto);
        if(b != null) this.sonido = b.consumir();
        Moneda efectivo = exp.getVuelto();
        while (efectivo != null && efectivo.getValor() == 100) {
            this.vuelto += efectivo.getValor();
            efectivo = exp.getVuelto();
        }
        if(efectivo != null) this.vuelto += efectivo.getValor();
    }
    /** Getter de vuelto */
    public int cuantoVuelto(){
        return this.vuelto;
    }
    /** Getter del producto comprado*/
    public String queConsumiste(){
        return this.sonido;
    }
}
