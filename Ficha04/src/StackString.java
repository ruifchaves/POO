import java.util.ArrayList;

public class StackString {
    private ArrayList<String> elementos;

    /**
     * Constructor for objects of class StackString
     */
    public StackString(){
        this.elementos = new ArrayList<>();
    }

    /**
     * top
     */
    public String top(){
        int tam = this.elementos.size();
        return tam>0 ? this.elementos.get(tam-1) : null; // se o tamanho for maior que 0 podemos aceder ao tamanho-1 com segurança
    }

    /**
     * push
     */
    public void push(String s){
        this.elementos.add(s);
    }

    /**
     * pop
     */
    public void pop(){
        int tam = this.elementos.size();
        if(tam>0)
            this.elementos.remove(tam-1);
    }

    /**
     * empty
     */
    public boolean empty(){
        return this.elementos.size()==0;
    }

    /**
     * length
     */
    public int length(){
        return this.elementos.size();
    }

    /**
     * getElementos
     */
    public ArrayList<String> getElementos(){
        ArrayList<String> copia = new ArrayList<>();
        //pegar em todos os valores da minha instancia e copia-los para a copia.
        for(String s : this.elementos) //o prof prefere que se metam as chavetas porque caso queiramos adicionar codigo dentro do for, não haver a possibilidade de nos enganarmos.
            copia.add(s);
        return copia;
    }

    /**
     * equals
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if((o!=null) || (o.getClass() != this.getClass())) return false;
        StackString s = (StackString) o;
        return this.elementos.equals(s.getElementos()); //não pode ser == senão iria estar a comparar apontadores.
    }
}

