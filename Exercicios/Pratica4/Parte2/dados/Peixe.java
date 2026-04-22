package dados;

public class Peixe extends Animal{
    private float temperaturaIdeal;

    public float getTemperaturaIdeal() {
        return this.temperaturaIdeal;
    }
    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float calculaEspacoOcupado(){
        return super.calculaEspacoOcupado() * altura; 
    }


    public String toString() {
        return "Peixe [" +
               "Nome: " + nome + 
               " | Espécie: " + especie + 
               " | Cor: " + cor + 
               " | Idade: " + idade + 
               " | Temp. Ideal: " + temperaturaIdeal + "°C" +
               "]";
    }


}