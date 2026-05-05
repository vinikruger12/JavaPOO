package Exercicios.Prova1.Externos.Netflix.dados;

public class Filme extends Midia{
    private int duracaoMinutos;

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    public int getDuracaoMinutos() {
        return this.duracaoMinutos;
    }

    public int calcularTempoMaratona(){
        return this.duracaoMinutos;
    }
}
