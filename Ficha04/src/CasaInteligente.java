import sun.plugin2.applet.StopListener;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Iterator;


public class CasaInteligente {
    private List<Lampada> lampadas; //se destruir a casa, destruo também as lâmpadas, daí ser composição, daí usar os clones

    public CasaInteligente(){
        this.lampadas = new ArrayList<>();
    }
    public CasaInteligente(List<Lampada> lampadas){
        this.lampadas = lampadas;
    }
    public CasaInteligente(CasaInteligente ci){

    }

    //iterador externo
    public void setLampadas(List<Lampada> lampadas){
        this.lampadas = new ArrayList<>();
        for(Lampada l: lampadas){
            this.lampadas.add(l.clone());
        }
    }
    //iterador interno
    public void setLampadasI(List<Lampadas> lampadas){
        this.lampadas = lampadas.stream().map(l -> l.clone()).collect(toList()); //mapear cada lampada stream num l.clone. //Collectors.toList()
        // ou this.lampadas = lampadas.stream().map(Lampada::clone).collect(toList());
    }

    public List<Lampada> getLampadas(){
        return this.lampadas.stream().map(Lampada::clone).collect(toList());
    }
    public void addLampada(Lampada l){
        this.lampadas.add(l.clone());
    }
    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }
    public int qtEmEco(){
        int total = 0;
        for(Lampada l : this.lampadas){
            total += l.getModo() == Lampada.ECO ? 1:0;
            //ou
            //if(l.getModo() == Lampada.ECO) total++;
        // }
        // total;
        }
    }

    public int qtEmEcoI(){ //tem que ter o (int) porque o count dá um long.
        return (int) this.lampadas.stream()
                                    .filter(l->l.getModo()==Lampada.ECO)
                                    .count();
    }
}
