package DriveIt_abstract;

import javax.xml.bind.annotation.XmlEnum;
import java.util.*;

public class Menu {
    private List<String> opcoes;
    private int op;

    /**
     * Constructor for objetcs of type Menu
     */
    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes); //recebe array, converte para uma lista dess tipo
        this.op = 0;
    }

    /**
     * Construtor 2
     */
    public Menu(List<String> opcoes){
        this.opcoes = opcoes;
        this.op = 0;
    }

    /**
     * Metodo para apresentar o menu e ler uma opcao;
     */
    public void executa(int menuNumber){ //em vez de passar menuNumber, era preferivel criar vi String nomeMenu;
        do {
            showMenu(menuNumber);
            this.op = lerOpcao();
        } while(this.op == -1); //enquanto nao for opcao valida, mostra o menu
    }
    /**
     * Apresentar o Menu
     */
    private void showMenu(int menuNumber){
        System.out.println("\n *** "+getMenuName(menuNumber)+" *** ");
        for(int i = 0; i<this.opcoes.size(); i++){
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        if(menuNumber!=0) System.out.println(this.opcoes.size()+1+" - Voltar ao menu Inicial");
        System.out.println("0 - Sair");
    }
    /**
     * Nome do menu, atraves de menuNumber
     */
    private String getMenuName(int menuNumber){
        String name = "";
        switch (menuNumber){
            case 0: name = "Menu Inicial"; break;
            case 2: name = "Menu B"; break;
            case 3: name = "Menu C"; break;
        }
        return name;
    }

    /**
     * Ler uma opcao valida
     */
    private int lerOpcao(){
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opcao: ");
        try {
            op = is.nextInt();
        } catch (InputMismatchException e) { //Nao foi escrito um int
            op = -1;
        } if (op<0 || op>this.opcoes.size()+1) {
            System.out.println("Opcao Invalida!");
            op = -1;
        }
        return op;
    }

    /**
     * Metodo para obter a última opcao lida
     */
    public int getOpcao(){
        return this.op;
    }
}
