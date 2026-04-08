package dados;

public class Contato {


    private String nome;
    private int telefone;

    public Contato(){}

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return this.telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    
    public String toString() {
        return "Contato [nome=" + nome + ", telefone=" + telefone + ", toString()=" + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;        
        if (obj == null || getClass() != obj.getClass()) return false;        
        Contato outroContato = (Contato) obj;
        
        return this.telefone == outroContato.telefone && this.nome.equals(outroContato.nome);
    }

    


}
