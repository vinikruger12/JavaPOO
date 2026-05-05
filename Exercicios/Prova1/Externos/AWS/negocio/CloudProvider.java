package Exercicios.Prova1.Externos.AWS.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import dados.*;

public class CloudProvider {
    private Map<String, ZeroDisponibilidade> zonas = new HashMap<>();

    public Map<String, ZeroDisponibilidade> getZonas() {
        return zonas;
    }

    public void cadastrarZona(String id, ZeroDisponibilidade z){
        zonas.put(id, z);
    }

    public void fazerDeploy(String id, MaquinaVirtual m){
        zonas.get(id).alocarMaquina(m);
    }

    public List<Container> obterApenasConteiContainers(){
        List<Container> containers = new ArrayList<>();
        for(String id : zonas.keySet()){
            for(int i = 0;i < zonas.get(id).getMaquinas().size();i++){
                if(zonas.get(id).getMaquinas().get(i) instanceof Container) containers.add(zonas.get(id).getMaquinas().get(i));
            }
        }
        return containers;
    }

}
