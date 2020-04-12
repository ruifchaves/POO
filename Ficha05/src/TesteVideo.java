import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TesteVideo {
    public static void main(String[] args){
        ArrayList<String> coms1 = new ArrayList<>(Arrays.asList("comment 1", "comment 2")); //ou String[] com = {"com1", "com2"}; coms.add(com)
        ArrayList<String> coms2 = new ArrayList<>(Arrays.asList("comment 45", "comment 54"));
        VideoYoutube vid1 = new VideoYoutube("iPhone Review", new Byte[]{1,2,3,4}, LocalDate.of(2019, 4, 15),
                "1080p", 5, 30, coms1, 10, 1, "123123");
        VideoYoutube vid2 = new VideoYoutube("iPhone2 Review", new Byte[]{1,2,3,4}, LocalDate.of(2020, 4, 10),
                "2160p", 10, 25, coms2, 200, 5, "123124");

        SistemaVideos sv = new SistemaVideos();
        sv.addVideo(vid1); sv.addVideo(vid2);


        //metodos Classe VideoYoutube
        vid1.insereComentario("comentario 3");
        System.out.println("O video foi publicado há "+vid1.qtsDiasDepois()+" dias.");
        vid1.thumbsUp();
        System.out.println("\n"+vid1.toString());

        //metodos classe SistemaVideos
        System.out.println("\nVídeo com o cod 123124: "+sv.getVideo("123124").toString());
        sv.addLike("123123");
        System.out.println("\nCódigo Vídeo com mais likes: "+sv.topLikes());
        System.out.println("\nCódigo Vídeo com mais likes entre duas datas: "+sv.topLikes(LocalDate.of(2018, 5, 25), LocalDate.now()));
        System.out.println("\nVídeo mais longo: "+sv.videoMaisLongo().toString());

        sv.removeVideo("123124");
        System.out.println(sv.toString());
    }


}
