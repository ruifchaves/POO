import java.util.Scanner;

/**
 * Escrever um programa que, dada um data em dia (1..31), mês (1..12) e ano, calcule o dia
 * da semana dessa data.
 */
public class Ex1 {
    public static void main (String[] args){
        int dia, mes, ano, diaDaSemana;
        String resp;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o dia, o mês e o ano: ");
        dia = input.nextInt();
        mes = input.nextInt();
        ano = input.nextInt();
        diaDaSemana=(ano - 1900)*365+((ano-1900)/4);
        if (ano % 4 == 0 && (mes==1 || mes==2)) diaDaSemana-=1;
        if (mes>2) diaDaSemana = diaDaSemana + dia + (mes-2)*31 + 28;
        else diaDaSemana = diaDaSemana + (mes-1)*31 + dia;
        diaDaSemana%=7;
        switch(diaDaSemana){
            case 0: resp = "Domingo"; break;
            case 1: resp = "Segunda-feira"; break;
            case 2: resp = "Terça-feira"; break;
            case 3: resp = "Quarta-feira"; break;
            case 4: resp = "Quinta-feira"; break;
            case 5: resp = "Sexta-feira"; break;
            default: resp = "Sábado"; break;}      //caso tenha case 6 em vez de default reclama que o resp não foi inicializado
         System.out.println("O dia da semana é: "+resp);
        input.close();
    }
}

