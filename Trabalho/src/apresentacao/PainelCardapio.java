package apresentacao;

import dados.CategoriaItem;
import dados.ItemCardapio;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;

public class PainelCardapio extends JPanel {

    private final Sistema sistema;
    private final JTextField txtCodigo = new JTextField();
    private final JTextField txtNome = new JTextField();
    private final JTextField txtDescricao = new JTextField();
    private final JTextField txtPreco = new JTextField();
    private final JTextField txtTempo = new JTextField();
    private final JCheckBox chkDisponivel = new JCheckBox("Disponível", true);
    private final JComboBox<CategoriaItem> cbCategoria = new JComboBox<>(CategoriaItem.values());
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);

    public PainelCardapio(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(8, 2, 6, 6));
        form.setBorder(BorderFactory.createTitledBorder("Cadastro de Item do Cardápio"));
        form.add(new JLabel("Código:"));
        form.add(txtCodigo);
        form.add(new JLabel("Nome:"));
        form.add(txtNome);
        form.add(new JLabel("Descrição:"));
        form.add(txtDescricao);
        form.add(new JLabel("Preço (R$):"));
        form.add(txtPreco);
        form.add(new JLabel("Tempo de preparo (min):"));
        form.add(txtTempo);
        form.add(new JLabel("Categoria:"));
        form.add(cbCategoria);
        form.add(new JLabel("Disponibilidade:"));
        form.add(chkDisponivel);

        JButton btnCadastrar = new JButton("Cadastrar Item");
        JButton btnCompor = new JButton("Adicionar componente (combo)");
        form.add(btnCadastrar);
        form.add(btnCompor);

        add(form, BorderLayout.NORTH);

        lista.setBorder(BorderFactory.createTitledBorder("Itens do Cardápio"));
        add(new JScrollPane(lista), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrar());
        btnCompor.addActionListener(e -> compor());
    }

    private void cadastrar() {
        try {
            ItemCardapio item = new ItemCardapio();
            item.setCodigo(txtCodigo.getText().trim());
            item.setNome(txtNome.getText().trim());
            item.setDescricao(txtDescricao.getText().trim());
            item.setPreco(Double.parseDouble(txtPreco.getText().trim().replace(",", ".")));
            item.setTempoMedioPreparo(Integer.parseInt(txtTempo.getText().trim()));
            item.setDisponivel(chkDisponivel.isSelected());
            item.setCategoria((CategoriaItem) cbCategoria.getSelectedItem());

            sistema.cadastrarItemCardapio(item);
            atualizarLista();
            limpar();
            JOptionPane.showMessageDialog(this, "Item cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço e tempo devem ser numéricos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void compor() {
        var itens = sistema.getItensCardapio();
        if (itens.size() < 2) {
            JOptionPane.showMessageDialog(this, "Cadastre ao menos 2 itens para montar um combo.");
            return;
        }
        ItemCardapio combo = (ItemCardapio) JOptionPane.showInputDialog(this,
                "Selecione o item COMBO (que receberá o componente):", "Composição de combo",
                JOptionPane.QUESTION_MESSAGE, null, itens.toArray(), itens.get(0));
        if (combo == null) return;

        ItemCardapio componente = (ItemCardapio) JOptionPane.showInputDialog(this,
                "Selecione o item COMPONENTE a adicionar:", "Composição de combo",
                JOptionPane.QUESTION_MESSAGE, null, itens.toArray(), itens.get(0));
        if (componente == null) return;

        combo.adicionarComponente(componente);
        JOptionPane.showMessageDialog(this, "Componente '" + componente.getNome()
                + "' adicionado ao combo '" + combo.getNome() + "'.");
    }

    private void limpar() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtTempo.setText("");
        chkDisponivel.setSelected(true);
    }

    private void atualizarLista() {
        modelo.clear();
        for (ItemCardapio i : sistema.getItensCardapio()) {
            String comp = i.getComponentes().isEmpty() ? "" : " [combo: " + i.getComponentes().size() + " itens]";
            modelo.addElement(i.getCodigo() + " - " + i.getNome()
                    + " | R$ " + i.getPreco()
                    + " | " + i.getCategoria().getCategoriaItem()
                    + (i.isDisponivel() ? " | DISPONÍVEL" : " | INDISPONÍVEL") + comp);
        }
    }
}
