package Tarea1;

class Expendedor{
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private int precio;

    public Expendedor(int size, int precioIn){
        this.precio = precioIn;
        coca = new Deposito(this.precio);
        sprite = new Deposito(this.precio);
        for(int i = 0;i < size;i++){
            coca.addBebida(new CocaCola(i+100));
            sprite.addBebida(new Sprite(i+200));
        }
        monVu = new DepositoM();
    }
    public Bebida comprarBebida(Moneda dinero, int type){
        if(dinero != null) {
            Deposito dep = null;
            if (type==COCA) dep = coca;
            else if(type==SPRITE) dep = sprite;

            if (dep != null && dinero.getValor() >= dep.getPrecio()) {
                Bebida auxOut = dep.getBebida();
                if(auxOut != null) {
                    int cantidadVuelto = (dinero.getValor() - dep.getPrecio()) / 100;
                    for (int i = 0; i < cantidadVuelto; i++) {
                        monVu.addMoneda(new Moneda100());
                    }
                    return auxOut;
                }
                else {
                    monVu.addMoneda(dinero);
                    return null;
                }
            } else {
                monVu.addMoneda(dinero);
                return null;
            }
        }
        else {
            monVu.addMoneda(null);
            return null;
        }
    }
    public Moneda getVuelto() {
        return monVu.getVuelto();
    }
}