import java.util.ArrayList;
import java.time.LocalDate;
/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class EncEficienteTeste{
    public static void main(String[] args){
        LinhaEncomenda le = new LinhaEncomenda("6593431", "Telemóvel",
                13, 300, 0.23, 0.20);
        LinhaEncomenda le1 = new LinhaEncomenda("6593431", "Telemóvel",
                13, 300, 0.23, 0.20);
        LinhaEncomenda le2 = new LinhaEncomenda("6593430", "Telemóvel",
                13, 300, 0.23, 0.20);
        ArrayList<LinhaEncomenda> linha = new ArrayList<>();
        linha.add(le); linha.add(le2);linha.add(le1);
        EncEficiente Ola = new EncEficiente("Ze",2655685,"Rua da Uni",1,LocalDate.now(),linha);
        EncEficiente Ola2 = new EncEficiente("Ze",2655685,"Rua da Uni",1,LocalDate.now(),linha);
        System.out.println("-Valor total de Produtos: "+Ola.calculaValorTotal());
        System.out.println("-Desconto total de Produtos: "+Ola.calculaValorDesconto());
        System.out.println("-Número total de Produtos: "+Ola.numeroTotalProdutos());
        if(Ola.equals(Ola2))System.out.println("São iguais obviamente.");
        if(Ola.existeProdutoEncomenda("6593431")) System.out.println("Existe produto.");
        LinhaEncomenda le3 = new LinhaEncomenda("12345", "Telemóvel",
                13, 300, 0.23, 0.20);
        Ola.adicionaLinha(le3);
        Ola.removeProduto("6593430");
        System.out.println(Ola.toString());
    }
}
