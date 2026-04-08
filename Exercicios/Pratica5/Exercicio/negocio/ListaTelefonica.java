package negocio;
import dados.Contato;
import java.util.*;

public class ListaTelefonica {
    private Map<Character, List<Contato>> listaDeContatos = new HashMap<Character, List<Contato>>();

    public void adicionarContato(Contato contato){
        Character letra = Character.valueOf(contato.getNome().charAt(0));
        
        if(this.listaDeContatos.get(letra) == null){
            List<Contato> novaLista = new ArrayList<Contato>();
            novaLista.add(contato);
            this.listaDeContatos.put((letra), novaLista);
            return;
        }

        List<Contato> listaAntiga = this.listaDeContatos.get(letra);
        listaAntiga.add(contato);
        this.listaDeContatos.put((letra), listaAntiga);

    }

    public void removerContato(Contato contato){
        Character letra = Character.valueOf(contato.getNome().charAt(0));

        if(this.listaDeContatos.get(letra) == null) return;
        this.listaDeContatos.get(letra).remove(contato);
    }

    public List<Contato> buscarContatos(Character letra){
        return this.listaDeContatos.get(letra);
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return this.listaDeContatos;
    }

}
