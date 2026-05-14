package dados;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String dataHoraAbertura;
    private Mesa mesa;
    private Garcom garcom;
    private List<ItemPedido> itensPedido = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();

    public String getDataHoraAbertura() {
        return dataHoraAbertura;
    }
    public void setDataHoraAbertura(String dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Garcom getGarcom() {
        return garcom;
    }
    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void adicionarItem(ItemPedido item){
        itensPedido.add(item); 
    }
    public void adicionarPagamento(Pagamento pag){
        pagamentos.add(pag); 
    }
    
    public double calcularTotal(boolean incluirTaxa) {
        double total = 0;
        for(ItemPedido ip : itensPedido){
            total += ip.calcularSubtotal();
        }
        if(incluirTaxa) return (total*(1.10));
        return total;
    }

    public String toString() {
        return "PEDIDO \n" + "ABERTURA: " + this.dataHoraAbertura + "\n" + 
        "MESA: " + this.mesa.getNumero() + "\n" + 
        "GARÇOM: " + this.garcom.getNome();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pedido) {
            Pedido p = (Pedido) obj;
            if (this.dataHoraAbertura.equals(p.getDataHoraAbertura())
                && this.mesa.equals(p.getMesa())
                && this.garcom.equals(p.getGarcom())) return true;
        }
        return false;
    }
}