package dados;

public enum Cor{
    ROXO("Roxo"), VERDE("Verde"), VERMELHO("Vemelho"), AZUL("Azul");

    private String cor;
    private Cor(String cor){
        this.cor = cor;
    }

    public String getCor() {
        return this.cor;
    }
}