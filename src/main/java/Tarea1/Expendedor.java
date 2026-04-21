package Tarea1;

class Expendedor{
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;

    private Deposito<Moneda> monVu;

    private int precio;
    public Expendedor(int size, int precioIn){
        this.precio = precioIn;
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

    public Producto comprarProducto(Moneda dinero, int type){
        if(dinero != null) {
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

            if (dep != null && dinero.getValor() >= productoActual.getPrecio()) {
                Producto auxOut = (Producto) dep.getElemento();
                if(auxOut != null) {
                    int cantidadVuelto = (dinero.getValor() - productoActual.getPrecio()) / 100;
                    for (int i = 0; i < cantidadVuelto; i++) {
                        monVu.addElemento(new Moneda100());
                    }
                    return auxOut;
                }
                else {
                    monVu.addElemento(dinero);
                    return null;
                }
            } else {
                monVu.addElemento(dinero);
                return null;
            }
        }
        else {
            monVu.addElemento(null);
            return null;
        }
    }
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}