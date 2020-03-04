import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * 7. Escrever um programa que leia o ano, mês e dia de nascimento de uma pessoa e calcule
 * a sua idade actual em horas, assim como a data e hora em que esse cálculo foi efectuado
 */
public class Ex7 { //CLASSE
    public static void main(String[] args){ //MÉTODO MAIN
        int ano, mes, dia;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ano, o mês e o dia da sua data de nascimento: ");
        ano = input.nextInt();
        mes = input.nextInt();
        dia = input.nextInt();
        LocalDate date = LocalDate.of(ano, mes, dia);
        System.out.println("Idade atual em horas: "+(DAYS.between(date, LocalDate.now()))*24);
        //System.out.println("Idade atual em horas: "+ano*12*31*24+mes*31*24+dia*24); //mal, teríamos que subtrair a data atual ao ano mes e dia e dps multiplicar.
        System.out.println(LocalDateTime.now());
        input.close();
    }
}
