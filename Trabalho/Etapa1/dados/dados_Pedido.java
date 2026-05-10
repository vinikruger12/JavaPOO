package dados;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    protected LocalDateTime dataHoraAbertura;
    protected Mesa mesa;
    protected Garcom garcom;
    protected List<ItemPedido> itensPedido;
    protected List<Pagamento> pagamentos;

    public Pedido(Mesa mesa, Garcom garcom) {
        this.mesa = mesa;
        this.garcom = garcom;
        this.dataHoraAbertura = LocalDateTime.now();
        this.itensPedido = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }

    public LocalDateTime getDataHoraAbertura() { return dataHoraAbertura; }
    public Mesa getMesa() { return mesa; }
    public Garcom getGarcom() { return garcom; }
    public List<ItemPedido> getItensPedido() { return itensPedido; }
    public List<Pagamento> getPagamentos() { return pagamentos; }

    public void adicionarItem(ItemPedido item) { itensPedido.add(item); }
    public void adicionarPagamento(Pagamento pag) { pagamentos.add(pag); }
    
    public double calcularTotal(boolean incluirTaxa) {
        double total = 0;
        for (ItemPedido ip : itensPedido) {
            total += ip.calcularSubtotal();
        }
        return incluirTaxa ? total * 1.10 : total;
    }
}