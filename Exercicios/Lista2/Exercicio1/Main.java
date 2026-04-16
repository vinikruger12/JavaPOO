package Exercicio1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    Scanner in;
    List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
    int quantidade = 0;
    boolean lendoDoArquivo;

    public Main(){
        
        try{
            in = new Scanner(new File("pessoas.txt")); 
            lendoDoArquivo = true;
        }
        catch(FileNotFoundException e){
            in = new Scanner(System.in); 
            lendoDoArquivo = false;
        }
    }

    public void run(){
        boolean flag = true;

        

        while(flag){

            if(!in.hasNextLine()){

                if(lendoDoArquivo){
                    in = new Scanner(System.in);
                    lendoDoArquivo = false;
                    continue;
                } 
                else break; 
            
            }

            menu();
            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                
                case -1:
                    flag = false;
                    break;
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    mostrarPessoas();
                    break;
                default:
                    break;
            }

        }

    }

    public void menu(){
        System.out.println("Digite -1 sair");
        System.out.println("Digite 1 para cadastrar pessoa");
        System.out.println("Digite 2 para mostrar as pessoas cadastradas");
    }

    public void adicionarPessoa(){
        Pessoa pessoa = new Pessoa();
        System.out.println("Digite o nome da pessoa");
        pessoa.setNome(in.nextLine());

        System.out.println("Digite a idade da pessoa");
        pessoa.setIdade(Integer.parseInt(in.nextLine()));

        System.out.println("Digite a cidade da pessoa");
        pessoa.setCidade(in.nextLine());

        System.out.println("Digite o cpf da pessoa");
        pessoa.setCpf(in.nextLine());

        listaDePessoas.add(pessoa);
        quantidade++;
        sortPessoas(listaDePessoas);

        mostrarPessoas();

    }

    public void mostrarPessoas(){
        System.out.println("1 até 12 anos: crianças;");
        for(int i = 0;i < quantidade;i++){
            if(listaDePessoas.get(i).getIdade() <= 12){
                System.out.println(listaDePessoas.get(i));
            }
        }


        System.out.println("13 até 18 anos: adolescentes;");
        for(int i = 0;i < quantidade;i++){
            if(listaDePessoas.get(i).getIdade() >= 13 && listaDePessoas.get(i).getIdade() <= 18){
                System.out.println(listaDePessoas.get(i));
            }
        }


        System.out.println("19 até 25 anos: jovens;");
        for(int i = 0;i < quantidade;i++){
            if(listaDePessoas.get(i).getIdade() >= 19 && listaDePessoas.get(i).getIdade() <= 25){
                System.out.println(listaDePessoas.get(i));
            }
        }


        System.out.println("26 até 59: adultos;");
        for(int i = 0;i < quantidade;i++){
            if(listaDePessoas.get(i).getIdade() >= 26 && listaDePessoas.get(i).getIdade() <= 59){
                System.out.println(listaDePessoas.get(i));
            }
        }


        System.out.println("60 ou mais: idosos;");
        for(int i = 0;i < quantidade;i++){
            if(listaDePessoas.get(i).getIdade() >= 60){
                System.out.println(listaDePessoas.get(i));
            }
        }

    }



    public void sortPessoas(List<Pessoa> listaDePessoas){
        for(int i = 0;i < quantidade;i++){
            for(int j = i;j < quantidade;j++){
                if(listaDePessoas.get(i).getNome().compareToIgnoreCase(listaDePessoas.get(j).getNome()) > 0){
                    Pessoa aux = listaDePessoas.get(i);
                    listaDePessoas.set(i, listaDePessoas.get(j));
                    listaDePessoas.set(j, aux);

                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }

}
