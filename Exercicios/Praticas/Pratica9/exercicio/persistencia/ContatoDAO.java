package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dados.*;

public class ContatoDAO{
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato){
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        if(contatos == null){
            contatos = new ArrayList<>();
        }
        contatos.add(contato);
        
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public void delete(Contato contato){
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public Map<Character, List<Contato>> getAll(){
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        Map<Character, List<Contato>> mapaContatos = new HashMap<>();

        if (contatos != null) {
            for (Contato c : contatos) {
                if (c.getNome() != null && !c.getNome().isEmpty()) {
                    
                    char inicial = c.getNome().toUpperCase().charAt(0);

                    if(!mapaContatos.containsKey(inicial)) {
                        mapaContatos.put(inicial, new ArrayList<>());
                    }

                    mapaContatos.get(inicial).add(c);
                }
            }
        }

        return mapaContatos;
    }
}
