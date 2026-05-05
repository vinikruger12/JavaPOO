package Exercicios.Prova1.Externos.AWS.negocio;

import java.util.ArrayList;
import java.util.List;

import Exercicios.Prova1.Externos.AWS.dados.MaquinaVirtual;
import dados.*;

public class ZeroDisponibilidade {
    protected String nome;
    protected int maxVcpus;
    protected List<MaquinaVirtual> maquinas = new ArrayList<>();

    public List<MaquinaVirtual> getMaquinas() {
        return maquinas;
    }

    public void setMaxVcpus(int maxVcpus) {
        this.maxVcpus = maxVcpus;
    }
    public int getMaxVcpus() {
        return maxVcpus;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    private int getVcpusAlocados(){
        int soma = 0;
        for(int i = 0;i < maquinas.size();i++){
            soma += maquinas.get(i).getvCpus();
        }
        return soma;
    }

    public int getVcpusLivres(){
        return this.maxVcpus - this.getVcpusAlocados();
    }

    public boolean alocarMaquina(MaquinaVirtual m){
        if(m.getvCpus() > this.getVcpusLivres()) return false;
        maquinas.add(m);
        return true;
    }


}
