import java.util.Scanner;

/**
 * Calcular o somatório de n números
 */

public class Exemplo4V2{
    public static void main(String[] args) {
        int soma = 0, i = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Quantos números quer somar?");
        int n = input.nextInt();
        for(;i<n;i++){
            System.out.print("Valor a somar: ");
            soma += input.nextInt();
        }
        input.close();
        System.out.print("A somatório dos " + n + " números é: " + soma);
    }
}