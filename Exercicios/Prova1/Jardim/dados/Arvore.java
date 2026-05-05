package dados;

public class Arvore extends Planta {
    private float alturaMaxima;

    public float getAlturaMaxima() {
        return alturaMaxima;
    }
    public void setAlturaMaxima(float alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public float calcularAguaDiaria(){
        return this.alturaMaxima * super.espacoNescessario;
    }
}
