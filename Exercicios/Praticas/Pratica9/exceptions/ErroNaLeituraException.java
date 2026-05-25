package exceptions;

public class ErroNaLeituraException extends ErroArquivoException {
    public ErroNaLeituraException(){

    }
    public ErroNaLeituraException(String mensagem){
        super(mensagem);
    }
}
