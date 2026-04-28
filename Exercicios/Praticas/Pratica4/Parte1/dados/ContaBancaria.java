package dados;

public class ContaBancaria {
    protected String cpf;
    protected float saldo;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return this.cpf;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getSaldo() {
        return this.saldo;
    }

    public float sacar(float valor){
        if(this.saldo >= valor) this.saldo -= valor;
        return this.saldo;
    }

    public String gerarExtrato(){
        return this.cpf + " tem " + this.saldo + " reais";
    }

}
