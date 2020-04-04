import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;


public class FBFeed {
    private List<FBPost> posts;   //se destruir o feed, destruo também os posts, daí ser composição, daí usar os clones.

    public FBFeed(){
        this.posts = new ArrayList<>();
    }
    public FBFeed(List<FBPost> posts) {
        this.setPosts(posts);
    }
    public FBFeed(FBFeed posts){
        this.setPosts(posts.getPosts());
    }

    public List<FBPost> getPosts() {
        //return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
        //return this.posts.stream().map(l->l.clone()).collect(Collectors.toList());
        List<FBPost> aux = new ArrayList<FBPost>();
        for(FBPost s : this.posts){
            aux.add(s.clone());
        }
        return aux;
    }
    public void setPosts(List<FBPost> pts) {
        //this.posts = pts.stream().map(FBPost::clone).collect(Collectors.toList());
        //this.posts = pts.stream().map(l->l.clone()).collect(Collectors.toList());
        this.posts = new ArrayList<FBPost>();
        for(FBPost p : pts){
            posts.add(p.clone());
        }
    }

    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        FBFeed j = (FBFeed) o;
        return this.posts.equals(j.getPosts());
    }
    public FBFeed clone(){
        return new FBFeed(this);
    }
    public String toString(){
        return "FEED: "+
                "\n Posts: "+this.posts.toString();
    }


    /** i - Determinar o número de posts de um user
     */
    public int nrPosts(String user){
        return (int) posts.stream().filter(l->l.getUser().equals(user)).count(); //tem que ter o (int) porque o count retorna um long.
    }

    /** ii - Determinar a lista de posts de um user
     */
    public List<FBPost> postsOf(String user){
        return this.posts.stream().filter(l->l.getUser().equals(user)).collect(toList());
    }

    /** iii - Determinar a lista de posts de um user num determinado intervalo de tempo
     */
    public List<FBPost> postsOF(String user, LocalDateTime inicio, LocalDateTime fim) { //OU myList.stream().filter(x -> x.size() > 10 && x -> x.isCool()) ...
        return this.posts.stream().filter(l -> l.getPostTime().isAfter(inicio))
                .filter(l -> l.getPostTime().isBefore(fim))
                .filter(l -> l.getUser().equals(user))
                .collect(toList());
        //return posts.stream().filter(p->p.getUser() == user && p.getPostTime().compareTo(inicio)>0 && p.getPostTime().compareTo(fim)<0).collect(Collectors.toList());
    }

    /** iv - Obter um post dado o seu identificador
     */
    public FBPost getPost(int id){
        FBPost withID = new FBPost();
        for(FBPost x : posts){
            if(x.getId() == id)
                withID = x;
        }
        return withID;
    }

    /** v - Inserir um comentário num post
     */
    public void comment(FBPost post, String comentario){
        for(FBPost f : posts){
            if(f.equals(post))
                f.getComments().add(comentario);
        }
        //getPost(post.getId()).getComments().add(comentario);
    }

    /** vi - Inserir um comentário num post
     */
    public void comment(int postid, String comentario){
        for(FBPost x : posts){
            if(postid == x.getId())
                x.getComments().add(comentario);
        }
        //getPost(postid).getComments().add(comentario);
    }

    /** vii - Adicionar um like a um post
     */
    public void like(FBPost post){
        getPost(post.getId()).setLikes(post.getLikes()+1);
    }

    /** viii - Adicionar um like a um post
     */
    public void like(int postid){
        FBPost aux = getPost(postid);
        aux.setLikes(aux.getLikes()+1);
    }

    /** ix - Determinar a lista dos 5 posts (identificador) com mais comentários
     */
    public List<Integer> top5Comments(){
        return this.posts.stream().limit(5).map(FBPost::getId)  //java sorted arraylist with comparator, limited to 5 elements
                .sorted((o1, o2) -> {
                    int size1 = getPost(o1).getComments().size(); int size2 = getPost(o2).getComments().size();
                    return Integer.compare(size2, size1);
                }
                ).collect(toList());
    }
}
