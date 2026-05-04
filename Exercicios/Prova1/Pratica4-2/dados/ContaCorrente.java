package dados;
import dados.ContaBancaria;


public class ContaCorrente extends ContaBancaria{
    public boolean depositar(float valor){
        if(valor < 0) return false;
        super.saldo += valor;
        return true;
    }
}
