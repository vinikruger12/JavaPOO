package negocio;

import java.util.List;
import java.util.Map;
import dados.*;
import persistencia.*;

public class ListaTelefonica {

    public ListaTelefonica(){
    }
    private ContatoDAO contatoDAO = new ContatoDAO();

    public void adicionarContato(Contato contato) {
        contatoDAO.insert(contato);
    }

    public void removerContato(Contato contato) {
        contatoDAO.delete(contato);
    }

    public List<Contato> buscarContatos(char letra) {
        Map<Character, List<Contato>> todosContatos = contatoDAO.getAll();
        
        char letraMaiuscula = Character.toUpperCase(letra);
        return todosContatos.get(letraMaiuscula);
    }

    public Map<Character, List<Contato>> listarContatos() {
        return contatoDAO.getAll();
    }
}