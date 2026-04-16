package Exercicio4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    Scanner in;
    Turma turma = new Turma();
    int quantidade = 0;
    boolean lendoDoArquivo;

    public Main(){
        
        try{
            in = new Scanner(new File("alunos.txt")); 
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
            menu();
            if(!in.hasNextLine()){

                if(lendoDoArquivo){
                    in = new Scanner(System.in);
                    lendoDoArquivo = false;
                    continue;
                } 
                else break; 
            
            }

            
            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                
                case -1:
                    flag = false;
                    mostrarGrupos();
                    break;
                case 1:
                    adicionarAluno();
                    break;
                default:
                    break;
            }

        }

    }

    public void menu(){
        System.out.println("Digite -1 sair e mostrar os grupos formados");
        System.out.println("Digite 1 para cadastrar aluno");
    }

    public void adicionarAluno(){
        Aluno aluno = new Aluno();
        System.out.println("Digite o nome do aluno");
        aluno.setNome(in.nextLine());

        System.out.println("Digite a idade do aluno");
        aluno.setIdade(Integer.parseInt(in.nextLine()));

        double[] notas = new double[5];
        for(int i = 0;i < 5;i++){
            System.out.println("Digite a nota número " + (i+1) + "do aluno");
            notas[i] = Double.parseDouble(in.nextLine());
        }

        aluno.setNotas(notas);
        
        turma.adicionarAluno(aluno);
        quantidade++;
    }

    public void mostrarGrupos(){
        List<Equipe<Aluno>> turmas = turma.separarEmEquipes();
        for(Equipe<Aluno> grupo : turmas){
            System.out.println(grupo);
        }
    }    

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }

}
