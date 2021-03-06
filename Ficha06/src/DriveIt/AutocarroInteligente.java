package DriveIt;

import java.time.Year;

public class AutocarroInteligente extends Veiculo {
    private int ocupacaoPercent; //from 0 to 100

    public AutocarroInteligente(){
        super();
        ocupacaoPercent = 0;
    }
    public AutocarroInteligente(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms, int ocup){
        super(mat, mar, mod, yr, vel, price, rtg, kms);
        ocupacaoPercent = ocup;
    }
    public AutocarroInteligente(AutocarroInteligente ai){
        super(ai);
        ocupacaoPercent = ai.getOcupacaoPercent();
    }

    public int getOcupacaoPercent() {
        return ocupacaoPercent;
    }
    public void setOcupacaoPercent(int newOcup){
        ocupacaoPercent = newOcup;
    }

    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        AutocarroInteligente ai = (AutocarroInteligente) o;
        return ocupacaoPercent == ai.getOcupacaoPercent();
    }
    public AutocarroInteligente clone(){
        return new AutocarroInteligente(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nAutocarroInteligente: ")
                .append("  matricula: ").append(getMatricula())
                .append(", marca: ").append(getMarca())
                .append(", modelo: ").append(getMarca())
                .append(", ano de construção: ").append(getAnoConstrucao())
                .append(", velocidade média por km: ").append(getAvgSpeedKm())
                .append(", preço teórico base por km: ").append(getAvgPriceKm())
                .append(", rating: ").append(getRating())
                .append(", Ocupação do Autocarro: ").append(ocupacaoPercent);
        return sb.append('\n').toString();
    }

}
