package Exercicios.Lista1.Exercicio3;

public class Imovel {
    private double largura;
    private double comprimento;
    private double preco;

    public Imovel(){}
    public Imovel(double largura, double comprimento, double preco){
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    public double getComprimento() {
        return this.comprimento;
    }
    
    public void setLargura(double largura) {
        this.largura = largura;
    }
    public double getLargura() {
        return this.largura;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return this.preco;
    }

    public double areaTotal(){
        return largura * comprimento;
    }

    public String toString(){
        return "Largura: " + this.largura + ", Comprimento: " + this.comprimento + ", Preco: " + this.preco + ", Area: " + this.areaTotal();
    }

}
