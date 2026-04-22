package dados;
import dados.Animal;
import dados.Viveiro;

import java.util.ArrayList;
import java.util.List;

import dados.Peixe;

public class Aquario extends Viveiro{
    private float altura;
    private float temperatura;
    
    public float getAltura() {
        return this.altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return this.temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public List<Peixe> getPeixes(){
        List<Peixe> listaDePeixes = new ArrayList<>();
        
        for (Animal animal : animais){
            if(animal instanceof Peixe){
                listaDePeixes.add((Peixe) animal);
            }
        }
        return listaDePeixes;
    }

    public float calculaEspaco(){
        return super.calculaEspaco() * this.altura;
    }

    public boolean adicionarAnimal(Animal animal){
        if((animal.calculaEspacoOcupado() * 0.7) >= espacoDisponivel() ||
        !(animal instanceof Peixe)) return false;

        Peixe peixe = (Peixe) animal;
        float diferencaTemp = Math.abs(this.temperatura - peixe.getTemperaturaIdeal());
        
        if(diferencaTemp > 3) {
            return false; 
        }

        animais.add(animal);
        return true;
    }

}
