package Exercicio1;
import Exercicio1.Cor;

public abstract class Veiculo {
    
    protected Cor cor;

    public Cor getCor(){
        return this.cor;
    }
    public void setCor(Cor cor){
        this.cor = cor;
    }

    public abstract String info();
}
