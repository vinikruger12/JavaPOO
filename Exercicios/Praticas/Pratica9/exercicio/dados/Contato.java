package dados;

public class Contato {
    private String nome;
    private String telefone;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean equals(Object o){
        if(o instanceof Contato){
            Contato c = (Contato) o;
            if(c.getNome().equals(this.nome) 
                && c.getTelefone().equals(this.telefone)) return true;
        }

        return false;
    }

    public String toString() {
        return "Nome: " + nome + " | Telefone: " + telefone;
    }
}
