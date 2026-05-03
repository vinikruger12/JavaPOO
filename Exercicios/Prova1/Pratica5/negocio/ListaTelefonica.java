package negocio;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import dados.*;

public class ListaTelefonica {
    private Map<Character, List<Contato>> listaContatos = new HashMap<>();

    public void adicionarContato(Contato contato){
        Character first = contato.getNome().toUpperCase().charAt(0); 
        List<Contato> contatos = listaContatos.get(first);

        if(contatos == null){
            contatos = new ArrayList<>();
            listaContatos.put(first, contatos);
            // CORREÇÃO: O return que existia aqui foi removido!
        }
        
        contatos.add(contato);
        listaContatos.put(first, contatos);
    }

    public void removerContato(Contato contato){
        Character first = contato.getNome().toUpperCase().charAt(0);
        List<Contato> contatos = listaContatos.get(first);
        List<Contato> contatosNovo = new ArrayList<>();
        
        // CORREÇÃO: Adicionado if para proteger contra NullPointerException
        if(contatos != null){
            for(int i = 0;i < contatos.size();i++){
                if(!(contato.equals(contatos.get(i)))){
                    contatosNovo.add(contatos.get(i));
                }
            }
            // CORREÇÃO: Alterado de 'contatos' para 'contatosNovo'
            listaContatos.put(first, contatosNovo);
        }
    }

    public List<Contato> buscarContatos(Character letra){
        return listaContatos.get(Character.toUpperCase(letra));
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return listaContatos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Lista Telefônica ---\n");
        
        for (char i = 'A'; i <= 'Z'; i++) {
            List<Contato> contatos = listaContatos.get(i);
            
            if (contatos != null && !contatos.isEmpty()) {
                sb.append(i).append(":\n");
                for (Contato c : contatos) {
                    sb.append("  ").append(c.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        ListaTelefonica outraLista = (ListaTelefonica) obj;
        return this.listaContatos.equals(outraLista.listaContatos);
    }
}