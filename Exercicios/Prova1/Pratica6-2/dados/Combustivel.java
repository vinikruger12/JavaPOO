package dados;

public enum Combustivel {
    GASOLINA("Gasolina"), ALCOOL("Alcool"), DIESEL("Diesel"), GAS("Gás");

    private String combustivel;
    private Combustivel(String combustivel){
        this.combustivel = combustivel;
    } 

    public String getCombustivel(){
        return this.combustivel;
    }
}

