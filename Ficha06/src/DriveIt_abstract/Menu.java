package DriveIt_abstract;

import java.util.*;

public class Menu {
    private List<String> opcoes;
    private int op;

    /**
     * Constructor for objetcs of type Menu
     */
    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes); //recebe array, converte para uma lista dess tipo
        op = 0;
    }

    /**
     * Metodo para apresentar o menu e ler uma opcao;
     */
    public void executa(){
        do {
            showMenu();
            this.op = lerOpcao();
        } while(this.op == -1);
    }
    /**
     * Apresentar o Menu
     */
    private void showMenu(){
        System.out.println("\n *** Menu *** ");
        for(int i = 0; i<this.opcoes.size(); i++){
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
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
        } if (op<0 || op>this.opcoes.size()) {
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
