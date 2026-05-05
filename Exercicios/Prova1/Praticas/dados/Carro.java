package dados;

public class Carro extends Veiculo {
    private int numeroPortas;
    private Combustivel combustivel;

    public Combustivel getCombustivel() {
        return this.combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumeroPortas() {
        return this.numeroPortas;
    }
    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String info(){
        return "Carro \n Cor: " + super.cor + 
        " \n Combustível: " + this.combustivel +
        " \n Número de portas: " + this.numeroPortas;
    }

    public boolean equals(Object o){
        
        if(o instanceof Carro){
            Carro c = (Carro) o;
            if(this.combustivel.equals(c.getCombustivel())
                && this.numeroPortas == c.getNumeroPortas()
                && super.cor.equals(c.getCor())) return true;
        }
        return false;
    }

}
