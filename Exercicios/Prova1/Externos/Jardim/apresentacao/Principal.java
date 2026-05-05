package Exercicios.Prova1.Externos.Jardim.apresentacao;
import java.util.Scanner;


import dados.*;
import negocio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Principal {
    
    Jardim jardim = new Jardim();
    Scanner in = new Scanner(System.in);

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
                    adicionarCanteiro();
                    break;
                case 2:
                    adicionarEstufa();
                    break;
                case 3:
                    adicionarArvore();
                    break;
                case 4:
                    adicionarFlor();
                    break;
                case 5:
                    mostrarJardins();
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para adicionar Canteiro");
        System.out.println("Digite 2 para adicionar Estufa");
        System.out.println("Digite 3 para adicionar Arvore");
        System.out.println("Digite 4 para adicionar Flor");
        System.out.println("Digite 5 para mostrar jardim");
    }
    
    public void adicionarCanteiro(){
        System.out.println("Digite o nome do jardim que você quer adicionar o canteiro");
        String id = in.nextLine();
        Canteiro c = new Canteiro();

        System.out.println("Digite a área total do canteiro");
        c.setAreaTotal(Float.parseFloat(in.nextLine()));

        jardim.cadastrarCanteiro(id, c);
    }

    public void adicionarEstufa(){
        System.out.println("Digite o nome do jardim que você quer adicionar a estufa");
        String id = in.nextLine();
        Estufa e = new Estufa();

        System.out.println("Digite a área total da estufa");
        e.setAreaTotal(Float.parseFloat(in.nextLine()));

        for(int i = 0;i < Clima.values().length;i++){
            System.out.println("[" + i + "] " + Clima.values()[i]);
        }

        System.out.println("Digite o indíce do clima da estufa");
        int indice = Integer.parseInt(in.nextLine());
        e.setClimaInterno(Clima.values()[indice]);

        jardim.cadastrarCanteiro(id, e);
    }

    public void adicionarArvore(){
        System.out.println("Escolha o jardim que voce quer colocar a arvore");
        Map<String, Canteiro> mapas = jardim.getSetores();
        for(String id : mapas.keySet()){
            System.out.println(id);
        }
        System.out.println("Digite o nome: ");
        String s = in.nextLine();
        
        Arvore arvore = new Arvore();
        System.out.println("Digite a altura da arvore");
        arvore.setAlturaMaxima(Float.parseFloat(in.nextLine()));

        System.out.println("Digite o nome da arvore");
        arvore.setNome(in.nextLine());

        System.out.println("Digite o espaco nescessario da arvore");
        arvore.setEspacoNescessario(Float.parseFloat(in.nextLine()));

        for(int i = 0;i < Clima.values().length;i++){
            System.out.println("[" + i + "] " + Clima.values()[i]);
        }
        System.out.println("Digite o indíce do clima da arvore");
        int indice = Integer.parseInt(in.nextLine());
        arvore.setClima(Clima.values()[indice]);

        jardim.alocarPlanta(s, arvore);

    }

    public void adicionarFlor(){
        System.out.println("Escolha o jardim que voce quer colocar a flor");
        for(String id : jardim.getSetores().keySet()){
            System.out.println(id);
        }
        System.out.println("Digite o nome: ");
        String s = in.nextLine();
        
        Flor flor = new Flor();
        System.out.println("Digite a cor da flor");
        flor.setCor(in.nextLine());

        System.out.println("Digite o nome da flor");
        flor.setNome(in.nextLine());

        System.out.println("Digite o espaco nescessario da flor");
        flor.setEspacoNescessario(Float.parseFloat(in.nextLine()));

        for(int i = 0;i < Clima.values().length;i++){
            System.out.println("[" + i + "] " + Clima.values()[i]);
        }
        System.out.println("Digite o indíce do clima da flor");
        int indice = Integer.parseInt(in.nextLine());
        flor.setClima(Clima.values()[indice]);

        jardim.alocarPlanta(s, flor);
    }

    public void mostrarJardins(){
        Map<String, Canteiro> mapas = jardim.getSetores();
        for(String id : mapas.keySet()){
            System.out.println(id);
            for(int i = 0;i < mapas.get(id).getPlantas().size();i++){
                System.out.println(mapas.get(id).getPlantas().get(i));
            }
        }
    }
    
    public static void main(String[] args){
        Principal princ = new Principal();
        princ.run();
    }
}
