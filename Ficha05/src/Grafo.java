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

    /**
     * Implementação do haCaminho
     */
    public boolean haCaminho(Integer vOrig, Integer vDest){
        return haCaminho(vOrig, vDest, new HashSet<>()); //HashSet corresponde se já existiu
    }
    public boolean haCaminho(Integer vOrig, Integer vDest, Set<Integer> visitados){
        //caminhar da origem até chegar ao destino
        boolean hac;
        if(vOrig == vDest) hac = true;
        else if (!this.adj.containsKey(vOrig) || visitados.contains(vOrig))
                hac = false; //se nao existir o nodo ou se já visitei, estou em loop e dou return false.
            else {
                //usar um iterador pq basta ver se há um caminho.
                Iterator<Integer> it = this.adj.get(vOrig).iterator();
                hac = false;
                visitados.add(vOrig);
                while(it.hasNext() && !hac){
                hac = haCaminho(it.next(), vDest, visitados);
            }
        }
        return hac;
    }

    /**
     * Implementação do getCaminho
     */
    public List<Integer> getCaminho(Integer vOrig, Integer vDest){
        return getCaminho(vOrig, vDest, new ArrayList<>());
    }
    public List<Integer> getCaminho(Integer vOrig, Integer vDest, List<Integer> visitados) {
        List<Integer> res = null;
        if (vOrig.equals(vDest)) {
            visitados.add(vOrig);
            res = visitados;
        } else if (!adj.containsKey(vOrig) || visitados.contains(vOrig))
            res = null;
        else {
            Iterator<Integer> i = adj.get(vOrig).iterator();
            visitados.add(vOrig);
            while (i.hasNext() && res == null)
                res = getCaminho(i.next(), vDest, new ArrayList<>(visitados));
        }
        return res;
    }

    /**
     * Implementação do getCaminho utilizando o algoritmo do Dijkstra
     */
    public List<Integer> getCaminhoDSP(Integer vOrig, Integer vDest) {
        Set<Integer> vertex = new HashSet<>();
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        for (Integer v : adj.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
            vertex.add(v);
        }
        dist.put(vOrig, 0);

        boolean found = false;
        while (!vertex.isEmpty() && !found) {
            Integer u = vertex.stream().sorted((v1, v2) -> dist.get(v1) - dist.get(v2))
                    .findFirst().get(); //certo??
            vertex.remove(u);
            found = (u == vDest);
            if (!found) {
                for (Integer v : adj.get(u)) {
                    int alt = dist.get(u) + 1;
                    if (alt < dist.get(v)) {
                        dist.put(v, alt);
                        prev.put(v, u);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        Integer u = vDest;
        if (prev.containsKey(u) || u == vOrig) {
            while (prev.containsKey((u))) {
                res.add(0, u);
                u = prev.get(u);
            }
        }
        return res;
    }

    //public int size()
    //public Set<Map.Entry<Integer, Integer>> fanIn(Integer v)
    //public boolean subGrafo(Grafo g)
}