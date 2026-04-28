package apresentacao;
import java.util.Scanner;
import dados.Animal;
import dados.Viveiro;
import negocios.Zoologico;
import java.util.ArrayList;
import java.util.List;
import dados.Aquario;
import negocios.Zoologico;
import dados.Peixe;



public class Main {

    Scanner in = new Scanner(System.in);
    Zoologico zoo = new Zoologico();

    void menu(){
        System.out.println("Sistema de Gestão de Zoológico");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para cadastrar viveiro");
        System.out.println("Digite 2 para cadastrar aquário");
        System.out.println("Digite 3 para cadastrar animal");
        System.out.println("Digite 4 para cadastrar peixe");
        System.out.println("Digite 5 para ver os animais de um viveiro");
        System.out.println("Digite 6 para ver os peixes de um aquario");
    }

    void run(){
        boolean flag = true;

        while(flag){
            menu();

            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 0:
                    flag = false;
                    break;
                case 1:
                    cadastrarViveiro();
                    break;
                case 2:
                    cadastrarAquario();
                    break;
                case 3:
                    cadastrarAnimal();
                    break;
                case 4:
                    cadastrarPeixe();
                    break;
                case 5:
                    verViveiro();
                    break;
                case 6:
                    verAquario();
                    break;
                default:
                    break;
            } 
        }
    }

    public void cadastrarViveiro(){
        Viveiro v = new Viveiro();
        System.out.println("Cadastro de Viveiro");
        
        System.out.println("Digite o nome");
        v.setNome(in.nextLine());

        System.out.println("Digite o comprimento");
        v.setComprimento(Float.parseFloat(in.nextLine()));

        System.out.println("Digite o largura");
        v.setLargura(Float.parseFloat(in.nextLine()));

        zoo.cadastrarViveiro(v);
    }

    public void cadastrarAquario(){
        Aquario a = new Aquario();
        System.out.println("Cadastro de Aquário");
        
        System.out.println("Digite o nome");
        a.setNome(in.nextLine());

        System.out.println("Digite o comprimento");
        a.setComprimento(Float.parseFloat(in.nextLine()));

        System.out.println("Digite o largura");
        a.setLargura(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a altura");
        a.setAltura(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a temperatura");
        a.setTemperatura(Float.parseFloat(in.nextLine()));

        zoo.cadastrarViveiro(a);
    }

    public void cadastrarAnimal(){
        Animal a = new Animal();
        System.out.println("Cadastro de Animal");

        System.out.println("Digite o nome");
        a.setNome(in.nextLine());

        System.out.println("Digite a cor");
        a.setCor(in.nextLine());

        System.out.println("Digite a espécie");
        a.setEspecie(in.nextLine());

        System.out.println("Digite a idade");
        a.setIdade(Integer.parseInt(in.nextLine()));

        System.out.println("Digite a largura");
        a.setLargura(Float.parseFloat(in.nextLine()));

        System.out.println("Digite o comprimento");
        a.setComprimento(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a altura");
        a.setAltura(Float.parseFloat(in.nextLine()));

        zoo.cadastrarAnimal(a);

        System.out.println("Escolha o viveiro");
        List<Viveiro> viveiros = zoo.getSoViveiros();

        for(int i = 0;i < zoo.getSoViveiros().size();i++){
            System.out.println("[" + i + "]" + zoo.getSoViveiros().get(i));
        }

        System.out.println("Digite o número do viveiro");
        int numViveiro = Integer.parseInt(in.nextLine());
        zoo.alocarAnimal(a, zoo.getSoViveiros().get(numViveiro));

    }

    public void cadastrarPeixe(){
        Peixe a = new Peixe();
        System.out.println("Cadastro de Peixe");

        System.out.println("Digite o nome");
        a.setNome(in.nextLine());

        System.out.println("Digite a cor");
        a.setCor(in.nextLine());

        System.out.println("Digite a espécie");
        a.setEspecie(in.nextLine());

        System.out.println("Digite a idade");
        a.setIdade(Integer.parseInt(in.nextLine()));

        System.out.println("Digite a largura");
        a.setLargura(Float.parseFloat(in.nextLine()));

        System.out.println("Digite o comprimento");
        a.setComprimento(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a altura");
        a.setAltura(Float.parseFloat(in.nextLine()));

        System.out.println("Digite a temperatura ideal");
        a.setTemperaturaIdeal(Float.parseFloat(in.nextLine()));

        zoo.cadastrarAnimal(a);

        System.out.println("Escolha o aquário");
        List<Aquario> aquarios = zoo.getSoAquarios();

        for(int i = 0;i < zoo.getSoAquarios().size();i++){
            System.out.println("[" + i + "]" + zoo.getSoAquarios().get(i));
        }

        System.out.println("Digite o número do viveiro");
        int numAq = Integer.parseInt(in.nextLine());
        zoo.alocarAnimal(a, zoo.getSoAquarios().get(numAq));

    }

    public void verViveiro(){
        System.out.println("Escolha o viveiro");
        List<Viveiro> viveiros = zoo.getSoViveiros();

        for(int i = 0;i < zoo.getSoViveiros().size();i++){
            System.out.println("[" + i + "]" + zoo.getSoViveiros().get(i));
        }
        int numViveiro = Integer.parseInt(in.nextLine());
        List<Animal> animais = zoo.getSoViveiros().get(numViveiro).getAnimais();

        for(int i = 0;i < animais.size();i++){
            System.out.println(animais.get(i));
        }
    }

    public void verAquario(){
        System.out.println("Escolha o aquário");
        List<Aquario> aquarios = zoo.getSoAquarios();

        for(int i = 0;i < zoo.getSoAquarios().size();i++){
            System.out.println("[" + i + "]" + zoo.getSoAquarios().get(i));
        }
        int nq = Integer.parseInt(in.nextLine());
        List<Peixe> peixes = zoo.getSoAquarios().get(nq).getPeixes();
        for(int i = 0;i < peixes.size();i++){
            System.out.println(peixes.get(i));
        }
    }

    


    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }
}
