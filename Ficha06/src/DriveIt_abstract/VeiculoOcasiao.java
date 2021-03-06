package DriveIt_abstract;

import java.io.Serializable;
import java.time.Year;

public class VeiculoOcasiao extends Veiculo implements Serializable {
    private boolean promocao;

    public VeiculoOcasiao(){
        super(); //invocar construtor da super classe
        promocao = false;
    }
    public VeiculoOcasiao(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms, boolean prom){
        super(mat, mar, mod, yr, vel, price, rtg, kms);
        promocao = prom;
    }
    public VeiculoOcasiao(VeiculoOcasiao vo){
        super(vo);
        promocao = vo.getPromocao();
    }

    public boolean getPromocao(){
        return promocao;
    }
    public void setPromocao(boolean boo){
        promocao = boo;
    }


    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return promocao==vo.getPromocao(); // added fields are tested
    } //https://rules.sonarsource.com/java/tag/suspicious/RSPEC-2160

    public String toString(){ //nao usar o .append(super.toString()); mas sim os gets definidos na super class
        StringBuilder sb = new StringBuilder();
        sb.append("VeículoOcasiao: ")
                .append("  matricula: ").append(getMatricula())
                .append(", marca: ").append(getMarca())
                .append(", modelo: ").append(getMarca())
                .append(", ano de construção: ").append(getAnoConstrucao())
                .append(", velocidade média por km: ").append(getAvgSpeedKm())
                .append(", preço teórico base por km: ").append(getAvgPriceKm())
                .append(", rating: ").append(getRating())
                .append(", kms totais realizados: ").append(getTotalKms()).append('\n');
        if(promocao) sb.append("EM PROMOCAO!");
        else sb.append("SEM PROMOCAO!");
        return sb.append('\n').toString();
    }

    public double custoRealKm(){
        double tax = 1;
        if(getPromocao()) tax = 0.75;
        return getAvgPriceKm()*getTotalKms()*tax;
    }

    public String toStringCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringCSV());
        sb.append(";");
        if(promocao)    sb.append("EM PROMOCAO!");
        else            sb.append("SEM PROMOCAO!");
        sb.append(";").append("N/A")
                .append(";").append("N/A")
                .append(";").append("N/A");
        return sb.toString();
    }
}
