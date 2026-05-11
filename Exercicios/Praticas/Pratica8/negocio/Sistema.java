package negocio;

import dados.*;
import persistencia.*;
import java.util.List;

public class Sistema {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void adicionarPessoa(Pessoa p){
        pessoaDAO.insert(p);
    }

    public void removerPessoa(Pessoa p){
        pessoaDAO.delete(p);
    }

    public List<Pessoa> getList(){
        return pessoaDAO.getAll();
    }
}
