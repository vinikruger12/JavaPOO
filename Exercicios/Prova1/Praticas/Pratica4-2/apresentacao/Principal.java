package apresentacao;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import dados.*;
import negocios.*;

public class Principal {
    
    Scanner in = new Scanner(System.in);
    Sistema sistema = new Sistema();

    public void run(){
        boolean flag = true;
        while(flag){
            menu();
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarContaCorrente();
                    break;
                case 2:
                    adicionarContaSalario();
                    break; 
                case 3:
                    adicionarValor();
                    break;
                case 4:
                    sacarValor();
                    break;
                case 5:
                    mostrarTodos();
                    break;
                case 6:
                    mostrarCorrentes();
                    break;
                case 7:
                    mostrarSalarios();
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para adicionar conta corrente");
        System.out.println("Digite 2 para adicionar conta salário");
        System.out.println("Digite 3 para adicionar valor em alguma conta");
        System.out.println("Digite 4 para sacar valor de alguma conta");
        System.out.println("Digite 5 para mostrar todas as contas");
        System.out.println("Digite 6 para mostrar as conta corrente");
        System.out.println("Digite 7 para mostrar as conta salários");

    }

    public void adicionarContaCorrente(){
        ContaBancaria contaCorrente = new ContaCorrente();
        System.out.println("Digite o cpf da conta");
        contaCorrente.setCpf(in.nextLine());
        System.out.println("Digite o saldo presente na conta");
        contaCorrente.setSaldo(Float.parseFloat(in.nextLine()));

        sistema.cadastrarConta(contaCorrente);
    }

    public void adicionarContaSalario(){
        ContaSalario contaSalario = new ContaSalario();
        System.out.println("Digite o cnpj da conta");
        contaSalario.setCnpjEmpresa(in.nextLine());
        System.out.println("Digite o saldo presente na conta");
        contaSalario.setSaldo(Float.parseFloat(in.nextLine()));
        
        sistema.cadastrarConta(contaSalario);
    }

    public void adicionarValor(){
        mostrarTodos();

        System.out.println("Digite 1 para conta corrente e 2 para conta salário");
        int which = Integer.parseInt(in.nextLine());
        if(which == 1){

            mostrarCorrentes();
            System.out.println("Escolha o indíce de qual conta você quer adicionar valor");
            int indice = Integer.parseInt(in.nextLine());
            List<ContaCorrente> contas = sistema.getContaCorrentes();

            System.out.println("Digite o valor que você quer adicionar");
            float valor = Float.parseFloat(in.nextLine());

            sistema.realizarDeposito(contas.get(indice), valor);
        }
        else if(which == 2){

            mostrarSalarios();
            System.out.println("Escolha o indíce de qual conta você quer adicionar valor");
            int indice = Integer.parseInt(in.nextLine());
            List<ContaSalario> contas = sistema.geContaSalarios();

            System.out.println("Digite o valor que você quer adicionar");
            float valor = Float.parseFloat(in.nextLine());

            sistema.realizarDeposito(contas.get(indice), valor, contas.get(indice).getCnpjEmpresa());
        }
    }

    public void sacarValor(){
        
        mostrarTodos();

        System.out.println("Digite 1 para conta corrente e 2 para conta salário");
        int which = Integer.parseInt(in.nextLine());
        if(which == 1){

            mostrarCorrentes();
            System.out.println("Escolha o indíce de qual conta você quer sacar valor");
            int indice = Integer.parseInt(in.nextLine());
            List<ContaCorrente> contas = sistema.getContaCorrentes();

            System.out.println("Digite o valor que você quer adicionar");
            float valor = Float.parseFloat(in.nextLine());

            sistema.realizarSaque(contas.get(indice), valor);
        }
        else if(which == 2){

            mostrarSalarios();
            System.out.println("Escolha o indíce de qual conta você quer adicionar valor");
            int indice = Integer.parseInt(in.nextLine());
            List<ContaSalario> contas = sistema.geContaSalarios();

            System.out.println("Digite o valor que você sacar adicionar");
            float valor = Float.parseFloat(in.nextLine());

            sistema.realizarSaque(contas.get(indice), valor);
        }
    }


    public void mostrarSalarios(){
        List<ContaSalario> contas = sistema.geContaSalarios();
        if(contas.size() == 0){
            System.out.println("Nenhuma conta salário adicionada");
            return;
        }

        for(int i = 0;i < contas.size();i++){
            System.out.println("[" + i + "] " + contas.get(i).gerarExtrato());
        }
    }

    public void mostrarCorrentes(){
        List<ContaCorrente> contas = sistema.getContaCorrentes();
        if(contas.size() == 0){
            System.out.println("Nenhuma conta corrente adicionada");
            return;
        }

        for(int i = 0;i < contas.size();i++){
            System.out.println("[" + i + "] " + contas.get(i).gerarExtrato());
        }
    }

    public void mostrarTodos(){
        System.out.println("Contas salários");
        mostrarSalarios();
        System.out.println("Contas correntes");
        mostrarCorrentes();
    }
    
    public static void main(String[] args){
        Principal princ = new Principal();
        princ.run();
    }
}
