import java.util.Scanner;

/**
 * Lê dois números e diz qual é o maior.
 * (agora sem inventar a roda)
 */

public class Exemplo2 {
    /** Diz qual é o maior - utilizando a classe Math  */
    public static void dizMaior (int a, int b){
        System.out.println("O maior dos dois números é: " + Math.max(a,b));
    }
    public static void main(String[] args) {
        int a, b;
        Scanner lerNums = new Scanner(System.in);
        System.out.println("Indique dois inteiros: ");
        a = lerNums.nextInt();
        b = lerNums.nextInt();
        dizMaior(a,b);
        lerNums.close();
    }
}
