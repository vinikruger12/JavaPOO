package negocios;

import dados.Compra;
import dados.Produto;
import dados.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    
    List<Produto> produtos = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void cadastrarUsuario(Usuario u){
        usuarios.add(u);
    }

    public void cadastrarProduto(Produto p){
        produtos.add(p);
    }

    public void realizarCompra(Usuario u, Compra c){
        u.adicionarCompra(c);
    }

    public List<Compra> buscarComprasNaoPagasPeloUsuario(Usuario u){
        List<Compra> nPagas = u.getComprasNaoPagas();
        return nPagas;
    }

    public void pagarCompra(Compra c){
        c.pagar();
    }

    //
    public String resumoComprasUsuario(Usuario u){
        List<Compra> com = u.getCompras();
        String s = "";
        for(int i = 0;i < com.size();i++){
            s += com.get(i).toString();
        }
        return s;
    }

    public String toString() {
        return "Loja [ produtos=" + produtos + ", usuarios=" + usuarios + "]";
    }

}
