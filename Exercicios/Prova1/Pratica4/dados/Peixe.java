package dados;

public class Peixe extends Animal{
    private float temperaturaIdeal;
    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }
    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
    
    public float calculaEspaco(){
        return super.calculaEspaco() * this.altura;
    }

    @Override
    public String toString() {
        // Aproveita a string do Animal e concatena a regra específica do Peixe
        return super.toString() + " -> Peixe [Temperatura Ideal: " + temperaturaIdeal + "°C]";
    }

}
