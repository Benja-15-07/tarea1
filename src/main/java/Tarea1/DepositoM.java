package Tarea1;
import java.util.ArrayList;

class DepositoM {
    private ArrayList<Moneda> monedas;
    public DepositoM(){
        this.monedas = new ArrayList<Moneda>();
    }
    public void addMoneda(Moneda cual) {
        this.monedas.add(cual);
    }
    public Moneda getVuelto(){
        if (monedas.size() != 0) return this.monedas.remove(0);
        else return null;
    }
}
