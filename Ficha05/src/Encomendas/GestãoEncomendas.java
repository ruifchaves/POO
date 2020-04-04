

import com.sun.xml.internal.ws.resources.EncodingMessages;
import jdk.nashorn.internal.ir.GetSplitState;
import sun.reflect.generics.tree.Tree;
import sun.security.action.GetBooleanSecurityPropertyAction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * i. métodos usuais de acesso e alteração das variáveis de instância
 */
public class GestãoEncomendas {
    private Map<Integer, EncEficiente> encomendas;

    public GestãoEncomendas(){
        this.encomendas = new HashMap<>();
    }
    public GestãoEncomendas(Map<Integer, EncEficiente> encs){
        this.setEncomendas2(encs);
    }
    public GestãoEncomendas(GestãoEncomendas c){
        this.encomendas = c.getEncomendas2();
    }

    public Map<Integer, EncEficiente> getEncomendas(){
        Map<Integer, EncEficiente> ret = new HashMap<>();
        for(Map.Entry<Integer, EncEficiente> en : this.encomendas.entrySet())
            ret.put(en.getKey(), en.getValue().clone());
        return ret;
    }
    //ou
    public Map<Integer, EncEficiente> getEncomendas2(){
        return this.encomendas.entrySet().stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue().clone()));
    }

    public void setEncomendas(Map<Integer, EncEficiente> enc) {
        for (Map.Entry<Integer, EncEficiente> en : enc.entrySet())
            this.encomendas.put(en.getKey(), en.getValue().clone());
    }
    //ou
    public void setEncomendas2(Map<Integer, EncEficiente> enc){
        this.encomendas = enc.entrySet().stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue().clone()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Encomendas:\n ")
                .append(this.encomendas);
        return sb.toString();
    }
    public GestãoEncomendas clone(){
        return new GestãoEncomendas(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if((o != null) || (o.getClass() != this.getClass())) return false;
        GestãoEncomendas p = (GestãoEncomendas) o;
        return this.encomendas.equals(p.getEncomendas());
    }

    /**
     * i. método que determina os códigos de encomenda existentes.
     */
    public Set<Integer> todosCodigos(){
        return new HashSet<>(this.encomendas.keySet());
    }

    /**
     * ii. método que adiciona mais uma encomenda ao sistema.
     */
    public void addEncomenda(EncEficiente enc){
        this.encomendas.put(enc.getNumEnc(),enc.clone());
    }

    /**
     * iii. método que dado um código de encomenda devolve a informação respetiva
     */
    public EncEficiente getEncomenda(int codEnc){
        return this.encomendas.get(codEnc);
    }

    /**
     * iv. método que remove uma encomenda dado o seu código
     */
    public void removeEncomenda(int codEnc){
        this.encomendas.remove(codEnc);
    }

    /**
     * v. método que determina a encomenda (identificada pelo código) com mais produtos encomendados
     */
    public int encomendaComMaisProdutos(){
        int idMaior = 0, maior = 0;
        for(EncEficiente en : this.encomendas.values()){
            int size = en.getLinhas().size();
            if(size > maior){
                maior = size;
                idMaior = en.getNumEnc();
            }
        }
        return idMaior;
    }

    /**
     * vi. método que determina todas as encomendas em que um determinado produto
     *     ,identificado pelo código, está presente.
     */
    public Set<Integer> encomendasComProduto(String codProd) {
        return this.encomendas.values().stream().filter(l -> l.existeProdutoEncomenda(codProd))
                .map(EncEficiente::getNumEnc).collect(Collectors.toSet());
    }

    /**
     * vii. método que determina todas as encomendas com data posterior a uma data
     *      fornecida como parâmetro
     */
    public Set<Integer> encomendasAposData(LocalDate d){
        return this.encomendas.values().stream().filter(l->l.getData().isAfter(d))
                .map(EncEficiente::getNumEnc).collect(Collectors.toSet());
    }

    /**
     * viii. método que devolve uma ordenação, por ordem decrescente de valor de encomenda,
     *       de todas as encomendas do sistema;
     */
    public Set<EncEficiente> encomendasValorDecrescente(){
            //return this.encomendas.values().stream().map(EncEficiente::clone).collect(Collectors.toCollection(()->new TreeSet<EncEficiente>(new ComparatorEncValor())));
            //da forma em cima(interna) teríamos que definir uma nova class public class ComparatorEncValor com o método public int compare(EncEficiente a, EncEficiente b)
            Set<EncEficiente> ordenadoDecres = new TreeSet<EncEficiente>((encA, encB)->{
                if(encA.calculaValorTotal()<encB.calculaValorTotal()) return -1;
                if(encA.calculaValorTotal()>encB.calculaValorTotal()) return 1;
                return 0;
            });
            this.encomendas.values().forEach(p->ordenadoDecres.add(p.clone()));
            return ordenadoDecres;
    }

    /**
     * ix. método que calcula um map em que associa cada código de produto à lista das encomendas em que foi referida.
     */
    public Map<String, List<Integer>> encomendasDeProduto(){
        Map<String, List<Integer>> prodListaEncs = new HashMap<>();
        for(EncEficiente en : this.encomendas.values()){
            List<String> refProds = en.getLinhas().stream().map(LinhaEncomenda::getReferencia).collect(Collectors.toList());
            for(String ref : refProds){
                if(!prodListaEncs.containsKey(ref)) prodListaEncs.put(ref, new ArrayList<Integer>());
                prodListaEncs.get(ref).add(en.getNumEnc());
            }
        }
        return prodListaEncs;
    }
}
