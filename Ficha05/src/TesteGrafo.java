public class TesteGrafo {
    public static void main(String[] args){
        Grafo g = new Grafo();

        g.addArco(1, 2);
        g.addArco(1, 3);
        g.addArco(1, 4);
        g.addArco(2, 6);
        g.addArco(2, 7);
        g.addArco(3, 5);
        g.addArco(4, 3);
        g.addArco(5, 7);
        g.addArco(6, 4);

        System.out.println("Tamanho do grafo: "+g.size());
        System.out.println("4 é sink? "+g.isSink(4));
        System.out.println("5 é source? "+g.isSource(5));
        System.out.println("Há caminho entre 2 e 4? "+g.haCaminho(2,4));
        //System.out.println("FanOut de 1: "+g.fanOut(1));
        System.out.println("Caminho de 1 a 5: "+g.getCaminho(1,5));

    }
}

