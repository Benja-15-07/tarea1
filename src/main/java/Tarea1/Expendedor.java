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
        coca = new Deposito<Producto>(Precios.COCACOLA.getPrecio());
        sprite = new Deposito<Producto>(Precios.SPRITE.getPrecio());
        fanta = new Deposito<Producto>(Precios.FANTA.getPrecio());
        snickers = new Deposito<Producto>(Precios.SNICKERS.getPrecio());
        super8 = new Deposito<Producto>(Precios.SUPER8.getPrecio());

        for(int i = 0;i < size;i++){
            coca.addElemento(new CocaCola(i+100));
            sprite.addElemento(new Sprite(i+200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i));
            super8.addElemento(new Super8(i+50));
        }
        monVu = new Deposito<Moneda>(0);
    }

    public Producto comprarProducto(Moneda dinero, int type){
        if(dinero != null) {
            Deposito<Producto> dep;
            if (type == 1) {dep = coca;}
            else if (type == 2) {dep = sprite;}
            else if (type == 3) {dep = fanta;}
            else if (type == 4) {dep = snickers;}
            else if (type == 5) {dep = super8;}
            else {dep = null;}

            if (dep != null && dinero.getValor() >= dep.getPrecio()) {
                Producto auxOut = (Producto) dep.getElemento();
                if(auxOut != null) {
                    int cantidadVuelto = (dinero.getValor() - dep.getPrecio()) / 100;
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