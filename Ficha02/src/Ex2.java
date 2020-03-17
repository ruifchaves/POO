
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

    //d
    public float mediaUC(int uc, int[][] notasTurma){
        float soma2 = 0;
        int i=0;
        for(; i<notasTurma.length; i++){
            soma2 += notasTurma[i][uc];
        }
        return soma2/i;
    }

    //e
    public int notaMaisAlta(int[][] notasTurma){
        int notaMAlta = 0;
        for(int i=0; i<notasTurma.length; i++){
            for(int l=0; l<notasTurma[i].length; l++)
                notaMAlta = (notasTurma[i][l]>notaMAlta) ? notasTurma[i][l] : notaMAlta;
        }
        return notaMAlta;
    }

    //f
    public int notaMaisBaixa(int[][] notasTurma){
        int notamin = notasTurma[0][0];
        for(int i=0; i<notasTurma.length; i++){
            for(int x=0; x<notasTurma[i].length; x++)
                notamin = (notasTurma[i][x]<notamin) ? notasTurma[i][x] : notamin;
        }
        return notamin;
    }

    //g dá erro caso o return do array seja null, as in caso o array esteja vazio
    public int[] notasAbove(int[][] aNotas, int v){
        int i=0;
        int[] notasMaioresAux = new int[aNotas.length*aNotas[0].length];
        for(int a=0; a<aNotas.length; a++){
            for(int b=0; b<aNotas[a].length; b++){
                if(aNotas[a][b]>v){
                    notasMaioresAux[i]=aNotas[a][b];
                    i++;
                }
            }
        }
        int[] notasMaiores = new int[i];
        System.arraycopy(notasMaioresAux,0,notasMaiores,0,i); //i=notasMaiores.length
        return notasMaiores;
    }

    //h
    public String stringNotas(int[][] aNotas) {
        String todasAsNotas = "";
        for (int i = 0; i < aNotas.length; i++) {
            for (int x = 0; x < aNotas[i].length; x++) {
                todasAsNotas += "Aluno "+(i+1)+" UC "+(x+1)+": "+aNotas[i][x]+"; \n"; // ou simplesmente aNotas[i][x]+", ";
            }
        }
        return todasAsNotas;
    }

    //i
    public int ucMelhorMedia(int[][] aNotas){
        float mMediaUC = 0;
        int idUC = 0;
        for (int i = 0; i < aNotas.length; i++) {
            if(mediaUC(i, aNotas)>mMediaUC){
                mMediaUC = mediaUC(i, aNotas);
                idUC = i;
            }
        }
        return (idUC+1);
    }
}
