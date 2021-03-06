import sun.reflect.annotation.AnnotationSupport;

import javax.sound.midi.SysexMessage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

        //ALÍNEA D
        System.out.print("\nDe que unidade curricular quer calcular a média (1-5)? ");
        int idUC = sc.nextInt();
        float media2 = f2.mediaUC(idUC-1, notasTurma);
        System.out.print("A média das notas da unidade curricular "+idUC+" é: "+media2);

        //ALÍNEA E
        int notamax = f2.notaMaisAlta(notasTurma);
        System.out.print("\nA nota mais alta a todas as unidades curriculares de todos os alunos é: "+notamax);

        //ALÍNEA F
        int notamin = f2.notaMaisBaixa(notasTurma);
        System.out.println("\nA nota mais baixa a todas as unidades curriculares de todos os alunos é: "+notamin);

        //ALÍNEA G
        int j=1;
        System.out.print("\nPretende ver as notas acima de que valor(Valores inteiros)? ");
        int v = sc.nextInt();
        int[] notasAcima = f2.notasAbove(notasTurma, v);
        System.out.print("As notas maiores que "+v+" são: "+notasAcima[0]);
        for(; j<notasAcima.length-1; j++) {
            System.out.print(", " + notasAcima[j]);
        }
        System.out.print(", "+notasAcima[j]+".");

        //ALÍNEA H
        System.out.println("\n"+f2.stringNotas(notasTurma));

        //ALÍNEA I
        System.out.println("\nA UC com melhor média é a UC nº: "+f2.ucMelhorMedia(notasTurma));
    }

    public static void Ex4TestCall(){
        //ALÍNEA A
        Scanner sc = new Scanner(System.in);
        Ex4 f4 = new Ex4();

        System.out.println("\nQuantos inteiros que adicionar ao array?");
        int n = sc.nextInt();
        int[] ints = new int[n];
        System.out.println("Escreva os números que pretende adicionar ao array: ");
        for(int i=0; i<n; i++){
            ints[i] = sc.nextInt();
        }
        ints = f4.ordenarArray(ints);
        /*for(int m=0; m<ints.length; m++) {
            System.out.println("ints[i] = " + ints[m]);
        }*/
        System.out.println(Arrays.toString(ints)); //mais simples que o de cima. import java.util.Arrays

        //ALÍNEA B
        System.out.print("Qual o valor a procurar no array? ");
        int x = sc.nextInt();
        int result = f4.binarysearch(ints, 0, n-1, x);
        switch(result){
            case -1:
                System.out.println("O valor inserido não existe no array.");
                break;
            default:
                System.out.println("O valor está presente no indíce "+result+" do array.");
                break;
        }
    }

    public static void Ex3TestCall(){
        Scanner sc = new Scanner(System.in);
        Dates ld = new Dates();

        //ALÍNEA A
        System.out.println("\nDigita o ano, o mês e o dia de uma data: ");
        int ano = sc.nextInt(); int mes = sc.nextInt(); int dia = sc.nextInt();
        System.out.println("\nA data vai ser adicionada ao array.");
        LocalDate date = LocalDate.of(ano,mes,dia);
        ld.insereData(date);
        //System.out.println("Dates: "+ld.toString());

        //ALÍNEA B
        System.out.println("\nA data dada vai ser comparada com as outras do array.");
        LocalDate maisProx = ld.dataMaisProxima(date);
        maisProx.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("\nA data do array que está mais próxima é: "+maisProx);

        //ALÍNEA C
        System.out.println("\nDatas: "+ld.toString());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Que exercício pretende executar(1-4)? ");
        int ex = sc.nextInt();
        switch (ex){
            case 1: Ex1TestCall();
                break;
            case 2: Ex2TestCall();
                break;
            case 3: Ex3TestCall();
                break;
            case 4: Ex4TestCall();
                break;
        }
    }
}
