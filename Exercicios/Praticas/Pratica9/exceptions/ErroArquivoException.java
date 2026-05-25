package exceptions;

public class ErroArquivoException extends Exception {
    
    private String caminho;
    
    public String getCaminho() {
        return caminho;
    }
    
    public ErroArquivoException(){

    }
    public ErroArquivoException(String mensagem){
        super(mensagem);
    }
}
