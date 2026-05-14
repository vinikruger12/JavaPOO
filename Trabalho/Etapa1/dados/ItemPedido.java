package dados;

public class ItemPedido {
    private ItemCardapio itemCardapio;
    private int quantidade;
    private String observacoesCliente;
    private StatusItemPedido statusPreparo;

    public ItemCardapio getItemCardapio(){
        return itemCardapio; 
    }
    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public int getQuantidade(){
        return quantidade; 
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade; 
    }

    public String getObservacoesCliente(){
        return observacoesCliente; 
    }
    public void setObservacoesCliente(String observacoesCliente){
        this.observacoesCliente = observacoesCliente; 
    }
    
    public StatusItemPedido getStatusPreparo(){
        return statusPreparo; 
    }
    public void setStatusPreparo(StatusItemPedido statusPreparo){
        this.statusPreparo = statusPreparo; 
    }

    public double calcularSubtotal() {
        return itemCardapio.getPreco() * quantidade;
    }

    public String toString() {
        return "ITEM PEDIDO \n" + "ITEM: " + this.itemCardapio.getNome() + "\n" + 
        "QUANTIDADE: " + this.quantidade + "\n" + 
        "OBSERVAÇÕES: " + this.observacoesCliente + "\n" + 
        "STATUS PREPARO: " + this.statusPreparo.getStatusItemPedido();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ItemPedido) {
            ItemPedido ip = (ItemPedido) obj;
            if (this.itemCardapio.equals(ip.getItemCardapio())
                && this.quantidade == ip.getQuantidade()
                && this.statusPreparo == ip.getStatusPreparo()) return true;
        }
        return false;
    }
}