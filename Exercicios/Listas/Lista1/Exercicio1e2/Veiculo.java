package Exercicios.Lista1.Exercicio1e2;
public class Veiculo {
    private String nome;
    private String cor;
    private String marca;
    private int ano;

    public Veiculo(){}

    public Veiculo(String nome, String cor, String marca, int ano){
        this.nome = nome;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString(){
        String info = "Nome: " + this.nome + ". Cor: " + this.cor + ". Marca: " + this.marca + ". Ano: " + this.ano;
    
        return info;
    }

    public boolean equals(Object o){
        if(o instanceof Veiculo){
            Veiculo v = (Veiculo) o;
            if(this.nome.equals(v.getNome())
            && this.ano == v.getAno() 
            && this.cor.equals(v.getCor())
            && this.marca.equals(v.getMarca())) return true;
        }
        return false;
    }
    
}
