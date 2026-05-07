package apresentacao;

import dados.*;
import java.util.Scanner;
import negocios.Loja;


public class Principal {
    
    Scanner in = new Scanner(System.in);
    Loja loja = new Loja();

    public void run(){
        boolean flag = true;
        while (flag){ 
            menu();
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    mostrarProdutos();
                    break;
                case 4:
                    fazerCompra();
                    break;
                case 5:
                    userPagaConta();
                    break;
                case 6:
                    mostrarComprasUser();
                default:
                    break;
            }
            
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para adicionar usuario");
        System.out.println("Digite 2 para adicionar produto");
        System.out.println("Digite 3 para mostrar produtos");
        System.out.println("Digite 4 para fazer compra");
        System.out.println("Digite 5 para o usuario pagar a compra");
        System.out.println("Digite 6 para mostrar as compras do usuario");
    }

    public void adicionarUsuario(){
        System.out.println("Digite 1 para usuario normal e 2 para usuario premium");
        int idUser = Integer.parseInt(in.nextLine());
        if(idUser == 1){
            Usuario usuario = new Usuario();
            System.out.println("Digite o nome do usuario");
            usuario.setNome(in.nextLine());

            System.out.println("Digite o cpf do usuario");
            usuario.setCpf(in.nextLine());

            System.out.println("Digite o endereco do usuario");
            usuario.setEndereco(in.nextLine());

            loja.cadastrarUsuario(usuario);
        }
        else{
            UsuarioPremium userP = new UsuarioPremium();
            System.out.println("Digite o nome do usuario premium");
            userP.setNome(in.nextLine());

            System.out.println("Digite o cpf do usuario premium");
            userP.setCpf(in.nextLine());

            System.out.println("Digite o endereco do usuario premium");
            userP.setEndereco(in.nextLine());

            System.out.println("Digite o desconto que o usuario tem");
            userP.setDesconto(Float.parseFloat(in.nextLine()));

            loja.cadastrarUsuario(userP);
        }
    }

    public void adicionarProduto(){

        for(int i = 0;i < TipoProduto.values().length;i++){
            System.out.println("[" + i + "]" + TipoProduto.values()[i]);
        }

        System.out.println("Escolha o indice do tipo do produto");
        int indice = Integer.parseInt(in.nextLine());

        Produto p = new Produto();
        p.setTipo(TipoProduto.values()[indice]);

        System.out.println("Digite o ID do produto");
        p.setId(Integer.parseInt(in.nextLine()));

        System.out.println("Digite o nome do produto");
        p.setNome(in.nextLine());

        System.out.println("Digite a marca do produto");
        p.setMarca(in.nextLine());

        System.out.println("Digite a descricao do produto");
        p.setDescricao(in.nextLine());

        System.out.println("Digite o preco do produto");
        p.setPreco(Float.parseFloat(in.nextLine()));

        loja.cadastrarProduto(p);


    }

    public void mostrarProdutos(){
        for(int i = 0;i < loja.getProdutos().size();i++){
            System.out.println(loja.getProdutos().get(i));
        }
    }

    public void fazerCompra(){
        for(int i = 0;i < loja.getUsuarios().size();i++){
            System.out.println("[" + i + "]" + loja.getUsuarios().get(i));
        }
        System.out.println("Escolha o indice do usuario que irá comprar");
        int indiceU = Integer.parseInt(in.nextLine());

        for(int i = 0;i < loja.getProdutos().size();i++){
            System.out.println("[" + i + "]" + loja.getProdutos().get(i));
        }

        System.out.println("Escolha o indice do produto que irá comprar");
        int indiceP = Integer.parseInt(in.nextLine());


        Compra c = new Compra();

        System.out.println("Digite a data da compra");
        c.setData(in.nextLine());
        System.out.println("Digite a forma de pagamento");
        c.setFormaDePegamentos(in.nextLine());

        Produto p = loja.getProdutos().get(indiceP);

        if(loja.getUsuarios().get(indiceU) instanceof UsuarioPremium){
            UsuarioPremium uP = (UsuarioPremium) loja.getUsuarios().get(indiceU);

            if(p.getTipo().equals(TipoProduto.values()[2]) || p.getTipo().equals(TipoProduto.values()[5]) || p.getTipo().equals(TipoProduto.values()[3])){
                p.setPreco(p.getPreco() - uP.getDesconto());
            }
            c.adicionarProduto(p);
            c.calculaValorTotal();
            loja.realizarCompra(uP, c);
        }
        else{
            Usuario u = loja.getUsuarios().get(indiceU);
            c.adicionarProduto(p);
            c.calculaValorTotal();
            loja.realizarCompra(u, c);
        }
    }

    public void userPagaConta(){
        for(int i = 0;i < loja.getUsuarios().size();i++){
            System.out.println("[" + i + "] " + loja.getUsuarios().get(i));
        }
        System.out.println("Escolha o usuario que vai pagar algum produto");
        int indice = Integer.parseInt(in.nextLine());

        for(int i = 0;i < loja.getUsuarios().get(indice).getComprasNaoPagas().size();i++){
            System.out.println("[" + i + "] " + loja.getUsuarios().get(indice).getComprasNaoPagas().get(i));
        }

        System.out.println("Escolha o indice da compra que voce quer que o usuario pague");
        int idParaPagar = Integer.parseInt(in.nextLine());
        loja.getUsuarios().get(indice).getComprasNaoPagas().get(idParaPagar).pagar();
    }


    public void mostrarComprasUser(){
        for(int i = 0;i < loja.getUsuarios().size();i++){
            System.out.println("[" + i + "] " + loja.getUsuarios().get(i));
        }
        System.out.println("Escolha o usuario para ver seus produtos");
        int indice = Integer.parseInt(in.nextLine());

        for(int i = 0;i < loja.getUsuarios().get(indice).getCompras().size();i++){
            System.out.println("[" + i + "] " + loja.getUsuarios().get(indice).getCompras().get(i));
        }
    }


    
    public static void main(String[] args) {
        Principal princ = new Principal();
        princ.run();   
    }
}

