package apresentacao;

import java.util.List;
import java.util.Scanner;

import dados.*;
import negocio.*;

public class Main {
    
    Scanner in = new Scanner(System.in);
    ListaTelefonica lista = new ListaTelefonica();

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
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContato();
                    break;
                case 4:
                    exibirContatoLetra();
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para adicionar contato");
        System.out.println("Digite 2 para remover contato");
        System.out.println("Digite 3 para exibir contatos");
        System.out.println("Digite 4 para exibir contatos por letra");
    }

    public void adicionarContato(){
        Contato c = new Contato();
        System.out.println("Digite o nome do contato");
        c.setNome(in.nextLine());
        System.out.println("Digite o número do contato");
        c.setTelefone(in.nextLine());

        lista.adicionarContato(c);
    }

    public void removerContato(){
        for(char letra = 'A';letra <= 'Z';letra++){
            System.out.println(letra);
            if(lista.buscarContatos(letra) == null) continue;
            for(int i = 0;i < lista.buscarContatos(letra).size();i++){
                System.out.println("[" + i + "] " + lista.buscarContatos(letra).get(i));
            }
        }

        System.out.println("Digite a letra do contato que você quer apagar");
        Character letra = in.nextLine().charAt(0);
        System.out.println("Digite o índice do contato que você quer apagar");
        int indice = Integer.parseInt(in.nextLine());

        List<Contato> cc = lista.buscarContatos(letra);
        if(cc == null){
            System.out.println("Nenhum com essa letra");
            return;
        }
        Contato novo = cc.get(indice);

        lista.removerContato(novo);
    }

    public void exibirContato(){
        for(char letra = 'A';letra <= 'Z';letra++){
            System.out.println(letra);
            if(lista.buscarContatos(letra) == null || lista.buscarContatos(letra).size() == 0){
                System.out.println('-');
                continue;
            }
            else{
                for(int i = 0;i < lista.buscarContatos(letra).size();i++){
                    System.out.println("[" + i + "] " + lista.buscarContatos(letra).get(i));
                }
            }
        }
    }

    public void exibirContatoLetra(){
        System.out.println("Digite a letra");
        Character letra = in.nextLine().charAt(0);
        List<Contato> cc = lista.buscarContatos(letra);
        if(cc == null){
            System.out.println("Nenhum contato com essa letra");
            return;
        }
        for(int i = 0;i < cc.size();i++){
            System.out.println(cc.get(i));
        }
    }


    public static void main(String[] args){
        Main m = new Main();
        m.run();
    }
}
