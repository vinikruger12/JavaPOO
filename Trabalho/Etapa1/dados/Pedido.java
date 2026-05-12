package dados;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    protected String dataHoraAbertura;
    protected Mesa mesa;
    protected Garcom garcom;
    protected List<ItemPedido> itensPedido = new ArrayList<>();
    protected List<Pagamento> pagamentos = new ArrayList<>();

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }


    public String getDataHoraAbertura(){
        return dataHoraAbertura; 
    }
    public Mesa getMesa(){
        return mesa; 
    }

    public Garcom getGarcom(){
        return garcom; 
    }
    public List<ItemPedido> getItensPedido(){
        return itensPedido; 
    }
    public List<Pagamento> getPagamentos(){
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
        return incluirTaxa ? total * 1.10 : total;
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