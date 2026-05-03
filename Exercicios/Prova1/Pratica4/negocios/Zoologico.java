package negocios;
import java.util.ArrayList;
import java.util.List;
import dados.*;

public class Zoologico {
    private List<Animal> animais = new ArrayList<>();
    private List<Viveiro> viveiros = new ArrayList<>();

    public void cadastrarViveiro(Viveiro viveiro){
        viveiros.add(viveiro);
    }

    public void cadastrarAnimal(Animal animal){
        animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
        return viveiro.adicionarAnimal(animal);
    }

    public List<Aquario> getAquarios(){
        List<Aquario> listaAquarios = new ArrayList<>();
        for(int i = 0;i < viveiros.size();i++){
            if(viveiros.get(i) instanceof Aquario){
                listaAquarios.add((Aquario) viveiros.get(i));
            }
        }

        return listaAquarios;
    }

    public List<Viveiro> getViveiros(){
        List<Viveiro> listaViveiros = new ArrayList<>();
        for(int i = 0;i < viveiros.size();i++){
            if(viveiros.get(i) instanceof Viveiro && !(viveiros.get(i) instanceof Aquario)){
                listaViveiros.add(viveiros.get(i));
            }
        }

        return listaViveiros;
    }



}
