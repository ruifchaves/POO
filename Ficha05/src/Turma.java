
import java.util.*;
import java.util.stream.Collectors;


public class Turma {
    private String nome;
    private String codigo;
    private Map<String, Aluno> alunos;

    public Turma(){
        this.nome = "";
        this.codigo = "";
        this.alunos = new HashMap<>();
    }

    public Turma(String n, String c, Map<String,Aluno> als){
        this.nome = n;
        this.codigo = c;
        this.setAlunos(als);
    }

    public Turma(Turma t){
        this.nome = t.getNome();
        this.codigo = t.getCodigo();
        this.alunos = t.getAlunosStream();
    }

    public String getNome(){
        return this.nome;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public Map<String, Aluno> getAlunos(){ //funciona, mas não é ideal, porque estamos a assumir que a chave vai ser sempre o numero do aluno: getnumero()
        Map<String, Aluno> res = new HashMap<>();
        for(Aluno al: this.alunos.values()){
            res.put(al.getNumero(), al.clone());
        }
        return res;
    }
    //outra alternativa
    public Map<String, Aluno> getAlunos2(){ //com iteradores externos, esta estratégia é a ideal
        Map<String, Aluno> res = new HashMap<>();
        for(Map.Entry<String, Aluno> p: this.alunos.entrySet()){
            res.put(p.getKey(), p.getValue().clone());
        }
        return res;
    }
    //com side effects :(
    public Map<String, Aluno> getAlunosFE(){
        Map<String, Aluno> res = new HashMap<>();
        this.alunos.entrySet().forEach(p -> res.put(p.getKey(), p.getValue().clone()));
        return res;
    }
    public Map<String, Aluno> getAlunosStream(){
        return this.alunos.entrySet().stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue().clone()));
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodigo(String c){
        this.codigo = c;
    }
    public void setAlunos(Map<String, Aluno> als){
        this.alunos = als.entrySet().stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue().clone()));
    }
    public void insereAluno(Aluno a) {
        this.alunos.put(a.getNumero(), a.clone());
    }
    public Aluno getAluno(String codAluno) {
        return this.alunos.get(codAluno);
    }
    public Aluno removeAluno(String codAluno) {
        return this.alunos.remove(codAluno);
    }

    public Set<String> todosOsCodigos(){
        //return this.alunos.keySet();  estamos a devolver a referência e não podemos fazer clone, pq não está na api do set
        // a solução é fazer new
        return new TreeSet<>(this.alunos.keySet());
    }

    public Set<Aluno> alunosOrdemAlfabetica(){
        return this.alunos.values().stream().map(Aluno::clone).collect(Collectors.toCollection(TreeSet::new));
        //adicionar todos os alunos copiados a um treeSet;
    }

    public Set<Aluno> alunosOrdemAlfabeticaExt() {
        Set<Aluno> t = new TreeSet<>();
        for (Aluno l : this.alunos.values()) {
            t.add(l.clone());
        }
        return t;
    }

    public Set<Aluno> alunosOrdemDecrescenteNumero() {
        return this.alunos.values().stream()
                .map(Aluno::clone)
                .collect(Collectors.toCollection(()->new TreeSet<Aluno>((Collection<? extends Aluno>) new ComparatorAlunoNumero())));
    }


    public String toString()
    { StringBuilder sb = new StringBuilder();
        sb.append("Turma:\n").append(this.nome).append("\n")
                .append(this.codigo).append("\n")
                .append(this.alunos);
        return sb.toString();
    }

    public Turma clone() {
        return new Turma(this);
    }

    public boolean equals (Object o)
    { if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Turma t = (Turma) o;
        return this.nome.equals(t.getNome()) &&
                this.codigo.equals(t.getCodigo()) &&
                this.alunos.equals(t.getAlunos());
    }

    public int compareTo(Turma a) {
        return this.nome.compareTo(a.getNome());
    }
}
