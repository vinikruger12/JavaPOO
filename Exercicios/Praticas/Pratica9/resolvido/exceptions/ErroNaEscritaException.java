package exceptions;

public class ErroNaEscritaException extends ErroArquivoException{
    
    public ErroNaEscritaException(){

    }
    public ErroNaEscritaException(String mensagem){
        super(mensagem);
    }

}
