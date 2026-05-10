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
    private List<ItemCardapio> componentes;

    public ItemCardapio(String codigo, String nome, double preco, CategoriaItem categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = true;
        this.componentes = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getTempoMedioPreparo() { return tempoMedioPreparo; }
    public void setTempoMedioPreparo(int tempoMedioPreparo) { this.tempoMedioPreparo = tempoMedioPreparo; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public CategoriaItem getCategoria() { return categoria; }
    public void setCategoria(CategoriaItem categoria) { this.categoria = categoria; }
    public List<ItemCardapio> getComponentes() { return componentes; }
    public void adicionarComponente(ItemCardapio item) { this.componentes.add(item); }
}