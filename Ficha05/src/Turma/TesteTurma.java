package Turma;
import java.util.Set;

public class TesteTurma {
    public static void main(String[] ars){
        Aluno a1 = new Aluno("1", "Ze", "MIEI", 15);
        Aluno a2 = new Aluno("2", "Ana", "MIEI", 18);
        Aluno a3 = new Aluno("3", "To", "MIEI", 13);
        Aluno a4 = new Aluno("4", "Manel", "MIEI", 14);
        Aluno a5 = new Aluno("5", "Maria", "MIEI", 16);
        Aluno a6 = new Aluno("6", "Jo", "MIEI", 10);

        Turma t = new Turma();
        t.setNome("Turma 1");
        t.setCodigo("c1");

        t.insereAluno(a1);
        t.insereAluno(a2);
        t.insereAluno(a3);

        System.out.println(t.toString());

        Set<String> s = t.todosOsCodigos();
        s.clear();

        System.out.println(t.alunosOrdemAlfabetica().toString());
    }
}
