package negocio;

import dados.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe principal da camada de negócio que centraliza a lógica do restaurante.
 */
public class Sistema {
    private List<Mesa> mesas;
    private List<ItemCardapio> itensCardapio;
    private List<Garcom> garcons;
    private List<Reserva> reservas;
    private List<Pedido> pedidos;

    public Sistema() {
        this.mesas = new ArrayList<>();
        this.itensCardapio = new ArrayList<>();
        this.garcons = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    // --- MÉTODOS DE CADASTRO ---

    public Mesa cadastrarMesa(int numero, int capacidade, LocalizacaoMesa loc) {
        Mesa mesa = new Mesa(numero, capacidade, loc);
        mesas.add(mesa);
        return mesa;
    }

    public Garcom cadastrarGarcom(String nome, String cpf, LocalDate data, double com) {
        Garcom garcom = new Garcom(nome, cpf, data, com);
        garcons.add(garcom);
        return garcom;
    }

    public ItemCardapio cadastrarItemCardapio(String cod, String nome, String desc, double preco, int tempo, CategoriaItem cat) {
        ItemCardapio item = new ItemCardapio(cod, nome, preco, cat);
        item.setDescricao(desc);
        item.setTempoMedioPreparo(tempo);
        itensCardapio.add(item);
        return item;
    }

    // --- GESTÃO DE RESERVAS ---

    public List<Mesa> buscarMesaDisponivel(int capacidadeDesejada, LocalDate data, LocalTime hora) {
        return mesas.stream()
                .filter(m -> m.getCapacidadePessoas() >= capacidadeDesejada)
                .filter(m -> isMesaLivre(m, data, hora))
                .collect(Collectors.toList());
    }

    private boolean isMesaLivre(Mesa mesa, LocalDate data, LocalTime hora) {
        for (Reserva r : reservas) {
            // Verifica se a reserva está ativa e se há conflito de data, hora e mesa
            if (r.getStatus() != StatusReserva.CANCELADA && 
                r.getData().equals(data) && 
                r.getHora().equals(hora) && 
                r.getMesas().contains(mesa)) {
                return false;
            }
        }
        return true;
    }

    public Reserva fazerReserva(String nomeCliente, String telefone, LocalDate data, LocalTime hora, int numPessoas, String obs, List<Mesa> mesasReserva) {
        Reserva reserva = new Reserva(nomeCliente, data, hora, mesasReserva);
        reserva.setTelefone(telefone);
        reserva.setNumeroPessoas(numPessoas);
        reserva.setObservacoes(obs);
        reservas.add(reserva);
        return reserva;
    }

    // --- GESTÃO DE PEDIDOS ---

    public Pedido abrirPedido(Mesa mesa, Garcom garcom) {
        Pedido pedido = new Pedido(mesa, garcom);
        pedidos.add(pedido);
        return pedido;
    }

    public PedidoDelivery abrirPedidoDelivery(String endereco, double taxa) {
        PedidoDelivery delivery = new PedidoDelivery(endereco, taxa);
        pedidos.add(delivery);
        return delivery;
    }

    public ItemPedido adicionarItemAoPedido(Pedido pedido, ItemCardapio item, int qtd, String obs) {
        ItemPedido itemPedido = new ItemPedido(item, qtd, obs);
        pedido.adicionarItem(itemPedido);
        return itemPedido;
    }

    public void atualizarStatusCozinha(ItemPedido itemPedido, StatusItemPedido status) {
        itemPedido.setStatusPreparo(status);
    }

    // --- FECHAMENTO E PAGAMENTO ---

    public double fecharConta(Pedido pedido, boolean incluirTaxa) {
        return pedido.calcularTotal(incluirTaxa);
    }

    public Pagamento receberPagamento(Pedido pedido, FormaPagamento forma, double valor) {
        Pagamento pagamento = new Pagamento(forma, valor);
        pedido.adicionarPagamento(pagamento);
        return pagamento;
    }

    // --- GETTERS DAS LISTAS (PERSISTÊNCIA EM MEMÓRIA) ---

    public List<Mesa> getMesas() { return mesas; }
    public List<ItemCardapio> getItensCardapio() { return itensCardapio; }
    public List<Garcom> getGarcons() { return garcons; }
    public List<Reserva> getReservas() { return reservas; }
    public List<Pedido> getPedidos() { return pedidos; }
}
