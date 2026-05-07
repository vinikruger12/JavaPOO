package dados;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    List<Compra> compras = new ArrayList<>();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void adicionarCompra(Compra c){
        compras.add(c);
    }

    public List<Compra> getComprasNaoPagas(){
        List<Compra> listaNPagas = new ArrayList<>();
        for(int i = 0;i < compras.size();i++){
            if(!(compras.get(i).estaPago())) listaNPagas.add(compras.get(i));
        }

        return listaNPagas;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    
    public String toString() {
        return "Usuario [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", compras=" + compras + "]";
    }

    


}
