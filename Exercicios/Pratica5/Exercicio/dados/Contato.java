package dados;

public class Contato {

    private String nome;
    private String telefone;

    public Contato(){}

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String toString() {
        return "Contato [nome=" + nome + ", telefone=" + telefone + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Contato){
            Contato c = (Contato) obj;
            if(nome.equals(c.getNome()) && telefone.equals(c.getTelefone())) return true; 
        }
        return false;
    }

    


}
