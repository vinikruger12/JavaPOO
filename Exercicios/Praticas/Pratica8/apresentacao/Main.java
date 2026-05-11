package apresentacao;

import dados.Pessoa;
import negocio.Sistema;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        
        // Define o Locale como US para podermos usar PONTO (.) nos números decimais (ex: 1.75)
        scanner.useLocale(Locale.US); 
        
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Adicionar Pessoa");
            System.out.println("2 - Listar Pessoas cadastradas");
            System.out.println("3 - Remover Pessoa");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha que sobra após digitar o número

            switch (opcao) {
                case 1:
                    adicionar(sistema, scanner);
                    break;
                case 2:
                    listar(sistema);
                    break;
                case 3:
                    remover(sistema, scanner);
                    break;
                case 4:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }

    // --- MÉTODOS AUXILIARES PARA DEIXAR O MAIN ORGANIZADO ---

    private static void adicionar(Sistema sistema, Scanner scanner) {
        System.out.println("\n--- Nova Pessoa ---");
        Pessoa p = new Pessoa();

        System.out.print("Nome: ");
        p.setNome(scanner.nextLine());

        System.out.print("Idade: ");
        p.setIdade(scanner.nextInt());

        System.out.print("Altura (ex: 1.75): ");
        p.setAltura(scanner.nextFloat());

        System.out.print("Massa/Peso (ex: 75.5): ");
        p.setMassa(scanner.nextFloat());

        sistema.adicionarPessoa(p);
        System.out.println("✅ Pessoa salva no arquivo com sucesso!");
    }

    private static void listar(Sistema sistema) {
        List<Pessoa> lista = sistema.getList();
        
        if (lista.isEmpty()) {
            System.out.println("\nNenhuma pessoa cadastrada no arquivo ainda.");
            return;
        }

        System.out.println("\n--- Pessoas Cadastradas ---");
        for (int i = 0; i < lista.size(); i++) {
            Pessoa p = lista.get(i);
            System.out.printf("[%d] %s (Idade: %d, Altura: %.2f, Massa: %.2f) -> IMC: %.2f\n", 
                              i, p.getNome(), p.getIdade(), p.getAltura(), p.getMassa(), p.calculaIMC());
        }
    }

    private static void remover(Sistema sistema, Scanner scanner) {
        List<Pessoa> lista = sistema.getList();
        
        if (lista.isEmpty()) {
            System.out.println("\nNão há pessoas para remover.");
            return;
        }

        // Mostra a lista antes de pedir qual remover
        listar(sistema);

        System.out.print("\nDigite o número entre colchetes [ ] da pessoa que deseja remover: ");
        int indice = scanner.nextInt();

        // Verifica se o número digitado é válido
        if (indice >= 0 && indice < lista.size()) {
            Pessoa pessoaParaRemover = lista.get(indice);
            sistema.removerPessoa(pessoaParaRemover);
            System.out.println("❌ " + pessoaParaRemover.getNome() + " removido(a) com sucesso!");
        } else {
            System.out.println("Índice inválido! Operação cancelada.");
        }
    }
}