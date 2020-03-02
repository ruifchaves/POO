import java.util.Scanner;

/**
 * 6. Escrever um programa que leia um inteiro n e imprima todos os números primos inferiores
 * a n. Utilize um método auxiliar para determinar de um número é ou não primo.
 * No fim da execução o utilizador deverá ter a possibilidade de jogar novamente
 */

public class Ex6 {
    public static boolean isPrimo(int x){
        for(int i = 2; i <= x/2; ++i){ //We only have to loop through 2 to half of x, because no number is divisible by more than its half.
            if(x % i == 0) return false; //false & true em pequeno
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String resp;
        int n;
        do{
            System.out.print("Digite o número: ");
            n = input.nextInt();
            System.out.print("Números primos até "+n+": ");
            for(int i=2; i<=n; i++){
                if(isPrimo(i)) System.out.print(i+" ");
            }
            System.out.print("\n\nDeseja jogar novamente? [s/n] ");
            resp = input.next();
        }while(resp.charAt(0) != 'n');
        input.close();
    }
}
