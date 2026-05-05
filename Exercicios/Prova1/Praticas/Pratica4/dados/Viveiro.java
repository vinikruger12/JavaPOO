package dados;

import java.util.ArrayList;
import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais = new ArrayList<>();

    public List<Animal> getAnimais() {
        return animais;
    }

    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float calculaEspaco(){
        return this.comprimento * this.largura;
    }

    private float espacoOcupado(){
        float soma = 0;
        for(int i = 0;i < animais.size();i++){
            soma += animais.get(i).calculaEspaco();
        }

        return soma;
    }

    public float espacoDisponivel(){
        return this.calculaEspaco() - this.espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal){
        if(this.espacoDisponivel() > animal.calculaEspaco()*0.7 && !(animal instanceof Peixe)){
            animais.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Viveiro: " + nome + 
               " | Dimensões: " + comprimento + "x" + largura + 
               " | Espaço Total: " + calculaEspaco();
    }




}
