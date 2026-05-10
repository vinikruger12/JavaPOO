package dados;

public class PedidoDelivery extends Pedido {
    private String enderecoEntrega;
    private double taxaEntrega;
    private StatusEntrega statusEntrega;

    public PedidoDelivery(String endereco, double taxa) {
        super(null, null);
        this.enderecoEntrega = endereco;
        this.taxaEntrega = taxa;
        this.statusEntrega = StatusEntrega.PREPARANDO;
    }

    public String getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
    public double getTaxaEntrega() { return taxaEntrega; }
    public void setTaxaEntrega(double taxaEntrega) { this.taxaEntrega = taxaEntrega; }
    public StatusEntrega getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(StatusEntrega statusEntrega) { this.statusEntrega = statusEntrega; }

    @Override
    public double calcularTotal(boolean incluirTaxa) {
        return super.calcularTotal(false) + taxaEntrega;
    }
}