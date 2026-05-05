package Exercicios.Prova1.Externos.Netflix.dados;

public enum Genero {

    ACAO("Acao"), COMEDIA("Comedia"), DRAMA("Drama");

    private String genero;
    private Genero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return this.genero;
    }
}
