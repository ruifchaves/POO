import java.util.Scanner;
import java.time.LocalDate;

/**
 * Escrever um programa que, dada um data em dia (1..31), mês (1..12) e ano, calcule o dia
 * da semana dessa data. - usando classes do package java.time
 */
public class Ex1V2 {
    public static void main(String[] args){
        int dia, mes, ano;
        Scanner input = new Scanner(System.in);
        System.out.print("Escreva o dia: ");
        dia = input.nextInt();
        System.out.print("Escreva o mês: ");
        mes = input.nextInt();
        System.out.print("Escreva o ano: ");
        ano = input.nextInt();
        LocalDate data = LocalDate.of(ano,mes,dia);
        System.out.println("O dia da semana da data dada é: "+data.getDayOfWeek());
    }
}
