package apresentacao;

import dados.LocalizacaoMesa;
import dados.Mesa;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;

public class PainelMesas extends JPanel {

    private final Sistema sistema;
    private final JTextField txtNumero = new JTextField();
    private final JTextField txtCapacidade = new JTextField();
    private final JComboBox<LocalizacaoMesa> cbLocalizacao = new JComboBox<>(LocalizacaoMesa.values());
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);

    public PainelMesas(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(4, 2, 6, 6));
        form.setBorder(BorderFactory.createTitledBorder("Cadastro de Mesa"));
        form.add(new JLabel("Número:"));
        form.add(txtNumero);
        form.add(new JLabel("Capacidade de pessoas:"));
        form.add(txtCapacidade);
        form.add(new JLabel("Localização:"));
        form.add(cbLocalizacao);

        JButton btnCadastrar = new JButton("Cadastrar Mesa");
        form.add(new JLabel());
        form.add(btnCadastrar);

        add(form, BorderLayout.NORTH);

        lista.setBorder(BorderFactory.createTitledBorder("Mesas Cadastradas"));
        add(new JScrollPane(lista), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrar());
    }

    private void cadastrar() {
        try {
            Mesa m = new Mesa();
            m.setNumero(Integer.parseInt(txtNumero.getText().trim()));
            m.setCapacidadePessoas(Integer.parseInt(txtCapacidade.getText().trim()));
            m.setLocalizacao((LocalizacaoMesa) cbLocalizacao.getSelectedItem());

            sistema.cadastrarMesa(m);
            atualizarLista();
            txtNumero.setText("");
            txtCapacidade.setText("");
            JOptionPane.showMessageDialog(this, "Mesa cadastrada com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número e capacidade devem ser valores inteiros válidos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarLista() {
        modelo.clear();
        for (Mesa m : sistema.getMesas()) {
            modelo.addElement("Mesa " + m.getNumero() + " | Cap.: " + m.getCapacidadePessoas()
                    + " | " + m.getLocalizacao().getLocalizacaoMesa());
        }
    }
}
