package Turma;
import java.util.Comparator;

public class ComparatorAlunoNumero {
    public int compare(Aluno a1, Aluno a2){
        if (a1.getNumero().compareTo(a2.getNumero()) < 0) return 1;
        if (a1.getNumero().compareTo(a2.getNumero()) > 0) return -1;
        return a1.getNome().compareTo(a2.getNome());
    }
}
