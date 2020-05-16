package DriveIt_abstract;

import com.sun.deploy.util.VersionID;

import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {
    private Map<String, Veiculo> veics;
    private boolean promocao; //se todos os veics ocasiao estao em promocao

    public DriveIt() {
        this.veics = new HashMap<>();
        this.promocao = false;
    }

    public DriveIt(Map<String, Veiculo> vs) {
        setVeics(vs);
        promocao = false;
    }

    public DriveIt(DriveIt di) {
        veics = di.getVeics(); //assim dá ou setVeics(di.getVeics())?
        promocao = di.getPromocao();
    }

    public Map<String, Veiculo> getVeics() {
        Map<String, Veiculo> ret = new HashMap<>();
        for (Map.Entry<String, Veiculo> v : this.veics.entrySet()) {
            ret.put(v.getKey(), v.getValue().clone());
        }
        return ret;
    }
    public Map<String, Veiculo> getVeics2() {
        return this.veics.entrySet().stream().collect(Collectors.toMap(l -> l.getKey(), l -> l.getValue().clone()));
    }
    public boolean getPromocao(){
        return promocao;
    }

    public void setVeics(Map<String, Veiculo> vs) {
        this.veics = new HashMap<>();
        for (Map.Entry<String, Veiculo> v : this.veics.entrySet()) {
            this.veics.put(v.getKey(), v.getValue().clone());
        }
    }
    public void setVeics2(Map<String, Veiculo> vs) {
        this.veics = vs.entrySet().stream().collect(Collectors.toMap(l -> l.getKey(), l -> l.getValue().clone()));
    }
    public void setPromocao(boolean prom){
        promocao = prom;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---VEÍCULOS REGISTADOS---\n")
                .append(veics);
        return sb.toString();
    }
    //FASE 1
    //a
    public boolean existeVeiculo(String cod) {
        return this.veics.containsKey(cod);
    }

    //b
    public int quantos() {
        return this.veics.size(); //Returns the number of key-value mappings in this map.
    }

    //c1
    public int quantos(String marca) {
        return (int) this.veics.values().stream().filter(l -> marca.equals(l.getMarca())).count();
    }

    //c2
    public int quantosT(String tipo){
        return (int) veics.values().stream().filter(l->l.getClass().getSimpleName().equals(tipo)).count();
    }

    //d
    public Veiculo getVeiculo(String cod) {
        return this.veics.get(cod).clone();
    }

    //e
    public void adiciona(Veiculo v) {
        this.veics.put(v.getMatricula(), v.clone());
    }

    //f
    public List<Veiculo> getVeiculos() {
        return this.veics.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }

    //g v1
    public List<Veiculo> veiculosOrdenadosCusto(){
        List<Veiculo> carrosOrd = new ArrayList<>();
        for(Veiculo v : veics.values()){
            carrosOrd.add(v.clone());
        }
        carrosOrd.sort((Veiculo o1, Veiculo o2) -> {
            if(custoRealKm(o1.getMatricula())<custoRealKm(o2.getMatricula())) return 1;
            if(custoRealKm(o1.getMatricula())>custoRealKm(o2.getMatricula())) return -1;
            return 0;
        });
        return carrosOrd;
    }
    //g v2
    public List<Veiculo> veiculosOrdenadosCustoStream(){
        return veics.values().stream().sorted(Comparator.comparingDouble(Veiculo::custoRealKm))
                .map(Veiculo::clone).collect(Collectors.toList());
    }


    //h -> nao ideal inicializar assim lowestprice e x
    //public Veiculo veiculoMaisBarato(){
    //    Veiculo x = (Veiculo) veics.values().toArray()[0];
    //    double lowestPrice = custoRealKm((String) veics.keySet().toArray()[0]); //https://www.javacodeexamples.com/java-hashmap-get-first-key-value-without-iterating-example/2290
    //    for(Map.Entry<String, Veiculo> v : veics.entrySet()){
    //        if(custoRealKm(v.getKey())<lowestPrice){
    //            lowestPrice = custoRealKm(v.getKey());
    //            x = v.getValue().clone();
    //        }
    //    }
    //    return x;
    //}
    public Veiculo veiculoMaisBarato(){
        return veiculosOrdenadosCustoStream().get(0).clone();
    }

    //i
    public Veiculo veiculoMenosUtilizado(){
        return veics.values().stream()
                .min(Comparator.comparing(Veiculo::getTotalKms)).get().clone();
    }

    //j
    public void adiciona(Set<Veiculo> vs) {
        for (Veiculo v : vs) {
            adiciona(v);
        }
        //ou vs.forEach(v->adiciona(v));
    }

    //k
    public void registarAluguer(String codVeiculo, int numKms){
        if(veics.containsKey(codVeiculo)){
            Veiculo v = veics.get(codVeiculo).clone();
            v.setTotalKms(v.getTotalKms() + numKms);
            veics.replace(codVeiculo, v);
        }
    }

    //l
    public void classificarVeiculo(String cod, int classificacao) {
        if(veics.containsKey(cod)) {
            Veiculo v = veics.get(cod).clone();
            double newrtg = (v.getRating() + classificacao) / 2;
            v.setRating(newrtg);
            veics.replace(cod, v);
        }
    }

    //m
    public double custoRealKm(String cod) {
        Veiculo v = veics.get(cod);
        return (v.custoRealKm()/0.9);
    }

    //n
    public void alteraPromocao(boolean estado){
        setPromocao(estado);
        for(Veiculo v : veics.values()){
            if(v instanceof VeiculoOcasiao)
                ((VeiculoOcasiao) v).setPromocao(estado);
        }
    }

    //n1 Agencia entra em promocao
    public void entraemPromocao(){
        setPromocao(true);
        for(Veiculo v : this.veics.values())
            if( v instanceof VeiculoOcasiao)
                ((VeiculoOcasiao) v).setPromocao(true);
    }

    //n2 Agencia termina a promocao
    public void terminaPromocao(){
        setPromocao(false);
        for(Veiculo v : this.veics.values())
            if( v instanceof VeiculoOcasiao)
                ((VeiculoOcasiao) v).setPromocao(false);
    }



    //FASE 2
    //a v1
    public Set<Veiculo> ordenarVeiculos(){  //por omissao, vai usar a ordenacao natural definida em veiculo
        Set<Veiculo> aux = new TreeSet<>();
        for(Veiculo v : veics.values()){
            aux.add(v.clone());
        }
        return aux;
    }
    //a v2
    public Set<Veiculo> ordenarVeiculosStream(){
        return veics.values().stream().sorted().map(Veiculo::clone).collect(Collectors.toSet());
    }

    //b
    public List<Veiculo> ordenarVeiculosList(){
        return veics.values().stream().sorted().map(Veiculo::clone).collect(Collectors.toList());
    }

    //c
    public Set<Veiculo> ordenarVeiculosStream(Comparator<Veiculo> c){
        return veics.values().stream().sorted(c).map(Veiculo::clone).collect(Collectors.toSet());
    }

    //d
    public static Map<String,Comparator<Veiculo>> ordem = new TreeMap<>();
    public Map<String, Comparator<Veiculo>> getMapOrdens(){
        return ordem.entrySet().stream().collect(Collectors.toMap(o->o.getKey(), o->o.getValue()));
    }
    public void addCriterio(String c, Comparator<Veiculo> cp){ //c-nome do criterio, cp-comparador que o implementa
        ordem.put(c,cp);
    }

    public int compare1(Veiculo a, Veiculo b) { //order by class name
        return a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName());
    }
    public int compare2(Veiculo a, Veiculo b){ //crescente total kms
        return a.getTotalKms()-b.getTotalKms();
    }

    //e
    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Set<Veiculo> s = new TreeSet<>(ordem.get(criterio));
        for(Veiculo v : veics.values())
            s.add(v.clone());
        return s.iterator(); //converter o treeset de veiculos num iterator de veiculos;
    }


    //FASE 3
    public List<BonificaKms> daoPontos(){
        return this.veics.values().stream().filter(l->l instanceof BonificaKms)
                                  .map(l-> (BonificaKms) l).collect(Collectors.toList());
    }
    public List<BonificaKms> daoPontos2(){
        List<BonificaKms> bonificaKmsList = new ArrayList<>();
        for(Veiculo v : this.veics.values()){
            if(v instanceof VeiculoPremium || v instanceof AutocarroInteligente){
                BonificaKms bk = (BonificaKms) v.clone();
                bonificaKmsList.add(bk);
            }
        }
        return bonificaKmsList;
    }
}
