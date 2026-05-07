package dados;

public class Produto {
    private int id;
    private String nome;
    private String marca;
    private String descricao;
    private float preco;
    private TipoProduto tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", marca=" + marca + ", descricao=" + descricao + ", preco="
                + preco + ", tipo=" + tipo + "]";
    }
    
    
}
