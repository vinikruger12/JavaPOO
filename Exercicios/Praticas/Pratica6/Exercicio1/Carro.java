package Exercicio1;
import Exercicio1.Veiculo;

public class Carro extends Veiculo{
    private int numeroPortas;
    private Combustivel combustivel;
    private Cor cor;

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
    public int getNumeroPortas() {
        return this.numeroPortas;
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }


    public String info(){
        return "Informações do Carro \n " + 
        "Carro com " + this.getNumeroPortas() + " número de portas com a cor " + this.getCor() + " que usa o combustível " + this.getCombustivel(); 
    }




}
