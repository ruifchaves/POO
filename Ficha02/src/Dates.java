import java.time.LocalDate;
import java.util.Arrays;

/**
 * 3. Crie um programa que mantenha um array de objectos LocalDate (com
 * representação de datas, cf. Ficha1). Escreva os seguintes métodos:
 * (a) inserir uma nova data, public void insereData(LocalDate data)
 * (b) dada uma data, determinar a data do array que está mais pró-
 * xima (em termos de proximidade de calendário), public LocalDate
 * dataMaisProxima(LocalDate data)
 * (c) devolver uma String com todas as datas do array, public String
 * toString
 */

public class Dates {
    private LocalDate date1 = LocalDate.of(2017, 1, 13);
    private LocalDate date2 = LocalDate.of(2020, 5, 23);
    private LocalDate[] arrld = new LocalDate[]{date1, date2};
    //a
    public LocalDate[] insereData(LocalDate data){
        LocalDate[] newArrld = new LocalDate[3];
        newArrld[newArrld.length-1] = data;
        return newArrld;
    }
    //b
    public LocalDate dataMaisProxima(LocalDate data){
        System.out.print(arrld[0]);
        int menorDif = data.compareTo(arrld[0]);
        LocalDate store = arrld[0];
        for(int i = 0; i < arrld.length; i++){
            if(data.compareTo(arrld[i])<menorDif) {
                menorDif = data.compareTo(arrld[i]);
                store = arrld[i];
            }
        }
        return store;
    }
    //c                                  DEVIA PASSAR COMO STRING TAMBÉM O ARRAY COM A DATA ADICIONADA
    public String toString(){ //
        String aux = "";
        int i=0;
        for(; i<arrld.length-1; i++)
            aux += arrld[i].toString()+"; ";
        return aux + arrld[i] + ".";
    }
}
