/**
 * Write a description of class Lampada here.
 *
 * @author MaterialPOO
 * @version 20200326
 */


public class Lampada
{
    //0 desligado, 1 ligado, 2 eco
    public static final int OFF= 0;
    public static final int ON = 1;
    public static final int ECO = 2;
    private int modo;

    private final double consumoNormal = 0.1;
    private final double consumoEco = 0.05;
    private double total;
    private double cperiodo;
    private long stamp;


    public Lampada() {
        this.modo = 0;
        this.total = 0;
        this.cperiodo = 0;
        this.stamp = System.currentTimeMillis();
    }

    public Lampada(Lampada l){
        this.modo = l.getModo();
        this.total = l.totalConsumo();
        this.cperiodo = l.periodoConsumo();
        this.stamp = l.getStamp();

    }

    public Lampada(double total, double cperiodo, long stamp) {
        this.modo = 0;
        this.total = total;
        this.cperiodo = cperiodo;
        this.stamp = stamp;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public long getStamp() {
        return stamp;
    }

    public void lampON() {
        this.actualizaConsumo();
        this.modo = 1;
    }

    public void lampOFF() {
        this.actualizaConsumo();
        this.modo = 0;
    }

    public void lampECO() {
        this.actualizaConsumo();
        this.modo = 2;
    }

    public void resetPeriodo(){
        actualizaConsumo();
        this.cperiodo = 0;
    }

    public double getTotal() {
        return total;
    }

    public double getCperiodo() {
        return cperiodo;
    }

    public double periodoConsumo(){
        actualizaConsumo();
        return cperiodo;
    }
    public double totalConsumo() {
        actualizaConsumo();
        return total;
    }

    private void actualizaConsumo() {
        long periodo = System.currentTimeMillis() - stamp;
        if(this.modo == 1) {
            this.total += consumoNormal*periodo;
            this.cperiodo += consumoNormal*periodo;
        } else if(this.modo == 2) {
            this.total += consumoEco*periodo;
            this.cperiodo += consumoEco*periodo;
        }
        this.stamp = System.currentTimeMillis();
    }

    public double getConsumoNormal() {
        return consumoNormal;
    }

    public double getConsumoEco() {
        return consumoEco;
    }

    public Lampada clone(){
        return  new Lampada(this);
    }

    @Override
    public String toString() {
        return "Lampada{" +
                "modo=" + modo +
                ", consumoNormal=" + consumoNormal +
                ", consumoEco=" + consumoEco +
                ", total=" + total +
                ", cperiodo=" + cperiodo +
                ", stamp=" + stamp +
                '}';
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if( o == null || o.getClass() != this.getClass()) return false;
        Lampada l = (Lampada)o;
        return (l.getModo() == this.getModo() &&
                l.getTotal() == this.getTotal() &&
                l.getCperiodo() == this.getCperiodo() &&
                l.getConsumoEco() == this.getConsumoEco() &&
                l.getConsumoNormal() == this.getConsumoNormal()
        );
    }
}
