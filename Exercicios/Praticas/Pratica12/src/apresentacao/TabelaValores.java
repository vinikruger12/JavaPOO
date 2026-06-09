package apresentacao;
import javax.swing.table.AbstractTableModel;

import dados.CalculadoraEstatistica;

public class TabelaValores extends AbstractTableModel{
    private String[] colunas = {"Valores"};
    private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();

    public int getRowCount(){
        return calculadora.getValores().size();
    }

    public int getColumnCount(){
        return 1;
    }

    public Object getValueAt(int rowIndex, int columnIndex){
        return calculadora.getValores().get(rowIndex);
    }

    public String getColumnName(int column){
        return colunas[column];
    }

    public void adicionarValor(int valor){
        calculadora.adicionarValores(valor);
        fireTableStructureChanged();
    }

    public void limpar(){
        calculadora.limparValores();
    }

    public void tirarUltimo(){
        calculadora.tirarUltimoValor();
        fireTableStructureChanged();
    }
}

