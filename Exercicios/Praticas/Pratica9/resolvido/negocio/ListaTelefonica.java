package negocio;

import java.util.List;
import java.util.Map;
import exceptions.*;
import dados.*;
import persistencia.*;

public class ListaTelefonica {

    public ListaTelefonica(){
    }
    private ContatoDAO contatoDAO = new ContatoDAO();

    public void adicionarContato(Contato contato) throws ContatojaCadastradoException, ErroNaEscritaException, ErroNaLeituraException{
        contatoDAO.insert(contato);
    }

    public void removerContato(Contato contato) throws ContatoNaoCadastradoException, ErroNaLeituraException, ErroNaEscritaException, ContatojaCadastradoException{
        contatoDAO.delete(contato);
    }

    public List<Contato> buscarContatos(char letra) throws ErroNaLeituraException{
        Map<Character, List<Contato>> todosContatos = contatoDAO.getAll();
        
        char letraMaiuscula = Character.toUpperCase(letra);
        return todosContatos.get(letraMaiuscula);
    }

    public Map<Character, List<Contato>> listarContatos() throws ErroNaLeituraException{
        return contatoDAO.getAll();
    }
}