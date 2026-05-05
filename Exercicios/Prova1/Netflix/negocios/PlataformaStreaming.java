package negocios;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dados.*;

public class PlataformaStreaming {
    private Map<Genero, List<Midia>> catalogo = new HashMap<>();

    public void adicionarMidia(Midia midia){
        if(catalogo.get(midia.getGenero()) != null){
            List<Midia> listaMidias = catalogo.get(midia.getGenero());
            listaMidias.add(midia);
            catalogo.put(midia.getGenero(), listaMidias);
        }
        else{ 
            List<Midia> listaMidias = new ArrayList<>();
            listaMidias.add(midia);
            catalogo.put(midia.getGenero(), listaMidias);
        }
        
    }

    public void removerMidia(Midia midia){
        List<Midia> listaMidias = catalogo.get(midia.getGenero());
        
        if(listaMidias != null){
            listaMidias.remove(midia);

            if(listaMidias.size() == 0){
                catalogo.remove(midia.getGenero());
            }
        }
    } 

    public List<Midia> buscarPorGenero(Genero g){
        return catalogo.get(g);
    }

    public void mostrarCatalogo(){
        for(int i = 0;i < Genero.values().length;i++){
            System.out.println(Genero.values()[i]);
            if(catalogo.get(Genero.values()[i]) == null) System.out.println("Nenhum filme desse gênero");
            else{
                List<Midia> midias = catalogo.get(Genero.values()[i]);
                for(int j = 0;j < midias.size();j++){
                    System.out.println(midias.get(j));
                }
            }
        }
    }

}
