/**
 * 1. Um Circulo representa-se através de um ponto central, denido pelas suas
 *    coordenadas em x e y e por um raio. Crie a classe Circulo com a declaração de variáveis de instância,
 *    os construtores habituais (por omissão, parametrizado e de cópia) e os seguinte métodos:
 *  (a) método que devolve o valor da variável x, public double getX()
 *  (b) método que devolve o valor da variável y, public double getY()
 *  (c) método que devolve o valor da variável raio, public double getRaio()
 *  (d) métodos que alteram o valor das variáveis de instância public
 *      void setX(double x), public void setY(double y) e public void
 *      setRaio(double raio)
 *  (e) método que altera o posicionamento do círculo, public void
 *      alteraCentro(double x, double y)
 *  (f) método que calcula a área do círculo, public double calculaArea()
 *  (g) método que calcula o perímetro do círculo, public double
 *      calculaPerimetro()
 */

public class Circulo {

    //variáveis de instância
    private double x;
    private double y;
    private double raio;

    /////////////////////////////////

    /**
     * Construtores da classe Circulo .
     * (omissão, parametrizado e de cópia)
     */

    /** Construtor por omissão */
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    /** Construtor parametrizado */
    public Circulo(double cx, double cy, double r){
        this.x = cx;
        this.y = cy;
        this.raio = r;
    }

    /** Construtor de cópia */
    public Circulo(Circulo c){
        this.x = c.getX();
        //this.x = c.x;
        this.y = c.getY();
        this.raio = c.getRaio();
    }
    /////////////////////////////////

    /**
     * métodos de instância
     */
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getRaio(){
        return this.raio;
    }

    public void setX(double newX){
        this.x = newX;
    }
    public void setY(double newY){
        this.y = newY;
    }
    public void setRaio(double newRaio){
        this.raio = newRaio;
    }

    /////////////////////////////////

    /**
     * métodos complementares
     */
    public boolean equals(Object o){
        if(this == o)
            return true;
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;
        Circulo p = (Circulo) o;
        return (this.x == p.getX() && this.y == p.getY() && this.raio == p.getRaio());
    }


}

