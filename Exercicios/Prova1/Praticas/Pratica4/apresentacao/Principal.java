package apresentacao;
import java.util.List;
import java.util.Scanner;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;
import negocios.Zoologico;

public class Principal {
    
    Scanner in = new Scanner(System.in);
    Zoologico zoo = new Zoologico();

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
                    mostrarTudo();
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para cadastrar Viveiro");
        System.out.println("Digite 2 para cadastrar Aquario");
        System.out.println("Digite 3 para cadastrar Animal");
        System.out.println("Digite 4 para cadastrar Peixe");
        System.out.println("Digite 5 para mostrar tudo");
    }


    public void cadastrarViveiro(){
        Viveiro v = new Viveiro();
        System.out.println("Digite o nome do Viveiro");
        v.setNome(in.nextLine());
        System.out.println("Digite o comprimento do Viveiro");
        v.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a largura do Viveiro");
        v.setLargura(Float.parseFloat(in.nextLine()));

        zoo.cadastrarViveiro(v);
    }

    public void cadastrarAquario(){
        Aquario a = new Aquario();
        System.out.println("Digite o nome do Aquario");
        a.setNome(in.nextLine());
        System.out.println("Digite o comprimento do Aquario");
        a.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a largura do Aquario");
        a.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a altura do Aquario");
        a.setAltura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a temperatura do Aquario");
        a.setTemperatura(Float.parseFloat(in.nextLine()));

        zoo.cadastrarViveiro(a);
    }

    public void cadastrarAnimal(){
        Animal a = new Animal();
        System.out.println("Digite o nome do animal");
        a.setNome(in.nextLine());
        System.out.println("Digite a cor do animal");
        a.setCor(in.nextLine());
        System.out.println("Digite a especia do animal");
        a.setEspecie(in.nextLine());
        System.out.println("Digite a idade do animal");
        a.setIdade(Integer.parseInt(in.nextLine()));
        System.out.println("Digite a largura do animal");
        a.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o comprimento do animal");
        a.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a altura do animal");
        a.setAltura(Float.parseFloat(in.nextLine()));

        List<Viveiro> viveiros = zoo.getViveiros();
        System.out.println("Digite o viveiro que voce quer adicionar o animal");
        for(int i = 0;i < viveiros.size();i++){
            System.out.println("[" + i + "]" + " " + viveiros.get(i).getNome());
        }

        int indice = Integer.parseInt(in.nextLine());

        boolean sucesso = zoo.alocarAnimal(a, viveiros.get(indice));
        if(!sucesso){
            System.out.println("Não foi possível alocar o Animal (Verifique o espaço ou a temperatura).");
        }else {
            System.out.println("Peixe alocado com sucesso!");
        }

    }

    public void cadastrarPeixe(){
        Peixe a = new Peixe();
        System.out.println("Digite o nome do Peixe");
        a.setNome(in.nextLine());
        System.out.println("Digite a cor do Peixe");
        a.setCor(in.nextLine());
        System.out.println("Digite a especia do Peixe");
        a.setEspecie(in.nextLine());
        System.out.println("Digite a idade do Peixe");
        a.setIdade(Integer.parseInt(in.nextLine()));
        System.out.println("Digite a largura do Peixe");
        a.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o comprimento do Peixe");
        a.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a altura do Peixe");
        a.setAltura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a temperatura ideal do Peixe");
        a.setTemperaturaIdeal(Float.parseFloat(in.nextLine()));
       


        List<Aquario> aquarios = zoo.getAquarios();
        System.out.println("Digite o aquario que voce quer adicionar o animal");
        for(int i = 0;i < aquarios.size();i++){
            System.out.println("[" + i + "]" + " " + aquarios.get(i).getNome());
        }

        int indice = Integer.parseInt(in.nextLine());

        boolean sucesso = zoo.alocarAnimal(a, aquarios.get(indice));
        if(!sucesso){
            System.out.println("Não foi possível alocar o Peixe (Verifique o espaço ou a temperatura).");
        }else {
            System.out.println("Peixe alocado com sucesso!");
        }
    }

    public void mostrarTudo(){
        List<Aquario> aquarios = zoo.getAquarios();
        List<Viveiro> viveiros = zoo.getViveiros();

        for(int i = 0;i < viveiros.size();i++){
            System.out.println(viveiros.get(i));
            List<Animal> animais = viveiros.get(i).getAnimais();
            for(int j = 0;j < animais.size();j++){
                System.out.println(animais.get(j));
            }
        }

        System.out.println("\n");

        for(int i = 0;i < aquarios.size();i++){
            System.out.println(aquarios.get(i));
            List<Peixe> peixes = aquarios.get(i).getPeixes();
            for(int j = 0;j < peixes.size();j++){
                System.out.println(peixes.get(j));
            }
        }

    }

    
    public static void main(String[] args){
        Principal princ = new Principal();
        princ.run();
    }
}
