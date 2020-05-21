package DriveIt_abstract;

import java.io.Serializable;
import java.time.Year;

public class VeiculoNormal extends Veiculo implements Serializable {
    public VeiculoNormal(){
        super();
    }
    public VeiculoNormal(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms){
        super(mat, mar, mod, yr, vel, price, rtg, kms);
    }
    public VeiculoNormal(VeiculoNormal vn){
        super(vn);
    }

    public VeiculoNormal clone(){ //obrigados a ser redefinido, abstract em Veiculo
        return new VeiculoNormal(this);
    }

    public String toString(){ //nao necessario definir, definido ja em Veiculo
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append('\n');
        return sb.toString();
    }

    public double custoRealKm(){
        return getAvgPriceKm()*getTotalKms();
    }

    public String toStringCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringCSV())
                .append(";").append("N/A")
                .append(";").append("N/A")
                .append(";").append("N/A")
                .append(";").append("N/A");
        return sb.toString();
    }
}
