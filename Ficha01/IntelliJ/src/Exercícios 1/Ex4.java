import java.util.Scanner;
import java.lang.Math;

/**
 * Escrever um programa que aceite n temperaturas inteiras (pelo menos duas) e determine
 * a média das temperaturas, o dia (2,3, ...) em que se registou a maior variação em valor
 * absoluto relativamente ao dia anterior e qual o valor efectivo (positivo ou negativo) dessa
 * variação.
 */

public class Ex4{
    public static int med(int[] temps){
        int media=0, soma=0;
        for(int i=0; i<temps.length; i++)
            soma+=temps[i];
        media=soma/temps.length;
        return media;
    }

    public static int[] variacao(int[] temps){
        int[] varia = new int[3];
        int max=0;
        for(int i=1; i<(temps.length);i++){
            if(Math.abs(temps[i-1]-temps[i])>max){
                max=(temps[i-1]-temps[i]);
                varia[0]=(i);
                varia[1]=(i+1);
                varia[2]=max;
            }
        }
        return varia;
    }

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Quantas temperaturas pretende introduzir (>2)? ");
        int n = input.nextInt();
        int[] temps = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("Digite a "+(i+1)+"ª temperatura: ");
            temps[i] = input.nextInt();
        }

        String subdesc;
        int[] varia = variacao(temps);
        if(varia[2]<0) subdesc="subido";
        else subdesc="descido";
        System.out.println("A média das "+n+" temperaturas foi de "+med(temps)+" graus.");
        System.out.println("A maior variação registou-se entre os dias "+varia[0]+" e "+varia[1]+", tendo a temperatura "+subdesc+" "+Math.abs(varia[2])+" graus.");
        input.close();
    }
}
