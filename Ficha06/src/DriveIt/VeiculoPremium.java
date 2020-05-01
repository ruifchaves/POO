package DriveIt;

import java.time.Year;

public class VeiculoPremium extends Veiculo{
    private double taxaLuxo;

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

    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        VeiculoPremium vp = (VeiculoPremium) o;
        return taxaLuxo == vp.getTaxaLuxo();
    }
    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }

    public String toString(){ //nao usar o .append(super.toString()); mas sim os gets definidos na super class
        StringBuilder sb = new StringBuilder();
        sb.append("\nVeículoPremium: ")
                .append("  matricula: ").append(getMatricula())
                .append(", marca: ").append(getMarca())
                .append(", modelo: ").append(getMarca())
                .append(", ano de construção: ").append(getAnoConstrucao())
                .append(", velocidade média por km: ").append(getAvgSpeedKm())
                .append(", preço teórico base por km: ").append(getAvgPriceKm())
                .append(", rating: ").append(getRating())
                .append(", kms totais realizados: ").append(getTotalKms())
                .append(", taxa de luxo: ").append(taxaLuxo);
        return sb.append('\n').toString();
    }
}
