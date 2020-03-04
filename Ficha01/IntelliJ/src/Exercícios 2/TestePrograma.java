import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 * 4 Metodologia de programação de POO
 * Exercícios II
 */

public class TestePrograma {
    public static void main(String[] args){
        // inicialização de um scanner para leitura
        Scanner sc = new Scanner(System.in);

        // criar um objecto da classe que implementa os métodos
        Ficha1 f = new Ficha1();

        //Exercício 1
        System.out.print("EX 1:\nDigite a temperatura em graus Celsius: ");
        float temp = sc.nextFloat();
        System.out.println("Temperatura dada em Fahrenheit: "+f.celsiusParaFahrenheit(temp)+"\n");

        //Exercício 2
        System.out.println("EX 2:\nDigite dois valores inteiros: ");
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        System.out.println("O maior dos dois valores inteiros é: "+f.maximoNumeros(x1,x2)+"\n");

        //Exercício 3
        System.out.println("EX 3:\nInsira saldo e nome: ");
        double saldo = sc.nextDouble();
        sc.nextLine();  // Consume newline left-over
        //That's because the Scanner.nextInt method does not read the newline character in your input created by hitting "Enter," and so the call to Scanner.nextLine returns after reading that newline.
        String nome = sc.nextLine();
        String str = f.criaDescricaoConta(nome, saldo);
        System.out.println("Resposta: "+str+"\n");

        //Exercício 4
        System.out.println("EX 4:\nDigite o valor em euros e a taxa de conversão: ");
        double euros = sc.nextDouble();
        double taxa = sc.nextDouble();
        System.out.println("Valor em euros: "+f.eurosParaLibras(euros,taxa)+"\n");

        //Exercício 5
        System.out.println("EX 5:\nDigite dois valores inteiros: ");
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println(f.decrescenteEmedia(y1,y2)+"\n");

        //Exercício 6
        int num = Integer.parseInt(args[0]);
        System.out.println("EX 6:\nResultado: "+f.fatorial(num)); //Integer.valueOf() vs Integer.parseInt()

        //Exercício 7
        LocalDateTime begin = LocalDateTime.now();
        System.out.println("EX 7:\nTempo Gasto: "+f.tempoGasto());

    }
}
class Ficha1{ //caso tenha public class, erro:"Class 'Ficha1' is public, should be declared in a file named 'Ficha1.java'"
        //implementação dos métodos que permitem
        //responder a cada um dos exercícios propostos
        // Pergunta 3: Ler um nome (String) e um saldo (decimal)
        // e imprimir uma String texto com os resultados.
        // Nota: o método devolve uma String que será
        // impressa no programa principal (na main)
        public double celsiusParaFahrenheit(double graus){
            double fahren = graus*(9/5) + 32;
            return fahren;
        }
        public int maximoNumeros(int a, int b){
            int max;
            if(a>b) max = a;
            else max=b;
            return max;
        }
        public String criaDescricaoConta(String nome, double saldo){
            return "Nome: " +nome+ ", Saldo: "+saldo;
        }
        public double eurosParaLibras(double valor, double taxaConversao){
            return valor*taxaConversao;
        }
        public String decrescenteEmedia(int a, int b){
            int menor=a, maior=b, media;
            if(a>b){
                maior = a; menor = b;
            }
            else{
                maior = b; menor = b;
            }
            media = (a+b)/2;
            return "Valores por ordem decrescente: "+maior+" "+menor+"; Média: "+media+".";
        }
        public long fatorial(int num){
            long fat=1;
            for(;num>0;num--){
                fat*=num;
            }
            return fat;
        }
        public long tempoGasto(){
            LocalDateTime begin = LocalDateTime.now();
            long res=1;
            for(int i=2; i<5001; i++){
                res*=i;
            }
            LocalDateTime end = LocalDateTime.now();
            Duration duration = Duration.between(begin, end);
            long seconds = duration.getSeconds();
            return seconds*1000;
        }
}
