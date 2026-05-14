package negocio;

import dados.*;

import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private List<Mesa> mesas = new ArrayList<>();
    private List<ItemCardapio> itensCardapio = new ArrayList<>();
    private List<Garcom> garcons = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Mesa> getMesas(){
        return mesas; 
    }
    public List<ItemCardapio> getItensCardapio(){
        return itensCardapio; 
    }
    public List<Garcom> getGarcons(){
        return garcons; 
    }
    public List<Reserva> getReservas(){
        return reservas; 
    }
    public List<Pedido> getPedidos(){
        return pedidos; 
    }


    public void cadastrarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void cadastrarGarcom(Garcom garcom) {
        garcons.add(garcom);
    }

    public void cadastrarItemCardapio(ItemCardapio itemCardapio) {
        itensCardapio.add(itemCardapio);
    }


    public List<Mesa> buscarMesaDisponivel(int capacidadeDesejada, String data, String hora) {
        List<Mesa> mesasDisponiveis = new ArrayList<>();
        
        for (Mesa mesa : mesas) {
            if (mesa.getCapacidadePessoas() >= capacidadeDesejada) {
                if (isMesaLivre(mesa, data, hora)) {
                    mesasDisponiveis.add(mesa);
                }
            }
        }
        
        return mesasDisponiveis;
    }

    private boolean isMesaLivre(Mesa mesa, String data, String hora) {
        for (Reserva r : reservas) {
            if(r.getStatus() != StatusReserva.CANCELADA) {                
                if (r.getData().equals(data) && r.getHora().equals(hora)){
                    if (r.getMesas().contains(mesa)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void abrirPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void abrirPedidoDelivery(PedidoDelivery pedidoDelivery) {
        pedidos.add(pedidoDelivery);
    }

    public void adicionarItemAoPedido(ItemPedido itemPedido, Pedido pedido) {
        pedido.adicionarItem(itemPedido);
    }

    public void atualizarStatusCozinha(ItemPedido itemPedido, StatusItemPedido status) {
        itemPedido.setStatusPreparo(status);
    }

    public double fecharConta(Pedido pedido, boolean incluirTaxa) {
        return pedido.calcularTotal(incluirTaxa);
    }

    public void receberPagamento(Pagamento pagamento, Pedido pedido) {
        pedido.adicionarPagamento(pagamento);
    }
    
}
