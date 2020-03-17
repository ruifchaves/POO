
/**
 * 2. Considerando que temos uma pauta de 5 alunos e que todos os alunos tem
 * notas a 5 unidades curriculares, dene-se o array int[5][5] notasTurma
 * (Alunos X UnidadesCurriculares). Crie um programa que permita:
 *      (a) ler as notas dos alunos e actualiza o array da pauta;
 *      (b) calcular a soma das notas a uma determinada unidade curricular;
 *      (c) calcular a média das notas de um aluno (fornecendo o índice da sua
 *      posição no array);
 *      (d) calcular a média das notas de uma unidade curricular, dado o índice
 *      da unidade curricular;
 *      (e) calcular a nota mais alta a todas as unidades curriculares de todos os
 *      alunos;
 *      (f) idem para a nota mais baixa;
 *      (g) devolver o array com as notas acima de um determinado valor;
 *      (h) calcular uma String com as notas de todos os alunos do curso a todas
 *      as unidades curriculares;
 *      (i) determinar o índice da unidade curricular com a média mais elevada
 */

public class Ex2 {
    //a

    //b
    public int somaNotas(int x ,int[][] notasTurma){
        int soma=0;
        for(int i=0; i<5; i++)
            soma += notasTurma[i][x];
        return soma;
    }
    //c
    public float mediaAluno(int al, int[][] notasTurma){ //era suposto so passar como argumento o array com as notas desse aluno?
        float soma = 0;
        int i=0;
        for (; i < notasTurma[al].length; i++) {
            soma += notasTurma[al][i];
        }
        return soma/i;
    }
}
