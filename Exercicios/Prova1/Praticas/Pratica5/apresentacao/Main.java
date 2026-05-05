package Exercicios.Prova1.Praticas.Pratica5.apresentacao;
import java.util.Scanner;
import dados.Contato;
import negocio.ListaTelefonica;
import java.util.List;
import java.util.ArrayList;

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
                    exibirContatos();
                    break;
                case 4:
                    System.out.println("Digite a letra que voce quer buscar nos contatos");    
                    Character c = in.nextLine().toUpperCase().charAt(0);
                    exibirContato(c);
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para criar novo contato");
        System.out.println("Digit 2 para remover contato");
        System.out.println("Digite 3 para exibir os contatos");
        System.out.println("Digite 4 para exibir os contatos a partir da letra");
    }

    public void adicionarContato(){
        Contato contato = new Contato();
        System.out.println("Digite o nome do contato");
        contato.setNome(in.nextLine());
        System.out.println("Digite o telefone do contato");
        contato.setTelefone(in.nextLine());

        lista.adicionarContato(contato);
    }

    public void removerContato(){
        Contato contato = new Contato();
        System.out.println("Digite o nome do contato que voce quer excluir");
        contato.setNome(in.nextLine());
        System.out.println("Digite o telefone do contato que voce quer excluir");
        
        // A LINHA ABAIXO ESTAVA FALTANDO NO SEU CÓDIGO!
        contato.setTelefone(in.nextLine()); 
        
        lista.removerContato(contato);
    }

    public void exibirContatos(){
        for(char i = 'A';i <= 'Z';i++){
            System.out.println(i);
            List<Contato> ccs = lista.buscarContatos((char) (i));
            if(ccs == null){
                System.out.println("-");
                continue;
            }
            for(int j = 0;j < ccs.size();j++){
                System.out.println(ccs.get(j));
            }
        }
    }

    public void exibirContato(Character c){
        System.out.println(c);
        List<Contato> ccs = lista.buscarContatos(c);
        if(ccs == null) System.out.println("Nenhum contato com essa letra");
        for(int j = 0;j < ccs.size();j++){
            System.out.println(ccs.get(j));
        }
    }
    


    
    public static void main(String[] args){
        Main princ = new Main();
        princ.run();
    }
}
