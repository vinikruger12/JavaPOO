package dados;

public class Animal{
    protected String nome;
    protected String cor;
    protected String especie;
    protected int idade;
    protected float largura;
    protected float comprimento;
    protected float altura;

    public float getAltura() {
        return this.altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return this.comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    
    public String getCor() {
        return this.cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getEspecie() {
        return this.especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getLargura() {
        return this.largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float calculaEspacoOcupado(){
        return largura * comprimento;
    }


    public String toString() {
        return "Animal [" +
               "Nome: " + nome + 
               " | Espécie: " + especie + 
               " | Cor: " + cor + 
               " | Idade: " + idade + 
               "]";
    }

}