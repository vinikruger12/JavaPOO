package apresentacao;

import dados.Garcom;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;

public class PainelGarcons extends JPanel {

    private final Sistema sistema;
    private final JTextField txtNome = new JTextField();
    private final JTextField txtCpf = new JTextField();
    private final JTextField txtAdmissao = new JTextField();
    private final JTextField txtComissao = new JTextField();
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);

    public PainelGarcons(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 6, 6));
        form.setBorder(BorderFactory.createTitledBorder("Cadastro de Garçom"));
        form.add(new JLabel("Nome:"));
        form.add(txtNome);
        form.add(new JLabel("CPF:"));
        form.add(txtCpf);
        form.add(new JLabel("Data de admissão:"));
        form.add(txtAdmissao);
        form.add(new JLabel("Comissão (ex: 0.10 = 10%):"));
        form.add(txtComissao);

        JButton btnCadastrar = new JButton("Cadastrar Garçom");
        JButton btnComissao = new JButton("Ver comissão do selecionado");
        form.add(btnCadastrar);
        form.add(btnComissao);

        add(form, BorderLayout.NORTH);

        lista.setBorder(BorderFactory.createTitledBorder("Garçons Cadastrados"));
        add(new JScrollPane(lista), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrar());
        btnComissao.addActionListener(e -> verComissao());
    }

    private void cadastrar() {
        try {
            Garcom g = new Garcom();
            g.setNome(txtNome.getText().trim());
            g.setCpf(txtCpf.getText().trim());
            g.setDataAdmissao(txtAdmissao.getText().trim());
            g.setPercentualComissao(Double.parseDouble(txtComissao.getText().trim().replace(",", ".")));

            sistema.cadastrarGarcom(g);
            atualizarLista();
            txtNome.setText("");
            txtCpf.setText("");
            txtAdmissao.setText("");
            txtComissao.setText("");
            JOptionPane.showMessageDialog(this, "Garçom cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "A comissão deve ser um número (ex: 0.10).",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verComissao() {
        int idx = lista.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um garçom na lista.");
            return;
        }
        Garcom g = sistema.getGarcons().get(idx);
        double comissao = sistema.calcularComissaoGarcom(g);
        JOptionPane.showMessageDialog(this, String.format(
                "Comissão acumulada de %s sobre os pedidos: R$ %.2f", g.getNome(), comissao));
    }

    private void atualizarLista() {
        modelo.clear();
        for (Garcom g : sistema.getGarcons()) {
            modelo.addElement(g.getNome() + " | CPF: " + g.getCpf()
                    + " | Comissão: " + (g.getPercentualComissao() * 100) + "%");
        }
    }
}
