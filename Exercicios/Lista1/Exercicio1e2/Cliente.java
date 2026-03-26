package Exercicios.Lista1.Exercicio1e2;
import java.util.Arrays;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;
    private int numeroVeiculos = 0;
    private Veiculo[] veiculosAlugados = new Veiculo[10];

    public Cliente(){}
    public Cliente(String nome, int idade, Endereco endereco, Veiculo[] veiculosAlugados){
        this.idade = idade;
        this.nome = nome;
        this.endereco = endereco;
        this.veiculosAlugados = veiculosAlugados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return this.idade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setVeiculos_alugados(Veiculo veiculo) {
        this.veiculosAlugados[numeroVeiculos] = veiculo;
        numeroVeiculos++;
    }
    public Veiculo[] getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public int getNumeroVeiculos() {
        return this.numeroVeiculos;
    }
    public void setNumeroVeiculos(int numeroVeiculos) {
        this.numeroVeiculos = numeroVeiculos;
    }

    public String toString(){
        String info = "Cliente: " + this.nome + ". Idade: " + this.idade + ". Numero Veiculos: " + this.numeroVeiculos + ". Rua: " + this.endereco.getRua() + " .Numero: " + this.endereco.getNumero() + " .Cidade: " + this.endereco.getCidade() + " .Estado: " + this.endereco.getEstado();

        return info;
    }

    public boolean equals(Object o){
        if(o instanceof Cliente){
            Cliente v = (Cliente) o;
            if(this.nome.equals(v.getNome())
            && this.idade == v.getIdade() 
            && this.numeroVeiculos == v.getNumeroVeiculos()
            && Arrays.equals(this.veiculosAlugados, v.getVeiculosAlugados())
            && this.endereco.equals(v.getEndereco())) return true;
        }
        return false;
    }
}
