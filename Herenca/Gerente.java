public class Gerente extends Funcionario{
    private String departamentoGerenciado;
    private String nomeSecretaria;

    public Gerente(){}
    public Gerente(String nome, String cpf, double salario, String depto, String sec){
        super(nome, cpf, salario);
        
    }
}