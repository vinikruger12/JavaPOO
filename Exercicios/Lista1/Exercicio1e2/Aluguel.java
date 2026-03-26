package Exercicios.Lista1.Exercicio1e2;
public class Aluguel {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private Veiculo veiculo;

    public Aluguel(){}
    public Aluguel(Cliente cliente, Vendedor vendedor, double valor, Veiculo veiculo){
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return this.valor;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }


    public String toString(){
        return "Cliente: " + this.cliente.toString() + " . Vendedor: " + this.vendedor.toString()
        + " Valor: " + this.valor + " .Veiculo: " + this.veiculo.toString();
    }

    public boolean equals(Object o){
        if(o instanceof Aluguel){
            Aluguel v = (Aluguel) o;
            if(this.cliente.equals(v.getCliente())
            && this.veiculo.equals(v.getVeiculo())
            && this.valor == v.getValor()
            && this.vendedor.equals(v.getVendedor())) return true;
        }
        return false;
    }
}
