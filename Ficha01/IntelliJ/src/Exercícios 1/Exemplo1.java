import java.util.Scanner;

/**
 * Lê dois números e diz qual o maior
 */

public class Exemplo1 {
    /** Diz qual é o maior dos dois números */
    public static void dizMaior(int a, int b){
        int maior;
        if (a>b) maior = a;
        else maior = b;

        System.out.println("O MAIOR DOS NÚMEROS É: " + maior);
    }
    /** Início do programa */
    public static void main(String[] args){
        int a, b;
        Scanner ler = new Scanner(System.in);

        System.out.print("INDIQUE DOIS NÚMEROS INTEIROS: ");
        a = ler.nextInt();
        b = ler.nextInt();
        dizMaior(a,b); // ou Exemplo1.dizMaior(a,b)
        ler.close();
    }
}
