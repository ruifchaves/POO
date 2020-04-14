package Parque;


public class TesteParque {
    public static void main(String[] args){
        Lugar l1 = new Lugar("AA 01 AA", "Chaves", 5, false);
        Lugar l2 = new Lugar("BB 02 BB", "Manel", 0, true);
        Lugar l3 = new Lugar("CC 03 CC", "Tiago", 20, true);

        Parque p = new Parque();
        p.setNomeParque("Parque 1");
        p.setOcupado(l1);
        p.setOcupado(l2);

        //Métodos classe Parque
        System.out.println("\n"+p.toString());
        System.out.println("\nMatrículas dos lugares ocupados: "+p.lugaresOcupados().toString());
        p.setOcupado(l3);
        p.remLugarMatricula(l2.getMatricula());
        p.alteraTempoDisponive(l1.getMatricula(),15);
        System.out.println("Quantidade total de minutos atribuídos (it. externo): "+p.minsAtribuidos());
        System.out.println("Quantidade total de minutos atribuídos (it. interno): "+p.minsAtribuidosStream());
        System.out.println("Existe lugar com matrícula 'CC 03 CC': "+p.existeLugarMatricula("CC 03 CC"));
        System.out.println("Lista matriculas tempo maior que x (it. externo): "+p.matrMaiorX(10).toString());  //devolve list, imprimir com toString
        System.out.println("Lista matriculas tempo maior que x (it. interno): "+p.matrMaiorXStream(10).toString()); //devolve list, imprimir com toString
        System.out.println("Todos os lugares: "+p.todosLugares().toString()); //devolve Set, imprimir com toString
        System.out.println("Lugar da matrícula 'CC 03 CC': "+p.lugarMatricula("CC 03 CC").toString());

        System.out.println("\n"+p.toString());
    }
}
