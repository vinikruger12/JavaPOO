package Exercicios.Pratica4.Parte1.dados;

public class ContaSalario extends ContaBancaria{
    private String cnpjEmpresa;

    public String getCnpjEmpresa() {
        return this.cnpjEmpresa;
    }
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }


    public boolean depositarValor(float valor, String cnpj){
        if(cnpj.equals(this.cnpjEmpresa) && valor > 0){
            super.saldo += valor;
            return true;
        }
        return false;
    }
}
