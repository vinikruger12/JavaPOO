package apresentacao;

import dados.*;
import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PainelReservas extends JPanel {

    private final Sistema sistema;
    private final JTextField txtNome = new JTextField();
    private final JTextField txtTelefone = new JTextField();
    private final JTextField txtData = new JTextField();
    private final JTextField txtHora = new JTextField();
    private final JTextField txtPessoas = new JTextField();
    private final JTextField txtObs = new JTextField();
    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);

    public PainelReservas(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(7, 2, 6, 6));
        form.setBorder(BorderFactory.createTitledBorder("Nova Reserva"));
        form.add(new JLabel("Nome do cliente:"));
        form.add(txtNome);
        form.add(new JLabel("Telefone:"));
        form.add(txtTelefone);
        form.add(new JLabel("Data (ex: 15/05/2026):"));
        form.add(txtData);
        form.add(new JLabel("Hora (ex: 20:00):"));
        form.add(txtHora);
        form.add(new JLabel("Número de pessoas:"));
        form.add(txtPessoas);
        form.add(new JLabel("Observações:"));
        form.add(txtObs);

        JButton btnBuscar = new JButton("Buscar mesas disponíveis");
        JButton btnReservar = new JButton("Fazer Reserva");
        form.add(btnBuscar);
        form.add(btnReservar);

        add(form, BorderLayout.NORTH);

        JButton btnStatus = new JButton("Alterar status da reserva selecionada");
        JPanel sul = new JPanel(new BorderLayout());
        lista.setBorder(BorderFactory.createTitledBorder("Reservas"));
        sul.add(new JScrollPane(lista), BorderLayout.CENTER);
        sul.add(btnStatus, BorderLayout.SOUTH);
        add(sul, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> buscarMesas());
        btnReservar.addActionListener(e -> fazerReserva());
        btnStatus.addActionListener(e -> alterarStatus());
    }

    private void buscarMesas() {
        try {
            int cap = txtPessoas.getText().trim().isEmpty() ? 0
                    : Integer.parseInt(txtPessoas.getText().trim());
            String data = txtData.getText().trim();
            String hora = txtHora.getText().trim();
            List<Mesa> livres = sistema.buscarMesaDisponivel(cap, data, hora);
            if (livres.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma mesa disponível para este critério.");
                return;
            }
            StringBuilder sb = new StringBuilder("Mesas disponíveis:\n");
            for (Mesa m : livres) {
                sb.append("- Mesa ").append(m.getNumero())
                        .append(" (").append(m.getLocalizacao().getLocalizacaoMesa()).append(") - ")
                        .append(m.getCapacidadePessoas()).append(" pessoas\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de pessoas deve ser inteiro.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fazerReserva() {
        try {
            String data = txtData.getText().trim();
            String hora = txtHora.getText().trim();
            List<Mesa> disponiveis = sistema.buscarMesaDisponivel(0, data, hora);
            if (disponiveis.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há mesas disponíveis (cadastre mesas primeiro).");
                return;
            }

            List<Mesa> escolhidas = new ArrayList<>();
            boolean continuar = true;
            while (continuar && !disponiveis.isEmpty()) {
                List<Mesa> restantes = new ArrayList<>();
                for (Mesa m : disponiveis) {
                    if (!escolhidas.contains(m)) restantes.add(m);
                }
                if (restantes.isEmpty()) break;

                Mesa m = (Mesa) JOptionPane.showInputDialog(this,
                        "Selecione uma mesa para a reserva:", "Mesas da reserva",
                        JOptionPane.QUESTION_MESSAGE, null, restantes.toArray(), restantes.get(0));
                if (m == null) break;
                escolhidas.add(m);

                int resp = JOptionPane.showConfirmDialog(this,
                        "Adicionar outra mesa a esta reserva?", "Mais mesas", JOptionPane.YES_NO_OPTION);
                continuar = (resp == JOptionPane.YES_OPTION);
            }

            if (escolhidas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Reserva cancelada (nenhuma mesa escolhida).");
                return;
            }

            Reserva r = new Reserva();
            r.setNomeCliente(txtNome.getText().trim());
            r.setTelefone(txtTelefone.getText().trim());
            r.setData(data);
            r.setHora(hora);
            r.setNumeroPessoas(txtPessoas.getText().trim().isEmpty() ? 0
                    : Integer.parseInt(txtPessoas.getText().trim()));
            r.setObservacoes(txtObs.getText().trim());
            r.setStatus(StatusReserva.PENDENTE);
            r.setMesas(escolhidas);

            sistema.fazerReserva(r);
            atualizarLista();
            limpar();
            JOptionPane.showMessageDialog(this, "Reserva realizada com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de pessoas deve ser inteiro.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterarStatus() {
        int idx = lista.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma reserva na lista.");
            return;
        }
        Reserva r = sistema.getReservas().get(idx);
        StatusReserva novo = (StatusReserva) JOptionPane.showInputDialog(this,
                "Novo status da reserva:", "Status",
                JOptionPane.QUESTION_MESSAGE, null, StatusReserva.values(), r.getStatus());
        if (novo == null) return;
        sistema.atualizarStatusReserva(r, novo);
        atualizarLista();
    }

    private void limpar() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtData.setText("");
        txtHora.setText("");
        txtPessoas.setText("");
        txtObs.setText("");
    }

    private void atualizarLista() {
        modelo.clear();
        for (Reserva r : sistema.getReservas()) {
            StringBuilder mesas = new StringBuilder();
            for (Mesa m : r.getMesas()) mesas.append(m.getNumero()).append(" ");
            modelo.addElement(r.getNomeCliente() + " | " + r.getData() + " " + r.getHora()
                    + " | " + r.getNumeroPessoas() + " pessoas | Mesas: " + mesas.toString().trim()
                    + " | " + r.getStatus().getStatusReserva());
        }
    }
}
