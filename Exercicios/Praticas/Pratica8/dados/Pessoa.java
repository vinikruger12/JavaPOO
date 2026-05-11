package dados;

public class Pessoa {
    private String nome;
    private int idade;
    private float massa;
    private float altura;

    public Pessoa() {
    } 

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getMassa() {
        return massa;
    }
    public void setMassa(float massa) {
        this.massa = massa;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculaIMC() {
        return this.massa / (this.altura * this.altura);
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", massa=" + massa + ", altura=" + altura + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + idade;
        result = prime * result + Float.floatToIntBits(massa);
        result = prime * result + Float.floatToIntBits(altura);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idade != other.idade)
            return false;
        if (Float.floatToIntBits(massa) != Float.floatToIntBits(other.massa))
            return false;
        if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
            return false;
        return true;
    }
}
