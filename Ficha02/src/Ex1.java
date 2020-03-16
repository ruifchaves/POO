import java.util.Scanner;

/**
 *1. Criar um programa que permita efectuar as seguintes operações:
 * (a) ler inteiros para um array e depois determinar o valor mínimo desse
 * array.
 * (b) ler um array de inteiros e dois índices e determinar o array com os
 * valores entre esses índices.
 * (c) ler dois arrays de inteiros e determinar o array com os elementos
 * comuns aos dois arrays.
 */

public class Ex1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Ex1Test t = new Ex1Test(); // criar um objecto da classe que implementa os métodos.

        //a
        System.out.print("Número de inteiros a ler? ");
        int total = input.nextInt();
        System.out.println("Escreva os "+total+" números a adicionar ao array.");
        int[] ints = new int[total];
        for(int i=0; i<total; i++)  // for(int i=0; i < ints.length; i++)
            ints[i] = input.nextInt();
        //int[] array = t.array(total);
        System.out.println("O menor número do array é: "+ t.getMin(ints));

        //b
        System.out.println("Digite os dois índices para determinar o array com os valores entre esses índices:");
        int a = input.nextInt();
        int b = input.nextInt();
        int[] newints = t.arrayEntre(ints, a, b);
        for(int i=0; i<newints.length; i++){
            System.out.println("Posição: " + (i+1) + " = " +newints[i] +";");
        }

        //c

    }
}
