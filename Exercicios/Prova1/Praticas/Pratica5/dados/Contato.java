package Exercicios.Prova1.Praticas.Pratica5.dados;

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

    @Override
    public String toString() {
        return nome + ": " + telefone;
    }

    @Override
    public boolean equals(Object obj) {
        // Se for o exato mesmo espaço de memória, é igual
        if (this == obj) return true;
        // Se for nulo ou de uma classe diferente, não é igual
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Faz o cast para comparar os atributos
        Contato outroContato = (Contato) obj;
        
        // Retorna true se nome e telefone forem iguais
        return this.nome.equals(outroContato.getNome()) && 
               this.telefone.equals(outroContato.getTelefone());
    }

}
