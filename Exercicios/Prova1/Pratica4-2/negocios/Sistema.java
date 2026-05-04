package negocios;
import java.util.ArrayList;
import java.util.List;
import dados.ContaSalario;
import dados.ContaBancaria;
import dados.ContaCorrente;


public class Sistema {
    private int quantidade = 0;
    List<ContaBancaria> contas = new ArrayList<>();

    public void cadastrarConta(ContaBancaria conta){
        contas.add(conta);
    }

    public void realizarSaque(ContaBancaria conta, float valor){
        conta.sacarValor(valor);
    }

    public boolean realizarDeposito(ContaCorrente conta, float valor){
        return conta.depositar(valor);
    }

    public boolean realizarDeposito(ContaSalario conta, float valor, String cnpj){
        return conta.depositar(valor, cnpj);
    }

    public List<ContaBancaria> getContas(){
        return contas;
    }

    public List<ContaCorrente> getContaCorrentes(){
        List<ContaCorrente> correntes = new ArrayList<>();
        for(int i = 0;i < contas.size();i++){
            if(contas.get(i) instanceof ContaCorrente){
                correntes.add((ContaCorrente)contas.get(i));
            }
        }
        return correntes;
    }

    public List<ContaSalario> geContaSalarios(){
        List<ContaSalario> salarios = new ArrayList<>();
        for(int i = 0;i < contas.size();i++){
            if(contas.get(i) instanceof ContaSalario){
                salarios.add((ContaSalario)contas.get(i));
            }
        }
        return salarios;
    }

    public String obterExtrato(ContaBancaria conta){
        return conta.gerarExtrato();
    }

}
