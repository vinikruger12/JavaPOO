package dados;

import java.util.ArrayList;
import java.util.List;

public class Aquario extends Viveiro{
    private float altura;
    private float temperatura;

    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public List<Peixe> getPeixes(){
        List<Peixe> peixes = new ArrayList<>();

        for(Animal animal : animais){
            if(animal instanceof Peixe){
                peixes.add((Peixe) animal);
            }
        }

        return peixes;

    }

    public float calculaEspaco(){
        return super.calculaEspaco() * this.altura;
    }

    public boolean adicionarAnimal(Animal animal){
        Peixe peixe = (Peixe) animal;
        if(Math.abs(peixe.getTemperaturaIdeal() - this.temperatura) > 3) return false;
        
        if(animal.calculaEspaco()*0.7 < espacoDisponivel()){
            animais.add(peixe);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        // Aproveita os dados do Viveiro e adiciona as propriedades do Aquário
        return super.toString() + 
               " -> Aquário [Altura: " + altura + 
               ", Temperatura atual: " + temperatura + "°C" +
               ", Volume Total: " + calculaEspaco() + "]";
    }

}
