import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.DAYS;


public class VideoYoutube {
    private String nomevid;
    private Byte[] bytesvid;
    private LocalDate dataCarregamentoVid;
    private String resolucao;
    private int duracaoMins;
    private int duracaoSegs;
    private List<String> commentsVid;
    private int likes;
    private int dislikes;
    private String cod; //pedido para a classe SistemaVideos

    //construtores
    public VideoYoutube(){
        this.nomevid = "";
        this.bytesvid = null;
        this.dataCarregamentoVid =  LocalDate.now();
        this.resolucao = "0x0";
        this.duracaoMins = 0;
        this.duracaoSegs = 0;
        this.commentsVid = new ArrayList<>();
        this.likes = 0;
        this.dislikes = 0;
        this.cod = "n/a";
    }
    public VideoYoutube(String nv, Byte[] bv, LocalDate ld, String res, int durMin, int durSeg, List<String> coms, int likes, int dislikes, String cod){
        this.nomevid = nv;
        this.bytesvid = bv;
        this.dataCarregamentoVid = ld;
        this.resolucao = res;
        this.duracaoMins = durMin;
        this.duracaoSegs = durSeg;
        this.setCommentsVid(coms);
        this.likes = likes;
        this.dislikes = dislikes;
        this.cod = cod;
    }
    public VideoYoutube(VideoYoutube vy){
        this.nomevid = vy.getNomeVid();
        this.bytesvid = vy.getBytesVid();
        this.dataCarregamentoVid = vy.getDataCarregamentoVid();
        this.resolucao = vy.getResolucao();
        this.duracaoMins = vy.getDuracaoMins();
        this.duracaoSegs = vy.getDuracaoSegs();
        this.commentsVid = vy.getCommentsVid(); //pode ser feito assim porque a lista é criada
        this.likes = vy.getLikes();
        this.dislikes = vy.getDislikes();
        this.cod = vy.getCod();
    }


    //getters e setters
    public String getNomeVid(){
        return this.nomevid;
    }
    public Byte[] getBytesVid(){
        return this.bytesvid;
    }
    public LocalDate getDataCarregamentoVid(){
        return this.dataCarregamentoVid;
    }
    public String getResolucao(){
        return this.resolucao;
    }
    public int getDuracaoMins(){
        return this.duracaoMins;
    }
    public int getDuracaoSegs(){
        return this.duracaoSegs;
    }
    public List<String> getCommentsVid(){
        return this.commentsVid.stream().collect(Collectors.toList()); //stream().map(String::clone) ou stream().map(l->l.clone) se fosse preciso
    }
    public List<String> getCommentsVid2() {
        List<String> aux = new ArrayList<>();
        for(String com : this.commentsVid)
            aux.add(com); //com.clone se fosse preciso.
        return aux;
    } //ou
    public int getLikes(){
        return this.likes;
    }
    public int getDislikes(){
        return this.dislikes;
    }
    public String getCod(){
        return this.cod;
    }

    public void setNomevid(String nome){
        this.nomevid = nome;
    }
    public void setBytesvid(Byte[] bytes){
        this.bytesvid = bytes;
    }
    public void setDataCarregamentoVid(LocalDate data){
        this.dataCarregamentoVid = data;
    }
    public void setResolucao(String res){
        this.resolucao = res;
    }
    public void setDuracaoMins(int dm){
        this.duracaoMins = dm;
    }
    public void setDuracaoSegs(int ds){
        this.duracaoSegs = ds;
    }
    public void setCommentsVid(List<String> coms){
        this.commentsVid = coms.stream().collect(Collectors.toList()); //stream().map(String::clone) ou stream().map(l->l.clone) se fosse preciso
    }  //ou
    public void setCommentsVid2(List<String> coms){
        this.commentsVid = new ArrayList<>();
        for(String com : coms)
            commentsVid.add(com); //com.clone se fosse preciso.
    }
    public void setLikes(int li){
        this.likes = li;
    }
    public void setDislikes(int dis){
        this.dislikes = dis;
    }
    public void setCod(String cod){
        this.cod = cod;
    }

    public void insereComentario(String comentario){
        this.commentsVid.add(comentario);
    }
    public long qtsDiasDepois(){
        return DAYS.between(this.dataCarregamentoVid, LocalDate.now());
    }
    public void thumbsUp(){
        setLikes(getLikes()+1);
    }
    public String processa(){  //toString
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i=0; i<bytesvid.length; i++)
            sb.append(bytesvid[i]);
        return sb.append(']').toString();
    }

    //equals, clone e toString
    public boolean equal(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        VideoYoutube j = (VideoYoutube) o;
        boolean flag = true;
        for (int i = 0; i < bytesvid.length; i++) {
            if (bytesvid[i]!=(j.getBytesVid()[i]))
                flag = false;
        }
        return this.nomevid.equals(j.getNomeVid()) &&
                flag &&
                dataCarregamentoVid.equals(j.getDataCarregamentoVid()) &&
                resolucao.equals(j.getResolucao()) &&
                duracaoMins==j.getDuracaoMins() &&
                duracaoSegs==j.getDuracaoSegs() &&
                commentsVid.equals(j.getCommentsVid()) &&
                likes==j.getLikes() &&
                dislikes==j.getDislikes() &&
                nomevid.equals(j.getNomeVid()) &&
                cod.equals(j.getCod());

    }
    public VideoYoutube clone(){
        return new VideoYoutube(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nVIDEO: ")
                .append("\n-Nome: ").append(nomevid)
                .append("\n-Bytes: ").append(processa())
                .append("\n-Data Carregamento: ").append(dataCarregamentoVid)
                .append("\n-Resolução: ").append(resolucao)
                .append("\n-Duração: ").append(duracaoMins).append(':').append(duracaoSegs)
                .append("\n-Comentários: ").append(commentsVid.toString())
                .append("\n-Likes: ").append(likes)
                .append("\n-Dislikes: ").append(dislikes)
                .append("\n-Código do Vídeo: ").append(cod);
        return sb.toString();
    }
}


