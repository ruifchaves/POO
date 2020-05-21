package DriveIt_abstract;

public class ValorInvalidoException extends Exception{
    private int valorInvalido;

    public ValorInvalidoException(){
        super();
    }
    public ValorInvalidoException(String s){
        super(s);
    }
    public ValorInvalidoException(String s, int numInv){
        super(s);
        valorInvalido = numInv;
    }
    public ValorInvalidoException(int numInv){
        super();
        valorInvalido = numInv;
    }

    //getMessage retorna string, neste caso pretendesse que seja o código do Veiculo
    //poderia se ter criado uma variavel instancia private string codVeiculo
    public int getValorInvalido(){
        return valorInvalido;
    }
}
