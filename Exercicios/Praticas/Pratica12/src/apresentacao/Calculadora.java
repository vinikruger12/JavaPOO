package apresentacao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dados.Gerador;

import javax.swing.JTable;

import dados.Fibonacci;
import dados.Primos;
import dados.Fatorial;

public class Calculadora extends JFrame{

    private JPanel painel = new JPanel();

    private JPanel painelEntrada = new JPanel();
    private JScrollPane painelScrollTabelaResultados = new JScrollPane();
    private JScrollPane painelScrollTabelaValores = new JScrollPane();

    private JPanel painelGeradores = new JPanel();
    private JTextField caixaQuantidade = new JTextField();
    private JButton botaoFibonacci = new JButton("Fibonacci");
    private JButton botaoPrimos = new JButton("Primos");
    private JButton botaoFatorial = new JButton("Fatorial");

    private JLabel infoCaixaEntrada = new JLabel("Digite um valor");
    private JTextField caixaEntrada = new JTextField();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoLimpar = new JButton("Limpar");
    private JButton botaoTirar = new JButton("Tirar Último");

    private JTable tabelaValores;
    private JTable tabelaResultados;

    private TabelaResultados resultados = new TabelaResultados();
    private TabelaValores valores = new TabelaValores();

    public Calculadora(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 900, 300);
        setResizable(false);
        setTitle("Calculadora Estatística - PRO");

        this.setContentPane(painel);
        painel.setLayout(null);

        painelEntrada.setBounds(15, 80, 280, 173);
        painelEntrada.setLayout(null);
        painelEntrada.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        painel.add(painelEntrada);

        infoCaixaEntrada.setBounds(30, 30,200, 15);
        painelEntrada.add(infoCaixaEntrada);

        caixaEntrada.setBounds(30,50,200,20);
        caixaEntrada.setColumns(10);
        painelEntrada.add(caixaEntrada);

        botaoAdicionar.setBounds(77, 85, 117, 25);
        painelEntrada.add(botaoAdicionar);

        botaoLimpar.setBounds(77, 115, 117, 25);
        painelEntrada.add(botaoLimpar);

        botaoTirar.setBounds(77, 145, 117, 25);
        painelEntrada.add(botaoTirar);

        painelScrollTabelaResultados.setBounds(10, 10, 880, 50);
        painel.add(painelScrollTabelaResultados);

        tabelaResultados = new JTable(resultados);
        painelScrollTabelaResultados.setViewportView(tabelaResultados);

        painelScrollTabelaValores.setBounds(307, 80, 173, 173);
        painel.add(painelScrollTabelaValores);

        tabelaValores = new JTable(valores);
        painelScrollTabelaValores.setViewportView(tabelaValores);

        painelGeradores.setBounds(500, 80, 180, 173);
        painelGeradores.setLayout(null);
        painelGeradores.setBorder(BorderFactory.createTitledBorder("Gerar Valores"));
        painel.add(painelGeradores);

        caixaQuantidade.setBounds(30, 30, 120, 20);
        painelGeradores.add(caixaQuantidade);

        botaoFibonacci.setBounds(30, 65, 120, 25);
        painelGeradores.add(botaoFibonacci);

        botaoPrimos.setBounds(30, 95, 120, 25);
        painelGeradores.add(botaoPrimos);

        botaoFatorial.setBounds(30, 125, 120, 25);
        painelGeradores.add(botaoFatorial);

        botaoAdicionar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
                valores.adicionarValor(Integer.parseInt(caixaEntrada.getText()));
                resultados.atualizar();
                caixaEntrada.setText("");
           } 
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                valores.limpar();
                resultados.atualizar();
                caixaEntrada.setText("");
            }    
        });

        botaoTirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                valores.tirarUltimo();
                resultados.atualizar();
                caixaEntrada.setText("");
            }
        });
        
        botaoFibonacci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int qtd = Integer.parseInt(caixaQuantidade.getText());
                Gerador fib = new Fibonacci();
                fib.gerar(qtd);
                
                for(int val : fib.getSequencia()){
                    valores.adicionarValor(val);
                }
                
                resultados.atualizar();
                caixaQuantidade.setText("");
            }
        });

        botaoPrimos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int qtd = Integer.parseInt(caixaQuantidade.getText());
                Gerador pri = new Primos();
                pri.gerar(qtd);
                
                for(int val : pri.getSequencia()){
                    valores.adicionarValor(val);
                }
                
                resultados.atualizar();
                caixaQuantidade.setText("");
            }
        });

        botaoFatorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int qtd = Integer.parseInt(caixaQuantidade.getText());
                Gerador fat = new Fatorial();
                fat.gerar(qtd);
                
                for(int val : fat.getSequencia()){
                    valores.adicionarValor(val);
                }
                
                resultados.atualizar();
                caixaQuantidade.setText("");
            }
        });
        
    }

    public static void main(String[] args){
        Calculadora calc = new Calculadora();
        calc.setVisible(true);
    }
}