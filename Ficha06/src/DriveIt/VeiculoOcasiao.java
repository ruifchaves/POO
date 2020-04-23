package DriveIt;

import java.time.Year;

public class VeiculoOcasiao extends Veiculo{
    private boolean promocao;
    final String tipo = "VeiculoOcasiao";

    public VeiculoOcasiao(){
        super();
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
    public String getTipo(){
        return tipo;
    }


    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return promocao==vo.getPromocao(); // added fields are tested
    } //https://rules.sonarsource.com/java/tag/suspicious/RSPEC-2160
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("VeiculoOcasiao: ")
                .append(super.toString())
                .append("  promoção: ").append(promocao).append('\n');
        return sb.toString();
    }
}
