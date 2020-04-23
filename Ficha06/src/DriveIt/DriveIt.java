package DriveIt;

import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {
    private Map<String, Veiculo> veics;

    public DriveIt(){
        this.veics = new HashMap<>();
    }
    public DriveIt(Map<String, Veiculo> vs){
        setVeics(vs);
    }
    public DriveIt(DriveIt di){
        veics = di.getVeics();
    }

    public Map<String, Veiculo> getVeics(){
        Map<String, Veiculo> ret = new HashMap<>();
        for(Map.Entry<String, Veiculo> v : this.veics.entrySet()){
            ret.put(v.getKey(), v.getValue().clone());
        }
        return ret;
    }
    public Map<String, Veiculo> getVeics2(){
        return this.veics.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue().clone()));
    }
    public void setVeics(Map<String, Veiculo> vs){
        this.veics = new HashMap<>();
        for(Map.Entry<String, Veiculo> v : this.veics.entrySet()){
            this.veics.put(v.getKey(), v.getValue().clone());
        }
    }
    public void setVeics2(Map<String, Veiculo> vs){
        this.veics = vs.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue().clone()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("---VEÍCULOS REGISTADOS---")
                .append(veics);
        return sb.toString();
    }

    public boolean existeVeiculo(String cod){
        return this.veics.containsKey(cod);
    }
    public int quantos(){
        return this.veics.size(); //Returns the number of key-value mappings in this map.
    }
    public int quantos(String marca){
        return (int) this.veics.values().stream().filter(l->marca.equals(l.getMarca())).count();
    }
    public Veiculo getVeiculo(String cod){
        return this.veics.get(cod).clone();
    }
    public void adiciona(Veiculo v){
        this.veics.put(v.getMatricula(), v.clone());
    }
    public List<Veiculo> getVeiculos(){
        return this.veics.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }
    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v: vs){
            adiciona(v);
        }
        //vs.forEach(v->adiciona(v));
    }
    public void registarAluguer(String codVeiculo, int numKms){
        Veiculo v = veics.get(codVeiculo);
        int toSet = v.getTotalKms() + numKms;
        v.setTotalKms(toSet);
        veics.replace(codVeiculo, v);
    }
    public void classificarVeiculo(String cod, int classificacao){
        Veiculo v = veics.get(cod);
        double newrtg = (v.getRating()+classificacao)/2;
        v.setRating(newrtg);
        veics.replace(cod, v);
    }
    public double custoRealKm(String cod){
        Veiculo v = veics.get(cod);
        double ptb = v.getAvgPriceKm(); int nKms = v.getTotalKms();
        double ret = (ptb*nKms)/0.9;
        if(v instanceof VeiculoOcasiao && ((VeiculoOcasiao) v).getPromocao()==true) ret /= 1.25;
        return ret;
    }



    //-------------------------------------------------------//
    public boolean existeVeiculo2(String cod){  //IGUAL
        return veics.containsKey(cod);
    }
    public int quantos2(){  //IGUAL
        return veics.size();
    }


    //public abstract String getTipo();
    public int quantosT(String tipo){ //não dá TODO
    //    Class c = (Class) tipo;
    //    return (int) veics.values().stream().filter(l->l instanceof tipo).count();
        //return veics.values().stream().filter(l->l.get) //nao da para chamar o metodo da subclasse
    }

    public Veiculo getVeiculo2(String cod){  //IGUAL
        return veics.get(cod);
    }
    public void adiciona2(Veiculo v){  //IGUAL
        veics.put(v.getMatricula(), v.clone());
    }
    public List<Veiculo> getVeiculos2(){  //IGUAL
        return veics.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }
    public List<Veiculo> veiculosOrdenadosCusto(){
        List<Veiculo> carrosOrd= new ArrayList<>();
        for(Veiculo v : veics.values()){
            carrosOrd.add(v.clone());
        }
        Collections.sort(carrosOrd, compareByCusto);
        return carrosOrd;
    }
}
