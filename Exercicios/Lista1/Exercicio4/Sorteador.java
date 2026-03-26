import java.util.Random;

public class Sorteador {
    private Pessoa[] pessoas = new Pessoa[5];
    private int numPessoas = 0;
    public Sorteador(){}

    public Sorteador(Pessoa[] pessoas){
        this.pessoas = pessoas;
    }

    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
    public Pessoa[] getPessoas() {
        return this.pessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }
    public int getNumPessoas() {
        return this.numPessoas;
    }

    public void addPessoas(Pessoa pessoa){
        this.pessoas[this.numPessoas] = pessoa;
        this.numPessoas++;
    }

    Random gerador = new Random();
    public Pessoa sortearProximo(){
        if(this.numPessoas == 0) return null;
        
        int numAleatorio = gerador.nextInt(this.numPessoas);
        Pessoa sorteado = this.pessoas[numAleatorio];

        for(int i = numAleatorio+1;i < this.numPessoas;i++){
            this.pessoas[i-1] = this.pessoas[i];
        }

        this.pessoas[this.numPessoas - 1] = null;
        this.numPessoas--;

        return sorteado;
    }

}
