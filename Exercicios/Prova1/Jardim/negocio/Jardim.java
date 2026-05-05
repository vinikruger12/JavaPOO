package negocio;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import dados.*;


public class Jardim {
    private Map<String, Canteiro> setores = new HashMap<>();
    
    public Map<String, Canteiro> getSetores() {
        return setores;
    }

    public void cadastrarCanteiro(String id, Canteiro c){
        setores.put(id, c);
    }

    public void alocarPlanta(String id, Planta p){
        setores.get(id).adicionarPlanta(p);
    }

    public List<Arvore> obterApenasArvores(){
        List<Arvore> arvores = new ArrayList<>();
        for(String id : setores.keySet()){
            for(int i = 0;i < setores.get(id).getPlantas().size();i++){
                if(setores.get(id).getPlantas().get(i) instanceof Arvore) arvores.add((Arvore)setores.get(id).getPlantas().get(i));
            }
        }
        return arvores;
    }

}
