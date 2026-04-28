package Exercicios.Lista1.Exercicio1e2;
public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String estado;

    public Endereco(){}
    public Endereco(String rua, int numero, String cidade, String estado){
        this.cidade = cidade;
        this.rua = rua;
        this.estado = estado;
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getCidade() {
        return this.cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return this.estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return this.numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getRua() {
        return this.rua;
    }

    public String toString(){
        return  "Rua: " + this.rua + " .Numero: " + this.numero + " .Cidade: " + this.cidade + " .Estado: " + this.estado;
    }

    public boolean equals(Object o){
        if(o instanceof Endereco){
            Endereco v = (Endereco) o;
            if(this.rua.equals(v.getRua())
            && this.numero == v.getNumero() 
            && this.cidade.equals(v.getCidade())
            && this.estado.equals(v.getEstado())) return true;
        }
        return false;
    }

}
