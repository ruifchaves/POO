import java.util.Scanner;

/**
 * 3. Escrever um programa que aceite n classicações (números reais) de uma UC, e indique o
 * número de classicações em cada um dos intervalos: [0, 5[, [5, 10[, [10, 15[ e [15, 20].
 */

public class Ex3 {
    public static void main(String[] args){
        int n, conta1=0, conta2=0, conta3=0, conta4=0;
        int[] notas;
        Scanner input = new Scanner(System.in);
        System.out.print("Quantas classificações são? ");
        n = input.nextInt();
        for(int i=0; i<n; i++){
            System.out.print((i+1)+"ª Classificação: ");
            int nota=input.nextInt();
            if(nota>=0 && nota<5)    conta1++;
            if(nota>=5 && nota<10)   conta2++;
            if(nota>=10 && nota<15)  conta3++;
            if(nota>=15 && nota<=20) conta4++;
        }
        System.out.printf("-[ 0, 5[: %d;%n-[ 5,10[: %d;%n-[10,15[: %d;%n-[15,20]: %d;%n",conta1,conta2,conta3,conta4); //%n new line
        input.close();
    }
}