package dados;

public class Bicicleta extends Veiculo {
    private int numMarchas;
    
    public int getNumMarchas() {
        return this.numMarchas;
    }

    public void setNumMarchas(int numMarchas) {
        this.numMarchas = numMarchas;
    }

    public String info(){
        return "Bicicleta \n" + 
        "Cor: " + super.cor + " \n" + 
        "Número de marchas: " + this.numMarchas;
    }

}
