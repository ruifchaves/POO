package FBFeed;
import javafx.collections.transformation.SortedList;

import javax.print.DocFlavor;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeedMap {
    private Map<String, List<FBPost>> postsUser;

    public FBFeedMap(){
        postsUser = new HashMap<>();
    }
    public FBFeedMap(Map<String, List<FBPost>> sup){
        setPostsUser(sup);
    }
    public FBFeedMap(FBFeedMap feed){
        postsUser = feed.getPostsUser();
    }

    public List<FBPost> setList(List<FBPost> list){
        //return list.stream().map(FBPost::clone).collect(Collectors.toList());
        List<FBPost> ret = new ArrayList<>();
        for(FBPost p : list)
            ret.add(p);
        return ret;
    }
    public Map<String, List<FBPost>> getPostsUser(){
        Map<String, List<FBPost>> ret =  new HashMap<>();
        for(Map.Entry<String, List<FBPost>> fe : this.postsUser.entrySet())
            ret.put(fe.getKey(), setList(fe.getValue()));
        return ret;
    }
    public void setPostsUser(Map<String, List<FBPost>> newPosts){
        this.postsUser = new HashMap<>();
        for(Map.Entry<String, List<FBPost>> fe : newPosts.entrySet())
            postsUser.put(fe.getKey(), setList(fe.getValue()));
    }

    //i
    public void addFBPost(String user, FBPost post){
        postsUser.putIfAbsent(user, new ArrayList<>());
        postsUser.get(user).add(post);
    }

    //ii
    public void removePosts(String user, LocalDateTime di, LocalDateTime df) {
        this.postsUser.get(user).removeIf(l -> l.getPostTime().isAfter(di) && l.getPostTime().isBefore(df));
    }

    //iii
    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df){
        int soma = 0;
        for(List<FBPost> list : this.postsUser.values())
            soma += list.stream().filter(post->post.getPostTime().isAfter(di) && post.getPostTime().isBefore(df)).count();
        return soma;
    }

    //iv
    public int postsNumPeriodoPorUser(LocalDateTime di, LocalDateTime df, String user){
        return (int) postsUser.get(user).stream().filter(post->post.getPostTime().isAfter(di) && post.getPostTime().isBefore(df)).count();
    }
    public String utilizadorMaisAtivo(LocalDateTime di, LocalDateTime df){
        String storeUser = "";
        int max = 0;
        for(String user : this.postsUser.keySet())
            if(postsNumPeriodoPorUser(di, df, user)>max){
                max = postsNumPeriodoPorUser(di, df, user);
                storeUser = user;
            }
        return storeUser;
    }
    //v
    public List<FBPost> timelineGlobal(){
        List<FBPost> ordenadoCrono = new ArrayList<>();
        this.postsUser.values().forEach(p->ordenadoCrono.add(p.clone()));
        ordenadoCrono.sort(new Comparator<FBPost>() {
            @Override
            public int compare(FBPost o1, FBPost o2) {
                if(o1.getPostTime().isBefore(o2.getPostTime())) return -1;
                if(o1.getPostTime().isAfter(o2.getPostTime())) return 1;
                return 0;
            }
        });
        return ordenadoCrono;
    }
}
