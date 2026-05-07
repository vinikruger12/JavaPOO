package dados;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String data;
    private float valorTotal;
    private int qntProdutos;
    private String formaDePegamentos;
    private boolean pago = false;
    private List<Produto> produtos = new ArrayList<>();


    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
    public String getFormaDePegamentos() {
        return formaDePegamentos;
    }
    public void setFormaDePegamentos(String formaDePegamentos) {
        this.formaDePegamentos = formaDePegamentos;
    }
    

    public float calculaValorTotal() {
        float soma = 0;
        for(int i = 0;i < this.qntProdutos;i++){
            soma += produtos.get(i).getPreco();
        }
        this.valorTotal = soma;
        return soma;
    }


    

    public int getQntProdutos() {
        return qntProdutos;
    }
    public void setQntProdutos(int qntProdutos) {
        this.qntProdutos = qntProdutos;
    }

    public void adicionarProduto(Produto p){
        produtos.add(p);
        this.qntProdutos++;
    }

    public void removerProduto(Produto p){
        produtos.remove(p);
        this.qntProdutos--;
    }

    public void pagar(){
        this.pago = true;
    }

    public boolean estaPago(){
        return this.pago;
    }

    
    public String toString() {
        return "Compra [data=" + data + ", valorTotal=" + valorTotal + ", qntProdutos=" + qntProdutos
                + ", formaDePegamentos=" + formaDePegamentos + ", pago=" + pago + ", produtos=" + produtos + "]";
    }

}
