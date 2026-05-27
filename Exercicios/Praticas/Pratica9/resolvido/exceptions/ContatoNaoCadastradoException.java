package exceptions;

public class ContatoNaoCadastradoException extends Exception {
    public ContatoNaoCadastradoException(){

    }
    public ContatoNaoCadastradoException(String mensagem){
        super(mensagem);
    }
}
