package dados;

public enum Combustivel {
    GASOLINA("Gasolina"), ALCOOL("Alcool"), DIESEL("Diesel"), GAS("Gas");

    private String combustivel;
    private Combustivel(String combustivel){
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

}
