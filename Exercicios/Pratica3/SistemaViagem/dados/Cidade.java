public class Cidade {
    private String nome;
    private String estado;

    public Cidade(){}

    public String getEstado() {
        return this.estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return "Nome: " + this.nome + ", Estado: " + this.estado;
    }

}
