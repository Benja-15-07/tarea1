package Tarea1;

abstract class Bebida {
    private int serie;

    public Bebida(int serieIn) {
        this.serie = serieIn;
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String beber();
}
