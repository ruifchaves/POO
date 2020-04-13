import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SistemaVideos {
    private Map<String, VideoYoutube> mapVid;

    //construtores
    public SistemaVideos(){
        this.mapVid = new HashMap<>();
    }
    public SistemaVideos(Map<String, VideoYoutube> mapVidIn){
        this.setMapVid(mapVidIn);
    }
    public SistemaVideos(SistemaVideos svin){
        this.mapVid = svin.getMapVid(); //pode ser feito assim porque em get é criada um hashmap copia
    }

    //getters e setters
    public Map<String, VideoYoutube> getMapVid(){
        Map<String, VideoYoutube> aux = new HashMap<>();
        for(Map.Entry<String, VideoYoutube> v : this.mapVid.entrySet())
            aux.put(v.getKey(), v.getValue().clone());
        return aux;
    }
    public Map<String, VideoYoutube> getMapVid2(){
        return this.mapVid.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue().clone()));
    }

    public void setMapVid(Map<String, VideoYoutube> toset){
        this.mapVid = new HashMap<>();
        for(Map.Entry<String, VideoYoutube> v : toset.entrySet())
            this.mapVid.put(v.getKey(), v.getValue().clone());
    }
    public void setMapVid2(Map<String, VideoYoutube> toset){
        this.mapVid = toset.entrySet().stream().collect(Collectors.toMap(l->l.getKey(), l->l.getValue().clone()));
    }

    //equals, clone, toSring e compareTo
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        SistemaVideos s = (SistemaVideos) o;
        return this.mapVid.equals(s.getMapVid());
    }
    public SistemaVideos clone(){
        return new SistemaVideos(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n---Todos os Vídeos--- \n").append(mapVid);
        return sb.append("---------------------").toString();
    }
    public int compareTo(SistemaVideos sv){ //TODO
        //compareTo não definido para Map
        //return this.mapVid.compareTo(sv.getMapVid());
        return 1;
    }

    //metodos pedidos
    public void addVideo(VideoYoutube v){
        this.mapVid.put(v.getCod(), v);
    }
    public VideoYoutube getVideo(String codVideo){
        return this.mapVid.get(codVideo);
    }
    public void removeVideo(String codVideo){
        this.mapVid.remove(codVideo);
    }
    public void addLike(String codVideo){
        VideoYoutube aux = getVideo(codVideo);
        aux.setLikes(aux.getLikes()+1);
    }
    public String topLikes(){
        String ret = "";
        int max = 0;
        for(VideoYoutube v : this.mapVid.values()){
            if(v.getLikes()>=max){
                max = v.getLikes();
                ret = v.getCod();
            }
        }
        return ret;
    }
    public String topLikes(LocalDate dinicial, LocalDate dfinal){
        String ret = "";
        int max = 0;
        for(VideoYoutube v : this.mapVid.values()){
            if(v.getDataCarregamentoVid().isAfter(dinicial) && v.getDataCarregamentoVid().isBefore(dfinal)) {
                if (v.getLikes() >= max) {
                    max = v.getLikes();
                    ret = v.getCod();
                }
            }
        }
        return ret;
    }
    public VideoYoutube videoMaisLongo(){
        VideoYoutube aux = new VideoYoutube();
        int maxMins = 0, maxSegs = 0;
        for(VideoYoutube v : this.mapVid.values()){
            if(v.getDuracaoMins()>maxMins){
                if(v.getDuracaoSegs()>maxSegs){
                    maxMins=v.getDuracaoMins(); maxSegs=v.getDuracaoSegs();
                    aux=v.clone();
                }
            }
        }
        return aux;
    }
}
