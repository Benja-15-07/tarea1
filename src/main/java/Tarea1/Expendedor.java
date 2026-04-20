package Tarea1;

class Expendedor{
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;

    public Expendedor(int size, int precioIn){
        this.precio = precioIn;
        coca = new Deposito<Bebida>(this.precio);
        sprite = new Deposito<Bebida>(this.precio);
        for(int i = 0;i < size;i++){
            coca.addElemento(new CocaCola(i+100));
            sprite.addElemento(new Sprite(i+200));
        }
        monVu = new Deposito<Moneda>(0);
    }
    public Bebida comprarBebida(Moneda dinero, int type){
        if(dinero != null) {
            Deposito<Bebida> dep = null;
            if (type==COCA) dep = coca;
            else if(type==SPRITE) dep = sprite;

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