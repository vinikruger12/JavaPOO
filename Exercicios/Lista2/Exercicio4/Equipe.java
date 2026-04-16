package Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Equipe<T>{
    private String name;
    private List<T> membros = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void adicionarMembro(T membro){
        this.membros.add(membro);
    }

    public String toString(){
        return "A equipe: " + this.name + " tem os membros: " + this.membros;
    };

}
