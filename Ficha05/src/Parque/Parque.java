package Parque;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Parque {
    private String nomeParque;
    private Map<String, Lugar> lugares;

    public Parque(){
        nomeParque = "n/a";
        lugares = new HashMap<>();
    }
    public Parque(String np, Map<String, Lugar> lug){
        nomeParque = np;
        setLugares(lug);
    }
    public Parque(Parque p){
        nomeParque = p.getNomeParque();
        lugares = p.getLugares();
    }

    public String getNomeParque(){
        return nomeParque;
    }
    public Map<String, Lugar> getLugares(){
        Map<String, Lugar> ret = new HashMap<>();
        for(Map.Entry<String, Lugar> o : lugares.entrySet()){
            ret.put(o.getKey(), o.getValue());
        }
        return ret;
    }
    public Map<String, Lugar> getLugaresStream(){
        return this.lugares.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue()));
    }

    public void setNomeParque(String n){
        nomeParque = n;
    }
    public void setLugares(Map<String, Lugar> newLugs){
        lugares = new HashMap<>();
        for(Map.Entry<String, Lugar> o : newLugs.entrySet()){
            lugares.put(o.getKey(), o.getValue());
        }
    }
    public void setLugaresStream(Map<String, Lugar> newLugs){
        lugares = newLugs.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- PARQUE ---")
                .append("\nNome do Parque: ").append(nomeParque)
                .append("\nLugares: ").append(lugares);
        return sb.toString();
    }
    public Parque clone(){
        return new Parque(this);
    }
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass()!=this.getClass()) return false;
        Parque p = (Parque) o;
        return nomeParque.equals(p.getNomeParque())
                && lugares.equals(p.getLugares());
    }

    /** Método que devolve todas as matrículas dos lugares ocupados */
    public Set<String> lugaresOcupados(){
        return lugares.values().stream().filter(l->l.getPermanente() || l.getMinutos()>0)
                .map(Lugar::getMatricula).collect(Collectors.toSet());
    }

    /** Método que regista uma nova ocupação de lugar */
    public void setOcupado(Lugar newOcup){
        lugares.put(newOcup.getMatricula(), newOcup.clone());
    }

    /** Metodo que remove o lugar de dada matrícula */
    public void remLugarMatricula(String mat){
        lugares.remove(mat);
    }

    /** Metodo que altera o tempo disponivel de um lugar, para uma dada matricula */
    public void alteraTempoDisponive(String mat, int mins){
        lugares.get(mat).setMinutos(mins);
    }

    /** Metodos (iterador interno e externo) que devolve a quantidade total de minutos atribuidos */
    public int minsAtribuidos(){
        int soma = 0;
        for(Lugar m : lugares.values()){
            soma += m.getMinutos();
        }
        return soma;
    }
    public int minsAtribuidosStream(){
        return lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    /** Metodo que verifica se existe um lugar atribuido a uma dada matricula */
    public boolean existeLugarMatricula(String mat){
        return lugares.containsKey(mat);
    }

    /** Metodos (iterador interno e externo) que cria uma lista com as
     *  matriculas com tempo atribuido > x
     *  ,em que o lugar seja permanente.
     */
    public List<String> matrMaiorX(int x){
        List<String> aux = new ArrayList<>();
        for(Lugar l : lugares.values()){
            if(l.getMinutos()>x)
                aux.add(l.getMatricula());
        }
        return aux;
    }
    public List<String> matrMaiorXStream(int x){
        return lugares.values().stream().filter(l->l.getMinutos()>x).map(Lugar::getMatricula).collect(Collectors.toList());
    }

    /** Método que devolve uma copia dos lugares */
    public Set<Lugar> todosLugares(){
        return new HashSet<>(lugares.values());
    }

    /** Metodo que devolve a informação de um lugar para cada matrícula */
    public Lugar lugarMatricula(String mat){
        return lugares.get(mat);
    }
}
