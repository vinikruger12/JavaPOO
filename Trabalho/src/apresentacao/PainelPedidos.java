package apresentacao;

import dados.*;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class PainelPedidos extends JPanel {

    private final Sistema sistema;
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);

    public PainelPedidos(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel botoes = new JPanel(new GridLayout(2, 2, 6, 6));
        botoes.setBorder(BorderFactory.createTitledBorder("Operações de Pedido"));
        JButton btnAbrir = new JButton("Abrir Pedido (Mesa)");
        JButton btnDelivery = new JButton("Abrir Pedido Delivery");
        JButton btnAddItem = new JButton("Adicionar Item ao Pedido");
        JButton btnAtualizar = new JButton("Atualizar lista");
        botoes.add(btnAbrir);
        botoes.add(btnDelivery);
        botoes.add(btnAddItem);
        botoes.add(btnAtualizar);
        add(botoes, BorderLayout.NORTH);

        lista.setBorder(BorderFactory.createTitledBorder("Pedidos Abertos"));
        add(new JScrollPane(lista), BorderLayout.CENTER);

        btnAbrir.addActionListener(e -> abrirPedido());
        btnDelivery.addActionListener(e -> abrirDelivery());
        btnAddItem.addActionListener(e -> adicionarItem());
        btnAtualizar.addActionListener(e -> atualizarLista());
    }

    private Mesa escolherMesa() {
        if (sistema.getMesas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cadastre uma mesa primeiro.");
            return null;
        }
        return (Mesa) JOptionPane.showInputDialog(this, "Escolha a mesa:", "Mesa",
                JOptionPane.QUESTION_MESSAGE, null,
                sistema.getMesas().toArray(), sistema.getMesas().get(0));
    }

    private Garcom escolherGarcom() {
        if (sistema.getGarcons().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cadastre um garçom primeiro.");
            return null;
        }
        return (Garcom) JOptionPane.showInputDialog(this, "Escolha o garçom:", "Garçom",
                JOptionPane.QUESTION_MESSAGE, null,
                sistema.getGarcons().toArray(), sistema.getGarcons().get(0));
    }

    private void abrirPedido() {
        Mesa m = escolherMesa();
        if (m == null) return;
        Garcom g = escolherGarcom();
        if (g == null) return;

        Pedido p = new Pedido();
        p.setMesa(m);
        p.setGarcom(g);
        p.setDataHoraAbertura(LocalDateTime.now().toString());
        sistema.abrirPedido(p);
        atualizarLista();
        JOptionPane.showMessageDialog(this, "Pedido aberto na mesa " + m.getNumero() + "!");
    }

    private void abrirDelivery() {
        Mesa m = escolherMesa();
        if (m == null) return;
        Garcom g = escolherGarcom();
        if (g == null) return;

        String endereco = JOptionPane.showInputDialog(this, "Endereço de entrega:");
        if (endereco == null) return;
        String taxaStr = JOptionPane.showInputDialog(this, "Taxa de entrega (R$):", "0");
        if (taxaStr == null) return;

        try {
            PedidoDelivery pd = new PedidoDelivery();
            pd.setMesa(m);
            pd.setGarcom(g);
            pd.setEnderecoEntrega(endereco.trim());
            pd.setTaxaEntrega(Double.parseDouble(taxaStr.trim().replace(",", ".")));
            pd.setStatusEntrega(StatusEntrega.PREPARANDO);
            pd.setDataHoraAbertura(LocalDateTime.now().toString());
            sistema.abrirPedidoDelivery(pd);
            atualizarLista();
            JOptionPane.showMessageDialog(this, "Pedido delivery aberto para: " + endereco);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Taxa de entrega inválida.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarItem() {
        if (sistema.getPedidos().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há pedidos abertos.");
            return;
        }
        if (sistema.getItensCardapio().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cadastre itens no cardápio primeiro.");
            return;
        }

        Pedido pedido = (Pedido) JOptionPane.showInputDialog(this, "Escolha o pedido:", "Pedido",
                JOptionPane.QUESTION_MESSAGE, null,
                sistema.getPedidos().toArray(), sistema.getPedidos().get(0));
        if (pedido == null) return;

        ItemCardapio item = (ItemCardapio) JOptionPane.showInputDialog(this, "Escolha o item:", "Cardápio",
                JOptionPane.QUESTION_MESSAGE, null,
                sistema.getItensCardapio().toArray(), sistema.getItensCardapio().get(0));
        if (item == null) return;

        String qtdStr = JOptionPane.showInputDialog(this, "Quantidade:", "1");
        if (qtdStr == null) return;
        String obs = JOptionPane.showInputDialog(this, "Observações (ex: sem cebola):", "");
        if (obs == null) obs = "";

        try {
            ItemPedido ip = new ItemPedido();
            ip.setItemCardapio(item);
            ip.setQuantidade(Integer.parseInt(qtdStr.trim()));
            ip.setObservacoesCliente(obs.trim());
            ip.setStatusPreparo(StatusItemPedido.AGUARDANDO_PREPARO);
            sistema.adicionarItemAoPedido(ip, pedido);
            atualizarLista();
            JOptionPane.showMessageDialog(this, "Item adicionado ao pedido!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarLista() {
        modelo.clear();
        int i = 0;
        for (Pedido p : sistema.getPedidos()) {
            String tipo = (p instanceof PedidoDelivery) ? "DELIVERY" : "MESA";
            modelo.addElement("[" + i + "] " + tipo + " - Mesa " + p.getMesa().getNumero()
                    + " | Garçom: " + p.getGarcom().getNome()
                    + " | Itens: " + p.getItensPedido().size()
                    + " | Total: R$ " + String.format("%.2f", p.calcularTotal(false)));
            i++;
        }
    }
}
