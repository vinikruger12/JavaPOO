package Exercicios.Prova1.Externos.CentroDeDistribuicao.dados;

public class CargaRefrigerada extends Carga{
    
    private float temperaturaIdeal;
    protected float altura;

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }
    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }


    public float calculaEspacoOcupado(){
        return super.comprimento * super.largura * this.altura;
    }

}
