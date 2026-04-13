package apresentacao;
import java.util.*;
import dados.Contato;
import negocio.ListaTelefonica;


public class Main {
    Scanner in = new Scanner(System.in);
    ListaTelefonica lista = new ListaTelefonica();

    public void run(){
        boolean flag = true;
        while(flag){
            System.out.println("Digite a opção desejada");
            mostrarMenu();
            int x = Integer.parseInt((in.nextLine()));

            switch(x){
                case 0:
                    flag = false;
                    break;
                case 1:
                    contatosNaoRegistrados.add(novoContato());
                    break;
                case 2:
                    adicionarContato();
                    break;
                case 3:
                    removerContato();
                    break;
                case 4:
                    exibirContatos();
                    break;
                case 5:
                    System.out.println("Digite a letra que você deseja buscar");
                    Character c = Character.toUpperCase(in.nextLine().charAt(0));
                    exibirContatosLetra(c);
                default:
                    break;
        }
        }
    }

    public void mostrarMenu(){
        System.out.println("Digite 0 para encerrar");
        System.out.println("Digite 1 para criar novo contato");
        System.out.println("Digite 2 para adicionar contato");
        System.out.println("Digite 3 para remover contato");
        System.out.println("Digite 4 para exibir os contatos");
        System.out.println("Digite 5 para exibir um contato a partir da letra");
    }

    List<Contato> contatosNaoRegistrados = new ArrayList<Contato>();

    public Contato novoContato(){
        Contato user = new Contato();
        System.out.println("Digite o nome do usuário");
        user.setNome(in.nextLine());

        System.out.println("Digite o telefone do usuário");
        user.setTelefone((in.nextLine()));
        
        return user;
    }

    public void adicionarContato(){
        System.out.println("Escolha o ID de um dos contatos criados para adicionar à agenda:");
        
        for(int i = 0; i < contatosNaoRegistrados.size(); i++){
            Contato contato = contatosNaoRegistrados.get(i);
            System.out.println("ID [" + i + "] -> " + contato.getNome() + " (" + contato.getTelefone() + ")");
        }
        
        System.out.print("Digite o ID escolhido: ");
        int index = Integer.parseInt(in.nextLine()); 
        
        Contato contatoEscolhido = contatosNaoRegistrados.get(index);
        
        lista.adicionarContato(contatoEscolhido);
        contatosNaoRegistrados.remove(index);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato(){
        System.out.println("Escolha um dos contatos para remover da sua lista de contatos");
        
        exibirContatos();

        Contato user = new Contato();
        System.out.println("Digite o nome do usuário escolhido");
        user.setNome(in.nextLine());

        System.out.println("Digite o telefone do usuário do usuário escolhido");
        user.setTelefone(in.nextLine());
        
        lista.removerContato(user);
        System.out.println("Comando de remoção enviado.");
    }

    public void exibirContatos(){
        lista.buscarContatos().forEach(
            (chave, contatos) -> {
                System.out.println(chave + ": ");
                for(Contato contato : contatos){
                    System.out.println(contato);
                }
            }
        );
    }

    public void exibirContatosLetra(Character c){
        List<Contato> contatosDaLetra = lista.buscarContatos(c);
        
        if(contatosDaLetra != null){
            for(Contato contato : contatosDaLetra){
                System.out.println(contato);
            }
        }else{
            System.out.println("Nenhum contato encontrado para a letra " + c);
        }
    }



    public static void main(String args[]){
        Main main = new Main();
        main.run();
    }
}
