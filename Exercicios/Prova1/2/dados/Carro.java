package dados;

public class Carro extends Veiculo {
    private int numeroPortas;
    private Combustivel combustivel;

    public Combustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }
    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String info(){
        return "Carro " + this.numeroPortas + ", " + this.getCor() + ", " + this.combustivel;
    }
}
