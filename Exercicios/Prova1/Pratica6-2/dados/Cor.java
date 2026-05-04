package dados;

public enum Cor {
    ROXO("Roxo"), AZUL("Azul"), VERDE("Verde"), VERMELHO("Vermelho"),
    BRANCO("Branco"), PRETO("Preto");

    private String cor;
    private Cor(String cor){
        this.cor = cor;
    } 

    public String getCor(){
        return this.cor;
    }
}
