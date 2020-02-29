import java.util.Scanner;

/**
 * Calcular o somatório de n números enquanto o utilizador assim o quiser
 */

public class Exemplo4 {
    public static void main(String[] args) {
        int soma = 0, i = 0, n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Quantos números quer somar?");
            n = input.nextInt();
            i++;
        } while (i < n);
        input.close();
        System.out.print("A somatório dos " + " números é: " + soma);
    }
}
