package Tarea1;

class Expendedor{
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public static final int  FANTA=3;

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Moneda> monVu;
    private int precio;

    public Expendedor(int size, int precioIn){
        this.precio = precioIn;
        coca = new Deposito<Producto>(this.precio);
        sprite = new Deposito<Producto>(this.precio);
        fanta = new Deposito<Producto>(this.precio);
        for(int i = 0;i < size;i++){
            coca.addElemento(new CocaCola(i+100, this.precio));
            sprite.addElemento(new Sprite(i+200, this.precio));
            fanta.addElemento(new Fanta(i+300, this.precio));
        }
        monVu = new Deposito<Moneda>(0);
    }
    public Bebida comprarBebida(Moneda dinero, int type){
        if(dinero != null) {
            Deposito<Producto> dep;
            if (type == COCA) {dep = coca;}
            else if (type == SPRITE) {dep = sprite;}
            else if (type == FANTA) {dep = fanta;}
            else {dep = null;}

            if (dep != null && dinero.getValor() >= dep.getPrecio()) {
                Bebida auxOut = (Bebida) dep.getElemento();
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