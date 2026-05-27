package apresentacao;

import java.util.*;

import dados.*;
import exceptions.*;
import negocio.*;

public class Main {
    Scanner in = new Scanner(System.in);
    ListaTelefonica listaTelefonica = new ListaTelefonica(); 

    void run(){
        boolean flag = true;
        
        while (flag) {
            menu();
            int x = Integer.parseInt(in.nextLine());

            switch (x) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    try{
                        adicionarContato();
                    }
                    catch(ContatojaCadastradoException cj){
                        System.err.println(cj.getMessage());
                    }
                    catch(ErroNaLeituraException el){
                        System.err.println(el.getMessage());
                    }
                    catch(ErroNaEscritaException eg){
                        System.err.println(eg.getMessage());
                    }
                    break;
                case 2:
                    try{
                        removerContato();
                    }
                    catch(ContatoNaoCadastradoException cn){
                        System.err.println(cn.getMessage());
                    }
                    catch(ContatojaCadastradoException cj){
                        System.err.println(cj.getMessage());
                    }
                    catch(ErroNaLeituraException el){
                        System.err.println(el.getMessage());
                    }
                    catch(ErroNaEscritaException eg){
                        System.err.println(eg.getMessage());
                    }
                    break;
                case 3:
                    try{
                        exibirContatos();
                    }
                    catch(ErroNaLeituraException el){
                        System.err.println(el.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    void menu(){
        System.out.println("\n--- MENU ---");
        System.out.println("Digite 0 para encerrar");
        System.out.println("Digite 1 para adicionar um novo contato");
        System.out.println("Digite 2 para remover um contato");
        System.out.println("Digite 3 para exibir todos os contatos");
    }

    public void adicionarContato() throws ErroNaEscritaException, ErroNaLeituraException, ContatojaCadastradoException{
        Contato user = new Contato();
        
        System.out.println("Digite o nome do contato:");
        user.setNome(in.nextLine());

        System.out.println("Digite o telefone do contato (apenas números):");
        user.setTelefone(in.nextLine()); 
        
        listaTelefonica.adicionarContato(user);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato() throws ErroNaEscritaException, ErroNaLeituraException, ContatoNaoCadastradoException, ContatojaCadastradoException{
        System.out.println("\n--- Remoção de Contato ---");
        exibirContatos();

        Contato user = new Contato();
        System.out.println("Digite o nome exato do contato que deseja remover:");
        user.setNome(in.nextLine());

        System.out.println("Digite o telefone exato do contato escolhido:");
        user.setTelefone(in.nextLine()); 
        
        listaTelefonica.removerContato(user);
        System.out.println("Comando de remoção concluído.");
    }

    public void exibirContatos() throws ErroNaLeituraException{
        Map<Character, List<Contato>> mapa = listaTelefonica.listarContatos(); 
        
        if (mapa == null || mapa.isEmpty()) {
            System.out.println("A agenda está vazia.");
            return;
        }

        mapa.forEach((chave, contatos) -> {
            System.out.println("\n[" + chave + "]: ");
            for (Contato contato : contatos) {
                System.out.println("  " + contato); 
            }
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}