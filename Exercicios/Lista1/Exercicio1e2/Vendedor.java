package Exercicios.Lista1.Exercicio1e2;
public class Vendedor {
    private String nome;
    private int idade;
    private double salario;
    private Endereco endereco;

    public Vendedor(){}
    public Vendedor(String nome, int idade, double salario, Endereco endereco){
        this.idade = idade;
        this.nome = nome;
        this.salario = salario;
        this.endereco = endereco;
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

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getSalario() {
        return this.salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }

    public String toString(){
        String info = "Vendedor: " + this.nome + ". Idade: " + this.idade + ". Salario: " + this.salario + ". Rua: " + this.endereco.getRua() + " .Numero: " + this.endereco.getNumero() + " .Cidade: " + this.endereco.getCidade() + " .Estado: " + this.endereco.getEstado();
    
        return info;
    }

    public boolean equals(Object o){
        if(o instanceof Vendedor){
            Vendedor v = (Vendedor) o;
            if(this.nome.equals(v.getNome())
            && this.idade == v.getIdade() 
            && this.salario == v.getSalario()
            && this.endereco.equals(v.getEndereco())) return true;
        }
        return false;
    }

}
