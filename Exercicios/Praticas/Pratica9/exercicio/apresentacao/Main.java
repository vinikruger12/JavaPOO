package apresentacao;

import java.util.*;
import dados.*;
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
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
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

    public void adicionarContato() {
        Contato user = new Contato();
        
        System.out.println("Digite o nome do contato:");
        user.setNome(in.nextLine());

        System.out.println("Digite o telefone do contato (apenas números):");
        user.setTelefone(in.nextLine()); 
        
        listaTelefonica.adicionarContato(user);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato() {
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

    public void exibirContatos() {
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