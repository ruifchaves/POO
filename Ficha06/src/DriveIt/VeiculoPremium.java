package DriveIt;

import java.time.Year;

public class VeiculoPremium extends Veiculo{
    private double taxaLuxo;
    final String tipo = "VeiculoPremium";

    public VeiculoPremium(){
        super();
        taxaLuxo = 0.0;
    }
    public VeiculoPremium(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms, double il){
        super(mat, mar, mod, yr, vel, price, rtg, kms);
        taxaLuxo = il;
    }
    public VeiculoPremium(VeiculoPremium vp){
        super(vp);
        taxaLuxo = vp.getTaxaLuxo();
    }

    public double getTaxaLuxo(){
        return taxaLuxo;
    }
    public void setTaxaLuxo(double newTax){
        taxaLuxo = newTax;
    }
    public String getTipo(){
        return tipo;
    }

    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        VeiculoPremium vp = (VeiculoPremium) o;
        return taxaLuxo == vp.getTaxaLuxo();
    }
    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("VeiculoPremium: ") //nao usar o super mas sim os gets definidos em veiculo
                .append(super.toString())
                .append("  taxa veiculo premium: ").append(taxaLuxo).append('\n');
        return sb.toString();
    }
}
