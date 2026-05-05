package Exercicios.Prova1.Externos.CentroDeDistribuicao.negocios;

import java.util.ArrayList;
import java.util.List;

import dados.*;

public class Setor {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Carga> cargas = new ArrayList<>();
    
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Carga> getCargas() {
        return cargas;
    }

    public float calculaEspaco(){
        return this.comprimento*this.largura;
    }

    private float espacoOcupado(){
        float soma = 0;
        for(int i = 0;i < cargas.size();i++){
            soma += cargas.get(i).calculaEspacoOcupado();
        }

        return soma;
    }

    public float espacoDisponivel(){
        return this.calculaEspaco() - this.espacoOcupado();
    }

    public boolean adicionarCarga(Carga c){
        if(c.calculaEspacoOcupado() > this.espacoDisponivel()) return false;
        cargas.add(c);
        return true;
    }


}
