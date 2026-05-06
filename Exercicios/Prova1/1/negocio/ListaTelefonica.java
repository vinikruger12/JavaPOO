package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import dados.*;

public class ListaTelefonica {
    
    private Map<Character, List<Contato>> contatos = new HashMap<>();
    
    public void adicionarContato(Contato contato){
        if(contatos.get(contato.getNome().toUpperCase().charAt(0)) == null){
            List<Contato> cc = new ArrayList<>();
            cc.add(contato);
            contatos.put(contato.getNome().toUpperCase().charAt(0), cc);
            return;
        }

            List<Contato> cc = contatos.get(contato.getNome().toUpperCase().charAt(0));
            cc.add(contato);
            contatos.put(contato.getNome().toUpperCase().charAt(0), cc);
    }
    

    public void removerContato(Contato contato){
        contatos.get(contato.getNome().toUpperCase().charAt(0)).remove(contato);
    }

    public List<Contato> buscarContatos(Character letra){
        List<Contato> c = new ArrayList<>();
        Character indice = letra.toUpperCase(letra);

        if(contatos.get(indice) == null) return null;

        for(int i = 0;i < contatos.get(indice).size();i++){
            c.add(contatos.get(indice).get(i));
        }
        
        return c;
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return this.contatos;
    }

}
