package Exercicios.Prova1.Externos.CentroDeDistribuicao.negocios;

import dados.*;

public class CamaraFria extends Setor{
    private float altura;
    private float temperatura;

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float calculaEspaco(){
        return super.comprimento * super.largura * this.altura;
    }

    public boolean adicionarCarga(Carga c){
        if(this.espacoDisponivel() < c.calculaEspacoOcupado()) return false;
        if(!(c instanceof CargaRefrigerada)) return false;
        CargaRefrigerada cr = (CargaRefrigerada) c;
        if(Math.abs(this.temperatura - cr.getTemperaturaIdeal()) > 3) return false;
        super.cargas.add(c);
        return true;
    }
}
