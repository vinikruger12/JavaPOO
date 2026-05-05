package Exercicios.Prova1.Externos.CentroDeDistribuicao.dados;

public class CargaComum extends Carga{
    private boolean ehFragil;

    public boolean getEhFragil(){
        return this.ehFragil;
    }

    public void setEhFragil(boolean ehFragil){
        this.ehFragil = ehFragil;
    }

    public float calculaEspacoOcupado(){
        return super.comprimento * super.largura;
    }

}
