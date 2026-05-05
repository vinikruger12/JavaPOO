package Exercicios.Prova1.Externos.CentroDeDistribuicao.negocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Exercicios.Prova1.Externos.CentroDeDistribuicao.dados.Carga;
import dados.*;

import negocios.CamaraFria;

import java.util.List;

public class CentroDeDistribuicao {
    private Map<String, Setor> setores = new HashMap<>();

    public Map<String, Setor> getSetores() {
        return setores;
    }

    public void cadastrarSetor(String id, Setor s){
        setores.put(id, s);
    }

    public void alocarCarga(String id, Carga c){
        boolean sucesso = setores.get(id).adicionarCarga(c);
        if(!sucesso){
            System.out.println("Erro: Não foi possível alocar a carga (Regras não atendidas).");
        }
    }

    public List<Setor> getSoCamerasFrias(){
        List<Setor> lista = new ArrayList<>();
        for(String id : setores.keySet()){
            if(setores.get(id) instanceof CamaraFria) lista.add(setores.get(id));
        }
        return lista;
    }


}
