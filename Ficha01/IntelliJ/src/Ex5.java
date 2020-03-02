import java.util.Scanner;

/**
 * Escrever um programa que leia sucessivas vezes a base e altura de um triângulo retângulo
 * (valores reais) e calcule a área e o perímetro respectivos. Usar printf() para apresentar os
 * resultados com uma precisão de 5 casas decimais. O programa apenas deverá terminar com
 * a leitura de uma base = 0.0.
 */

public class Ex5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        float base=1, alt, perim, area;
        while(base>0) {                                             //not good, tentar fazer ciclo e não precisar de break; nem system.exit nem wtv
            System.out.print("Digite o valor da base: ");
            base = input.nextFloat();
            if (base == (float) 0.0){
                System.out.println("exit...");
                System.exit(0);
            }
            System.out.print("Digite o valor da altura: ");
            alt = input.nextFloat();
            perim = base + alt;
            area = (base * alt) / 2;
            System.out.printf("A perímetro é %.5f e a área é %.5f. \n\n", perim, area);
            input.close();
        }
    }
}
