package dados;

public enum StatusEntrega {
    PREPARANDO("Preparando"), SAIU_PARA_ENTREGA("Saiu para entrega"),
    ENTREGUE("Entregue");

    private String statusEntrega;
    private StatusEntrega(String statusEntrega){
        this.statusEntrega = statusEntrega;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }
}