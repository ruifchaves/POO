package DriveIt_abstract;

import java.io.Serializable;
import java.time.Year;

public class VeiculoPremium extends Veiculo implements BonificaKms, Serializable {
    private double taxaLuxo;
    private int pontosPorKm;

    public VeiculoPremium(){
        super();
        taxaLuxo = 0.0;
        pontosPorKm = 0;
    }
    public VeiculoPremium(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms, double il, int ptskm){
        super(mat, mar, mod, yr, vel, price, rtg, kms);
        taxaLuxo = il;
        pontosPorKm = ptskm;
    }
    public VeiculoPremium(VeiculoPremium vp){
        super(vp);
        taxaLuxo = vp.getTaxaLuxo();
        pontosPorKm = vp.getPtsPorKm();
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
        sb.append("VeículoPremium: ")
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
    public double custoKmLuxo(){
        return getAvgPriceKm()*(1+taxaLuxo);
    }
    public double custoRealKm(){
        return custoKmLuxo()*getTotalKms();
    }

    @Override
    public void setPtsPorKm(int pontos) {
        pontosPorKm = pontos;
    }

    @Override
    public int getPtsPorKm() {
        return pontosPorKm;
    }

    @Override
    public double getPtsVeic(Veiculo v) {
        return v.getTotalKms()*pontosPorKm;
    }

    public String toStringCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringCSV())
                .append(";").append("N/A")
                .append(";").append("N/A")
                .append(";").append(pontosPorKm)
                .append(";").append(taxaLuxo);
        return sb.toString();
    }
}
