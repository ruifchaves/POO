/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/



/**
 * Classe Circulo (versão simplificada das aulas).
 * Note-se que para sinalizar que esta classe possui um método de comparação, 
 * via ordem natural, se tem de explicitamente dizer que 
 * se implementa o tipo de dados Comparable<Circulo>.
 *
 * @author MaterialPOO
 * @version 20200323
 */
public class Circulo implements Comparable<Circulo>{
    private double x;
    private double y;
    private double raio;
    
    public Circulo() {
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }
    
    public Circulo(Circulo circulo) {
        this.x = circulo.getX();
        this.y = circulo.getY();
        this.raio = circulo.getRaio();
    }
    
    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getRaio() {
        return this.raio;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    public void alteraCentro(double x, double y) {
        this.setX(this.x+x);
        this.setY(this.y+y);
    }
    
    public double calculaArea() {
        return Math.PI * Math.pow(this.raio,2);
    }
    
    public double calculaPerimetro() {
        return 2 * Math.PI * this.raio;
    }
    
    
    public String toString() {
        //return "X: " + x + ", Y: " + y + ", R: " + raio;
        
        StringBuilder sb = new StringBuilder();
        sb.append("(X: ");
        sb.append(this.x);
        sb.append(", Y: "); sb.append(this.y);
        sb.append(", R: "); sb.append(this.raio);
        sb.append(")");
        
        return sb.toString();
        
        
    }
    
    
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Circulo n = (Circulo) o;
        return (this.x == n.getX() && this.y == n.getY() && this.raio == n.getRaio());
    }
    
    
    public Circulo clone() {
        return new Circulo(this);
    }
    
    
    /**
     * Método de comparação natural.
     * Um circulo é "maior" que outro se o seu valor de X for maior.
     * Obviamente este é apenas um exemplo de um método compareTo. Os alunos 
     * deverão reescrever de acordo com as necessidades.
     */
    public int compareTo(Circulo outro) {
      return (int) (this.getX() - outro.getX());  
    }
        
    
}
