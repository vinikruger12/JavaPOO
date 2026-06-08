package apresentacao;

import negocio.Sistema;

import javax.swing.*;
import java.awt.*;

/**
 * Janela principal do Sistema de Gestão de Restaurante.
 * Camada de apresentação (Etapa II). Comunica-se exclusivamente
 * com a classe negocio.Sistema, mantendo a lógica de negócio intacta.
 */
public class JanelaPrincipal extends JFrame {

    private final Sistema sistema = new Sistema();

    public JanelaPrincipal() {
        super("Sistema de Gestão de Restaurante");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 620);
        setMinimumSize(new Dimension(820, 560));
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Mesas", new PainelMesas(sistema));
        abas.addTab("Garçons", new PainelGarcons(sistema));
        abas.addTab("Cardápio", new PainelCardapio(sistema));
        abas.addTab("Reservas", new PainelReservas(sistema));
        abas.addTab("Pedidos", new PainelPedidos(sistema));
        abas.addTab("Cozinha", new PainelCozinha(sistema));
        abas.addTab("Conta / Pagamento", new PainelConta(sistema));

        add(abas, BorderLayout.CENTER);

        JLabel rodape = new JLabel(
                "  Trabalho de POO - Etapa II (Interface Gráfica) | Tema 3: Gestão de Restaurante");
        rodape.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        add(rodape, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> new JanelaPrincipal().setVisible(true));
    }
}
