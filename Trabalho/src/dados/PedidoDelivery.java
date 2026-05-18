package dados;

public class PedidoDelivery extends Pedido {
    private String enderecoEntrega;
    private double taxaEntrega;
    private StatusEntrega statusEntrega;

    public String getEnderecoEntrega(){
        return enderecoEntrega; 
    }
    public void setEnderecoEntrega(String enderecoEntrega){
        this.enderecoEntrega = enderecoEntrega; 
    }

    public double getTaxaEntrega(){
        return taxaEntrega; 
    }
    public void setTaxaEntrega(double taxaEntrega){
        this.taxaEntrega = taxaEntrega; 
    
    }
    public StatusEntrega getStatusEntrega(){
        return statusEntrega; 
    }
    public void setStatusEntrega(StatusEntrega statusEntrega){
        this.statusEntrega = statusEntrega; 
    }

    public double calcularTotal(boolean incluirTaxa) {
        return super.calcularTotal(incluirTaxa) + taxaEntrega;
    }

    public String toString() {
        return "PEDIDO DELIVERY \n" + "ENDEREÇO: " + this.enderecoEntrega + "\n" + 
        "TAXA: " + this.taxaEntrega + "\n" + 
        "STATUS ENTREGA: " + this.statusEntrega.getStatusEntrega();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PedidoDelivery) {
            PedidoDelivery pd = (PedidoDelivery) obj;
            if (super.equals(obj) 
                && this.enderecoEntrega.equals(pd.getEnderecoEntrega())
                && this.statusEntrega == pd.getStatusEntrega()) return true;
        }
        return false;
    }
}