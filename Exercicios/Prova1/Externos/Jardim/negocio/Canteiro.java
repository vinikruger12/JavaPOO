package Exercicios.Prova1.Externos.Jardim.negocio;

import java.util.ArrayList;
import java.util.List;

import dados.*;

public class Canteiro {
    protected float areaTotal;
    protected List<Planta> plantas = new ArrayList<>();

    

    public float getAreaTotal() {
        return areaTotal;
    }
    public void setAreaTotal(float areaTotal) {
        this.areaTotal = areaTotal;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public float calcularEspacoDisponivel(){
        float soma = 0;
        for(int i = 0;i < plantas.size();i++){
            soma += plantas.get(i).getEspacoNescessario();
        }
        return this.areaTotal - soma;
    }

    public boolean adicionarPlanta(Planta planta){
        if(this.calcularEspacoDisponivel() < planta.getEspacoNescessario()) return false;
        plantas.add(planta);
        return true;
    }
}
