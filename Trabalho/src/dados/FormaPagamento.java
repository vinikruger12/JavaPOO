package dados;

public enum FormaPagamento {
    DINHEIRO("Dinheiro"), CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"), PIX("Pix");

    private String formaPagamento;
    private FormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}