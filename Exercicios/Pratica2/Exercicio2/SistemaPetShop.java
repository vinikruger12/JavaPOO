import java.util.Scanner;

public class SistemaPetShop {
    Scanner in = new Scanner(System.in);

    private Veterinario[] veterinarios = new Veterinario[50];
    private int quantidadeVeterinarios = 0;

    public void cadastrarVeterinario(String nome, double salario){
        Veterinario aux = new Veterinario();
        aux.setNome(nome);
        aux.setSalario(salario);
        aux.setEndereco(null);

        veterinarios[this.quantidadeVeterinarios] = aux;
        this.quantidadeVeterinarios++;
    }

    public void mostrarVeterinarios(){
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            System.out.println("O veterinário " + (i + 1) + " se chama " + this.veterinarios[i].getNome() + " e ganha " + this.veterinarios[i].getSalario() + "\n");
        }
    }

    public void cadastrarEnderecoVeterinario(){
        System.out.println("Escolha um veterinário: ");
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            System.out.println("Veterinário " + (i+1) + ": " + this.veterinarios[i].getNome());
        }
        int x = in.nextInt();
        x--;
        in.nextLine();

        System.out.println("Digite a rua do veterinário: ");
        String rua = in.nextLine();

        System.out.println("Digite o número do veterinário: ");
        int numero = in.nextInt();
        in.nextLine();

        System.out.println("Digite o bairro do veterinário: ");
        String bairro = in.nextLine();

        System.out.println("Digite a cidade do veterinário: ");
        String cidade = in.nextLine();

        System.out.println("Digite o estado do veterinário: ");
        String estado = in.nextLine();

        System.out.println("Digite o cep do veterinário: ");
        String cep = in.nextLine();
        in.nextLine();

        Endereco aux = new Endereco();
        aux.setRua(rua);
        aux.setNumero(numero);
        aux.setBairro(bairro);
        aux.setCEP(cep);
        aux.setCidade(cidade);
        aux.setEstado(estado);
        
        this.veterinarios[x].setEndereco(aux);
    }

    public void cadastrarAnimal(){
        System.out.println("Escolha um veterinário: ");
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            System.out.println("Veterinário " + (i+1) + ": " + this.veterinarios[i].getNome());
        }
        int x = in.nextInt();
        in.nextLine();
        x--;

        System.out.println("Digite o nome do animal: ");
        String nome = in.nextLine();

        System.out.println("Digite a espécie do animal: ");
        String especia = in.nextLine();

        System.out.println("Digite a descrição do animal: ");
        String descricao = in.nextLine();

        Animal aux = new Animal();
        aux.setDescricao(descricao);
        aux.setEspecie(especia);
        aux.setNome(nome);
        this.veterinarios[x].setAnimais(aux);
    }

    public void mostrarAnimais(){
        System.out.println("Escolha um veterinário: ");
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            System.out.println("Veterinário " + (i+1) + ": " + this.veterinarios[i].getNome());
        }
        int x = in.nextInt();
        in.nextLine();
        x--;

        System.out.println("O veterinário " + this.veterinarios[x].getNome() + " cuida desses animais: ");
        for(int i = 0;i < this.veterinarios[x].getQuantidadeAnimais();i++){
            System.out.println("Animal " + (i+1) + ", nome: " + this.veterinarios[x].getAnimais(i).getNome());
        }
    }

    public void cadastrarDono(){
        
        System.out.println("Escolha um veterinário e seu respectivo aniaml: ");
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            if(this.veterinarios[i].getQuantidadeAnimais() > 0){
                System.out.println("Veterinário número " + (i+1) + " , " + this.veterinarios[i].getNome());
                for(int j = 0;j < this.veterinarios[i].getQuantidadeAnimais();j++){
                    System.out.println("Animal número " + (j+1) + " , " + this.veterinarios[i].getAnimais(j).getNome());
                }
                System.out.println("\n");
            }
        }
        System.out.println("Escolha um veterinário");
        int x = in.nextInt();
        in.nextLine();
        System.out.println("Escolha um aniaml: ");
        int y = in.nextInt();
        in.nextLine();
        x--;
        y--;

        Dono aux = new Dono();
        System.out.println("Digite o nome do dono: ");
        String nome = in.nextLine();
        System.out.println("Digite o cpf do dono: ");
        String cpf = in.nextLine();
        aux.setCpf(cpf);
        aux.setNome(nome);

        this.veterinarios[x].getAnimais(y).setDono(aux);
    }

    public void cadastrarEnderecoDono(){

        System.out.println("Escolha um veterinário e seu respectivo aniaml: ");
        for(int i = 0;i < this.quantidadeVeterinarios;i++){
            if(this.veterinarios[i].getQuantidadeAnimais() > 0){
                System.out.println("Veterinário número " + (i+1) + " , " + this.veterinarios[i].getNome());
                for(int j = 0;j < this.veterinarios[i].getQuantidadeAnimais();j++){
                    if(this.veterinarios[i].getAnimais(j).getDono() != null){
                        System.out.println("Animal número " + (j+1) + " , " + this.veterinarios[i].getAnimais(j).getNome());
                    }
                }
                System.out.println("\n");
            }
        }
        System.out.println("Escolha um veterinário");
        int x = in.nextInt();
        in.nextLine();
        System.out.println("Escolha um aniaml: ");
        int y = in.nextInt();
        in.nextLine();
        x--;
        y--;
        
        System.out.println("Dono: " + this.veterinarios[x].getAnimais(y).getDono().getNome() + " com o cpf: " + this.veterinarios[x].getAnimais(y).getDono().getCpf());
        
        System.out.println("Digite a rua do dono: ");
        String rua = in.nextLine();

        System.out.println("Digite o número do dono: ");
        int numero = in.nextInt();
        in.nextLine();

        System.out.println("Digite o bairro do dono: ");
        String bairro = in.nextLine();

        System.out.println("Digite a cidade do dono: ");
        String cidade = in.nextLine();

        System.out.println("Digite o estado do dono: ");
        String estado = in.nextLine();

        System.out.println("Digite o cep do dono: ");
        String cep = in.nextLine();

        Endereco aux = new Endereco();
        aux.setRua(rua);
        aux.setNumero(numero);
        aux.setBairro(bairro);
        aux.setCEP(cep);
        aux.setCidade(cidade);
        aux.setEstado(estado);
        
        this.veterinarios[x].getAnimais(y).getDono().setEndereco(aux);
    }
}
