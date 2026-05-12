package dados;

public enum StatusItemPedido {
    AGUARDANDO_PREPARO("Aguardando preparo"), EM_PREPARO("Em prepara"),
    PRONTO("Pronto"), SERVIDO("Servido");

    private String statusItemPedido;
    private StatusItemPedido(String statusItemPedido){
        this.statusItemPedido = statusItemPedido;
    }

    public String getStatusItemPedido() {
        return statusItemPedido;
    }
}