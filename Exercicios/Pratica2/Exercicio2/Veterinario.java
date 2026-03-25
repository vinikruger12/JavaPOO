public class Veterinario {
    private String nome;
    private double salario;
    private Endereco endereco;
    private int quantidadeAnimais = 0;
    private Animal[] animais = new Animal[10];
    

    public Veterinario(){}

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }
    public double getSalario(){
        return this.salario;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setAnimais(Animal animal){
        this.animais[this.quantidadeAnimais] = animal;
        this.quantidadeAnimais++;
    }
    public Animal getAnimais(int k){
        return this.animais[k];
    }

}
