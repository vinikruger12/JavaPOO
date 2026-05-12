package dados;
import java.util.ArrayList;
import java.util.List;

public class ItemCardapio {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int tempoMedioPreparo;
    private boolean disponivel;
    private CategoriaItem categoria;
    private List<ItemCardapio> componentes = new ArrayList<>();

    

    public String getCodigo(){
        return codigo; 
    }
    public void setCodigo(String codigo){
        this.codigo = codigo; 
    }
    public String getNome(){
        return nome; 
    }
    public void setNome(String nome){
        this.nome = nome; 
    }
    public String getDescricao(){
        return descricao; 
    }
    public void setDescricao(String descricao){
        this.descricao = descricao; 
    }
    public double getPreco(){
        return preco; 
    }
    public void setPreco(double preco){
        this.preco = preco; 
    }
    public int getTempoMedioPreparo(){
        return tempoMedioPreparo; 
    }
    public void setTempoMedioPreparo(int tempoMedioPreparo){
        this.tempoMedioPreparo = tempoMedioPreparo; 
    }
    public boolean isDisponivel(){
        return disponivel; 
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel; 
    }
    public CategoriaItem getCategoria(){
        return categoria; 
    }
    public void setCategoria(CategoriaItem categoria){
        this.categoria = categoria; 
    }
    public List<ItemCardapio> getComponentes(){
        return componentes; 
    }
    public void adicionarComponente(ItemCardapio item){
        this.componentes.add(item); 
    }

    public String toString() {
        return "ITEM CARDAPIO \n" + "CÓDIGO: " + this.codigo + "\n" + 
        "NOME: " + this.nome + "\n" + "DESCRIÇÃO: " + this.descricao + "\n" +
        "PREÇO: " + this.preco + "\n" + "TEMPO: " + this.tempoMedioPreparo + "\n" +
        "DISPONÍVEL: " + this.disponivel + "\n" + "CATEGORIA: " + this.categoria.getCategoriaItem();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ItemCardapio) {
            ItemCardapio i = (ItemCardapio) obj;
            if (this.codigo.equals(i.getCodigo())
                && this.nome.equals(i.getNome())
                && this.preco == i.getPreco()
                && this.categoria == i.getCategoria()) return true;
        }
        return false;
    }
}