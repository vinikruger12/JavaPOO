package dados;
import java.time.LocalDateTime;

public class Pagamento {
    private FormaPagamento formaUtilizada;
    private double valorPago;
    private LocalDateTime dataHora;

    public Pagamento(FormaPagamento forma, double valor) {
        this.formaUtilizada = forma;
        this.valorPago = valor;
        this.dataHora = LocalDateTime.now();
    }

    public FormaPagamento getFormaUtilizada() { return formaUtilizada; }
    public void setFormaUtilizada(FormaPagamento forma) { this.formaUtilizada = forma; }
    public double getValorPago() { return valorPago; }
    public void setValorPago(double valor) { this.valorPago = valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}