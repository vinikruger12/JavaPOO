package dados;
import java.time.LocalDate;

public class Garcom {
    private String nome;
    private String cpf;
    private LocalDate dataAdmissao;
    private double percentualComissao;

    public Garcom(String nome, String cpf, LocalDate data, double comissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = data;
        this.percentualComissao = comissao;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }
    public double getPercentualComissao() { return percentualComissao; }
    public void setPercentualComissao(double percentualComissao) { this.percentualComissao = percentualComissao; }
}