package Exercicio1;
import Exercicio1.Veiculo;

public class Bicicleta extends Veiculo {
    private int numeroMarchas;
    
    public int getNumeroMarchas() {
        return numeroMarchas;
    }
    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }

    public String info(){
        return "Informações da Bicicleta\n" + 
        "A bicicleta tem " + this.numeroMarchas + " marchas " + 
        "e tem a cor " + this.getCor();
    }

}
