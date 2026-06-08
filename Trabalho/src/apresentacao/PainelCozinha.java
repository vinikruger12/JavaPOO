package apresentacao;

import dados.*;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;

public class PainelCozinha extends JPanel {

    private final Sistema sistema;
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);
    private final JComboBox<Pedido> cbPedidos = new JComboBox<>();

    public PainelCozinha(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topo = new JPanel(new BorderLayout(6, 6));
        topo.setBorder(BorderFactory.createTitledBorder("Cozinha - Status dos Itens"));
        JButton btnRecarregar = new JButton("Recarregar pedidos");
        topo.add(new JLabel("Pedido:"), BorderLayout.WEST);
        topo.add(cbPedidos, BorderLayout.CENTER);
        topo.add(btnRecarregar, BorderLayout.EAST);
        add(topo, BorderLayout.NORTH);

        lista.setBorder(BorderFactory.createTitledBorder("Itens do Pedido"));
        add(new JScrollPane(lista), BorderLayout.CENTER);

        JButton btnAtualizar = new JButton("Atualizar status do item selecionado");
        add(btnAtualizar, BorderLayout.SOUTH);

        btnRecarregar.addActionListener(e -> carregarPedidos());
        cbPedidos.addActionListener(e -> mostrarItens());
        btnAtualizar.addActionListener(e -> atualizarStatus());

        carregarPedidos();
    }

    private void carregarPedidos() {
        cbPedidos.removeAllItems();
        for (Pedido p : sistema.getPedidos()) {
            cbPedidos.addItem(p);
        }
        mostrarItens();
    }

    private void mostrarItens() {
        modelo.clear();
        Pedido p = (Pedido) cbPedidos.getSelectedItem();
        if (p == null) return;
        int i = 0;
        for (ItemPedido ip : p.getItensPedido()) {
            modelo.addElement("[" + i + "] " + ip.getItemCardapio().getNome()
                    + " x" + ip.getQuantidade()
                    + " | Status: " + ip.getStatusPreparo().getStatusItemPedido());
            i++;
        }
    }

    private void atualizarStatus() {
        Pedido p = (Pedido) cbPedidos.getSelectedItem();
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido.");
            return;
        }
        int idx = lista.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um item na lista.");
            return;
        }
        ItemPedido ip = p.getItensPedido().get(idx);

        StatusItemPedido novo = (StatusItemPedido) JOptionPane.showInputDialog(this,
                "Novo status de preparo:", "Status",
                JOptionPane.QUESTION_MESSAGE, null,
                StatusItemPedido.values(), ip.getStatusPreparo());
        if (novo == null) return;

        sistema.atualizarStatusCozinha(ip, novo);

        // Mesma automação de delivery do Main original
        if (p instanceof PedidoDelivery) {
            PedidoDelivery d = (PedidoDelivery) p;
            if (novo == StatusItemPedido.SERVIDO) {
                d.setStatusEntrega(StatusEntrega.ENTREGUE);
                JOptionPane.showMessageDialog(this, "Delivery atualizado automaticamente para: ENTREGUE!");
            } else if (novo == StatusItemPedido.PRONTO) {
                d.setStatusEntrega(StatusEntrega.SAIU_PARA_ENTREGA);
                JOptionPane.showMessageDialog(this, "Delivery atualizado automaticamente para: SAIU PARA ENTREGA!");
            }
        }
        mostrarItens();
    }
}
