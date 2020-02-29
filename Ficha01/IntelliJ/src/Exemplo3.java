import java.util.Scanner;

/**
 * Calcular o somatório de 10 números
 */

public class Exemplo3 {
    public static void main(String[] args){
        int soma=0;
        Scanner ler = new Scanner(System.in);

        for(int i=0; i<10; i++){
            System.out.print("Número a somar: ");
            soma += ler.nextInt();
        }
        System.out.print("O somatório dá: "+soma);
        ler.close();
    }
}
