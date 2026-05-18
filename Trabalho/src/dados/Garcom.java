package dados;

public class Garcom {
    private String nome;
    private String cpf;
    private String dataAdmissao;
    private double percentualComissao;

    public String getNome(){
        return nome; 
    }
    public void setNome(String nome){
        this.nome = nome; 
    }

    public String getCpf(){
        return cpf; 
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDataAdmissao(){
        return dataAdmissao; 
    }
    public void setDataAdmissao(String dataAdmissao){
        this.dataAdmissao = dataAdmissao;
    }

    public double getPercentualComissao(){
        return percentualComissao; 
    }
    public void setPercentualComissao(double percentualComissao){
        this.percentualComissao = percentualComissao; 
    }

    
    public String toString(){
        return "GARCOM \n" + "NOME: " + 
        this.nome + "\n" + 
        "CPF: " + this.cpf + "\n" + 
        "Data de admissão: " + this.dataAdmissao + "\n" + 
        "Percentual de comissão: " + this.percentualComissao;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Garcom){
            Garcom g = (Garcom) obj;
            if(this.nome.equals(g.getNome())
                && this.cpf.equals(g.getCpf())
                && this.dataAdmissao.equals(g.getDataAdmissao())
                && this.percentualComissao == g.getPercentualComissao()) return true;
        }
        return false;
    }

    
}