package DriveIt_abstract;

import java.time.Year;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class DriveItTest {
    public static void main(String[] args){
        VeiculoNormal d = new VeiculoNormal("4", "Corvette", "70s", Year.of(2020), 100.0, 4.0, 7.9, 5000);
        VeiculoOcasiao e = new VeiculoOcasiao("5", "Seat", "ibiza", Year.of(2020), 100.0, 4.0, 7.9, 1000000, true);
        VeiculoOcasiao f = new VeiculoOcasiao("6", "McLaren", "man", Year.of(2020), 100.0, 4.0, 7.9, 20000, false);
        VeiculoPremium j = new VeiculoPremium("7", "Fiat", "man", Year.of(2020), 100.0, 4.0, 7.9, 570505, 5.5);
        AutocarroInteligente k = new AutocarroInteligente("8", "Ford", "man", Year.of(2020), 100.0, 4.0, 7.9, 656461, 50);
        AutocarroInteligente l = new AutocarroInteligente("9", "Aston Martin", "007", Year.of(2020), 100.0, 4.0, 7.9, 656461, 75);

        DriveIt di = new DriveIt();
        di.adiciona(d);
        di.adiciona(e);
        di.adiciona(f);
        di.adiciona(j);
        di.adiciona(k);
        di.adiciona(l);

        //FASE 1
        System.out.println("------------Fase 1------------:");
        System.out.println("\n--DriveIt Inicial:\n"+di.toString());
        //a
        System.out.print("\n--Existe o veículo 1?: "+di.existeVeiculo("1"));
        System.out.print("\n--Existe o veículo 2?: "+di.existeVeiculo("2"));
        //b
        System.out.println("\n--Quantos veículos registados: "+di.quantos());

        //c1
        System.out.println("\n--Quantos veículos da marca McLaren: "+di.quantos("McLaren"));

        //c2
        System.out.println("\n--Quantos veículos do tipo VeiculoOcasiao: "+di.quantosT("VeiculoOcasiao"));

        //d
        System.out.println("\n--Veículo 4: "+di.getVeiculo("4").toString());

        //e adiciona - usado em cima

        //f
        System.out.println("\n--Lista Veiculos:\n"+di.getVeiculos().toString());

        //g v1
        System.out.println("\n--Lista Veiculos Ordenados Descres. Custo Real:\n"+di.veiculosOrdenadosCusto().toString());
        //g v2
        System.out.println("\n--Lista Veiculos Ordenados Descres. Custo Real, Stream:\n"+di.veiculosOrdenadosCustoStream().toString());

        //h
        Veiculo x = di.veiculoMaisBarato();
        System.out.print("\n--Veiculo mais barato: "+x.toString());
        System.out.printf("--Valor: %.2f\n", di.custoRealKm(x.getMatricula()));

        //i
        System.out.println("\n--Veiculo menos utilizado (stream min): "+di.veiculoMenosUtilizado().toString());

        //j
        VeiculoNormal m = new VeiculoNormal("8", "Corvette", "70s", Year.of(2020), 100.0, 4.0, 7.9, 100000);
        VeiculoOcasiao n = new VeiculoOcasiao("9", "Seat", "ibiza", Year.of(2020), 100.0, 4.0, 7.9, 100000, true);
        VeiculoPremium o = new VeiculoPremium("10", "Seat", "ibiza", Year.of(2020), 100.0, 4.0, 7.9, 100000, 2.0);
        Set<Veiculo> test = new HashSet<>();
        test.add(m); test.add(n); test.add(o);
        di.adiciona(test);
        System.out.println("\n--DriveIt com Veics de set adicionados:\n"+di.toString());

        //k
        System.out.print("\n--Resgistar 2000kms em veiculo 7:");
        di.registarAluguer("7", 2000);
        System.out.println(di.getVeiculo("7"));

        //l
        System.out.print("\n--Resgistar classificacao em veiculo 7:");
        di.classificarVeiculo("7", 10);
        System.out.println(di.getVeiculo("7"));

        //m
        System.out.printf("\n--CustoReal do Veiculo 7: %.2f", di.custoRealKm("7"));
        System.out.printf("\n--CustoReal do Veiculo 8: %.2f", di.custoRealKm("8"));
        System.out.printf("\n--CustoReal do Veiculo 9: %.2f\n\n", di.custoRealKm("9"));
        //os valores dos custos de 8 e 9 devem ser diferentes pq apenas diferem na ocupacao

        //n
        di.alteraPromocao(false);
        System.out.println("--Altera promocao para false: \n"+di.toString());

        //n1
        di.entraemPromocao();
        System.out.println("\n--Todos veics ocasiao em promocao:\n"+di.toString());
        //n2
        di.terminaPromocao();
        System.out.println("\n--Todos veics ocasiao sem promocao:\n"+di.toString());



        //FASE 2
        System.out.println("------------Fase 2------------:");
        //a v1
        System.out.println("\n--Set veics ordenados, ordem natural:\n"+di.ordenarVeiculos().toString());
        //a v2
        System.out.println("\n--Set veics ordenados Stream, ordem natural:\n"+di.ordenarVeiculosStream().toString());
        //b
        System.out.println("\n--List veics ordenados, ordem natural:\n"+di.ordenarVeiculosList().toString());
        //c
        //System.out.println("\n--Set veics ordenados com comparator dado:\n"+di.ordenarVeiculosStream().toString());
    }
}
