package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dados.*;
import exceptions.*;


public class ContatoDAO{
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato) throws ContatojaCadastradoException, ErroNaLeituraException, ErroNaEscritaException{
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        
        if(contatos.contains(contato)){
            ContatojaCadastradoException cj = new ContatojaCadastradoException("Contato: " + contato.getNome() + " já está cadastrado");
            throw cj;
        }

        if(contatos == null){
            contatos = new ArrayList<>();
        }
        contatos.add(contato);
        
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public void delete(Contato contato) throws ErroNaLeituraException, ErroNaEscritaException, ContatojaCadastradoException, ContatoNaoCadastradoException{
        List<Contato> contatos = arquivoContatoDAO.leContatos();

        if(!contatos.contains(contato)){
            ContatoNaoCadastradoException cn = new ContatoNaoCadastradoException("O contato " + contato.getNome() + " ainda não foi cadastrado");
            throw cn;
        }

        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }

    public Map<Character, List<Contato>> getAll() throws ErroNaLeituraException{
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
