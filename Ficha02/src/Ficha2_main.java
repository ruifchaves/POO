import javax.sound.midi.SysexMessage;
import java.util.Scanner;


public class Ficha2_main {
    public static void Ex1TestCall(){
        Scanner input = new Scanner(System.in);
        Ex1 t = new Ex1(); // criar um objecto da classe que implementa os métodos.

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

    public static void Ex2TestCall(){
        Scanner sc = new Scanner(System.in);
        Ex2 f2 = new Ex2();
        //int idaluno = 0, idnota = 0;
        int[][] notasTurma = new int[5][5];

        //ALÍNEA A (tem que ser aqui porque os inputs e outputs têm que estar na main)
        int aluno=1;
        for(int x=0; x<notasTurma.length; x++) {
            System.out.println("Digite as 5 notas do aluno " + (aluno++) + ": ");
            for (int i = 0; i < notasTurma[0].length; i++)
                notasTurma[x][i] = sc.nextInt();
        }
        /* NAO FUNCIONA, Só adiciona a cada notasTurma[i][0]
        for(int[] aluno: notasTurma){
            for(int nota: aluno){
                aluno[nota] = sc.nextInt();
            }
        */

        //ALÍNEA B
        System.out.print("\nPretende somar as notas de que unidade curricular(1-5)? ");
        int uniCurr = sc.nextInt();
        int soma = f2.somaNotas(uniCurr-1, notasTurma);
        System.out.println("A soma das notas é: "+soma);

        //ALÍNEA C
        System.out.print("\nDe que aluno quer calcular a média (1-5)? ");
        int idAluno = sc.nextInt();
        float media = f2.mediaAluno(idAluno-1, notasTurma);
        System.out.print("A média do aluno "+idAluno+" é: "+media);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Que exercício pretende executar(1-2)? ");
        int ex = sc.nextInt();
        switch (ex){
            case 1: Ex1TestCall();
                break;
            case 2: Ex2TestCall();
                break;
        }
    }
}
