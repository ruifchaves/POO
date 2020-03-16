
/**
 *1. Criar um programa que permita efectuar as seguintes operações:
 * (a) ler inteiros para um array e depois determinar o valor mínimo desse
 * array.
 * (b) ler um array de inteiros e dois índices e determinar o array com os
 * valores entre esses índices.
 * (c) ler dois arrays de inteiros e determinar o array com os elementos
 * comuns aos dois arrays.
 */

public class Ex1{
    //a
    public int getMin(int[] nums){  //sem static!!
        int min=nums[0];
        for(int i=0; i < nums.length; i++)
            if(nums[i]<min) min=nums.length;
        return min;
    }
    //b
    public int[] arrayEntre(int[] arr, int a, int b){   //sem static!!
        int[] newints = new int[b-a+1];
        for(int i = 0; a<=b; i++,a++){
            System.out.println("i: "+i+"\n");
            newints[i]=arr[a];
        }
        return newints;
    }
    //c
    public boolean existValue(int a, int[] array, int len){
        for(int i=0; i<len; i++){
            if(a==array[i]) return true;
        }
        return false;
    }

    public int[] comuns(int[] a1 , int[] a2) { //NÃO TESTADO
        int len = a1.length > a2.length ? a2.length : a1.length; //nº max de comuns corresponde tamanho do menor array.
        int[] sameAux = new int[len];
        int index = 0;
        for (int i = 0; i < a1.length; i++) {
            if (existValue(a1[i], a2, a2.length) && !existValue(a1[i], sameAux, index)) {
                sameAux[index] = a1[i];
                index++;
            }
        }
        int[] same = new int[index]; //nao é index+1 porque ele é incrementado
        System.arraycopy(sameAux,0,same, 0, same.length); //same.length=index+1
        return same;
    }
}
