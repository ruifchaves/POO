package DriveIt_abstract;

public class NaoExisteVeiculoException extends Exception{
    public NaoExisteVeiculoException(){
        super();
    }
    public NaoExisteVeiculoException(String s){
        super(s);
    }
}
