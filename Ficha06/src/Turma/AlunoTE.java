package Turma;


public class AlunoTE extends Aluno{ //herda todas as definicoes de Aluno
    private String nomeEmpresa;

    public AlunoTE(){
        super(); //chamar o construtor Aluno() da superclasse
        this.nomeEmpresa = "";
    }
    public AlunoTE(String numero, String nome, String curso,int nota,String nomeEmpresa){
        super(numero, nome, curso, nota);
        this.nomeEmpresa = nomeEmpresa;
    }
    public AlunoTE(AlunoTE umAluno){
        super(umAluno); //Aluno(Aluno umAluno)
                        //umAluni é do tipo AlunoTE
                        //ao invocar o construtor da superclasse este está à espera de um Aluno
                        //isto é válido ou não?
                        //sim, porque um AlunoTE é compatível com Aluno
        this.nomeEmpresa = umAluno.getNomeEmpresa();
    }
    public String getNomeEmpresa(){
        return this.nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }
    public AlunoTE clone(){
        return new AlunoTE(this);
    }

    /**
     * Redefinir o toString, para que também coloque
     * o nome da empresa.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AlunoTE: ")
          .append(super.toString()) //quero invocar um método com o mesmo nome (toString)
                                    // que está na superclasse
          .append(", Empresa: ")
          .append(nomeEmpresa);
        return sb.toString();
    }

}
