package dados;

public class ContaSalario extends ContaBancaria {
   
    private String cnpjEmpresa;

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public boolean depositar(float valor, String cnpj){
        if(valor < 0) return false;
        super.saldo += valor;
        return true;
    }

    public String gerarExtrato(){
        return "A empresa com cnpj " + this.cnpjEmpresa + " tem o total de " + super.saldo; 
    }
}
