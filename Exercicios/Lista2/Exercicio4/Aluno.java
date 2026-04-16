package Exercicio4;

public class Aluno {
    private String nome;
    private int idade;
    private double[] notas = new double[5];

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return this.notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia(){
        double ans = 0;
        for(int i = 0;i < 5;i++){
            ans += this.notas[i];
        }
        return (ans/5);
    }

    public String toString(){
        return "O aluno " + this.nome + " que tem " + this.idade + " tem média de " + this.calcularMedia();
    };


}
