import java.util.Scanner;

/**
 * Calcular o somatório de n números enquanto o utilizador assim o quiser
 */

public class Exemplo4 {
    public static void main(String[] args) {
        int soma = 0, n;
        String resp;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Quantos números quer somar?");
            n = input.nextInt();
            for(int i=0; i<n; i++){
                System.out.print("Valor a somar: ");
                soma += input.nextInt();
            }
            System.out.print("Quer continuar? [s/n]");
            resp = input.next();
        } while (resp.charAt(0) != 'n');
        input.close();
        System.out.print("A somatório dos números é: " + soma);
    }
}
