package DriveIt_abstract;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {
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

    //FASE 4
    //1
    public void gravaCSV(String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        pw.print(this.toStringCSV()); //grava o objeto. Necessario adaptar o toString para que grave com a formatacao de csv
        pw.flush();
        pw.close();
    }

    public String toStringCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("---VEICULOS REGISTADOS---\n"); //fst line
        //columns
        sb.append("Matricula;Marca;Modelo;Ano;Velocidade Media/km;Preco Base/km;Rating;Total Kms;Promocao;Ocupacao(%);Pontos/km;Taxa\n");
        for(Veiculo v : veics.values()){
            sb.append(v.toStringCSV());
        }
        return sb.toString();
    }



    //2
    public void gravaObj(String filename) throws IOException {
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));//grava em binario, info minimamente comprimida
        o.writeObject(this);
        o.flush();
        o.close(); //so consigo gravar em modo objeto, caso a classe implemente a interface Serializable.
        //como temos um map de veics, a classe veiculo tambem tem que implementar serializable
    }

    public DriveIt lerObj(String filename) throws IOException , ClassNotFoundException{
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
        DriveIt di = (DriveIt) o.readObject(); //pede classNotFoundException ("o que estava dentro do ficheiro dado nao é uma instancia desta classe")
        o.close();
        return di;
    }

    //3
    public void remove(String codVeiculo) throws NaoExisteVeiculoException{
        if(veics.containsKey(codVeiculo))
            veics.remove(codVeiculo);
        else
            throw new NaoExisteVeiculoException(codVeiculo);
    }

    //4
    public void adiciona2(Veiculo v) throws ExisteVeiculoException {
        if(veics.containsKey(v.getMatricula()))
            throw new ExisteVeiculoException(v.getMatricula());
        else
            this.veics.put(v.getMatricula(), v.clone());
    }

    //5
    public void classificarVeiculo2(String cod, int rtg) throws ValorInvalidoException, NaoExisteVeiculoException{
        if(rtg>=0 && rtg<=10){
            if(veics.containsKey(cod)) {
                Veiculo v = veics.get(cod).clone();
                double newrtg = (v.getRating() + rtg) / 2;
                v.setRating(newrtg);
                veics.replace(cod, v);
            }
            else throw new NaoExisteVeiculoException(cod);
        }else throw new ValorInvalidoException(rtg);
    }

    public Veiculo getVeiculo2(String codVeiculo) throws NaoExisteVeiculoException {
        if(veics.containsKey(codVeiculo))
            return veics.get(codVeiculo).clone();
        else throw new NaoExisteVeiculoException(codVeiculo);
    }

    public void registarAluguer2(String codVeiculo, int numKms) throws NaoExisteVeiculoException, ValorInvalidoException {
        if(veics.containsKey(codVeiculo)){
            if(numKms>=0){
                Veiculo v = veics.get(codVeiculo).clone();
                v.setTotalKms(v.getTotalKms() + numKms);
                veics.replace(codVeiculo, v);
            } else throw new ValorInvalidoException(codVeiculo, numKms);
        } else throw new NaoExisteVeiculoException(codVeiculo);
    }
}