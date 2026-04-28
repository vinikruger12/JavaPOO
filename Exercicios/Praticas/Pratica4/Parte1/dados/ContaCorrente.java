package dados;

public class ContaCorrente extends ContaBancaria{

    public boolean depositarValor(float valor){
        if(valor < 0) return false;

        super.saldo += valor;
        return true; 
    }
}
