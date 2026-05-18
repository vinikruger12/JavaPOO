package persistencia;

import java.util.ArrayList;
import java.util.List;
import dados.*;

public class ArquivoContatoDAO {
    private String caminho = "/Users/viniciuskruger/Documents/Estudos/JavaPOO/Exercicios/Praticas/Pratica8/exercicio/contatos.txt";

    private EditorTexto editarTexto = new EditorTexto();

    private String toCSV(Contato contato){
        String c = contato.getNome() + ",";
        c += contato.getTelefone();

        return c;
    }

    private Contato fromCSV(String s){
        String atributos[] = s.split(",");
        Contato contato = new Contato();

        contato.setNome(atributos[0]);
        contato.setTelefone(atributos[1]);

        return contato;
    }

    private List<Contato> stringToListaContatos(List<String> listaContatos){
        List<Contato> contatos = new ArrayList<Contato>();

        for(String s : listaContatos){
            contatos.add(fromCSV(s));
        }

        return contatos;
    }

    private List<String> listaContatosString(List<Contato> contatos){
        List<String> listaContatos = new ArrayList<>();

        for(Contato c : contatos){
            listaContatos.add(toCSV(c));
        }
        return listaContatos;
    }

    public List<Contato> leContatos(){
        return stringToListaContatos(editarTexto.leTexto(caminho));
    }

    public void salvaContatos(List<Contato> contatos){
        editarTexto.gravaTexto(caminho, listaContatosString(contatos));
    }

  
}
