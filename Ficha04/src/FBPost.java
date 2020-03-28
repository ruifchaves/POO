import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FBPost {
    private int id;
    private String user;
    private LocalDateTime postTime;
    private String content;
    private int likes;
    private List<String> comments;  //se destruir o post, destruo também os comments, daí ser composição, daí usar os clones.
                                    //mas https://stackoverflow.com/questions/10607990/how-should-i-copy-strings-in-java
                                    //"String is immutable. cloning Strings doesn't make much sense."

    public FBPost(){
        this.id = 0;
        this.user = "n/a";
        this.postTime = LocalDateTime.now();
        this.content = "n/a";
        this.likes = 0;
        this.comments = new ArrayList<>();
    }
    public FBPost(int id, String user, LocalDateTime dt, String content, int likes, List<String> comments){
        this.id = id;
        this.user = user;
        this.postTime = dt;
        this.content = content;
        this.likes = likes;
        this.setComments(comments);
    }
    public FBPost(FBPost fbp){
        this.id = fbp.getId();
        this.user = fbp.getUser();
        this.postTime = fbp.getPostTime();
        this.content = fbp.getContent();
        this.likes = fbp.getLikes();
        this.setComments(fbp.getComments());
    }

    public int getId(){
        return this.id;
    }
    public String getUser(){
        return this.user;
    }
    public LocalDateTime getPostTime(){
        return this.postTime;
    }
    public String getContent(){
        return this.content;
    }
    public int getLikes(){
        return this.likes;
    }
    public List<String> getComments(){
        //return this.comments.stream().map(String::clone).collect(Collectors.toList());  não fazer isto
        List<String> aux = new ArrayList<>();
        for(String s : comments){
            aux.add(s);
        }
        return aux;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPostTime(LocalDateTime dt){
        this.postTime = dt;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }
    public void setComments(List<String> coms){
        //this.comments = this.comments.stream(String::clone).collect(Collectors.toList());       não fazer isto
        //this.comments = this.comments.stream().map(l->l.clone).collect(Collectors.toList());    não fazer isto
        this.comments = new ArrayList<>();
        //comentarios.forEach(s -> {this.comentarios.add(s);});
        //OU
        for(String c : coms){
            this.comments.add(c);
        }
    }

    protected FBPost clone(){
        return new FBPost(this);
    }
    public boolean equals(Object obj){
        if(obj==this) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;
        FBPost o = (FBPost) obj;
        return     id==o.getId()
                && user.equals(o.getUser())
                && content.equals(o.getContent())
                && likes==o.getLikes()
                && postTime.equals(o.getPostTime())
                && comments.equals(o.getComments());
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\nUsername: ").append(user)
                .append("\nData: ").append(postTime).append("\nPost: ").append(content)
                .append("\nLikes: ").append(likes)
                .append("\nComentarios: ").append(comments.toString());  //toString
        return sb.toString();
    }
}
