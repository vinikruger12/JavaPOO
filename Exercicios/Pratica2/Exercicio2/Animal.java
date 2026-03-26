public class Animal {
    private String nome;
    private Dono dono;
    private String especie;
    private String descricao;

    public Animal(){}

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }
    public Dono getDono() {
        return this.dono;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getEspecie() {
        return especie;
    }

}
