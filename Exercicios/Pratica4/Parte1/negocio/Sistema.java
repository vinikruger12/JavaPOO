package negocio;
import java.util.List;

import Exercicios.Pratica4.Parte1.dados.ContaBancaria;
import Exercicios.Pratica4.Parte1.dados.ContaCorrente;
import Exercicios.Pratica4.Parte1.dados.ContaSalario;

import java.util.ArrayList;
import dados.*;

public class Sistema {
    List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
    private int quantidade = 0;

    public void cadastrarConta(ContaBancaria conta){
        contasBancarias.add(conta);
        quantidade++;
    }

    public boolean realizarSaque(ContaBancaria conta, float valor){
        return conta.sacar(valor) > 0;
    }

    public boolean realizarDeposito(ContaCorrente conta, float valor){
        if(valor > 0){ 
            conta.depositarValor(valor);
            return true;
        }
        return false;
    }

    public boolean realizarDeposito(ContaSalario conta, float valor, String cnpj)
    {        
        if(valor > 0){ 
            conta.depositarValor(valor, cnpj);
            return true;
        }
        return false;
    }

    public List<ContaBancaria> getContasBancarias(){
        return contasBancarias;
    }

    public List<ContaCorrente> getContaCorrentes(){
        List<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
        for(int i = 0;i < quantidade;i++){
            if(contasBancarias.get(i) instanceof ContaCorrente) contasCorrentes.add(contasBancarias.get(i));
        }

        return contasCorrentes;
    }

    public List<ContaSalario> getContaSalarios(){
        List<ContaSalario> contaSalarios = new ArrayList<ContaSalario>();
        for(int i = 0;i < quantidade;i++){
            if(contasBancarias.get(i) instanceof ContaSalario) contaSalarios.add(contasBancarias.get(i));
        }

        return contaSalarios;
    }

    public String obterExtrato(ContaBancaria conta){
        return conta.gerarExtrato();
    }



}
