package dados;

public class ItemPedido {
    private ItemCardapio itemCardapio;
    private int quantidade;
    private String observacoesCliente;
    private StatusItemPedido statusPreparo;

    public ItemPedido(ItemCardapio item, int qtd, String obs) {
        this.itemCardapio = item;
        this.quantidade = qtd;
        this.observacoesCliente = obs;
        this.statusPreparo = StatusItemPedido.AGUARDANDO_PREPARO;
    }

    public ItemCardapio getItemCardapio() { return itemCardapio; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getObservacoesCliente() { return observacoesCliente; }
    public void setObservacoesCliente(String observacoesCliente) { this.observacoesCliente = observacoesCliente; }
    public StatusItemPedido getStatusPreparo() { return statusPreparo; }
    public void setStatusPreparo(StatusItemPedido statusPreparo) { this.statusPreparo = statusPreparo; }

    public double calcularSubtotal() {
        return itemCardapio.getPreco() * quantidade;
    }
}