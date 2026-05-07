package dados;

public enum TipoProduto {
    CAMISA("Camisa"), CALCA("Calca"), TENIS("Tenis"), BONE("Bone"), PULSEIRA("Pulseira"), MEIA("Meia");
    
    private String tipoProduto;
    private TipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }
}
