package apresentacao;

import dados.*;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class PainelConta extends JPanel {

    private final Sistema sistema;
    private final JComboBox<Pedido> cbPedidos = new JComboBox<>();
    private final JCheckBox chkTaxa = new JCheckBox("Incluir taxa de serviço de 10%", true);
    private final JTextArea areaResumo = new JTextArea(12, 40);

    public PainelConta(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topo = new JPanel(new GridLayout(3, 1, 6, 6));
        topo.setBorder(BorderFactory.createTitledBorder("Fechar Conta / Pagamento"));

        JPanel linha = new JPanel(new BorderLayout(6, 6));
        JButton btnRecarregar = new JButton("Recarregar");
        linha.add(new JLabel("Pedido:"), BorderLayout.WEST);
        linha.add(cbPedidos, BorderLayout.CENTER);
        linha.add(btnRecarregar, BorderLayout.EAST);
        topo.add(linha);
        topo.add(chkTaxa);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnCalcular = new JButton("Calcular total");
        JButton btnPagar = new JButton("Registrar pagamento");
        botoes.add(btnCalcular);
        botoes.add(btnPagar);
        topo.add(botoes);

        add(topo, BorderLayout.NORTH);

        areaResumo.setEditable(false);
        areaResumo.setBorder(BorderFactory.createTitledBorder("Resumo da Conta"));
        add(new JScrollPane(areaResumo), BorderLayout.CENTER);

        btnRecarregar.addActionListener(e -> carregarPedidos());
        btnCalcular.addActionListener(e -> calcular());
        btnPagar.addActionListener(e -> pagar());

        carregarPedidos();
    }

    private void carregarPedidos() {
        cbPedidos.removeAllItems();
        for (Pedido p : sistema.getPedidos()) {
            cbPedidos.addItem(p);
        }
    }

    private void calcular() {
        Pedido p = (Pedido) cbPedidos.getSelectedItem();
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido.");
            return;
        }
        double total = sistema.fecharConta(p, chkTaxa.isSelected());
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido da mesa ").append(p.getMesa().getNumero())
                .append("  | Garçom: ").append(p.getGarcom().getNome()).append("\n");
        sb.append("--------------------------------------------------\n");
        for (ItemPedido ip : p.getItensPedido()) {
            sb.append(String.format("%-25s x%d  R$ %.2f%n",
                    ip.getItemCardapio().getNome(), ip.getQuantidade(), ip.calcularSubtotal()));
        }
        if (p instanceof PedidoDelivery) {
            sb.append(String.format("%-25s      R$ %.2f%n", "Taxa de entrega",
                    ((PedidoDelivery) p).getTaxaEntrega()));
        }
        sb.append("--------------------------------------------------\n");
        sb.append(chkTaxa.isSelected() ? "Com taxa de serviço (10%)\n" : "Sem taxa de serviço\n");
        sb.append(String.format("TOTAL: R$ %.2f%n", total));

        double pago = 0;
        for (Pagamento pg : p.getPagamentos()) pago += pg.getValorPago();
        if (!p.getPagamentos().isEmpty()) {
            sb.append(String.format("Já pago: R$ %.2f | Restante: R$ %.2f%n", pago, total - pago));
        }
        areaResumo.setText(sb.toString());
    }

    private void pagar() {
        Pedido p = (Pedido) cbPedidos.getSelectedItem();
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido.");
            return;
        }
        double total = sistema.fecharConta(p, chkTaxa.isSelected());
        double pago = 0;
        for (Pagamento pg : p.getPagamentos()) pago += pg.getValorPago();
        double restante = total - pago;

        String valorStr = JOptionPane.showInputDialog(this,
                String.format("Total: R$ %.2f | Restante: R$ %.2f%nValor deste pagamento (permite dividir):",
                        total, restante),
                String.format("%.2f", restante));
        if (valorStr == null) return;

        FormaPagamento forma = (FormaPagamento) JOptionPane.showInputDialog(this,
                "Forma de pagamento:", "Pagamento",
                JOptionPane.QUESTION_MESSAGE, null,
                FormaPagamento.values(), FormaPagamento.DINHEIRO);
        if (forma == null) return;

        try {
            Pagamento pag = new Pagamento();
            pag.setValorPago(Double.parseDouble(valorStr.trim().replace(",", ".")));
            pag.setFormaUtilizada(forma);
            pag.setDataHora(LocalDateTime.now().toString());
            sistema.receberPagamento(pag, p);
            JOptionPane.showMessageDialog(this, "Pagamento registrado com sucesso!");
            calcular();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
