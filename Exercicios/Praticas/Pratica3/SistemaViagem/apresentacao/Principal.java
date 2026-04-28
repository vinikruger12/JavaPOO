package apresentacao;
import negocio.*;
import dados.*;
import java.util.Scanner;

public class Principal {

    private ReservaPassagem reservaPassagem = new ReservaPassagem();
    private Scanner in = new Scanner(System.in);
    
    public void run(){
        boolean flag = true;
        char opcao = 0;
        while(flag){
            opcao = mostrarMenu();
            
           switch(opcao){
            case '0':
                flag = false;
                break;
            case '1':
                cadastrarCidade();
                break;
            case '2':
                cadastrarCliente();
                break;
            case '3':
                cadastrarIda();
                break;
            case '4':
                cadastrarVolta();
                break;
            case '5':
                mostrarReservas();
                break;
            case '6':
                mostrarCidades();
                break;
            case '7':
                mostrarClientes();
                break;
           }
        }
    }

    public char mostrarMenu(){
        System.out.println("Bem-vindo ao menu do sistema");
        System.out.println("0: Sair");
        System.out.println("1: Cadastrar Cidade");
        System.out.println("2: Cadastrar Cliente");
        System.out.println("3: Reservar Ida");
        System.out.println("4: Reservar Volta");
        System.out.println("5: Mostrar Reservas");
        System.out.println("6: Mostrar Cidades");
        System.out.println("7: Mostrar Clientes");
        System.out.println("Digite o número da opção desejada");
        return in.nextLine().charAt(0);
    }

    public void cadastrarCidade(){
        Cidade cidade = new Cidade();
        System.out.println("Cadastro de cidade");
        System.out.println("Digite o estado da cidade");
        cidade.setEstado(in.nextLine());
        System.out.println("Digite o nome da cidade");
        cidade.setNome(in.nextLine());
        reservaPassagem.cadastrarCidade(cidade);
    }

    public void mostrarCidades(){
        System.out.println("Lista de cidades cadastradas: ");
        Cidade[] cidades = reservaPassagem.getListaDeCidades();
        int quantCidades = reservaPassagem.getQuantCidades();
        for(int i = 0;i < quantCidades;i++){
            System.out.println(i + " : " + cidades[i]);
        }
    }

    public void mostrarClientes(){
        System.out.println("Lista de clientes cadastradas: ");
        Cliente[] clientes = reservaPassagem.getListaDeClientes();
        int quantClientes = reservaPassagem.getQuantClientes();
        for(int i = 0;i < quantClientes;i++){
            System.out.println(i + " : " + clientes[i]);
        }
    }

    public void mostrarReservas(){
        mostrarClientes();
        System.out.println("Digite o cpf do cliente");
        String cpfCliente = in.nextLine();
        Reserva[] reservas = reservaPassagem.mostrarReservas(cpfCliente);
        
        for(int i = 0;i < reservas.length;i++){
            System.out.println(reservas[i]);
        }   
        
    }

    public void cadastrarCliente(){
        Cliente cliente = new Cliente();
        System.out.println("Cadastro de cliente");
        System.out.println("Digite o nome do cliente");
        cliente.setNome(in.nextLine());

        System.out.println("Digite o cpf do cliente");
        cliente.setCpf(in.nextLine());

        System.out.println("Digite o endereço do cliente");
        cliente.setEndereco(in.nextLine());

        System.out.println("Digite o telefone do cliente");
        cliente.setTelefone(in.nextLine());

        reservaPassagem.cadastrarClientes(cliente);
    }

    public void cadastrarIda(){
        Reserva ida = new Reserva();

        System.out.println("Cadastro de Ida");
        System.out.println("Digite o número da reserva");
        ida.setNumReserva(Integer.parseInt(in.nextLine()));

        System.out.println("Digite o preço da reserva");
        ida.setPreco(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a data da reserva xx/xx/xx");
        ida.setDataVoo(in.nextLine());

        System.out.println("Digite o horário da reserva");
        ida.setHoraVoo(in.nextLine());

        System.out.println("Digite a classe da reserva");
        ida.setClasseVoo(in.nextLine());

        System.out.println("Digite a poltrona da reserva");
        ida.setPoltrona(Integer.parseInt(in.nextLine()));
        
        mostrarCidades();
        System.out.println("Digite o indice da cidade de origem");
        int cidadeOrigem = Integer.parseInt(in.nextLine());
        ida.setOrigem(reservaPassagem.getListaDeCidades()[cidadeOrigem]);
        System.out.println("Digite o indice da cidade de destino");
        int cidadeDestino = Integer.parseInt(in.nextLine());
        ida.setDestino(reservaPassagem.getListaDeCidades()[cidadeDestino]);

        mostrarClientes();

        System.out.println("Digite o indice do cliente da reserva");
        
        int indiceCliente = Integer.parseInt(in.nextLine());
        reservaPassagem.getListaDeClientes()[indiceCliente].reservarIda(ida);

    }


    public void cadastrarVolta(){
        Reserva volta = new Reserva();

        System.out.println("Cadastro de Volta");
        System.out.println("Digite o número da reserva");
        volta.setNumReserva(Integer.parseInt(in.nextLine()));

        System.out.println("Digite o preço da reserva");
        volta.setPreco(Float.parseFloat(in.nextLine()));

        
        mostrarCidades();
        System.out.println("Digite o indice da cidade de origem");
        int cidadeOrigem = Integer.parseInt(in.nextLine());
        volta.setOrigem(reservaPassagem.getListaDeCidades()[cidadeOrigem]);
        System.out.println("Digite o indice da cidade de destino");
        int cidadeDestino = Integer.parseInt(in.nextLine());
        volta.setDestino(reservaPassagem.getListaDeCidades()[cidadeDestino]);

        System.out.println("Digite a data da reserva xx/xx/xx");
        volta.setDataVoo(in.nextLine());

        System.out.println("Digite o horário da reserva");
        volta.setHoraVoo(in.nextLine());

        System.out.println("Digite a classe da reserva");
        volta.setClasseVoo(in.nextLine());

        System.out.println("Digite a poltrona da reserva");
        volta.setPoltrona(Integer.parseInt(in.nextLine()));

        System.out.println("Digite o indice do cliente da reserva");
        mostrarClientes();
        int indiceCliente = Integer.parseInt(in.nextLine());
        
        Cliente cliente = reservaPassagem.getListaDeClientes()[indiceCliente];
        if(cliente.getQuantReservas() == 0){
            System.out.println("Cliente não possui reserva de ida!");
            return;
        }
        System.out.println("Escolha a reserva de ida:");
        for(int i = 0; i < cliente.getQuantReservas(); i++){
            System.out.println(i + " - " + cliente.getReservas()[i]);
        }
        int indiceIda = Integer.parseInt(in.nextLine());
        
        Reserva ida = cliente.getReservas()[indiceIda];
        cliente.reservarVolta(ida, volta);

    }


    public static void main(String[] args){
        Principal principal = new Principal();
        principal.run();
    }
}
