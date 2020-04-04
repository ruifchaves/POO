import java.time.LocalDate;
import java.util.ArrayList;

public class TesteEncomenda extends LinhaEncomenda {
    public static void main(String[] args){
        LinhaEncomenda le1 = new LinhaEncomenda("12344", "Telemóvel a",
                200, 1, 0.23, 0.1);
        LinhaEncomenda le2 = new LinhaEncomenda("12345", "Telemóvel b",
                500, 2, 0.23, 0.1);
        LinhaEncomenda le3 = new LinhaEncomenda("12346", "Telemóvel c",
                300, 4, 0.23, 0.1);

        ArrayList<LinhaEncomenda> linha1 = new ArrayList<>();
        ArrayList<LinhaEncomenda> linha2 = new ArrayList<>();
        ArrayList<LinhaEncomenda> linha3 = new ArrayList<>();
        linha1.add(le1); linha1.add(le3);
        linha2.add(le2); linha2.add(le3);
        linha3.add(le1);

        EncEficiente encEf1 = new EncEficiente("Chaves",444444444,"Rua José Antunes",1, LocalDate.now(),linha1);
        EncEficiente encEf2 = new EncEficiente("Firmino",555555555,"Rua Liverpool",2, LocalDate.now(),linha2);
        EncEficiente encEf3 = new EncEficiente("Manel",555555555,"Rua JJboce",3, LocalDate.now(),linha3);

        GestãoEncomendas ge = new GestãoEncomendas();
        ge.addEncomenda(encEf1);
        ge.addEncomenda(encEf2);

        //i
        System.out.println("todosCodigos: ");
        System.out.println(ge.todosCodigos());
        //ii
        System.out.println("addEncomenda: ");
        ge.addEncomenda(encEf3);
        System.out.println(ge.toString());
        //iii
        System.out.println("getEncomenda: ");
        ge.getEncomenda(3).toString();
        //iv
        System.out.println("removeEncomenda: ");
        ge.removeEncomenda(3);
        System.out.println(ge.toString());
        //v
        System.out.println("Encomenda com mais produtos: "+ge.encomendaComMaisProdutos());
        //vi
        System.out.println("Encomendas com um deteterminado produto: "+ge.encomendasComProduto("12344").toString());
        //vii
        System.out.println("Encomendas após uma data: "+ge.encomendasAposData(LocalDate.ofYearDay(1999,29-11)).toString());
        //viii
        System.out.println("Encomendas por ordem decrescentes de valo: "+ge.encomendasValorDecrescente().toString());
        //ix
        System.out.println("Map: "+ge.encomendasDeProduto().toString());
    }
}
