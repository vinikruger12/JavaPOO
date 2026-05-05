package Exercicios.Prova1.Externos.Jardim.dados;

public class Flor extends Planta{
    private String cor;

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public float calcularAguaDiaria(){
        return (Float)this.espacoNescessario * 2;
    }
}
