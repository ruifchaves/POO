package Parque;

public class Lugar {
    /** Matrícula do veículo estacionado */
    private String matricula;
    /** Nome do proprietario */
    private String nome;
    /** Tempo atribuido ao lugar, em minutos */
    private int minutos;
    /** Indica se o lugar é permanente, ou de aluguer */
    private boolean permanente;

    /** Contrutores */
    public Lugar(){
        matricula  = "n/a";
        nome       = "n/a";
        minutos    = 0;
        permanente = false;
    }
    public Lugar(String m, String n, int min, boolean p){
        matricula  = m;
        nome       = n;
        minutos    = min;
        permanente = p;
    }
    public Lugar(Lugar lu){
        matricula  = lu.getMatricula();
        nome       = lu.getNome();
        minutos    = lu.getMinutos();
        permanente = lu.getPermanente();
    }

    /** Getters e Setters */
    public String getNome(){
        return nome;
    }
    public String getMatricula(){
        return matricula;
    }
    public int getMinutos(){
        return minutos;
    }
    public boolean getPermanente(){
        return permanente;
    }
    public void setMatricula(String m){
        matricula = m;
    }
    public void setNome(String n){
        nome = n;
    }
    public void setMinutos(int min){
        minutos = min;
    }
    public void setPermanente(boolean p){
        permanente = p;
    }

    /** Equals, clone e toString */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass()!=this.getClass()) return false;
        Lugar l = (Lugar) o;
        return matricula.equals(l.getMatricula()) && nome.equals(l.getNome())
                && minutos==l.getMinutos() && permanente==l.getPermanente();
                //https://stackoverflow.com/questions/11072870/does-check-for-full-equality-in-booleans-java
    }
    public Lugar clone(){
        return new Lugar(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nLugar de Estacionamento: ")
                .append("\n  Matrícula do veículo estacionado: ").append(matricula)
                .append("\n  Nome do proprietario: ").append(nome)
                .append("\n  Tempo atribuido ao lugar, em minutos: ").append(minutos)
                .append("\n  O lugar é permanente? ").append(permanente);
        return sb.append('\n').toString();
    }
}
