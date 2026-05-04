package dados;

public class ContaBancaria {
    protected String cpf;
    protected float saldo;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float sacarValor(float valor){
        if(this.saldo >= valor) this.saldo -= valor;
        return this.saldo;
    }

    public String gerarExtrato(){
        return "O saldo atual do " + this.cpf + " é de " + this.saldo + "!";
    }
}
