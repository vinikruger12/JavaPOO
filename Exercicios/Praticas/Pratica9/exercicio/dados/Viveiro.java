package dados;
import java.util.List;
import dados.Animal;
import dados.Peixe;
import java.util.ArrayList;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais = new ArrayList<>(); 

    public float getComprimento() {
        return this.comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
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

    public List<Animal> getAnimais() {
        return this.animais;
    }
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public float calculaEspaco(){
        return this.largura * this.comprimento;
    }

    private float espacoOcupado(){
        float soma = 0;
        for(Animal animal : animais){
            soma += animal.calculaEspacoOcupado();
        }
        return soma;
    }

    public float espacoDisponivel(){
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal){
        if((animal.calculaEspacoOcupado() * 0.7) >= espacoDisponivel() || animal instanceof Peixe) return false;
        animais.add(animal);
        return true;
    }

    public String toString(){
        return "Nome: " + this.nome;
    }


}
