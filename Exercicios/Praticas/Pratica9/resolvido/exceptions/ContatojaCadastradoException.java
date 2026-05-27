package exceptions;

public class ContatojaCadastradoException extends Exception {
    public ContatojaCadastradoException(){

    }

    public ContatojaCadastradoException(String mensagem){
        super(mensagem);    
    }
}
