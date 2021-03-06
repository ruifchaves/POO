package DriveIt_abstract;

import java.io.Serializable;
import java.time.Year;

public abstract class Veiculo implements Comparable<Veiculo>, Serializable {
    private String matricula;
    private String marca;
    private String modelo;
    private Year anoConstrucao;
    private double avgSpeedKm;
    private double avgPriceKm;
    private double rating;
    private int totalKms;

    public Veiculo(){
        this.matricula = "n/a";
        this.marca = "n/a";
        this.modelo = "n/a";
        this.anoConstrucao = null;
        this.avgSpeedKm = 0.0;
        this.avgPriceKm = 0.0;
        this.rating = 0.0;
        this.totalKms = 0;
    }
    public Veiculo(String mat, String mar, String mod, Year yr, double vel, double price, double rtg, int kms){
        matricula = mat;
        marca = mar;
        modelo = mod;
        anoConstrucao = yr;
        avgSpeedKm = vel;
        avgPriceKm = price;
        rating = rtg;
        totalKms = kms;
    }
    public Veiculo(Veiculo v){
        matricula = v.getMatricula();
        marca = v.getMarca();
        modelo = v.getModelo();
        anoConstrucao = v.getAnoConstrucao();
        avgSpeedKm = v.getAvgSpeedKm();
        avgPriceKm = v.getAvgPriceKm();
        rating = v.getRating();
        totalKms = v.getTotalKms();
    }

    public String getMatricula(){
        return matricula;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public Year getAnoConstrucao(){
        return anoConstrucao;
    }
    public double getAvgSpeedKm(){
        return avgSpeedKm;
    }
    public double getAvgPriceKm(){
        return avgPriceKm;
    }
    public double getRating(){
        return rating;
    }
    public int getTotalKms(){
        return totalKms;
    }
    public void setMatricula(String mat){
        matricula = mat;
    }
    public void setMarca(String mar){
        marca = mar;
    }
    public void setModelo(String mod){
        modelo = mod;
    }
    public void setAnoConstrucao(Year yr){
        anoConstrucao = yr;
    }
    public void setAvgSpeedKm(double vel){
        avgSpeedKm = vel;
    }
    public void setAvgPriceKm(double price){
        avgPriceKm = price;
    }
    public void setRating(double rtg){
        rating = rtg;
    }
    public void setTotalKms(int kms){
        totalKms = kms;
    }

    public abstract Veiculo clone();
    public abstract double custoRealKm();

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Veículo: ")
                .append("  matricula: ").append(matricula)
                .append(", marca: ").append(marca)
                .append(", modelo: ").append(modelo)
                .append(", ano de construção: ").append(anoConstrucao)
                .append(", velocidade média por km: ").append(avgSpeedKm)
                .append(", preço teórico base por km: ").append(avgPriceKm)
                .append(", rating: ").append(rating)
                .append(", kms totais realizados: ").append(totalKms);
        return sb.toString();
    }
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass()!=this.getClass()) return false;
        Veiculo v = (Veiculo) o;
        return matricula.equals(v.getMatricula()) &&
                marca.equals(v.getMarca()) &&
                modelo.equals(v.getModelo()) &&
                anoConstrucao.equals(v.getAnoConstrucao()) &&
                avgSpeedKm == v.getAvgSpeedKm() &&
                avgPriceKm == v.getAvgPriceKm() &&
                rating == v.getRating() &&
                totalKms == v.getTotalKms();
    }

    public int compareTo(Veiculo v){    //tenho que acrescentar que implementa a interface comparable
        if(marca.equals((v.getMarca())))
            return modelo.compareTo(v.getModelo());
        return marca.compareTo(v.getMarca());
    }

    public String toStringCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(matricula)
                .append(";").append(marca)
                .append(";").append(modelo)
                .append(";").append(anoConstrucao)
                .append(";").append(avgSpeedKm)
                .append(";").append(avgPriceKm)
                .append(";").append(rating)
                .append(";").append(totalKms);
        return sb.toString();
    }
}
