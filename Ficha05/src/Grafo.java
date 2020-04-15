import java.util.*;
import java.util.stream.Collectors;

public class Grafo {
    //variáveis de instância
    private Map<Integer, Set<Integer>> adj; //"lista" de adjacência

    public Grafo() {
        this.adj = new HashMap<>();
    }
    public Grafo(Map<Integer, Set<Integer>> newAdj) {
        setAdj(newAdj);
    }

    public Map<Integer, Set<Integer>> getAdj() {
        Map<Integer, Set<Integer>> ret = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> v : this.adj.entrySet())
            ret.put(v.getKey(), v.getValue());
        return ret;
    }
    public Map<Integer, Set<Integer>> getAdjStream() {
        return this.adj.entrySet().stream().collect(Collectors.toMap(l -> l.getKey(), l -> l.getValue()));
    }

    public void setAdj(Map<Integer, Set<Integer>> toSetAdj) {
        this.adj = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> v : toSetAdj.entrySet())
            adj.put(v.getKey(), v.getValue());
    }
    public void setAdjStream(Map<Integer, Set<Integer>> toSetAdj) {
        this.adj = toSetAdj.entrySet().stream().collect(Collectors.toMap(l -> l.getKey(), l -> l.getValue()));
    }

    public void addArco(Integer vOrig, Integer vDest){
        adj.putIfAbsent(vOrig, new HashSet<>()); //garantir que são nodos do grafo
        adj.putIfAbsent(vDest, new HashSet<>());
        adj.get(vOrig).add(vDest); //definir vDest como novo arco de vOrig
    }
    public boolean isSink(Integer v){
        return adj.get(v).isEmpty();
    }
    public boolean isSource(Integer v){ //percorre tudo, devemos usar um iterator.
        boolean source = this.adj.containsKey(v);
        Iterator<Set<Integer>> it = this.adj.values().iterator();
        while(it.hasNext() && source){
            source = !it.next().contains(v); //se nunca o encontrar ele continua
        }
        return source;
        //se fizessemos isto com forEach no teste íamos ser descontados. Tal como se saíssemos de um ciclo for ou forEach com um return.
    }


    public boolean haCaminho(Integer vOrig, Integer vDest){
        return haCaminho(vOrig, vDest, new HashSet<>()); //HashSet corresponde se já existiu
    }

    public boolean haCaminho(Integer vOrig, Integer vDest, Set<Integer> visitados){
        //caminhar da origem até chegar ao destino
        if(vOrig == vDest) return true;
        if(!this.adj.containsKey(vOrig) || visitados.contains(vOrig))
            return false; //se nao existir o nodo ou se já visitei, estou em loop e dou return false.

        //usar um iterador pq basta ver se há um caminho.
        Iterator<Integer> it = this.adj.get(vOrig).iterator();
        boolean hac = false;
        visitados.add(vOrig);
        while(it.hasNext() && !hac){
            hac = haCaminho(it.next(), vDest, visitados);
        }
        return hac;
    }


    public int size() //TODO
    public List<Integer> getCaminho(Integer vOrig, Integer vDest)
    public Set<Map.Entry<Integer, Integer>> fanIn(Integer v)
    public boolean subGrafo(Grafo g)
}