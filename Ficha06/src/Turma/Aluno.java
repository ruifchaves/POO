package Turma;
/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

/**
 * Classe Aluno.
 * Classe que modela de forma muito simples a 
 * informação e comportamento relevante de um aluno.
 * 
 * @author MaterialPOO
 * @version 20200403
 */

import java.util.Comparator;

public class Aluno implements Comparable<Aluno>{ //ter o comparable obriga a ter um metodo compareTo
 
    private String numero;
    private String nome;
    private String curso;
    private int nota;

    /**
     * Constructores para a classe Aluno
     */
    public Aluno() {
      this.numero = "";
      this.nome = "";  
      this.curso = "";
      this.nota = 0;
    }
    
    public Aluno(String numero, String nome, String curso, int nota) {
        this.numero = numero;
        this.nota = nota;
        this.nome = nome;
        this.curso = curso;
    }
    
    public Aluno(Aluno umAluno) {
        this.numero = umAluno.getNumero();
        this.nome = umAluno.getNome();
        this.curso = umAluno.getCurso();
        this.nota = umAluno.getNota();
    }     
    
    /**
     * Método que devolve o número de um aluno.
     * 
     * @return String com o número do aluno
     */
    public String getNumero() {
      return this.numero;
    }
    
    /**
     * Método que devolve o nome de um aluno.
     * 
     * @return String com o nome do aluno
     */
    public String getNome() {
      return this.nome;
    }
    
    /**
     * Método que devolve o curso de um aluno.
     * 
     * @return String com o número do aluno
     */
    public String getCurso() {
      return this.curso;
    }
    
    /**
     * Método que devolve a nota de um aluno.
     * 
     * @return int com o número do aluno
     */
    public int getNota() {
      return this.nota;
    }
    
   
    public void setNumero(String numero) {
      this.numero = numero;
    }
   
    public void setNome(String nome) {
      this.nome = nome;
    }
   
    public void setCurso(String curso) {
      this.curso = curso;
    }
   
    public void setNota(int novaNota) {
      this.nota = novaNota;
    }
    
    /**
     * Implementação do método toString
     * comum na maioria das classes Java.
     * 
     * @return     uma string com a informação textual do objecto aluno
     */
     public String toString() {
       StringBuffer sb= new StringBuffer("ALUNO: ");
        
       sb.append("Numero: ");
       sb.append(this.numero+", ");
       sb.append("Nome: ");
       sb.append(this.nome+", ");
       sb.append("Curso: ");
       sb.append(this.curso+", ");
       sb.append("Nota: ");
       sb.append(this.nota+"\n");
        
       return sb.toString();
        
        //embora obrigue a maior esforço de escrita, esta implementação
        //é mais eficiente que a normal
        //return("Numero:" + this.numero + "Nome:"+ this.nome + "Nota:" + this.nota);
        
     }
        
     /**
      * Implementação do método de igualdade entre dois Aluno
      * Redefinição do método equals de Object.
      * 
      * @param //umAluno   aluno que é comparado com o receptor
      * @return      booleano true ou false
      */
     public boolean equals(Object o) {
       if (this == o)
         return true;
      
       if((o == null) || (this.getClass() != o.getClass()))
         return false;
      
       Aluno umAluno = (Aluno) o;
       return(this.nome.equals(umAluno.getNome()) && this.nota == umAluno.getNota() 
            && this.numero.equals(umAluno.getNumero()) 
            && this.curso.equals(umAluno.getCurso()));
     }
  
     /**
      * Implementação do método de clonagem de um Aluno
      * 
      * @return  objecto do tipo Aluno
      */
         
     public Aluno clone() {
       return new Aluno(this);    
     }

     public int compareTo(Aluno a){
         return this.nome.compareTo(a.getNome());
     }
}
