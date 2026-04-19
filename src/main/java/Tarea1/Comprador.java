package Tarea1;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida b = exp.comprarBebida(m, cualBebida);
        if(b != null) this.sonido = b.beber();
        Moneda efectivo = exp.getVuelto();
        while (efectivo != null && efectivo.getValor() == 100) {
            this.vuelto += efectivo.getValor();
            efectivo = exp.getVuelto();
        }
        if(efectivo != null) this.vuelto += efectivo.getValor();
    }
    public int cuantoVuelto(){
        return this.vuelto;
    }
    public String queBebiste(){
        return this.sonido;
    }
}
