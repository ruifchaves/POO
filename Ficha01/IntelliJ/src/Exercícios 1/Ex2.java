import java.util.Scanner;

/**
 * 2. Escrever um programa que determine a soma de duas datas em dias, horas, minutos e
 * segundos, utilizando um método auxiliar para o efeito. O método deverá aceitar as duas
 * datas e devolver uma string no formato "ddD hhH mmM ssS".
 */
public class Ex2 {
    public static String aux(int d1, int d2, int h1, int h2, int m1, int m2, int s1, int s2){
        int d=0, h=0, m=0, s=0;
        String resp;
        if (s1+s2 <60) s=s1+s2;
        else{s=s1+s2-60; m=1;}
        if (m1+m2+m <60) m=m1+m2+m;
        else{m=m1+m2+m-60; h=1;}
        if (h1+h2+h <24) h=h1+h2+h;
        else{h=(h1+h2+h)-24;d=1;}
        d=d1+d2+d;
        resp = "A soma das datas é: "+d+"D "+h+"H "+m+"M "+s+"S.";
        System.out.println(resp);
        return resp;
        //System.out.printf("A soma das datas é: %dD %dH %dM %dS",d,h,m,s);
    }

    public static void main(String[] args){
        int dia1, dia2, hora1, hora2, min1, min2, seg1, seg2;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite os dias, as horas, os minutos e os segundos da primeira data: ");
        dia1 = input.nextInt(); hora1 = input.nextInt(); min1 = input.nextInt(); seg1 = input.nextInt();
        System.out.println("Digite os dias, as horas, os minutos e os segundos da segunda data: ");
        dia2 = input.nextInt(); hora2 = input.nextInt(); min2 = input.nextInt(); seg2 = input.nextInt();
        aux(dia1, dia2, hora1, hora2, min1, min2, seg1, seg2);
        input.close();
    }
}
