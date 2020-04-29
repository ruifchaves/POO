package DriveIt;

import java.time.Year;

public class DriveItTest {
    public static void main(String[] args){
        Veiculo a = new Veiculo("1", "Renault", "Scenic", Year.of(2020), 100.0, 4.0, 7.9, 100000);
        Veiculo b = new Veiculo("2", "Ferrari", "yo", Year.of(2020), 100.0, 4.0, 7.9, 100000);
        Veiculo c = new Veiculo("3", "Mercs", "gt", Year.of(2020), 100.0, 4.0, 7.9, 100000);
        Veiculo d = new Veiculo("4", "Corvette", "70s", Year.of(2020), 100.0, 4.0, 7.9, 100000);
        VeiculoOcasiao e = new VeiculoOcasiao("5", "Seat", "ibiza", Year.of(2020), 100.0, 4.0, 7.9, 100000, true);
        VeiculoOcasiao f = new VeiculoOcasiao("6", "McLaren", "man", Year.of(2020), 100.0, 4.0, 7.9, 100000, false);

        DriveIt di = new DriveIt();
        di.adiciona(a);
        di.adiciona(b);
        di.adiciona(c);
        di.adiciona(d);
        di.adiciona(e);
        di.adiciona(f);

        System.out.println("\nDriveIt 1:\n"+di.toString());
        di.entraemPromocao();
        System.out.println("\nDriveIt 2 (Veics ocasiao em promocao):\n"+di.toString());
    }
}
