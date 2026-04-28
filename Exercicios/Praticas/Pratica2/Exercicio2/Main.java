import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SistemaPetShop sistema = new SistemaPetShop();
        Scanner in = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("SISTEMA PET SHOP");
            System.out.println("1 - Cadastrar Veterinário");
            System.out.println("2 - Mostrar Veterinários");
            System.out.println("3 - Cadastrar Endereço do Veterinário");
            System.out.println("4 - Cadastrar Animal");
            System.out.println("5 - Mostrar Animais");
            System.out.println("6 - Cadastrar Dono");
            System.out.println("7 - Cadastrar Endereço do Dono");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = in.nextInt();
            in.nextLine(); 

            switch (opcao) {

                case 1:
                    System.out.print("Nome do veterinário: ");
                    String nomeVet = in.nextLine();

                    System.out.print("Salário: ");
                    double salario = in.nextDouble();
                    in.nextLine();

                    sistema.cadastrarVeterinario(nomeVet, salario);
                    System.out.println("Veterinário cadastrado!");
                    break;

                case 2:
                    sistema.mostrarVeterinarios();
                    break;

                case 3:
                    sistema.cadastrarEnderecoVeterinario();
                    break;

                case 4:
                    sistema.cadastrarAnimal();
                    break;

                case 5:
                    sistema.mostrarAnimais();
                    break;

                case 6:
                    sistema.cadastrarDono();
                    break;

                case 7:
                    sistema.cadastrarEnderecoDono();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        in.close();
    }
}