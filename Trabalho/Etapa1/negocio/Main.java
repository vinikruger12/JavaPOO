package negocio;

import dados.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Scanner in = new Scanner(System.in);
    Sistema sistema = new Sistema();

    void menu() {
        System.out.println("\n========== SISTEMA DE GESTÃO DE RESTAURANTE ==========");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para cadastrar mesa");
        System.out.println("Digite 2 para cadastrar garçom");
        System.out.println("Digite 3 para cadastrar item no cardápio");
        System.out.println("Digite 4 para buscar mesa livre");
        System.out.println("Digite 5 para fazer uma reserva");
        System.out.println("Digite 6 para abrir um pedido (Mesa)");
        System.out.println("Digite 7 para adicionar item ao pedido");
        System.out.println("Digite 8 para fechar conta e pagar");
        System.out.println("Digite 9 para mostrar todas as mesas");
        System.out.println("Digite 10 para mostrar todos os garçons"); 
        System.out.println("Digite 11 para mostrar todos os itens do cardápio"); 
        System.out.println("======================================================");
        System.out.print("Escolha uma opção: ");
    }

    void run(){

        boolean flag = true;

        while (flag) {
            menu();
            int opcao = Integer.parseInt(in.nextLine());

            switch (opcao) {
                case 0:
                    flag = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                case 1:
                    cadastrarMesa();
                    break;
                case 2:
                    cadastrarGarcom();
                    break;
                case 3:
                    cadastrarItemCardapio();
                    break;
                case 4:
                    buscarMesaDisponivel();
                    break;
                case 5:
                    fazerReserva();
                    break;
                case 6:
                    abrirPedido();
                    break;
                case 7:
                    adicionarItemAoPedido();
                    break;
                case 8:
                    fecharContaEPagar();
                    break;
                case 9:
                    mostrarTodasAsMesas();
                    break;
                case 10:
                    mostrarTodosOsGarcons();
                    break;
                case 11:
                    mostrarTodosOsItensCardapio();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    

    public void cadastrarMesa() {
        Mesa m = new Mesa();
        System.out.println("\n--- Cadastro de Mesa ---");

        System.out.print("Digite o número da mesa: ");
        m.setNumero(Integer.parseInt(in.nextLine()));

        System.out.print("Digite a capacidade de pessoas: ");
        m.setCapacidadePessoas(Integer.parseInt(in.nextLine()));

        System.out.println("Escolha a localização: [0] Salão | [1] Varanda | [2] Mezanino");
        int loc = Integer.parseInt(in.nextLine());
        if (loc == 1) m.setLocalizacao(LocalizacaoMesa.VARANDA);
        else if (loc == 2) m.setLocalizacao(LocalizacaoMesa.MEZANINO);
        else m.setLocalizacao(LocalizacaoMesa.SALAO);

        sistema.cadastrarMesa(m);
        System.out.println("Mesa cadastrada com sucesso!");
    }

    public void cadastrarGarcom() {
        Garcom g = new Garcom();
        System.out.println("\n--- Cadastro de Garçom ---");

        System.out.print("Digite o nome: ");
        g.setNome(in.nextLine());

        System.out.print("Digite o CPF: ");
        g.setCpf(in.nextLine());

        System.out.print("Digite a data de admissão: ");
        g.setDataAdmissao(in.nextLine());

        System.out.print("Digite o percentual de comissão (ex: 0.10 para 10%): ");
        g.setPercentualComissao(Double.parseDouble(in.nextLine()));

        sistema.cadastrarGarcom(g);
        System.out.println("Garçom cadastrado com sucesso!");
    }

    public void cadastrarItemCardapio() {
        ItemCardapio item = new ItemCardapio();
        System.out.println("\n--- Cadastro de Item no Cardápio ---");

        System.out.print("Digite o código: ");
        item.setCodigo(in.nextLine());

        System.out.print("Digite o nome: ");
        item.setNome(in.nextLine());

        System.out.print("Digite a descrição: ");
        item.setDescricao(in.nextLine());

        System.out.print("Digite o preço: R$ ");
        item.setPreco(Double.parseDouble(in.nextLine()));

        System.out.print("Digite o tempo médio de preparo (minutos): ");
        item.setTempoMedioPreparo(Integer.parseInt(in.nextLine()));

        item.setDisponivel(true); 

        System.out.println("Escolha a categoria:");
        System.out.println("[0] Entradas | [1] Pratos Principais | [2] Sobremesas | [3] Bebidas | [4] Bebidas Alcoólicas");
        int cat = Integer.parseInt(in.nextLine());
        switch (cat) {
            case 0: item.setCategoria(CategoriaItem.ENTRADAS); break;
            case 1: item.setCategoria(CategoriaItem.PRATOS_PRINCIPAIS); break;
            case 2: item.setCategoria(CategoriaItem.SOBREMESAS); break;
            case 4: item.setCategoria(CategoriaItem.BEBIDAS_ALCOOLICAS); break;
            default: item.setCategoria(CategoriaItem.BEBIDAS_NAO_ALCOOLICAS); break;
        }

        sistema.cadastrarItemCardapio(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    public void buscarMesaDisponivel() {
        System.out.println("\n--- Buscar Mesa Livre ---");
        System.out.print("Capacidade mínima desejada: ");
        int cap = Integer.parseInt(in.nextLine());

        System.out.print("Data (ex: 15/05/2026): ");
        String data = in.nextLine();

        System.out.print("Hora (ex: 20:00): ");
        String hora = in.nextLine();

        List<Mesa> livres = sistema.buscarMesaDisponivel(cap, data, hora);
        
        if (livres.isEmpty()) {
            System.out.println("Nenhuma mesa livre encontrada para este horário/capacidade.");
        } else {
            System.out.println("Mesas Livres:");
            for (Mesa m : livres) {
                System.out.println("- Mesa " + m.getNumero() + " (" + m.getLocalizacao().getLocalizacaoMesa() + ") - " + m.getCapacidadePessoas() + " pessoas");
            }
        }
    }

    public void fazerReserva() {
        Reserva r = new Reserva();
        System.out.println("\n--- Fazer Reserva ---");

        System.out.print("Nome do cliente: ");
        r.setNomeCliente(in.nextLine());

        System.out.print("Telefone: ");
        r.setTelefone(in.nextLine());

        System.out.print("Data: ");
        r.setData(in.nextLine());

        System.out.print("Hora: ");
        r.setHora(in.nextLine());

        System.out.print("Número de Pessoas: ");
        r.setNumeroPessoas(Integer.parseInt(in.nextLine()));

        System.out.print("Observações: ");
        r.setObservacoes(in.nextLine());

        r.setStatus(StatusReserva.PENDENTE); 

        // Listando e escolhendo a mesa
        List<Mesa> mesas = sistema.getMesas();
        if (mesas.isEmpty()) {
            System.out.println("Não há mesas cadastradas no sistema!");
            return;
        }

        System.out.println("Escolha a mesa para a reserva:");
        for (int i = 0; i < mesas.size(); i++) {
            System.out.println("[" + i + "] Mesa " + mesas.get(i).getNumero());
        }
        int numMesa = Integer.parseInt(in.nextLine());
        List<Mesa> mesasReserva = new ArrayList<>();
        mesasReserva.add(mesas.get(numMesa));
        r.setMesas(mesasReserva);

        sistema.fazerReserva(r);
        System.out.println("Reserva realizada com sucesso!");
    }

    public void abrirPedido() {
        Pedido p = new Pedido();
        System.out.println("\n--- Abrir Pedido ---");

        
        List<Mesa> mesas = sistema.getMesas();
        System.out.println("Escolha a mesa do pedido:");
        for (int i = 0; i < mesas.size(); i++) {
            System.out.println("[" + i + "] Mesa " + mesas.get(i).getNumero());
        }
        int numMesa = Integer.parseInt(in.nextLine());
        p.setMesa(mesas.get(numMesa));

       
        List<Garcom> garcons = sistema.getGarcons();
        System.out.println("Escolha o garçom:");
        for (int i = 0; i < garcons.size(); i++) {
            System.out.println("[" + i + "] " + garcons.get(i).getNome());
        }
        int numGarcom = Integer.parseInt(in.nextLine());
        p.setGarcom(garcons.get(numGarcom));

        sistema.abrirPedido(p);
        System.out.println("Pedido aberto na mesa " + p.getMesa().getNumero() + "!");
    }

    public void adicionarItemAoPedido() {
        List<Pedido> pedidos = sistema.getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos abertos!");
            return;
        }

        System.out.println("\n--- Adicionar Item ao Pedido ---");
        System.out.println("Escolha o pedido (pela mesa):");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("[" + i + "] Mesa " + pedidos.get(i).getMesa().getNumero());
        }
        int numPedido = Integer.parseInt(in.nextLine());
        Pedido pedido = pedidos.get(numPedido);

        List<ItemCardapio> cardapio = sistema.getItensCardapio();
        System.out.println("Escolha o item do cardápio:");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println("[" + i + "] " + cardapio.get(i).getNome() + " - R$" + cardapio.get(i).getPreco());
        }
        int numItem = Integer.parseInt(in.nextLine());

        ItemPedido itemP = new ItemPedido();
        itemP.setItemCardapio(cardapio.get(numItem));
        
        System.out.print("Quantidade: ");
        itemP.setQuantidade(Integer.parseInt(in.nextLine()));
        
        System.out.print("Observações (ex: sem cebola) ");
        itemP.setObservacoesCliente(in.nextLine());
        
        itemP.setStatusPreparo(StatusItemPedido.AGUARDANDO_PREPARO); 

        sistema.adicionarItemAoPedido(itemP, pedido);
        System.out.println("Item adicionado ao pedido com sucesso!");
    }

    public void fecharContaEPagar() {
        List<Pedido> pedidos = sistema.getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para pagar!");
            return;
        }

        System.out.println("\n--- Fechar Conta ---");
        System.out.println("Escolha o pedido para encerrar:");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("[" + i + "] Mesa " + pedidos.get(i).getMesa().getNumero());
        }
        int numPedido = Integer.parseInt(in.nextLine());
        Pedido pedido = pedidos.get(numPedido);

        System.out.println("Incluir taxa de serviço de 10%? (1 = Sim, 0 = Não):");
        boolean comTaxa = Integer.parseInt(in.nextLine()) == 1;

        double total = sistema.fecharConta(pedido, comTaxa);
        System.out.println("Total a pagar: R$ " + total);

        Pagamento pag = new Pagamento();
        pag.setValorPago(total);
        pag.setDataHora("Agora");

        System.out.println("Forma de Pagamento: [0] Dinheiro | [1] Crédito | [2] Débito | [3] PIX");
        int forma = Integer.parseInt(in.nextLine());
        if (forma == 0) pag.setFormaUtilizada(FormaPagamento.DINHEIRO);
        else if (forma == 1) pag.setFormaUtilizada(FormaPagamento.CARTAO_CREDITO);
        else if (forma == 2) pag.setFormaUtilizada(FormaPagamento.CARTAO_DEBITO);
        else pag.setFormaUtilizada(FormaPagamento.PIX);

        sistema.receberPagamento(pag, pedido);
        System.out.println("Pagamento registrado com sucesso. Conta finalizada!");
    }

    public void mostrarTodasAsMesas() {
        List<Mesa> mesas = sistema.getMesas();
        System.out.println("\n--- Lista de Mesas Cadastradas ---");
        
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa cadastrada no sistema.");
            return;
        }

        for (int i = 0; i < mesas.size(); i++) {
            Mesa m = mesas.get(i);
            System.out.println("[" + i + "] \n" + m);
            System.out.println("-------------------------");
        }
    }

    public void mostrarTodosOsGarcons() {
        List<Garcom> garcons = sistema.getGarcons();
        System.out.println("\n--- Lista de Garçons Cadastrados ---");
        
        if (garcons.isEmpty()) {
            System.out.println("Nenhum garçom cadastrado no sistema.");
            return;
        }

        for (int i = 0; i < garcons.size(); i++) {
            Garcom g = garcons.get(i);
            System.out.println("[" + i + "] \n" + g); 
            System.out.println("-------------------------");
        }
    }

    public void mostrarTodosOsItensCardapio() {
        List<ItemCardapio> itens = sistema.getItensCardapio();
        System.out.println("\n--- Cardápio Completo ---");
        
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado no cardápio.");
            return;
        }

        for (int i = 0; i < itens.size(); i++) {
            ItemCardapio item = itens.get(i);
            System.out.println("[" + i + "] \n" + item);
            System.out.println("-------------------------");
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}